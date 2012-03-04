/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MobileTracker;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dave
 */
public class RouteClient {
  RouteServerInterface routeServer;
  
  public RouteClient(String serverIp, int port) {
    try {
      routeServer = (RouteServerInterface) Naming.lookup("rmi://" + serverIp +
                    ":" + port + "/route_server");
    } catch (NotBoundException ex) {
      Logger.getLogger(RouteClient.class.getName()).log(Level.SEVERE, null, ex);
    } catch (MalformedURLException ex) {
      Logger.getLogger(RouteClient.class.getName()).log(Level.SEVERE, null, ex);
    } catch (RemoteException ex) {
      Logger.getLogger(RouteClient.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  /**
   * This method handles contacting the RMI route server.
   * @return A set of route names stored on the route server.
   */
  public ArrayList<Route> getRouteNames() {
    ArrayList<Route> returnSet = null;
    
    try {
      // ivoke the metod
      returnSet = routeServer.getRouteNameSet();
    } catch (Exception e) {
      e.printStackTrace();
//      System.exit(-1);
    }
    return returnSet;
  }
  
  /**
   * 
   * @return 
   */
  public String getRoute(int routeID) {
    String returnRoute = null;
    
    try {
      // ivoke the metod
      returnRoute = routeServer.getRoute(routeID);
    } catch (Exception e) {
      e.printStackTrace();
//      System.exit(-1);
    }
    return returnRoute;
  }
}
