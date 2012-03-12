/*
 * Authors:    Dave Hunn, Chris Livdahl
 * Date:       3/12/12
 * Course:     CSS 543
 * Instructor: M. Fukuda
 */
package MobileTracker;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * RouteClient: This class handles communications with the 
 *              RouteServerImplementation. Each of the two servlets
 *              has an instance of this class.
 */
public class RouteClient {
  /**
   * routeServer: Used to retrieve route data from the RouteServer via RMI.
   */
  RouteServerInterface routeServer;
  /**
   * currRoute: The RouteClient stores a copy of the last retrieved Route.
   */
  Route currRoute;
  
  /**
   * Constructor: The new RouteClient attempts to contact the RMI server and 
   *              initialize its RouteServerInterface object.
   * 
   * @param serverIp The name of the server that is hosting the RMI server.
   * @param port The port the server is listening on.
   */
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
   * getRouteNames: Route title data obtained via call to the routeServer over
   *                RMI.
   * 
   * @return An ArrayList of Route objects. Returns null if no Routes are found.
   */
  public ArrayList<Route> getRouteNames() {
    ArrayList<Route> returnSet = null;
    String routeListString;
    Gson gson = new Gson();
      
    try {
        routeListString = routeServer.getRouteTitles();
        // from http://sites.google.com/site/gson/gson-user-guide#TOC-Object-Examples
        // Under Serializing and Deserializing Generic Types section.
        java.lang.reflect.Type routeArray = new TypeToken<ArrayList<Route>>() {} .getType();
        returnSet = gson.fromJson(routeListString, routeArray);
    } catch (RemoteException ex) {
      Logger.getLogger(RouteClient.class.getName()).log(Level.SEVERE, null, ex);
    }
     
    return returnSet;
  }
  
  /**
   * getRoute: Route data obtained via call to the routeServer over RMI.
   * 
   * @return The route with ID routeID as a json-formatted string.
   */
  public String getRoute(int routeID) {
    String returnRoute = null;
    
    try {
      returnRoute = routeServer.getRoute(routeID);
      currRoute.fromString(returnRoute);
    } catch (RemoteException ex) {
      Logger.getLogger(RouteClient.class.getName()).log(Level.SEVERE, null, ex);
    }
    return returnRoute;
  }
  
  /**
   * getSpeedsFromCurrentRoute: 
   * 
   * @return A json-formatted string version of an array of speeds.
   */
  public String getSpeedsFromCurrentRoute() {
    Gson gson = new Gson();
    String json;
    double[] speeds = new double[currRoute.locations.size()];
    
    for (int i = 0; i < currRoute.locations.size(); i++ ) {
      speeds[i] = currRoute.locations.get(i).getSpeed();
    }
    json = gson.toJson(speeds);
    
    return json;
  }
  
}
