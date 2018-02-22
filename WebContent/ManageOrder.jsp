<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="NiceLayout.css">
<title>Manage Order</title>
</head>
<body>
	<div id="topsection"><div class="innertube"><h1>
	<a type="button" class="btn btn-info" href="CustomerHomePage.jsp">Home</a>
	<a type="button" class="btn btn-info" href="ViewOrders.jsp">View Orders</a>
	<a type="button" class="btn btn-info" href="ViewAndCheckoutShoppingCart.jsp">Shopping Cart</a>
	<a type="button" class="btn btn-danger" href="Login.jsp">Log out</a></h1></div></div>
<h3>Order Number: 123098923</h3>
<h3>Order Total: $42.00</h3>
<h3>Order Date: 01/30/2018</h3>
<table>
  <tr>
    <th>Movie Name</th>
    <th>Ticket Quantity</th>
    <th>Total Price</th>
    <th>Theater Name/Number</th>
    <th>Date and Time</th>
    <th></th>
    <th></th>
  </tr>
  <tr>
    <td>Interstellar</td>
    <td>2</td>
    <td>$18.00</td>
    <td>AMC East 12</td>
    <td>Feb. 02, 2018 @ 4:30pm</td>
    <td><a type="button" class="btn btn-warning" href="MovieDetailsSelection.jsp">View</a></td>
    <td><a type="button" class="btn btn-warning" href="CancelOrder.jsp">Cancel Order</a></td>
  </tr>
  <tr>
    <td>Dark Knight</td>
    <td>3</td>
    <td>$24.00</td>
    <td>Marcus Grande 4</td>
    <td>Feb. 05, 2018 @ 8:30pm</td>
    <td><a type="button" class="btn btn-warning" href="MovieDetailsSelection.jsp">View</a></td>
    <td><a type="button" class="btn btn-warning" href="CancelOrder.jsp">Cancel Order</a></td>
  </tr>
</table>

</body>
</html>

<!-- This page displays detailed information of an order. It must display the following order information: -->
	<!-- Order number -->
	<!-- List of items in the order. For each item, the following information must be displayed in a list: -->
		<!-- Movie name -->
		<!-- Ticket quantity -->
		<!-- Total price -->
		<!-- Theatre name and number -->
		<!-- Showtime/Date -->
		<!-- A “view” button must be displayed, upon clicking, should lead to the MovieDetailsSelection.jsp page that displays the product information. -->
		<!-- A “Cancel” button must be displayed if the item is not shipped, up on clicking that should lead to the CancelOrder.jsp page. -->
	<!-- Order Total -->
	<!-- Ordered date -->
<!-- It should have logout option upon clicking that takes to the Login page. -->
<!-- It should have “Home” button that lead to the CustomerHomePage.jsp page. -->
<!-- It should have “ViewOrders” button that lead to the ViewOrders.jsp page. -->

<!-- This page must display the orders passed by the Manage Order servlet. -->
<!-- o Each order item must have a “Cancel” button if the showtime of the movie has -->
<!-- not yet passed. Clicking this button must lead to the Cancel Order servlet, passing -->
<!-- the correct order item  -->