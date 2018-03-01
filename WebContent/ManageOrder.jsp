<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="NiceLayout.css">
<title>Manage Order</title>
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
<h3>Order Number: ${ id }</h3>
<h3>Order Total: $${ totalCost }</h3>
<h3>Order Date: ${ date }</h3>
<table>
	<tr>
	  <th>Movie Name</th>
	  <th>Ticket Quantity</th>
	  <th>Total Price</th>
	  <th>Theater Name/Number</th>
	  <th>Date and Time</th>
	  <th></th>
	</tr>
	<c:forEach items="${orderItems}" var="order">
	  <tr>
	    <td>${ order['title'] }</td>
	    <td>${ order['quantity'] }</td>
	    <td>$${ order['price'] }</td>
	    <td>${ order['theater'] }</td>
	    <td>${ order['time'] }</td>
	    <td>
	      <c:choose>
		      <c:when test="${ order['validCancel'] }">
		    	<form class="centered-form" action=CancelOrder name="cancelOrder" method="post">
		    		<input type="hidden" name="orderId" value="${ id }" />
		    		<input type="hidden" name="itemId" value="${ order['itemId'] }" />
					<input class="btn btn-warning" type=submit value="Cancel Order">
				</form>
			  </c:when>
		  </c:choose>
		</td>
	  </tr>
	</c:forEach>
</table>
</body>
</html>