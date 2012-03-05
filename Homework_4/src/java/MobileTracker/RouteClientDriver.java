/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MobileTracker;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Dave
 */
public class RouteClientDriver {

  public static void main(String args[]) {
    RouteClient client = new RouteClient("localhost", 7311);
    
    for (int i  = 1; i < 4; i++) {
      System.out.println(client.getRoute(i));
    }
    System.out.println(client.getRouteNames().toString());
  }
}
