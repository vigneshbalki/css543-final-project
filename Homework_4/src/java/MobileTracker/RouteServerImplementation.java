/*
 * Authors:    Dave Hunn, Chris Livdahl
 * Date:       3/12/12
 * Course:     CSS 543
 * Instructor: M. Fukuda
 */
package MobileTracker;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 * RouteServerImplementation: This class retrieves route data from 
 *                            json-formatted text files and returns it
 *                            via RMI to the client.
 */
public class RouteServerImplementation extends UnicastRemoteObject
        implements RouteServerInterface {
  /**
   * routeFileNames: A list of know route files.
   */
  ArrayList<String> routeFileNames;
  
  /**
   * Default Constructor: routeFileNames is initialized with hard-coded file
   *                      file names.
   * 
   * @throws RemoteException 
   */
  public RouteServerImplementation() throws RemoteException {
    super();
    routeFileNames = new ArrayList<String>();
    routeFileNames.add("src/java/MobileTracker/route1.json");
    routeFileNames.add("src/java/MobileTracker/route2.json");
    routeFileNames.add("src/java/MobileTracker/route3.json");
  }

  /**
   * getRouteTitles:
   * 
   * @return A json-formatted string version of an ArrayList of Route objects.
   * 
   * @throws RemoteException 
   */
  @Override
  public synchronized String getRouteTitles() throws RemoteException {
    Gson gson = new Gson();
    ArrayList<Route> routes = new ArrayList<Route>() {};
    String retVal;
    
    for (String fileName : routeFileNames) {
      Route r = new Route();
      r.load(fileName);
      r.locations.clear();
      routes.add(r);
    }
    
    // from http://sites.google.com/site/gson/gson-user-guide#TOC-Object-Examples
    // Under Serializing and Deserializing Generic Types section.
    java.lang.reflect.Type routeArray = new TypeToken<ArrayList<Route>>() {} .getType();
    retVal = gson.toJson(routes, routeArray);
    System.out.println(retVal);
    return retVal;
  }

  /**
   * getRoute:
   * 
   * @param routeID The id of the route you wish to retrieve.
   * @return If routeID exists, then the associated route is returned as a 
   *         json-formatted string.
   * 
   * @throws RemoteException 
   */
  @Override
  public synchronized String getRoute(int routeID) throws RemoteException {
    Route r = new Route();
    
    if (routeID > 0 && routeID <routeFileNames.size() + 1) {
      r.load(routeFileNames.get(routeID - 1));
    }
    return r.toString();
  }
}
