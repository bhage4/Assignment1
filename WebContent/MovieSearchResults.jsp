<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c"  uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="NiceLayout.css">
<title>Search Results</title>
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
<table>
  <tr>
  	<th> Movie Name</th>
    <th>Theater Name</th>
    <th>Showtime</th>
    <th>Price</th>
    <th>Seats Available</th>
    <th>Poster</th>
    <th></th>
  </tr>
  <c:forEach items="${results}" var="result">
	  <tr>
	  	<td>${ result['title'] }</td>
	    <td>${ result['theater'] }</td>
	    <td>${ result['startTime'] }</td>
	    <td>$ ${ result['price'] }</td>
	    <td>${ result['seats'] }</td>
	    <td><img src="${ result['poster'] }"></td>
	    <td><form class="centered-form" action=MovieSearchResults name="moviesearchresults" method="post">
	    		<input type="hidden" name="movieId" value="${ result['movieId'] }" />
	    		<input type="hidden" name="showingId" value="${ result['showingId'] }" />
				<input class="btn btn-warning" type=submit value="View Movie Details">
			</form></td>
	  </tr>
  </c:forEach>
</table>
</body>
</html>