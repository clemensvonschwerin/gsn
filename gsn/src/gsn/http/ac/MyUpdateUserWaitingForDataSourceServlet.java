package gsn.http.ac;

import gsn.Main;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: Behnaz Bostanipour
 * Date: Apr 24, 2010
 * Time: 4:41:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class MyUpdateUserWaitingForDataSourceServlet extends HttpServlet
{
    /****************************************** Servlet Methods*******************************************/
    /****************************************************************************************************/
    public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
    {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        // Get the session
        HttpSession session = req.getSession();
        ConnectToDB ctdb = null;
        DataSource newDataSource=null;
        DataSource oldDataSource=null;
        //String newType=null;
        User user = (User) session.getAttribute("user");
        if (user == null)
       {
          this.redirectToLogin(req,res);
       }
       else
       {
           this.checkSessionScheme(req,res);
           ParameterSet pm = new ParameterSet(req);

           try
           {
               ctdb=new ConnectToDB();
               if(ctdb.getDataSourceListForParameterSet(pm)==null)
               {
                   res.sendRedirect("/");
                   return;
               }
               if(ctdb.getDataSourceListForParameterSet(pm).size()==0)
               {
                   res.sendRedirect("/gsn/MyUserUpdateServlet");
                   return;
               }
               newDataSource=(DataSource)ctdb.getDataSourceListForParameterSet(pm).get(0);
               if(newDataSource==null)
               {
                   res.sendRedirect("/");
                   return;
               }

               oldDataSource=ctdb.getDataSourceForUser(user,newDataSource.getDataSourceName());


               if(oldDataSource !=null)
               {


               }
               if(ctdb.valueExistsForThisColumnUnderTwoConditions(new Column("ISUSERWAITING","yes"),new Column("USERNAME",user.getUserName()),new Column("DATASOURCENAME",newDataSource.getDataSourceName()), "ACUSER_ACDATASOURCE")==false)
               {

                   if(oldDataSource==null)
                   {
						user.setIsWaiting("yes");
						newDataSource.setDataSourceType("5"+ newDataSource.getDataSourceType());
						newDataSource.setOwnerDecision("notreceived");
						ctdb.registerDataSourceForUser(user,newDataSource);

						Emailer email = new Emailer();
						User owner = ctdb.getOwnerOfDataSource(newDataSource.getDataSourceName());
		                String msgHead = "Dear "+owner.getFirstName()+" "+owner.getLastName()+", "+"\n"+"\n";
						
						String msgBody = user.getFirstName()+" "+user.getLastName()+" (username="+user.getUserName()+") would like to have access rights:"+"\n"
						        +"virtual sensor: "+newDataSource.getDataSourceName()+"\n"
						        +"access right: "+newDataSource.getAccessRightsString()+"\n"+"\n";
						
						String msgTail = "Best Regards,"+"\n"+"GSN Team";
						
						// first change Emailer class params to use sendEmail
						email.sendEmail(owner.getEmail(),Main.getContainerConfig( ).getWebName( )+": Virtual Sensor New Access Rights request", msgHead, msgBody, msgTail);
	       	       }
                   else if(!oldDataSource.getDataSourceType().equals(newDataSource.getDataSourceType()))
                   {
						Emailer email = new Emailer();
						User owner = ctdb.getOwnerOfDataSource(oldDataSource.getDataSourceName());
		                String msgHead = "Dear "+owner.getFirstName()+" "+owner.getLastName()+", "+"\n"+"\n";

						String msgBody = user.getFirstName()+" "+user.getLastName()+" (username="+user.getUserName()+") would like to update access rights:"+"\n"
						        +"virtual sensor: "+oldDataSource.getDataSourceName()+"\n"
								+"existing access right: "+oldDataSource.getAccessRightsString()+"\n"
								+"requested access right: "+newDataSource.getAccessRightsString()+"\n"+"\n";
						
						String msgTail = "Best Regards,"+"\n"+"GSN Team";
						
						// first change Emailer class params to use sendEmail
						email.sendEmail(owner.getEmail(),Main.getContainerConfig( ).getWebName( )+": Virtual Sensor Update Access Rights request", msgHead, msgBody, msgTail);
                        
						user.setIsWaiting("yes");
                        oldDataSource.setDataSourceType(oldDataSource.getDataSourceType().charAt(0)+ newDataSource.getDataSourceType());
                        oldDataSource.setOwnerDecision("notreceived");
                        ctdb.updateDataSourceForUser(user,oldDataSource);
                   }
               }
               res.sendRedirect("/gsn/MyUserUpdateServlet");
           }
           catch(Exception e)
           {
               out.println("Exception caught : "+e.getMessage());
           }
           finally
           {
               if(ctdb!=null)
               {
                   ctdb.closeStatement();
                   ctdb.closeConnection();
               }
           }
       }
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException
    {
           this.doPost(req,res);
    }

    /****************************************** Client Session related Methods*******************************************/
    /********************************************************************************************************************/


    private void checkSessionScheme(HttpServletRequest req, HttpServletResponse res)throws IOException
    {

         if(req.getScheme().equals("https")== true)
        {
            if((req.getSession().getAttribute("scheme")==null))
            {
                req.getSession().setAttribute("scheme","https");
            }
        }
         else if(req.getScheme().equals("http")== true )
        {
             if((req.getSession().getAttribute("scheme")==null))
            {
                req.getSession().setAttribute("scheme","http");
            }
             
            String remoteHost = req.getHeader("x-forwarded-for");
            if (remoteHost == null) {
                remoteHost = req.getHeader("X_FORWARDED_FOR");
                if (remoteHost == null) {
                    remoteHost = req.getRemoteHost();
                }
            }
            res.sendRedirect("https://"+remoteHost+"/gsn/MyUpdateUserWaitingForDataSourceServlet");

        }
    }
    private void redirectToLogin(HttpServletRequest req, HttpServletResponse res)throws IOException
    {
        req.getSession().setAttribute("login.target", HttpUtils.getRequestURL(req).toString());
        res.sendRedirect("/gsn/MyLoginHandlerServlet");
    }

}
