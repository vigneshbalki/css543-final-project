package MobileTracker;

import java.rmi.*;
import java.util.Set;

public interface RouteServerInterface extends Remote {

  public Set<String> getRouteNameSet(/*String user_name*/) 
          throws RemoteException;
  
  public String getRoute(int routeID) throws RemoteException;
  
  public void addRoute(int routeID, RouteServlet r) throws RemoteException;
}
