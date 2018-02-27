<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<%@ page import="models.Theatres, data.access.layer.TheatersDB, java.util.List" %>
<%
	TheatersDB tdb = new TheatersDB();
	List<Theatres> theaters = tdb.getAllTheaters();
%>
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
		<div id="topsection"><div class="innertube"><h1>
		<a type="button" class="btn btn-info disabled" href="CustomerHomePage.jsp">Home</a>
		<a type="button" class="btn btn-info" href="ViewOrders.jsp">View Orders</a>
		<a type="button" class="btn btn-info" href="ViewAndCheckoutShoppingCart.jsp">Shopping Cart</a>
		<a type="button" class="btn btn-danger" href="Login.jsp">Log out</a></h1></div></div>
		<br>
		
		<form action=TheaterMovieSearchQuery name="movieSearchForm">
			Movie Name: <input type="text" name="name">
			Theater: <select name="theaterSelected">
				<c:forEach  items="${theaters}" var="theater">
					<option value="${ theater.name }">"${ theater.name }"</option>
				</c:forEach>
			</select>
			
			Select Date:<select name="date">
			<option value="2018-03-14">03-14-2018
	  		<option value="2018-03-15">03-15-2018
	  		<option value="2018-03-16">03-16-2018
			</select>
			
			<input class="btn btn-warning" type=submit value="Search">
		</form>
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
	
<!-- The user should fill out the query and upon clicking the search button should call -->
<!-- the Theatre And Movie Search Query servlet. -->
<!-- 2 -->
<!-- o Existing theatre buildings should be provided in a drop-down menu (after being -->
<!-- read from the database using the TheatreDB class) -->
<!-- o Should include a date selection that allows the user to select the day they wish to -->
<!-- see the movies being shown -->