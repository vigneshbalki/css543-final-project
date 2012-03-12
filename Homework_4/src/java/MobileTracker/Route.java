/*
 * Authors:    Dave Hunn, Chris Livdahl
 * Date:       3/12/12
 * Course:     CSS 543
 * Instructor: M. Fukuda
 */
package MobileTracker;

import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/** 
 * Route: Stores data about a single route. This class can load itself from
 *        disk or from a String.
 */
public class Route implements Serializable {
  String title;
  Integer routeid;
  ArrayList<Location> locations;
  
  /**
   * Default Constructor: Initializes the Route object with an empty locations
   *                      list.
   */
  public Route() {
    this.title = "";
    this.routeid = new Integer(-1);
    this.locations = new ArrayList<Location>();
  }
  
  /**
   * Constructor: New Route with title title title and routeid id.
   * @param name
   * @param id 
   */
  public Route(String title, Integer id) {
    this.title = title;
    this.routeid = id;
    this.locations = new ArrayList<Location>();
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
  
  /**
   * toString
   * 
   * @return The Route object as a json-formatted String.
   */
  @Override
  public String toString() {
    String retVal = null;
    Gson gson = new Gson();
    
    retVal = gson.toJson(this);
    return retVal;
  }
  
  /**
   * fromString: The calling Route object deserializes the String s and uses 
   *             it to populate its data.
   * 
   * @param s A json-formatted String.
   */
  public void fromString(String s) {
    Gson gson = new Gson();

    Route route = gson.fromJson(s, Route.class);
    this.title = route.title;
    this.routeid = route.routeid;
    this.locations = route.locations;
  }
  
  /**
   * load: The calling Route object populates its data using filename.
   * 
   * @param fileName A json-formatted text file containing data for a single 
   *                 route.
   */
  public void load(String fileName) {
    try {
      this.fromString(readFile(fileName));
    } catch (IOException ex) {
      Logger.getLogger(Route.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  /**
   * readFile: This method is used to stringify a text file containing route
   *           data.
   * 
   * @param pathname
   * @return A stringifed version of the file at pathname.
   * @throws IOException 
   */
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
