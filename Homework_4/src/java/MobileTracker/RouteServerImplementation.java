package MobileTracker;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
//import java.lang.ProcessBuilder.Redirect.Type;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.util.*;

public class RouteServerImplementation extends UnicastRemoteObject
        implements RouteServerInterface {
  ArrayList<String> routeFileNames;
  
  public RouteServerImplementation() throws RemoteException {
    super();
    routeFileNames = new ArrayList<String>();
    routeFileNames.add("src/java/MobileTracker/route1.json");
    routeFileNames.add("src/java/MobileTracker/route2.json");
    routeFileNames.add("src/java/MobileTracker/route3.json");
  }

  /**
   * 
   * @return The set of route names stored in the route server.
   * @throws RemoteException 
   */
  @Override
  public String getRouteNameSet() throws RemoteException {
    Gson gson = new Gson();
    ArrayList<Route> routes = new ArrayList<Route>() {};
    String retVal = null;
    
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
   * 
   * @param routeName The name of the route you wish to retrieve.
   * @return If routeName exists, then the associated route is returned.
   *         Returns null if routeName does not exist.
   * @throws RemoteException 
   */
  @Override
  public String getRoute(int routeID) throws RemoteException {
    Route r = new Route();
    
    r.load(routeFileNames.get(routeID - 1));
    return r.toString();
  }
}
