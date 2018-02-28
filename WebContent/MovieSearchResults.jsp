<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<%@ page import="models.MovieShowing, models.Movie, models.Showroom, models.Theatres, java.util.List, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpSession" %>
<% 
		HttpSession thisSession = request.getSession();
	 	List<MovieShowing> showings = (List<MovieShowing>) thisSession.getAttribute("showingList");
	 	Movie movie = (Movie) thisSession.getAttribute("movie");
	 	Showroom room = (Showroom) thisSession.getAttribute("showroom");
	 	Theatres theater = (Theatres) thisSession.getAttribute("theater"); 
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="NiceLayout.css">
<title>Search Results</title>
</head>
<body>
	<div id="topsection"><div class="innertube"><h1>
	<a type="button" class="btn btn-info" href="CustomerHomePage.jsp">Home</a>
	<a type="button" class="btn btn-info" href="ViewOrders.jsp">View Orders</a>
	<a type="button" class="btn btn-info" href="ViewAndCheckoutShoppingCart.jsp">Shopping Cart</a>
	<a type="button" class="btn btn-danger" href="Login.jsp">Log out</a>&#9;Welcome, ${ user.userName }</h1></div></div>
<table>
  <tr>
  	<th> Movie Name</th>
    <th>Theater Name</th>
    <th>Showtime</th>
    <th>Price</th>
    <th>Seats Available</th>
    <th>Poster</th>
    <th></th>
  </tr>
  <c:forEach items="${showingList}" var="showing">
	  <c:set var="seats" value="${ showing.numberPurchased - room.availableSeats }"/>
	  <tr>
	  	<td>${ movie.title }</td>
	    <td>${ theater.name }</td>
	    <td>${ showing.startTime }</td>
	    <td>$ ${ showing.price }</td>
	    <td>${ seats }</td>
	    <td><img src="${ movie.thumbnail }"></td>
	    <td><form action=MovieSearchResults name="moviesearchresults">
	    		<input type="hidden" name="movieId" value="${ movie.id }" />>
	    		<input type="hidden" name="showingId" value="${ showing.id }" />
				<input class="btn btn-warning" type=submit value="View Movie Details">
			</form></td>
	  </tr>
  </c:forEach>
</table>
</body>
</html>