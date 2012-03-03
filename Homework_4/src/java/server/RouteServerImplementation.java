package server;

import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class RouteServerImplementation extends UnicastRemoteObject
        implements RouteServerInterface {
  /**
   *  The set of all routes stored in the route server.
   */
  private HashMap<String, Route> routes;
  
  
  public RouteServerImplementation() throws RemoteException {
    super();
    routes = new HashMap<String, Route>();
    MobileTracker.RouteFileReader reader = new MobileTracker.RouteFileReader();
    // slurp data into HashMap.
  }

  /**
   * 
   * @return The set of route names stored in the route server.
   * @throws RemoteException 
   */
  @Override
  public Set<String> getRouteNameSet() throws RemoteException {
    return routes.keySet();
  }

  /**
   * 
   * @param routeName The name of the route you wish to retrieve.
   * @return If routeName exists, then the associated route is returned.
   *         Returns null if routeName does not exist.
   * @throws RemoteException 
   */
  @Override
  public Route getRoute(String routeName) throws RemoteException {
    return routes.get(routeName);
  }

  /**
   * If routeName does not exist, then Route r is added with key routeName.
   * If routeName already exists then the value associated with that key 
   * is set to r.
   * @param routeName
   * @param r
   * @throws RemoteException 
   */
  @Override
  public void addRoute(String routeName, Route r) throws RemoteException {
    routes.put(routeName, r);
  }

}
