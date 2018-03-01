<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="NiceLayout.css">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Confirm Cancellation</title>
</head>
	<body>
		<div id="topsection" class="controls form-inline"><br>
		<form action=ViewOrders name="viewOrders">
			<a type="button" class="btn btn-info" href="CustomerHomePage.jsp">Home</a>
			<input class="btn btn-info" type=submit value="View Orders">
			<a type="button" class="btn btn-info" href="ViewAndCheckoutShoppingCart.jsp">Shopping Cart</a>
		</form>
		<form action=Logout method=post>
			<input type=submit class="btn btn-danger" value="Log out">Welcome, ${ user.userName }
		</form></div>
		<table>
		  <tr>
		    <th>Movie Name</th>
		    <th>Ticket Quantity</th>
		    <th>Total Price</th>
		    <th>Refunded?</th>
		  </tr>
		  <c:forEach items="${result}" var="item">
			  <tr>
			    <td>${ item['movieName'] }</td>
			    <td>${ item['quantity'] }</td>
			    <td>$ ${ item['status'] }</td>
			    <td>${ refundStatus }</td>
			  </tr>
		  </c:forEach>
		</table>
	</body>
</html>

<!-- This page must display information regarding the movie, with a status update showing that the ticket order has been cancelled. -->
<!-- The refundable amount (e.g., damage deposit) of the items price must be refunded (credited) back to the credit card account that was used to make the purchase. -->