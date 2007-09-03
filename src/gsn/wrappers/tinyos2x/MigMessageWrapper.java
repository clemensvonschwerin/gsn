package gsn.wrappers.tinyos2x;

import gsn.wrappers.AbstractWrapper;

import gsn.beans.AddressBean;
import gsn.beans.DataField;
import org.apache.log4j.Logger;

import java.io.*;
import net.tinyos.packet.*;
import net.tinyos.util.*;
import net.tinyos.message.*;
import net.tinyos.tools.*;

import java.util.regex.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

/** MigMessageWrapper is used for reading TinyOS 2.x generated datapackets.
 * The wrapper reads packet definition from a MIG-generated .java-file and
 * uses the compiled class-file to read the appropriate data.
 */

public class MigMessageWrapper extends AbstractWrapper implements net.tinyos.message.MessageListener {

    // regular expression clauses for finding the field names and their types from packet definition
    private static final String NAME_PATTERN = "// Accessor methods for field: (\\w+)";
    private static final String TYPE_PATTERN = "//\\s+Field type: (\\w+)";
    
    private static final String INITPARAM_SOURCE = "source";
    private static final String INITPARAM_PACKETNAME = "packet-name";
    private static final String INITPARAM_PATH = "path";
    
    private String source;
    private String packetName;
    private String path;
    
    private int threadCounter = 0;
    private final transient Logger logger = Logger.getLogger( MigMessageWrapper.class );
    
    private transient DataField [ ] outputStructureCache;
    
    // the interface to communicate with mote
    private MoteIF moteIF;
    // they have to be buffered because they arrive independently of GSN
    private static HashMap<String, String> types;
    private HashMap<String, String> fields;
    
    // class and object variables used to extract data from packets using reflection
    private Class packetClass;
    private Object packetObject;
    
    public boolean initialize ( ) {
        setName( "CodeGenWrapper-Thread" + ( ++threadCounter ) );
        AddressBean addressBean = getActiveAddressBean( );
        if ( addressBean.getPredicateValue(INITPARAM_SOURCE) != null ) {
            source = addressBean.getPredicateValue(INITPARAM_SOURCE);
        } else {
            logger.warn("The specified parameter >" + INITPARAM_SOURCE + "< for >CodeGenWrapper< is missing.");
            logger.warn("Initialization failed.");
            return false;
        }
        if ( addressBean.getPredicateValue(INITPARAM_PACKETNAME) != null ) {
            packetName = addressBean.getPredicateValue(INITPARAM_PACKETNAME);
        } else {
            logger.warn("The specified parameter >" + INITPARAM_PACKETNAME + "< for >CodeGenWrapper< is missing.");
            logger.warn("Initialization failed.");
            return false;
        }
        if ( addressBean.getPredicateValue(INITPARAM_PATH) != null ) {
            path = addressBean.getPredicateValue(INITPARAM_PATH);
        } else {
            logger.warn("The specified parameter >" + INITPARAM_PATH + "< for >CodeGenWrapper< is missing.");
            logger.warn("Initialization failed.");
            return false;
        }

        logger.debug("Connecting to " + source);
        moteIF = new MoteIF(BuildSource.makePhoenix(source, PrintStreamMessenger.err));
        types = makeTypeMap();
        logger.debug("Reading packet definition from " + path + packetName + ".java");
        outputStructureCache = createOutputStructure(path + packetName + ".java");
        if(outputStructureCache == null) return false;
        
        try {
            packetClass = Class.forName(packetName);
            packetObject = packetClass.newInstance();
            Message msg = (Message)packetObject;
            moteIF.registerListener(msg, this);
        }
        catch (Exception e) {
            logger.warn("Reading packet structure of " + packetName + " failed:", e);
            return false;
        } 
        return true;
    }
    
    /** Creates a HashMap, where key is the type in nesC and value is the type in GSN
     */
    private static HashMap<String, String> makeTypeMap() {
        HashMap<String, String> types = new HashMap<String, String>();
        types.put("byte", "tinyint");
        types.put("short", "smallint");
        types.put("int", "integer");
        types.put("long", "bigint");
        return types;
    }
    
    /** Creates the output structure required for posting data to GSN
     * Reads definition from a file, whose name is given as a parameter and
     * uses regular expression 
     */
    private DataField[] createOutputStructure(String filename) {
        fields = new HashMap<String, String>();
        ArrayList<String> fieldnames = new ArrayList<String>();
        try
        {
            BufferedReader input = new BufferedReader(new FileReader(filename));
            String data;
            
            Pattern namePattern = Pattern.compile(NAME_PATTERN);
            Pattern typePattern = Pattern.compile(TYPE_PATTERN);
            Matcher nameMatcher;
            Matcher typeMatcher;
            String name = null;
            String type = null;
            
            // Name and type aren't on the same line, so we have to clear the
            // variables only after both are read successfully.
            // There is a possibility that this might cause problems if
            // at some time the regular expressions don't match the correct
            // lines.
            // The names have to be put to a separate datastructure, which
            // retains the order: if they were stored only to a hashmap, then
            // later we wouldn't know in which order they would be and the
            // values would be set to wrong sensor names.
            while((data = input.readLine()) != null) {
                nameMatcher = namePattern.matcher(data);
                typeMatcher = typePattern.matcher(data);
                
                while(nameMatcher.find()) {
                    name = nameMatcher.group(1);
                }
                while(typeMatcher.find()) {
                    type = typeMatcher.group(1);
                }
                if(name != null && type != null) {
                    fieldnames.add(name);
                    fields.put(name, type);
                    name = null;
                    type = null;
                }
            }
            input.close();
        } 
        catch (Exception e)
        {
            logger.warn("File input error", e);
            return null;
        }

        // create an array of DataTypes for returning
        ArrayList<DataField> fieldsAL = new ArrayList<DataField>();
        Iterator<String> it = fieldnames.iterator();
        while(it.hasNext()) {
            String curName = it.next();
            String curType = fields.get(curName);
            fieldsAL.add(new DataField(curName.toUpperCase(), types.get(curType), curName));
        }
        return fieldsAL.toArray(new DataField[] {} );
    }
    
    /** Implements net.tinyos.message.MessageListener.messageReceived
     * Stores the received message to a buffer so that GSN can fetch the message
     * from there whenever it wants.
     */
    public void messageReceived(int to, Message message) {
        logger.debug("Received message");
        try {
            Constructor packetConstructor = packetClass.getDeclaredConstructor(Message.class, int.class, int.class);
            if(message == null) {
                logger.warn("Message was null!");
                return;
            }
            packetObject = packetConstructor.newInstance(message, message.baseOffset(), message.dataLength());
        } catch(NoSuchMethodException e) {
            logger.error("Cannot create an instance of packet: constructor not found", e);
            return;
        } catch(InstantiationException e) {
            logger.error("Cannot create an instance of packet", e);
            return;
        } catch(IllegalAccessException e) {
            logger.error("Cannot create an instance of packet", e);
            return;
        } catch(InvocationTargetException e) {
            logger.error("Cannot create an instance of packet", e);
            return;
        }

        // The return values are always short, int or long.
        // Here we don't have to mind about it as they are all serializable, and
        // we can return an array of serializable-objects.
        ArrayList<Serializable> retvals = new ArrayList<Serializable>();            
        Method[] allMethods = packetClass.getDeclaredMethods();

        for (Method method : allMethods) {
            String methodName = method.getName();
            try {
                for(String fieldName : fields.keySet()) {
                    if(methodName.equals("get_" + fieldName)) {
                        method.setAccessible(true);
                        retvals.add((Serializable) method.invoke(packetObject));
                    }
                }
            } catch (InvocationTargetException e) {
                logger.error("Invocation of " + methodName + " failed: %s%n", e);
            } catch (IllegalAccessException e) {
                logger.error("Cannot access " + methodName, e);
            }
        }
        postStreamElement( retvals.toArray(new Serializable[] {}) );
    }
    
    /** Overrides gsn.wrappers.AbstractWrapper.run
     * Nothing to do, because the values are inserted to GSN whenever packets arrive.
     */
    @Override
    public void run ( ) {
    }

    public void finalize ( ) {
        threadCounter--;
    }

    public final DataField [ ] getOutputFormat ( ) {
        return outputStructureCache;
    }
   
    public String getWrapperName ( ) {
        return "TinyOS packet wrapper";
    }

}
