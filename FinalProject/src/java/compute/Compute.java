/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package compute;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Dave
 */
public interface Compute extends Remote {
  <T> T executeTask(Task<T> t) throws RemoteException;
}
