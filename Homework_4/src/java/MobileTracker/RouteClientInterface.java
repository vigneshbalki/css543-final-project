/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
