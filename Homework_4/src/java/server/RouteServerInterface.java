package server;

import java.rmi.*;
import java.util.Set;

public interface RouteServerInterface extends Remote {

  public Set<String> getRouteNameSet(/*String user_name*/) 
          throws RemoteException;
  
  public Route getRoute(String routeName) throws RemoteException;
  
  public void addRoute(String routeName, Route r) throws RemoteException;
}
