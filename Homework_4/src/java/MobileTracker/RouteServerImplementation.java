package MobileTracker;

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
  public ArrayList<Route> getRouteNameSet() throws RemoteException {
    ArrayList<Route> routes = new ArrayList<Route>() {};
    
    for (String fileName : routeFileNames) {
      Route r = new Route();
      r.load(fileName);
      r.locations.clear();
      routes.add(r);
    }

    return routes;
  }

  /**
   * 
   * @param routeName The name of the route you wish to retrieve.
   * @return If routeName exists, then the associated route is returned.
   *         Returns null if routeName does not exist.
   * @throws RemoteException 
   */
  @Override
  public Route getRoute(int routeID) throws RemoteException {
    Route r = new Route();
    
    r.load(routeFileNames.get(routeID - 1));
    return r;
  }
}
