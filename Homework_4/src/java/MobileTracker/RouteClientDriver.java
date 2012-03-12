/*
 * Authors:    Dave Hunn, Chris Livdahl
 * Date:       3/12/12
 * Course:     CSS 543
 * Instructor: M. Fukuda
 */
package MobileTracker;

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
