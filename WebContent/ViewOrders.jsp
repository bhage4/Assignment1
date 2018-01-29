<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orders</title>
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
    <th>Order Number</th>
    <th>Total</th>
    <th>Date</th>
    <th></th>
  </tr>
  <tr>
    <td>123456</td>
    <td>$16.99</td>
    <td>Feb. 01, 2017</td>
    <td><a type="button" class="btn btn-warning" href="ManageOrder.jsp">View Orders</a></td>
  </tr>
  <tr>
    <td>375930</td>
    <td>$20.00</td>
    <td>Jan. 12, 2018</td>
    <td><a type="button" class="btn btn-warning" href="ManageOrder.jsp">View Orders</a></td>
  </tr>
  <tr>
    <td>234068</td>
    <td>$5.43</td>
    <td>Dec. 30, 2017</td>
    <td><a type="button" class="btn btn-warning" href="ManageOrder.jsp">View Orders</a></td>
  </tr>
</table>

</body>
</html>

<!--  This page displays the list of customer orders briefly. Each order in the list must be displayed with the following information -->
	<!-- Order number -->
	<!-- Order Total -->
	<!-- Ordered date -->
<!-- Use placeholders for this assignment. -->
<!-- A View button also must be displayed along with each order which up on clicking should lead to the ManageOrder.jsp page. -->
<!-- It should have logout option upon clicking that takes to the Login page. -->
<!-- It should have “Home” button that lead to the CustomerHomePage.jsp page. -->