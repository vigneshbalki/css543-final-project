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

//    ArrayList<String> routeNames = client.getRouteNames();
//    Iterator<String> iter = routeNames.iterator();
//
//    while (iter.hasNext()) {
//      Route r = new Route();
//      r.fromString(iter.next());
//      System.out.println("<a href='route.jsp?routeid=" + r.getId().toString() + "'>" + r.getName() + "</a>");
//    }
    
    //for (int i  = 1; i < 4; i++) {
    //  System.out.println(client.getRoute(i));
    //}
    System.out.println(client.getRouteNames().toString());
  }
}
