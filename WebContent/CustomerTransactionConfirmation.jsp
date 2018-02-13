<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="NiceLayout.css">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Transaction Confirmation</title>
	</head>
	<body>
		<div id="topsection"><div class="innertube"><h1>
		<a type="button" class="btn btn-info" href="CustomerHomePage.jsp">Home</a>
		<a type="button" class="btn btn-info" href="ViewOrders.jsp">View Orders</a>
		<a type="button" class="btn btn-danger" href="Login.jsp">Log out</a></h1></div></div>
		<h2>Your Order Has Been Placed</h2>
        <h3>Details:</h3>
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
		<strong>Total Cost:</strong> $42.00<br><br>
		<strong>Shipping Address:</strong>
		<br>
		Street: <input type="text" name="shipStreet"> City: <input type="text" name="shipCity"> State: <input type="text" name="shipStreet"> Zip Code: <input type="text" name="shipZip">
		<br><br>
	</body>
</html>

<!--  The page must display all information on the transaction page except the credit card information. -->
<!-- The page must display a message “Your order has been placed”. -->
<!-- The page has a “Home” button that when clicked leads to the Customer Home page. -->
<!-- This page should have a link to the ViewOrders.jsp page. -->
<!-- It should have logout option upon clicking that takes to the Login page -->

<!-- On Success: -->
<!-- 5 -->
<!-- ! The page displays all the information passed on by the previous servlet. -->
<!-- ! Display Success/Failure message. -->
<!-- ! The page has a Print button that allows the customer to print the order -->
<!-- showing all the order details. -->
<!-- o On Failure: -->
<!-- ! The page displays a message: “Transaction was not successful”. -->
<!-- ! Display failure reason (Incorrect details/insufficient funds, etc.) -->