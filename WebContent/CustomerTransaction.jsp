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
<form action=CustomerTransactionConfirmation name="confirmTransaction">
	<select>
	  <option value="visa">Visa</option>
	  <option value="mastercard">Mastercard</option>
	  <option value="discover">Discover</option>
	</select><br><br>
	Number: <input type="text" name="cardNumber"> Security Code: <input type="text" name="securityCode"> Exp. Date: <input type="date" name="expDate"><br><br>
	First Name: <input type="text" name="firstName"> Last Name: <input type="text" name="lastName"><br><br>
	<strong>Billing Address:</strong>
	<br>
	Street: <input type="text" name="billStreet"> City: <input type="text" name="billCity"> State: <input type="text" name="billStreet"> Zip Code: <input type="text" name="billZip">
	<br><br>
	<strong>Shipping Address:</strong>
	<br>
	Street: <input type="text" name="shipStreet"> City: <input type="text" name="shipCity"> State: <input type="text" name="shipStreet"> Zip Code: <input type="text" name="shipZip">
	<br><br>
	<input class="btn btn-warning" type=submit value="Confirm Transaction">
</form>
<a class="btn" href="ViewAndCheckoutShoppingCart.jsp">Cancel Payment</a>
</body>
</html>