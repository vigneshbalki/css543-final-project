/*
 * Authors:    Dave Hunn, Chris Livdahl
 * Date:       3/12/12
 * Course:     CSS 543
 * Instructor: M. Fukuda
 */
package MobileTracker;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface RouteServerInterface extends Remote {
  public String getRouteTitles() throws RemoteException;  
  public String getRoute(int routeID) throws RemoteException;
}
