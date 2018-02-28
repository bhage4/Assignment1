<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="NiceLayout.css">
		<title>Cancel Order</title>
	</head>
	<body>
		<div id="topsection"><div class="innertube"><br><form action=Logout method=post>
		<a type="button" class="btn btn-info disabled" href="CustomerHomePage.jsp">Home</a>
		<a type="button" class="btn btn-info" href="ViewOrders.jsp">View Orders</a>
		<a type="button" class="btn btn-info" href="ViewAndCheckoutShoppingCart.jsp">Shopping Cart</a>
		<input type=submit class="btn btn-danger" value="Log out">Welcome, ${ user.userName }</form></div></div>
	<h3>Order Number: "${ order.id }"</h3>
<table>
  <tr>
    <th>Movie Name</th>
    <th>Ticket Quantity</th>
    <th>Total Price</th>
    <th>Theater Name/Number</th>
    <th>Date and Time</th>
  </tr>
  <tr>
    <td>${ movie.title }</td>
    <td>${ order.ticketsPurchased }</td>
    <td>${ order.totalPrice }</td>
    <td>"${ theater.name }" "${ room.roomNumber }"</td>
	<td>"${ showing.startTime }"</td>
  </tr>
</table>
<br>
<form class="centered-form" action=CancelOrder name="cancelOrder">
  	<input type="hidden" name="orderId" value="${ order.id }" />
	<input class="btn btn-warning" type=submit value="Confirm Cancellation">
</form>
<form class="centered-form" action=ManageOrder name="manageOrder">
  	<input type="hidden" name="orderId" value="${ order.id }" />
	<input class="btn btn-warning" type=submit value="Discard Cancellation">
</form>
</body>
</html>