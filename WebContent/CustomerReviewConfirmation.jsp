<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="NiceLayout.css">
<title>Review Confirmation</title>
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
	
	<c:choose>
		<c:when test="${ result }">
			Your review was successfully submitted
		</c:when>
		<c:otherwise>
			Oops! Your review was not successfully submitted. If your review was too long, please try submitting one with less than 100 characters.
		</c:otherwise>
	</c:choose>

</body>
</html>