<%-- 
    Document   : index
    Created on : Mar 1, 2012, 2:07:01 PM
    Author     : clivdahl
--%>

<%! String last_updated = "03012012"; %> 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	
	<title>CSS 543 - David Hunn & Chris Livdahl</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="style.css?<%=last_updated%>" type="text/css">
	
	
	<meta name="viewport" content="initial-scale=1.0, user-scalable=no" />
	
	<style type="text/css">
      html { /* height: 100% */  }
      body { /* height: 100%; margin: 0; padding: 0 */ }
      #map_canvas { width: 400px; height: 400px; }
    </style>
	
	<script type="text/javascript"
      src="http://maps.googleapis.com/maps/api/js?key=AIzaSyBwEjS8fI30MwKEpwcnAf4NdOZym66Ot5s&sensor=false">
    </script>
    <script type="text/javascript">
		function initialize() {

			var myLatLng = new google.maps.LatLng(47.6063889, -122.3308333);

			var myOptions = {
				center: myLatLng, 
				zoom: 12,
				mapTypeId: google.maps.MapTypeId.ROADMAP
			};
			var map = new google.maps.Map(document.getElementById("map_canvas"),
				myOptions);


			// how to drop one pin on the map 
			var marker = new google.maps.Marker({
				position: myLatLng,
				map: map,
				title:"Hello World!", 
				animation: google.maps.Animation.DROP
			});
			
			// how to create a line on the map: 
			var flightPlanCoordinates = [
				new google.maps.LatLng(37.772323, -122.214897),
				new google.maps.LatLng(21.291982, -157.821856),
				new google.maps.LatLng(-18.142599, 178.431),
				new google.maps.LatLng(-27.46758, 153.027892)
			];
			var flightPath = new google.maps.Polyline({
				path: flightPlanCoordinates,
				strokeColor: "#FF0000",
				strokeOpacity: 1.0,
				strokeWeight: 2
			});

			flightPath.setMap(map);
			
			

		}

		// get value from query string parameter/key
		function qs(key) {
			key = key.replace(/[*+?^$.\[\]{}()|\\\/]/g, "\\$&"); // escape RegEx meta chars
			var match = location.search.match(new RegExp("[?&]"+key+"=([^&]+)(&|$)"));
			return match && decodeURIComponent(match[1]);
		}
    </script>
	
	
	<script type="text/javascript"
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js">
	</script>
	
	<script text="text/javascript"> 
	
		$(document).ready(function() {
			
			// route.jsp?routeid=1
			
			var routeIdFromQueryString = qs("routeid");  
			
			$.get(
				"RouteServlet", 
				{ routeid: routeIdFromQueryString }, 
				function(data) { 
					$("#route_data").html(data); 
				}
			)
			
			
		}); 
		
	</script>
	
	
</head>
<body onload="initialize()">
	
	<div id="menu_bar_wrapper">
	
		<div id="menu_bar">
			
			<div id="logo_small" class="box_float_left"> 
				<a href="index.jsp">MobileTracker<!--img src="images/Logo_master.png" height="27" /--></a>
			</div>
			
			<div class="box_float_right">
			<ul>
				<li><a href="Menu1"><p></p></a></li>
				<li><a href="Menu2"><p></p></a></li>
				<li><a href="Menu3"><p></p></a></li>
			</ul>
			</div>
		</div>
		
	</div>

	
	 <div id="container-bgwrap">
    
		 <div id="container">

			  <!-- div id="masthead"> 

					<table width="100%">
					<tr>

					<td>
						<div id="logo"><img src="" /></div> 
					</td>

					<td align="right">
					<div id="globalNav"> 
						 <p class="header" align="right"><br>
						 <a class="header" href="">Home</a> | 
						 <a class="header" href="">Contact</a> 
						 </p> 
					</div> 
					</td>

					</tr>
					</table>
			  </div --> 
			  
			  
		 <div id="content-wrap">

			<div class="style1" id="content"> 

				<h1>Route title</h1>
				
				<p id="route_data"></p>
				
				<div id="map_canvas" style="width:600px; height:400px"></div>
			
			</div>
 
			<div class="clear"></div>

		 </div>

		 <div id="siteInfo"> 
			 Site Design, Implementation and Content, &copy;2012 David Hunn & Chris Livdahl
		 </div>

		 </div><!-- end containter -->
    </div><!-- end container-bgwrap -->

</body>

</html>



