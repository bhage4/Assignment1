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
		<div>
			<a href="ViewOrders.jsp">View Orders</a>
			
			<div class="dropdown">
				<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Dropdown</button>
					<span class="caret"></span></button>
				    <ul class="dropdown-menu">
				      <li><a href="#">Link 1</a></li><!--movie theatre locations-->
				    </ul>
			</div>
						
			<input type="text" name="movieSearch">
			<a class="btn" href="MovieSearchResults.jsp">Search</a>
			<a href="Login.jsp">Logout</a>
		</div>
		<h1>Home Page</h1>
	</body>
</html>

<!--  DONE: This page is the welcome page for the customers and can be designed as per the student's wish. -->
<!--  DONE: It must have accessible links, menus or buttons for navigating to the ViewOrders.jsp page. -->
<!--  DONE: It should have logout option upon clicking that takes to the Login page. -->
<!--  The page must also provide a section where the user can search for movies. -->
<!--  This section must include the following items: -->
	<!--  A drop-down menu consisting of available movie theatre locations. -->
	<!--  DONE: A text box to enter a search term (a movie). -->
	<!--  DONE: A search button which when clicked must lead to the MovieSearchResults.jsp page. -->