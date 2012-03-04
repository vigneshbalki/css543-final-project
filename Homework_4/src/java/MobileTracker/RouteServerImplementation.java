package MobileTracker;

import java.rmi.RemoteException;
import java.rmi.server.*;
import java.util.*;

public class RouteServerImplementation extends UnicastRemoteObject
        implements RouteServerInterface {
  RouteFileReader reader;
  
  
  public RouteServerImplementation() throws RemoteException {
    super();
   reader = new RouteFileReader();
  }

  /**
   * 
   * @return The set of route names stored in the route server.
   * @throws RemoteException 
   */
  @Override
  public ArrayList<Route> getRouteNameSet() throws RemoteException {
    ArrayList<Route> routes = new ArrayList<Route>() {};
    
    for (int i = 0; i < 3; i++) {
      Route r = new Route("Route " + i, i);
      routes.add(r);
    }
    //not sure how this will work.
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
  public String getRoute(int routeID) throws RemoteException {
    String r = "this is the route asscoiated with route " + routeID;
    return r;
  }
}
