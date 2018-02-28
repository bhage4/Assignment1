<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="NiceLayout.css">
<title>Shopping Cart</title>
</head>
<body>
	<div id="topsection"><div class="innertube"><h1>
	<a type="button" class="btn btn-info" href="CustomerHomePage.jsp">Home</a>
	<a type="button" class="btn btn-info" href="ViewOrders.jsp">View Orders</a>
	<a type="button" class="btn btn-info disabled" href="ViewAndCheckoutShoppingCart.jsp">Shopping Cart</a>
	<a type="button" class="btn btn-danger" href="Login.jsp">Log out</a>&#9;Welcome, ${ user.userName }</h1></div></div>
<table>
  <tr>
    <th>Movie</th>
    <th>Poster</th>
    <th>Theater Name/Number</th>
    <th>Showing Date and Time</th>
    <th>Number of Tickets</th>
    <th>Total Price</th>
    <th></th>
  </tr>
  <c:forEach items="${cart}" var="item">
	  <tr>
	    <td>${ item['movieName'] }</td>
	    <td><img src="${ item['moviePoster'] }"></td>
	    <td>${ item['theaterNameNum'] }</td>
	    <td>${ item['showtime'] }</td>
	    <td>${ item['ticketQuantity'] }</td>
	    <td>$ ${ item['price'] }</td>
	    <td><form action=UpdateShoppingCart name="updateCart">
	    		<input type="hidden" name="movieId" value="${ movie.id }" />>
	    		<input type="hidden" name="type" value="delete" />
	    		<input type="hidden" name="quantity" value=${ item['ticketQuantity'] } />
				<input class="btn btn-warning" type=submit value="Delete">
			</form></td>
	  </tr>
  </c:forEach>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td>$ ${ totalPrice }</td>
	<td></td>
  </tr>
</table>
<br>
<div class="innertube">
<form action=CustomerTransaction name="checkOut">
	<input class="btn btn-warning" type=submit value="Check Out">
</form>
</body>
</html>