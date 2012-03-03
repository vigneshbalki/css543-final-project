/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MobileTracker;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.rmi.Naming;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author clivdahl
 */
public class RoutesServlet extends HttpServlet {

	/**
	 * Processes requests for both HTTP
	 * <code>GET</code> and
	 * <code>POST</code> methods.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			// This is where we want to request the list of all routes
			// and create links that the user can click on, like so: 
			Set<String> routeNames = getRouteNames();
      Iterator<String> iter = routeNames.iterator();
      String title;
      int routeid = 1; 
      String dataString;
      
      while (iter.hasNext()) {
        title = iter.next();
        dataString = "{" + " title:" + '"' + title + '"' + ","
                         + " routeid:" + '"' + routeid + '"' 
                         + " }" ; 
        out.println("<a href='route.jsp?routeid=" + routeid + "'>" + title + "</a>");
        routeid++;
      }
		} finally {			
			//out.close();
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP
	 * <code>GET</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Handles the HTTP
	 * <code>POST</code> method.
	 *
	 * @param request servlet request
	 * @param response servlet response
	 * @throws ServletException if a servlet-specific error occurs
	 * @throws IOException if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

  /**
   * This method handles contacting the RMI route server.
   * @return A set of route names stored on the route server.
   */
  private Set<String> getRouteNames() {
    String serverIp = "localhost";
    int port = 7311;
    Set<String> returnSet = null;
    
    try {
      // get the object reference from the rmi name server
      MobileTracker.RouteServerInterface routeServer = 
              (MobileTracker.RouteServerInterface) Naming.lookup("rmi://" + serverIp +
              ":" + port + "/route_server");
      // ivoke the metod
      returnSet = routeServer.getRouteNameSet();
    } catch (Exception e) {
      e.printStackTrace();
//      System.exit(-1);
    }
    return returnSet;
  }
}
