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
		<div id="topsection"><div class="innertube"><h1>
		<a type="button" class="btn btn-info" href="CustomerHomePage.jsp">Home</a>
		<a type="button" class="btn btn-info" href="ViewOrders.jsp">View Orders</a>
		<a type="button" class="btn btn-info" href="ViewAndCheckoutShoppingCart.jsp">Shopping Cart</a>
		<a type="button" class="btn btn-danger" href="Login.jsp">Log out</a>&#9;Welcome, ${ user.userName }</h1></div></div>
	
	<h3>Order Number: 123098923</h3>
<table>
  <tr>
    <th>Movie Name</th>
    <th>Ticket Quantity</th>
    <th>Total Price</th>
    <th>Theater Name/Number</th>
    <th>Date and Time</th>
  </tr>
  <tr>
    <td>Interstellar</td>
    <td>2</td>
    <td>$18.00</td>
    <td>AMC East 12</td>
    <td>Feb. 02, 2018 @ 4:30pm</td>
  </tr>
</table>
<br>
<a class="btn btn-warning" href="CancellationConfirmation.jsp">Confirm Cancellation</a>
<a class="btn btn-warning" href="CustomerHomePage.jsp">Discard Cancellation</a>
</body>
	
</html>

<!-- This page must display the movie information and the order it belongs to. -->
<!-- This page lets the customer to cancel the selected item in an order but not necessarily the entire order. -->
<!-- There must be two buttons here: “Confirm Cancellation” and “Discard Cancellation”. -->
<!-- The Confirm Cancellation button should lead to the CancellationConfirmation.jsp page. -->
<!-- The Discard Cancellation button should lead to the Home page. -->
<!-- This page should have a link to the ViewOrders.jsp page. -->
<!-- It should have logout option upon clicking that takes to the Login page. -->

<!-- This page must display the full information for the order item received from the -->
<!-- Cancel Order servlet. -->
<!-- o When the “Confirm Cancellation” button is clicked, the Cancel Order Transaction -->
<!-- servlet is called with the order-item. -->
<!-- o The “Discard Cancel” button should lead back to the Manage Order page. -->
