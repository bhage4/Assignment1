<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
	<nav>
		<a href="ViewOrders.jsp">View Orders</a>
		
		<div class="dropdown">
			<button class="dropbtn">Dropdown</button>
				<div class="dropdown-content">
					<a href="#">Link 1</a><!-- Movie Theatre Locations -->
		  		</div>
		</div>
		
		<input type="text" name="movieSearch">
		<button type="button" href="MovieSearchResults.jsp">Search</button>
		<a href="Login.jsp">Logout</a>
	</nav>
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