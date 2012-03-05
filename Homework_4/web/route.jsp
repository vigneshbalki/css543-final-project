<%-- 
    Document   : index
    Created on : Mar 1, 2012, 2:07:01 PM
    Author     : clivdahl
--%>

<%! String last_updated = "03052012d"; %> 

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
	
		
	<script type="text/javascript"
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js">
	</script>
	
	
	<script type="text/javascript" src="https://www.google.com/jsapi"></script>

	
    <script type="text/javascript">
		
		
		google.load("visualization", "1", {packages:["corechart"]});
		google.setOnLoadCallback(drawChart);
		
		 
		var routeIdFromQueryString;
		 
		var json; 
		
		function initializeChart() {
			
			
			
			
		}
		

		function drawChart() {
			
			routeIdFromQueryString = qs("routeid");
			
			var dataString = "routeid=" + routeIdFromQueryString; 
			var speedData = new Array();
			
//			$.getJSON(
//				"RouteServlet", 
//				{ routeid: routeIdFromQueryString }, 
//				function(jsonReturn) { 
//					
//					json = jsonReturn; 
//					
//				}
//				); 
			
			jsonData = $.ajax({
				url: "RouteServlet", 
				data: dataString,
				dataType:"json",
				async: false, 
				success: function(dataReturned) {
					jsonData = dataReturned; 
					//alert(jsonData);	
					
					//alert(jsonData.locations[0].speed);
					
					$.each(dataReturned.locations, function (i, location) {
						
						 
						
						speedData.push(location.speed);  
					}); 
					
				}
			});
				
				 
			
			var data = new google.visualization.DataTable();
			
//			data.addColumn('string', 'Year');
//			data.addColumn('number', 'Sales');
//			data.addColumn('number', 'Expenses');
//			data.addRows([
//			['2004', 1000, 400],
//			['2005', 1170, 460],
//			['2006',  860, 580],
//			['2007', 1030, 540]
//			]);
			
			data.addColumn('number', 'Point');
			data.addColumn('number', 'Speed'); 
			


			
			for (var i = 0; i < speedData.length; i++) {
				
				data.addRow([i, speedData[i]]);
				
			}
//			 
//			 
//			$.getJSON(
//				"RouteServlet", 
//				{ routeid: routeIdFromQueryString }, 
//				function(json) { 
//					
//					//alert(json); 
//					
//					$.each(json.locations, function (i, location) {
//						
//						//speedData.push(location.speed); 
//						
//						data.addRow(i, location.speed); 
//						
//					}); 
//				
//					
//				}
//			); 
//			 
			 
			
			var options = {
			title: 'Speed Data'
			};

			var chart = new google.visualization.LineChart(document.getElementById('chart_div'));
			chart.draw(data, options);
			
			getRouteData(); 
			
		}

		
		function initialize() {
			
			
			
			
			
			
			
			
			
			
		}
		
		
		function getRouteData() {


			  
			
			$.getJSON(
				"RouteServlet", 
				{ routeid: routeIdFromQueryString }, 
				function(json) { 
					
					//alert(json);
					
					var myLatLng = new google.maps.LatLng(json.locations[0].latitude, json.locations[0].longitude);
					var lastLatLng = new google.maps.LatLng(json.locations[json.locations.length-1].latitude, json.locations[json.locations.length-1].longitude); 

					var myOptions = {
						center: myLatLng, 
						zoom: 15,
						mapTypeId: google.maps.MapTypeId.ROADMAP
					};
					var map = new google.maps.Map(document.getElementById("map_canvas"),
						myOptions);


					// how to drop one pin on the map 
					var marker = new google.maps.Marker({
						position: myLatLng,
						map: map,
						title:"Start", 
						animation: google.maps.Animation.DROP
					});
					
					var endMarker = new google.maps.Marker({
						position: lastLatLng, 
						map: map, 
						title: "End", 
						animation: google.maps.Animation.DROP
					}); 
					
					
					$('#route_title').html(json.title); 
					
					  
					var locationArray = new Array(); 
					
					// fit the map into the bounds of the points 
					var latlngbounds = new google.maps.LatLngBounds( );
					
					
					// go through the locations and add them to the map 
					$.each(json.locations, function (i, location) {
						
						var newLatLng = new google.maps.LatLng(location.latitude, location.longitude); 
						locationArray.push(newLatLng); 
						latlngbounds.extend(newLatLng); 
						
						//speedData.push(location.speed); 
						
					}); 
					
					// center the map on all points plotted 
					map.fitBounds( latlngbounds ); 

					var mapPath = new google.maps.Polyline({
						path: locationArray,
						strokeColor: "#FF0000",
						strokeOpacity: 1.0,
						strokeWeight: 4
					});

					mapPath.setMap(map);  
					
					
					
					
					
				}
			)
			
			return false; 

		}

		// get value from query string parameter/key
		function qs(key) {
			key = key.replace(/[*+?^$.\[\]{}()|\\\/]/g, "\\$&"); // escape RegEx meta chars
			var match = location.search.match(new RegExp("[?&]"+key+"=([^&]+)(&|$)"));
			return match && decodeURIComponent(match[1]);
		}
    </script>
	

	
	<script text="text/javascript"> 
	
		$(document).ready(function() {
			
			// route.jsp?routeid=1
			
			
				
				
			 
			
			
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

				<h1 id="route_title"></h1>
				
				<p id="route_data"></p>
				
				<div id="map_canvas" style="width:600px; height:400px"></div>
	
				<br />
				
				<!--Div that will hold the pie chart-->
				<div id="chart_div" style="width:400; height:300"></div>
				
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



