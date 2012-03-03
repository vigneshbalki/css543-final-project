package MobileTracker;

import java.rmi.*;
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
  public Set<String> getRouteNameSet() throws RemoteException {
    //not sure how this will work.
    return null;
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
    //reader.readFile(null)
    return null;
  }

 /**
  * 
  * @param routeID
  * @param r
  * @throws RemoteException 
  */
  @Override
  public void addRoute(int routeID, Route r) throws RemoteException {
    throw new UnsupportedOperationException("Not supported yet.");
  }

}
