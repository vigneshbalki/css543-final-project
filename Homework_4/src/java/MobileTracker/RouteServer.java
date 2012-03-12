/*
 * Authors:    Dave Hunn, Chris Livdahl
 * Date:       3/12/12
 * Course:     CSS 543
 * Instructor: M. Fukuda
 */
package MobileTracker;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * RouteServer: This class starts the RMI server and registers the 
 *              a RouteServerImplementation object with the server.
 */
public class RouteServer {

  public static void main(String args[]) {
    // verify arguments
    int port = 7311;
    
//    try {
//      if (args.length == 1) {
//        port = Integer.parseInt(args[0]);
//        if (port < 5001 || port > 65535) {
//          throw new Exception();
//        }
//      } else {
//        throw new Exception();
//      }
//    } catch (Exception e) {
//      System.err.println("Usage: java Server port");
//      System.exit(-1);
//    }

    try {
      startRegistry(port);
      RouteServerImplementation serverObject = new RouteServerImplementation();
      Naming.rebind("rmi://localhost:" + port + "/route_server",
              serverObject);
      System.out.println("Route server ready.");
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(-1);
    }
  }

  /**
   * startRegistry: This method first looks for an existing RMI registry. If
   *                it finds one then it stores a reference to it. Otherwise
   *                a new registry is created.
   * 
   * @param port The port to look for or create the registry.
   * @throws RemoteException 
   */
  private static void startRegistry(int port) throws RemoteException {
    try {
      Registry registry = LocateRegistry.getRegistry(port);
      registry.list();
    } catch (RemoteException e) {
      Registry registry = LocateRegistry.createRegistry(port);
    }
  }
}
