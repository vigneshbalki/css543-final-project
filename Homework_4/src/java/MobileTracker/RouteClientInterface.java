/*
 * Authors:    Dave Hunn, Chris Livdahl
 * Date:       3/12/12
 * Course:     CSS 543
 * Instructor: M. Fukuda
 */
package MobileTracker;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Dave
 */
public interface RouteClientInterface extends Remote {
  public void receiveRouteList(ArrayList<Route> routes) throws RemoteException;
  public void receiveRoute(String route) throws RemoteException;
}
