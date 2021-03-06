/**
* Global Sensor Networks (GSN) Source Code
* Copyright (c) 2006-2016, Ecole Polytechnique Federale de Lausanne (EPFL)
* 
* This file is part of GSN.
* 
* GSN is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
* 
* GSN is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with GSN.  If not, see <http://www.gnu.org/licenses/>.
* 
* File: src/ch/epfl/gsn/Mappings.java
*
* @author Ali Salehi
* @author Mehdi Riahi
* @author Timotee Maret
*
*/

package ch.epfl.gsn;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.LoggerFactory;

import ch.epfl.gsn.Mappings;
import ch.epfl.gsn.VirtualSensor;
import ch.epfl.gsn.beans.DataField;
import ch.epfl.gsn.beans.VSensorConfig;

import org.slf4j.Logger;

public final class Mappings {
   
   private static final ConcurrentHashMap<String,VSensorConfig> vsNameTOVSConfig = new ConcurrentHashMap<String,VSensorConfig>();
   
   private static final ConcurrentHashMap<String, VirtualSensor> fileNameToVSInstance = new ConcurrentHashMap<String, VirtualSensor>();
   
   private static final ConcurrentHashMap<String, TreeMap<String, Boolean>> vsNamesToOutputStructureFields = new ConcurrentHashMap<String, TreeMap<String, Boolean>>();
   
   private static final transient Logger logger = LoggerFactory.getLogger(Mappings.class);
   
   public static boolean addVSensorInstance(VirtualSensor sensorPool) {
      try {
         logger.info("Testing the pool for :" + sensorPool.getConfig().getName());
         sensorPool.returnVS(sensorPool.borrowVS());
      } catch (Exception e) {
         sensorPool.closePool();
         logger.error("GSN can't load the virtual sensor specified at " + sensorPool.getConfig().getFileName() + " because the initialization of the virtual sensor failed. " + e.getMessage(), e );
         return false;
      }
      TreeMap < String , Boolean > vsNameToOutputStructureFields = new TreeMap<String, Boolean>();
      vsNamesToOutputStructureFields.put(sensorPool.getConfig().getName(), vsNameToOutputStructureFields);
      for (DataField fields : sensorPool.getConfig().getOutputStructure()) {
         vsNameToOutputStructureFields.put(fields.getName(), Boolean.TRUE);
      }
      vsNameToOutputStructureFields.put("timed", Boolean.TRUE);
      vsNameTOVSConfig.put(sensorPool.getConfig().getName(), sensorPool.getConfig());
      fileNameToVSInstance.put(sensorPool.getConfig().getFileName(), sensorPool);
      return true;
   }
   
   public static VirtualSensor getVSensorInstanceByFileName(String fileName) {
      return fileNameToVSInstance.get(fileName);
   }
   
   public static final TreeMap<String, Boolean> getVsNamesToOutputStructureFieldsMapping(String vsName) {
      return vsNamesToOutputStructureFields.get(vsName);
   }
   
   public static VSensorConfig getVSensorConfig ( String vSensorName ) {
      if ( vSensorName == null ) return null;
      return vsNameTOVSConfig.get( vSensorName );
   }
   
   public static void removeFilename ( String fileName ) {
	   if(fileNameToVSInstance.containsKey(fileName)){
		   VSensorConfig config = ( fileNameToVSInstance.get( fileName ) ).getConfig( );
		   vsNameTOVSConfig.remove( config.getName( ) );
		   fileNameToVSInstance.remove( fileName );
	   }
   }
   
   public static Long getLastModifiedTime ( String configFileName ) {
      return Long.valueOf( ( fileNameToVSInstance.get( configFileName ) ).getLastModified( ) );
   }
   
   public static String[] getAllKnownFileName() {
      return fileNameToVSInstance.keySet().toArray(new String[0]);
   }
   
   public static VSensorConfig getConfigurationObject(String fileName) {
      if (fileName == null) return null;
      return (fileNameToVSInstance.get(fileName)).getConfig();
   }
   
   public static Iterator <VSensorConfig> getAllVSensorConfigs() {
      return vsNameTOVSConfig.values().iterator();
   }
   
   public static VirtualSensor getVSensorInstanceByVSName(String vsensorName) {
      if (vsensorName == null) return null;
      VSensorConfig vSensorConfig = vsNameTOVSConfig.get(vsensorName);
      if (vSensorConfig == null) return null;
      return getVSensorInstanceByFileName(vSensorConfig.getFileName());
   }
   /**
    * Case insensitive matching.
    * @param vsName
    * @return
    */
   public static VSensorConfig getConfig(String vsName) {
		Iterator<VSensorConfig> configs = Mappings.getAllVSensorConfigs();
		while(configs.hasNext()) {
			VSensorConfig config = configs.next();
			if (config.getName().equalsIgnoreCase(vsName))
				return config;
		}
		return null;
	}  
}
