<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="models.MovieShowing, models.Movie, models.Showroom, models.Theatres, models.Review, java.util.List, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpSession" %>
<%
	HttpSession thisSession = request.getSession();
	MovieShowing showing = (MovieShowing) thisSession.getAttribute("showing");
	List<Review> reviews = (List<Review>) thisSession.getAttribute("reviews");
	Movie movie = (Movie) thisSession.getAttribute("movie");
	Showroom room = (Showroom) thisSession.getAttribute("showroom");
	Theatres theater = (Theatres) thisSession.getAttribute("theater");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="NiceLayout.css">
<title>Movie Details</title>
</head>
<body>
<div id="topsection"><div class="innertube"><h1>
	<a type="button" class="btn btn-info" href="CustomerHomePage.jsp">Home</a>
	<a type="button" class="btn btn-info" href="ViewOrders.jsp">View Orders</a>
	<a type="button" class="btn btn-success" href="ViewAndCheckoutShoppingCart.jsp">Add to Cart</a>
	<a type="button" class="btn btn-danger" href="Login.jsp">Log out</a>
	<a type="button" class="btn btn-info" href="MovieSearchResults.jsp">Back</a></h1></div></div>
<h2>Movie Details</h2>
	<form action=UpdateShoppingCart name="updateShoppingCart">
		<input type="hidden" name="movieId" value="${ movie.id }" />
	    <input type="hidden" name="theaterId" value="${ theater.id }" />
	    <input type="hidden" name="showingId" value="${ showing.id }" />
	    <input type="hidden" name="type" value="add" />
		<input type="number" name="quantity">
		<input class="btn btn-warning" type=submit value="Add to Cart">
	</form>
	<table>
	  <tr>
	    <th>Name</th>
	    <th>Description</th>
	    <th>Rating</th>
	    <th>Poster</th>
	    <th>Theater Name/Number</th>
	    <th>Showtime</th>
	    <th>Price</th>
	    <th>Available Seats</th>
	  </tr>
	  <tr>
	    <td>"${ movie.title }"</td>
	    <td>"${ movie.description }"</td>
	    <td>"${ movie.rating }"</td>
	    <td><img src="${ movie.thumbnail }"></td>
	    <td>"${ theater.name }" "${ room.roomNumber }"</td>
	    <td>"${ showing.startTime }"</td>
	    <td>$ "${ showing.price }"</td>
	    	<c:set var="seats" value="${ room.availableSeats - showing.numberPurchased }"/>
	    <td>${ seats }</td>
	  </tr>
	</table>
	<h2>Reviews</h2>
	<h3>4.5/5 Star Rating</h3>
	<table>
		<tr>
		    <th>Name</th>
		    <th>Date</th>
		    <th>Rating</th>
		    <th>Content</th>
		</tr>
		<c:forEach items="${reviews}" var="review">
		  <tr>
		    <td>"${ review.user.userName }"</td>
		    <td>"${ review.reviewDate }"</td>
		    <td>"${ review.rating }"</td>
		    <td>"${ review.review }"</td>
		  </tr>
	    </c:forEach>
	</table>
	<a href="/CustomerReview.jsp">Add Review</a>
</body>
</html>