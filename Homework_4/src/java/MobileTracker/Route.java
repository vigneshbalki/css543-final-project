/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MobileTracker;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dave
 */
public class Route {
  String title;
  Integer routeid;
  ArrayList<Location> locations;
  
  public Route() {
    this.setName("");
    this.setId(new Integer(-1));
    locations = new ArrayList<Location>();
  }
  
  public Route(String name, Integer id) {
    this.setName(name);
    this.setId(id);
  }
    
  public void setName(String name) {
    this.title = name;
  }
  public String getName() {
    return this.title;
  }
  
  public void setId(Integer id) {
    this.routeid = id;
  }
  public Integer getId() {
    return this.routeid;
  }
  
  @Override
  public String toString() {
    String retVal = null;
    Gson gson = new Gson();
    
    retVal = gson.toJson(this);
    return retVal;
  }
  
  public void load(String fileName) {
    Gson gson = new Gson();
    
    try {
      Route route = gson.fromJson(readFile(fileName), Route.class);
      System.out.println(route.toString());
    } catch (IOException ex) {
      Logger.getLogger(RouteFileReader.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  private String readFile(String pathname) throws IOException {

		File file = new File(pathname);
		StringBuilder fileContents = new StringBuilder((int)file.length());
		Scanner scanner = new Scanner(file);
		String lineSeparator = System.getProperty("line.separator");
    
		try {
			while(scanner.hasNextLine()) {        
				fileContents.append(scanner.nextLine());
				fileContents.append(lineSeparator); 
			}
			return fileContents.toString();
		} finally {
			scanner.close();
		}
  }
}
