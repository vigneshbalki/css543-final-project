package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

 String last_updated = "03012012"; 
  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write('\n');
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t\n");
      out.write("\t<title>CSS 543 - David Hunn & Chris Livdahl</title>\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t<link rel=\"stylesheet\" href=\"style.css?");
      out.print(last_updated);
      out.write("\" type=\"text/css\">\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t<meta name=\"viewport\" content=\"initial-scale=1.0, user-scalable=no\" />\n");
      out.write("\t\n");
      out.write("\t<style type=\"text/css\">\n");
      out.write("      html { /* height: 100% */  }\n");
      out.write("      body { /* height: 100%; margin: 0; padding: 0 */ }\n");
      out.write("      #map_canvas { width: 400px; height: 400px; }\n");
      out.write("    </style>\n");
      out.write("\t\n");
      out.write("\t<script type=\"text/javascript\"\n");
      out.write("      src=\"http://maps.googleapis.com/maps/api/js?key=AIzaSyBwEjS8fI30MwKEpwcnAf4NdOZym66Ot5s&sensor=false\">\n");
      out.write("    </script>\n");
      out.write("    <script type=\"text/javascript\">\n");
      out.write("      function initialize() {\n");
      out.write("\t\t  \n");
      out.write("\t\tvar myLatLng = new google.maps.LatLng(47.6063889, -122.3308333);\n");
      out.write("\t\t  \n");
      out.write("        var myOptions = {\n");
      out.write("\t\t\tcenter: myLatLng, \n");
      out.write("\t\t\tzoom: 12,\n");
      out.write("\t\t\tmapTypeId: google.maps.MapTypeId.ROADMAP\n");
      out.write("        };\n");
      out.write("        var map = new google.maps.Map(document.getElementById(\"map_canvas\"),\n");
      out.write("            myOptions);\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\tvar marker = new google.maps.Marker({\n");
      out.write("\t\t\tposition: myLatLng,\n");
      out.write("\t\t\tmap: map,\n");
      out.write("\t\t\ttitle:\"Hello World!\", \n");
      out.write("\t\t\tanimation: google.maps.Animation.DROP\n");
      out.write("\t\t});\n");
      out.write("  \n");
      out.write("      }\n");
      out.write("    </script>\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("\t<script type=\"text/javascript\"\n");
      out.write("\t\t\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js\">\n");
      out.write("\t</script>\n");
      out.write("\t\n");
      out.write("\t<script text=\"text/javascript\"> \n");
      out.write("\t\n");
      out.write("\t\t$(document).ready(function() {\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t$.get(\n");
      out.write("\t\t\t\t\"RoutesServlet\", \n");
      out.write("\t\t\t\t{ list: all }, \n");
      out.write("\t\t\t\tfunction(data) { \n");
      out.write("\t\t\t\t\t$(\"#routes_data\").html(data); \n");
      out.write("\t\t\t\t}\n");
      out.write("\t\t\t)\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t}); \n");
      out.write("\t\t\n");
      out.write("\t</script>\n");
      out.write("\t\n");
      out.write("</head>\n");
      out.write("<body onload=\"initialize()\">\n");
      out.write("\t\n");
      out.write("\t<div id=\"menu_bar_wrapper\">\n");
      out.write("\t\n");
      out.write("\t\t<div id=\"menu_bar\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<div id=\"logo_small\" class=\"box_float_left\"> \n");
      out.write("\t\t\t\t<a href=\"index.jsp\">MobileTracker<!--img src=\"images/Logo_master.png\" height=\"27\" /--></a>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<div class=\"box_float_right\">\n");
      out.write("\t\t\t<ul>\n");
      out.write("\t\t\t\t<li><a href=\"Menu1\"><p>Menu1</p></a></li>\n");
      out.write("\t\t\t\t<li><a href=\"Menu2\"><p>Menu2</p></a></li>\n");
      out.write("\t\t\t\t<li><a href=\"Menu3\"><p>Menu3</p></a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t</div>\n");
      out.write("\n");
      out.write("\t\n");
      out.write("\t <div id=\"container-bgwrap\">\n");
      out.write("    \n");
      out.write("\t\t <div id=\"container\">\n");
      out.write("\n");
      out.write("\t\t\t  <!-- div id=\"masthead\"> \n");
      out.write("\n");
      out.write("\t\t\t\t\t<table width=\"100%\">\n");
      out.write("\t\t\t\t\t<tr>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t<div id=\"logo\"><img src=\"\" /></div> \n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\n");
      out.write("\t\t\t\t\t<td align=\"right\">\n");
      out.write("\t\t\t\t\t<div id=\"globalNav\"> \n");
      out.write("\t\t\t\t\t\t <p class=\"header\" align=\"right\"><br>\n");
      out.write("\t\t\t\t\t\t <a class=\"header\" href=\"\">Home</a> | \n");
      out.write("\t\t\t\t\t\t <a class=\"header\" href=\"\">Contact</a> \n");
      out.write("\t\t\t\t\t\t </p> \n");
      out.write("\t\t\t\t\t</div> \n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\n");
      out.write("\t\t\t\t\t</tr>\n");
      out.write("\t\t\t\t\t</table>\n");
      out.write("\t\t\t  </div --> \n");
      out.write("\t\t\t  \n");
      out.write("\t\t\t  \n");
      out.write("\t\t <div id=\"content-wrap\">\n");
      out.write("\n");
      out.write("\t\t\t<div class=\"style1\" id=\"content\"> \n");
      out.write("\n");
      out.write("\t\t\t\t<h1>Home</h1>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<p>Click on a route below to view details:</p>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<p>");
 // jsp:include page="Routes" / 
      out.write("</p>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<h2>Route title</h2>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<p id=\"routes_data\"></p>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t</div>\n");
      out.write("\n");
      out.write("\t\t\t<div id=\"right_side\">\n");
      out.write("\n");
      out.write("\t\t\t\t<h2>Side Nav</h2>\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t<!--p><a href=\"workportfolio\">Work Portfolio</a></p>\n");
      out.write("\t\t\t\t<p><a href=\"academicbackground\">Academic Background</a></p>\n");
      out.write("\t\t\t\t<p><a href=\"schoolportfolio\">School Portfolio</a></p>\n");
      out.write("\t\t\t\t<p><a href=\"audioportfolio\">Audio Portfolio</a></p-->\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\t\n");
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t \n");
      out.write("\t\t\t<div class=\"clear\"></div>\n");
      out.write("\n");
      out.write("\t\t </div>\n");
      out.write("\n");
      out.write("\t\t <div id=\"siteInfo\"> \n");
      out.write("\t\t\t Site Design, Implementation and Content, &copy;2012 David Hunn & Chris Livdahl\n");
      out.write("\t\t </div>\n");
      out.write("\n");
      out.write("\t\t </div><!-- end containter -->\n");
      out.write("    </div><!-- end container-bgwrap -->\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
