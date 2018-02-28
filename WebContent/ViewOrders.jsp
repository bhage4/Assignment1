<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="models.Orders, java.util.List" %>
<%
	List<Orders> orders = (List<Orders>) request.getAttribute("ordersForUser");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="NiceLayout.css">

<title>Orders</title>
</head>
<body>
	<div id="topsection"><div class="innertube"><br><form action=Logout method=post>
	<a type="button" class="btn btn-info" href="CustomerHomePage.jsp">Home</a>
	<a type="button" class="btn btn-info disabled" href="ViewOrders.jsp">View Orders</a>
	<a type="button" class="btn btn-info" href="ViewAndCheckoutShoppingCart.jsp">Shopping Cart</a>
	<input type=submit class="btn btn-danger" value="Log out">Welcome, ${ user.userName }</form></div></div>

<table>
  <tr>
    <th>Order Number</th>
    <th>Total</th>
    <th>Date</th>
    <th></th>
  </tr>
  <c:forEach items="${orders}" var="order">
  <tr>
    <td>"${ order.id }"</td>
    <td>"${ order.totalCost }"</td>
    <td>"${ order.orderDate }"</td>
    <td><form class="centered-form" action=ManageOrder name="manageOrder" method="post">
	    		<input type="hidden" name="orderId" value="${ order.id }" />
				<input class="btn btn-warning" type=submit value="Manage Order">
			</form></td>
  </tr>
  </c:forEach>
</table>

</body>
</html>