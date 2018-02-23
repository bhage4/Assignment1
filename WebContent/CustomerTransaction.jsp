<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<a type="button" class="btn btn-danger" href="Login.jsp">Log out</a></h1></div></div>
<table>
  <tr>
    <th>Movie Name</th>
    <th>Ticket Quantity</th>
    <th>Total Price</th>
    <th>Theater Name</th>
  </tr>
  <tr>
    <td>Interstellar</td>
    <td>3</td>
    <td>$24.00</td>
    <td>AMC West</td>
  </tr>
  <tr>
    <td>Dark Knight</td>
    <td>2</td>
    <td>$18.00</td>
    <td>Marcus Grande Cinema</td>
  </tr>
</table><br>
<strong>Total Cost:</strong> $42.00 <br><br>
<strong>Credit Card Information:</strong> 
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
<a class="btn" href="CustomerTransactionConfirmation.jsp">Confirm Payment</a>
<a class="btn" href="ViewAndCheckoutShoppingCart.jsp">Cancel Payment</a>
	</body>
</html>

<!-- This page displays a list of items in the shopping cart. Each item in the list must be displayed with the following information -->
	<!-- Movie name -->
	<!-- Ticket quantity -->
	<!-- Total price -->
	<!-- Theatre name -->
<!-- Use placeholders for this assignment. -->
<!-- No validation is required for this assignment. -->
<!-- The page should display the total cost (all items in the cart) and should allow for entry of
	 credit card information. Fields must include account holder first name, last name, card
	 type (drop-down menu with values Visa, Master or Discover), card number, security
	 code, expiration date (drop-down menu), billing address and shipping address. For this
	 assignment, use placeholder values for all variables. -->
<!-- This page should have two buttons: “Confirm Payment” and “Cancel Payment”. -->
<!-- Clicking the “Confirm Payment” button should lead to the CustomerTransactionConfirmation.jsp page. -->
<!-- Clicking the “Cancel Payment” button should lead to the View&CheckoutShoppingCart.jsp page. -->
<!-- This page should have a link to the ViewOrders.jsp page. -->
<!-- It should have logout option upon clicking that takes to the Login page. -->

<!-- o Displays the movie ticket items present in the shopping cart session object along -->
<!-- with the total cost in a suitable format. -->
<!-- o Clicking the “Confirm Payment” calls the Customer Transaction Confirmation -->
<!-- servlet with the total cost, billing address, and the customer’s credit card details. -->
<!-- o Clicking the “Cancel Payment” button should lead back to the View & Checkout -->
<!-- Shopping Cart jsp page. -->