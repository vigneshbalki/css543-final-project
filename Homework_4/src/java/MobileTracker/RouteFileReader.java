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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author clivdahl
 */
public class RouteFileReader {
	
	public static void main(String args[]) {	
//		FileReader reader; 
//		BufferedReader bufferedReader; 
//		JsonReader jsonReader; 
//		
//		String filePath = "src/java/MobileTracker/route1.json"; 
//		
//		try { 
//			String fileOutput = readFile(filePath); 
//			System.out.println(fileOutput); 
//		} catch (IOException e) {
//			
//		}
    foo();
		//System.out.println("test\n"); 
		//String curDir = System.getProperty("user.dir");
		//System.out.println(curDir); 
	
		//try {
			//reader = new FileReader("src/java/MobileTracker/route1.json"); 
			//bufferedReader = new BufferedReader(reader); 
			//jsonReader = new JsonReader(reader);
			//Gson gson = new Gson(); 
			//String output = gson.fromJson(jsonReader, String.class); 
			//System.out.println(output); 
			//System.out.println(reader); 
		//} catch (FileNotFoundException e) {
			//System.out.println("File not found\n"); 
		//} 		
	}
	
	/* 
	 * Code for reading the contents of a file to a string 
	 * found code at http://stackoverflow.com/questions/326390/how-to-create-a-java-string-from-the-contents-of-a-file
	 */
	public static String readFile(String pathname) throws IOException {

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
  
  public static void foo() {
    Gson gson = new Gson();
    try {
      Route route = gson.fromJson(readFile("src/java/MobileTracker/route1.json"), Route.class);
      System.out.println(route.toString());
    } catch (IOException ex) {
      Logger.getLogger(RouteFileReader.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
          
}
