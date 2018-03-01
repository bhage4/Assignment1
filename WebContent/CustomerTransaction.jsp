<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="NiceLayout.css">
		<title>Transaction Details</title>
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
    <th>Theater Name</th>
  </tr>
  <c:forEach items="${cart}" var="item">
	  <tr>
	    <td>${ item['movieName'] }</td>
	    <td>${ item['ticketQuantity'] }</td>
	    <td>$ ${ item['price'] }</td>
	   	<td>${ item['theaterNameNum'] }</td>
	  </tr>
  </c:forEach>
</table><br>
<strong>Total Cost:</strong> $ ${ totalPrice } <br><br>
<strong>Credit Card Information:</strong> 
<form class="centered-form" action=CustomerTransactionConfirmation name="confirmTransaction" method="post">
	<select name="cardType">
	  <option value="visa">Visa</option>
	  <option value="mastercard">Mastercard</option>
	  <option value="discover">Discover</option>
	</select><br><br>
	Number: <input type="text" name="cardNumber"> Security Code: <input type="text" name="securityCode"> Exp. Date: (YYYY-MM-DD) <input type="text" name="expDate">
	Add Funds: <input type="text" name="balance"><br><br>
	First Name: <input type="text" name="firstName"> Last Name: <input type="text" name="lastName"><br><br>
	<strong>Billing Address:</strong>
	<br>
	Street: <input type="text" name="billStreet"> City: <input type="text" name="billCity"> State: <input type="text" name="billState"> Zip Code: <input type="text" name="billZip">
	<br><br>
	<strong>Shipping Address:</strong>
	<br>
	Street: <input type="text" name="shipStreet"> City: <input type="text" name="shipCity"> State: <input type="text" name="shipState"> Zip Code: <input type="text" name="shipZip">
	<br><br>
	<input class="btn btn-warning" type=submit value="Confirm Transaction">
</form>
<a class="btn btn-danger" href="ViewAndCheckoutShoppingCart.jsp">Cancel Payment</a>
</body>
</html>