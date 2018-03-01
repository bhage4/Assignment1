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
	<div id="topsection" class="controls form-inline"><br>
	<form action=ViewOrders name="viewOrders" method=post>
		<a type="button" class="btn btn-info" href="CustomerHomePage.jsp">Home</a>
		<input class="btn btn-info" type=submit value="View Orders">
		<a type="button" class="btn btn-info" href="ViewAndCheckoutShoppingCart.jsp">Shopping Cart</a>
	</form>
	<form action=Logout method=post>
		<input type=submit class="btn btn-danger" value="Log out">Welcome, ${ user.userName }
	</form></div>
		
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
				<c:forEach items="${order.orderItems}" var="item">
					<tr>
					  <td> ${ item['movieName'] } </td>
					  <td> ${ item['quantity'] } </td>
					  <td>$ ${ item['price'] }</td>
					  <td>${ item['theater'] }</td>
					</tr>
				</c:forEach>
				</table><br>
				<strong>Total Cost:</strong> $ ${ totalPrice }<br><br>
				<br>
				<button onclick="printPage()">Print this page</button>

				<script>
				function printPage() {
				    window.print();
				}
				</script>
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