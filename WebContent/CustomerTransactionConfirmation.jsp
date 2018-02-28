<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="NiceLayout.css">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Transaction Confirmation</title>
	</head>
	<body>
	<div id="topsection"><div class="innertube"><br><form action=Logout method=post>
		<a type="button" class="btn btn-info" href="CustomerHomePage.jsp">Home</a>
		<a type="button" class="btn btn-info" href="ViewOrders.jsp">View Orders</a>
		<a type="button" class="btn btn-info" href="ViewAndCheckoutShoppingCart.jsp">Shopping Cart</a>
		<input type=submit class="btn btn-danger" value="Log out">Welcome, ${ user.userName }</form></div></div>
		
		<c:choose>
 			<c:when test= "${ status == 'valid' }">
 				<h2>Your Order Has Been Placed</h2>
		        <h3>Details:</h3>
				<table>
				<tr>
				  <th>Movie Name</th>
				  <th>Ticket Quantity</th>
				  <th>Total Price</th>
				  <th>Theater Name</th>
				</tr>
				<c:forEach items="${order}" var="item">
					<tr>
					  <td>  </td>
					  <td> item.orderItems['quantity'] </td>
					  <td>$</td>
					  <td></td>
					</tr>
				</c:forEach>
				</table><br>
				<strong>Total Cost:</strong> $42.00<br><br>
				<br>
 			</c:when>
 			<c:when test= "${ status == 'payment' }">
 				<h3>Purchase Not Completed</h3>
 				<strong>Sorry, but your payment info is not valid. Please try again.</strong>
 			</c:when>
 			<c:when test= "${ status == 'funds' }">
 				<h3>Purchase Not Completed</h3>
 				<strong>Sorry, but your account does not have sufficient funds for this purchase. Please add some more.</strong>
 			</c:when>
		</c:choose>
	</body>
</html>
<!-- On Success: -->
	<!-- The page displays all the information passed on by the previous servlet. -->
<!-- The page has a Print button that allows the customer to print the order showing all the order details. -->