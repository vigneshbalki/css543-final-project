/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MobileTracker;

import com.google.gson.Gson;
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
  Route currRoute;
  
  public RouteClient(String serverIp, int port) {
    try {
      routeServer = (RouteServerInterface) Naming.lookup("rmi://" + serverIp +
                    ":" + port + "/route_server");
      System.out.println("Connected to route server.");
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
      // invoke the metod
      returnSet = routeServer.getRouteNameSet();
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("Returning the following list of routes " + returnSet.toString());
    return returnSet;
  }
  
  /**
   * 
   * @return The route in json format.
   */
  public String getRoute(int routeID) {
    Route returnRoute = null;
    
    try {
      // ivoke the metod
      returnRoute = routeServer.getRoute(routeID);
      currRoute = returnRoute;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return returnRoute.toString();
  }
  
  /**
   * 
   * @return A json array of speeds.
   */
  public String getSpeedsFromCurrentRoute() {
    Gson gson = new Gson();
    String json = null;
    double[] speeds = new double[currRoute.locations.size()];
    
    for (int i = 0; i < currRoute.locations.size(); i++ ) {
      speeds[i] = currRoute.locations.get(i).getSpeed();
    }
    json = gson.toJson(speeds);
    
    return json;
  }
  
}
