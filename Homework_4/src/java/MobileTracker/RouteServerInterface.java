package MobileTracker;

import java.rmi.*;
import java.util.ArrayList;


public interface RouteServerInterface extends Remote {
  public String getRouteNameSet() throws RemoteException;  
  public String getRoute(int routeID) throws RemoteException;
}
