<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="NiceLayout.css">
<title>Customer Review</title>
</head>
<body>
	<div id="topsection"><div class="innertube"><h1>
	<a type="button" class="btn btn-info" href="CustomerHomePage.jsp">Home</a>
	<a type="button" class="btn btn-info" href="ViewOrders.jsp">View Orders</a>
	<a type="button" class="btn btn-info" href="ViewAndCheckoutShoppingCart.jsp">Shopping Cart</a>
	<a type="button" class="btn btn-danger" href="Login.jsp">Log out</a>&#9;Welcome, ${ user.userName }</h1></div></div>
	<br>
	<form action=CustomerReview name="customerReview">
		Rate the movie out of 5 stars:
		<select name="stars">
			<option value=1>1</option>
			<option value=2>2</option>
			<option value=3>3</option>
			<option value=4>4</option>
			<option value=5 selected>5</option>
		</select>
		/5<br><br>
		<textarea name="content" rows="7" cols="40"></textarea><br>
		Your review my not be longer than 100 characters<br><br>
		<input class="btn btn-success" type="submit" value="Submit Review">
		<a type="button" class="btn btn-danger" href="MovieDetailsSelection.jsp">Cancel</a>
	</form>
	
</body>
</html>