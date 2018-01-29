<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shopping Cart</title>
<style>
table {
    font-family: arial, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
}

tr:nth-child(even) {
    background-color: #dddddd;
}
</style>
</head>
<body>
<a type="button" class="btn btn-info" href="CustomerHomePage.jsp">Home</a>
<a type="button" class="btn btn-danger" href="Login.jsp">Log out</a>
<table>
  <tr>
    <th>Movie</th>
    <th>Poster</th>
    <th>Theater Name/Number</th>
    <th>Showing Date and Time</th>
    <th>Number of Tickets</th>
    <th>Total Price</th>
    <th></th>
  </tr>
  <tr>
    <td>The Mummy</td>
    <td><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR83_t_x7tsPJuDTDr-ki38X9wMJAP7sFDTq_aql1FmDpmqEnlRng"></td>
    <td>Marcus Grande 13</td>
    <td>Feb. 01, 2018 @ 9:00pm</td>
    <td>2</td>
    <td>$25.00</td>
    <td><a type="button" class="btn btn-warning" onclick="deleteOrder()">Delete Order</a></td>
  </tr>
  <tr>
    <td>Ferris Bueller's Day Off</td>
    <td><img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT2k7b8gFohCLPcg1C6rChgur99xh1G2FtnnoJ7-7S6H14pBIP37w"></td>
    <td>AMC Cinema</td>
    <td>Jan. 31, 2018 @ 6:00pm</td>
    <td>4</td>
    <td>$40.00</td>
    <td><a type="button" class="btn btn-warning" onclick="deleteOrder()">Delete Order</a></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td></td>
    <td>$65.00</td>
	<td></td>
  </tr>
</table>
<a type="button" class="btn btn-warning" href="CustomerTransaction.jsp">Checkout</a>
</body>
</html>

<!-- This page displays the list of items in the shopping cart. -->
<!-- The following information must be displayed for every item in the cart -->
	<!-- Movie name -->
	<!-- Movie thumbnail -->
	<!-- Theatre name and number -->
	<!-- Showtime and Date -->
	<!-- Number of tickets being bought -->
	<!-- Total price -->
<!-- Use placeholders for this assignment. -->
<!-- A delete button should be displayed for each item to delete that item from the shopping cart. -->
<!-- This page should also display the total cost of the items in the shopping cart. -->
<!-- This page should have a “Checkout” button that leads to the CustomerTransaction.jsp page. -->
<!-- It should have logout option upon clicking that takes to the Login page. -->
<!-- It should have “Home” button that lead to the CustomerHomePage.jsp. -->