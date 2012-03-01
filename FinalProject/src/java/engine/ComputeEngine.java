/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package engine;

import compute.Compute;
import compute.Task;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Dave
 */
public class ComputeEngine implements Compute {

  public ComputeEngine() {
    super();
  }

  public <T> T executeTask(Task<T> t) {
    return t.execute();
  }

  public static void main(String[] args) {
    if (System.getSecurityManager() == null) {
      System.setSecurityManager(new SecurityManager());
    }
    try {
      String name = "Compute";
      Compute engine = new ComputeEngine();
      Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);
      startRegistry();
      Registry registry = LocateRegistry.getRegistry();
      registry.rebind(name, stub);
      System.out.println("ComputeEngine bound");
    } catch (Exception e) {
      System.err.println("ComputeEngine exception:");
      e.printStackTrace();
    }
  }
  
  private static void startRegistry() throws RemoteException {
    try {
    Registry reg = LocateRegistry.getRegistry(); // use default port 1099
    reg.list();
    } catch (RemoteException e) {
      Registry reg = LocateRegistry.createRegistry(1099); // use default port
    }
  }
}
