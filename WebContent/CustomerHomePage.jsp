<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="NiceLayout.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
 		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<title>Home Page</title>
	</head>
	<body>
		
			<div id="topsection"><div class="innertube"><h1>Home Page 
			<a type="button" class="btn btn-info" href="ViewOrders.jsp">View Orders</a>
			<a type="button" class="btn btn-danger" href="Login.jsp">Log out</a></h1></div></div>
			<br>
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Theatre Locations</button>
					<span class="caret"></span></button>
				    <ul class="dropdown-menu">
				      <li><a href="#">Marcus Grande</a></li><!--movie theatre locations-->
				      <li><a href="#">Community Playhouse</a></li>
				      <li><a href="#">Marcus Grande East</a></li>
				      <li><a href="#">AMC Cinema</a></li>
				    </ul>
			</div>
			<br>
			<input type="text" name="movieSearch">
			<a class="btn btn-primary" href="MovieSearchResults.jsp">Search</a>
			
		
	</body>
</html>

<!--  DONE: This page is the welcome page for the customers and can be designed as per the student's wish. -->
<!--  DONE: It must have accessible links, menus or buttons for navigating to the ViewOrders.jsp page. -->
<!--  DONE: It should have logout option upon clicking that takes to the Login page. -->
<!--  The page must also provide a section where the user can search for movies. -->
<!--  This section must include the following items: -->
	<!--  DONE: A drop-down menu consisting of available movie theatre locations. -->
	<!--  DONE: A text box to enter a search term (a movie). -->
	<!--  DONE: A search button which when clicked must lead to the MovieSearchResults.jsp page. -->