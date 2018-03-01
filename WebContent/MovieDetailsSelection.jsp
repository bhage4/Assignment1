<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="NiceLayout.css">
<title>Movie Details</title>
</head>
<body>
	<div id="topsection" class="controls form-inline"><br>
	<form action=ViewOrders name="viewOrders" method=post>
		<a type="button" class="btn btn-info" href="CustomerHomePage.jsp">Home</a>
		<input class="btn btn-info" type=submit value="View Orders">
		<a type="button" class="btn btn-info" href="ViewAndCheckoutShoppingCart.jsp">Shopping Cart</a>
	</form>
	<form action=Logout method=post>
		<input type=submit class="btn btn-danger" value="Log out">Welcome, ${ user.userName }
	</form></div>
	<h2>Movie Details</h2>
	<form class="centered-form" action=UpdateShoppingCart name="updateShoppingCart" method="post">
		<input type="hidden" name="movieId" value="${ movie.id }" />
	    <input type="hidden" name="theaterId" value="${ theater.id }" />
	    <input type="hidden" name="showingId" value="${ showing.id }" />
	    <input type="hidden" name="type" value="add" />
		Number of Tickets: <input type="text" name="quantity">
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
	    <td>${ movie.title }</td>
	    <td>${ movie.description }</td>
	    <td>${ movie.rating }</td>
	    <td><img src="${ movie.thumbnail }"></td>
	    <td>${ theater.name } ${ room.roomNumber }</td>
	    <td>${ showing.startTime }</td>
	    <td>$ ${ showing.price }</td>
	    <td>${ seats }</td>
	  </tr>
	</table>
	<h2>Reviews</h2>
	<table>
		<tr>
		    <th>Name</th>
		    <th>Date</th>
		    <th>Rating</th>
		    <th>Content</th>
		</tr>
		<c:forEach items="${reviews}" var="review">
		  <tr>
		    <td>${ review.user.userName }</td>
		    <td>${ review.reviewDate }</td>
		    <td>${ review.rating }</td>
		    <td>${ review.review }</td>
		  </tr>
	    </c:forEach>
	</table>
	<br>
	<a type="button" class="btn btn-success" href="CustomerReview.jsp">Add Review</a>
</body>
</html>