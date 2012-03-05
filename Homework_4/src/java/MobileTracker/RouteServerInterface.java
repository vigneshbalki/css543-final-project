package MobileTracker;

import java.rmi.*;
import java.util.ArrayList;


public interface RouteServerInterface extends Remote {
  public ArrayList<Route> getRouteNameSet() throws RemoteException;  
  public Route getRoute(int routeID) throws RemoteException;
}
