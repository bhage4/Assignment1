<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="NiceLayout.css">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Confirm Cancellation</title>
</head>
	<body>
		<div id="topsection"><div class="innertube"><h1>
		<a type="button" class="btn btn-info" href="CustomerHomePage.jsp">Home</a>
		<a type="button" class="btn btn-info" href="ViewOrders.jsp">View Orders</a>
		<a type="button" class="btn btn-info" href="ViewAndCheckoutShoppingCart.jsp">Shopping Cart</a>
		<a type="button" class="btn btn-danger" href="Login.jsp">Log out</a>&#9;Welcome, ${ user.userName }</h1></div></div>
		
		<table>
		  <tr>
		    <th>Movie Name</th>
		    <th>Ticket Quantity</th>
		    <th>Total Price</th>
		    <th>Refunded?</th>
		  </tr>
		  <tr>
		    <td>Interstellar</td>
		    <td>2</td>
		    <td>$18.00</td>
		    <td>Yes</td>
		  </tr>
		</table>
	</body>
</html>

<!-- This page must display information regarding the movie, with a status update showing that the ticket order has been cancelled. -->
<!-- The refundable amount (e.g., damage deposit) of the items price must be refunded (credited) back to the credit card account that was used to make the purchase. -->
<!-- This page must have a home button that leads to the Home page. -->
<!-- This page should have a link to the ViewOrders.jsp page. -->
<!-- It should have logout option upon clicking that takes to the Login page. -->