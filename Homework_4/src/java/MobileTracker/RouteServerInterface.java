package MobileTracker;

import java.rmi.*;
import java.util.ArrayList;


public interface RouteServerInterface extends Remote {

  public ArrayList<Route> getRouteNameSet(/*String user_name*/) 
          throws RemoteException;
  
  public String getRoute(int routeID) throws RemoteException;

}
