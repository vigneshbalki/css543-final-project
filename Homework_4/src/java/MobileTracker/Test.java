
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MobileTracker;

import com.google.gson.Gson;

/**
 *
 * @author clivdahl
 */
public class Test {
	
	
	public static void main(String[] args) {
		
		
		RouteClient client = new RouteClient("localhost", 7311);
		
		String aRoute = client.getRoute(1);
		
		System.out.println(aRoute); 
		
//		Route obj = new Route(); 
//		//r.load("src/java/MobileTracker/route1.json");
//	
//		
//		
//		Gson gson = new Gson();
//		String json = gson.toJson(obj);
		
	}
	
}
