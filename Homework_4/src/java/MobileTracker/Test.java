/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MobileTracker;

/**
 *
 * @author clivdahl
 */
public class Test {
	
	
	public static void main(String[] args) {
		
		
		RouteClient client = new RouteClient("localhost", 7311);
		
		String aRoute = client.getRoute(1);
		
		System.out.println(aRoute); 
		
		//Route r = new Route(); 
		//r.load("src/java/MobileTracker/route1.json");
	
	}
	
}
