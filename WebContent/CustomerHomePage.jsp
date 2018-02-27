<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<%@ page import="models.Theatres, models.MovieShowing, data.access.layer.MovieShowingDB, data.access.layer.TheatersDB, java.util.List, java.text.SimpleDateFormat, java.util.ArrayList" %>
<%-- <% --%>
<!-- // 	TheatersDB tdb = new TheatersDB(); -->
<!-- // 	List<Theatres> theaters = tdb.getAllTheaters(); -->
	
<!-- // 	MovieShowingDB msdb = new MovieShowingDB(); -->
<!-- // 	List<MovieShowing> showings = msdb.getAllShowings(); -->
	
<!-- // 	List<String> showTimes = new ArrayList<String>(); -->
<!-- // 	for(MovieShowing showing: showings){ -->
<!-- // 		String time = new SimpleDateFormat("yyyy/MM/dd").format(showing.getStartTime()); -->
<!-- // 		showTimes.add(time); -->
<!-- // 	} -->
<%-- %> --%>
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
		&#9;Welcome, ${ user.userName }</h1><form action=Logout method=post><input type=submit class="btn btn-danger" value="Log out"></form></div></div>
		<br>
		<h2> Search for a Movie!</h2>
		<h3>    Now Showing: Interstellar, Black Panther, Jurassic Park</h3>
		<br>
		<form action=TheaterMovieSearchQuery name="movieSearchForm">
			Movie Name: <input type="text" name="name">
			Theater: <select name="theaterSelected">
				<c:forEach  items="${theaters}" var="theater">
					<option value="${ theater.name }">${ theater.name }</option>
				</c:forEach>
			</select>
			Date: <select name="dateSelected">
				<c:forEach  items="${showTimes}" var="showTime">
					<option value="${ showTime.value }">${ showTime.value }</option>
				</c:forEach>
			</select>
			<input class="btn btn-warning" type=submit value="Search">
		</form>
	</body>
</html>