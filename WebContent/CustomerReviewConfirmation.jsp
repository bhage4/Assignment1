<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="javax.servlet.http.HttpServletRequest" %>
<%
	boolean result = Boolean.valueOf(String.valueOf(request.getParameter("result")));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Review Confirmation</title>
</head>
<body>
	<div id="topsection"><div class="innertube"><h1>
	<a type="button" class="btn btn-info" href="CustomerHomePage.jsp">Home</a>
	<a type="button" class="btn btn-info" href="ViewOrders.jsp">View Orders</a>
	<a type="button" class="btn btn-info" href="ViewAndCheckoutShoppingCart.jsp">Shopping Cart</a>
	<a type="button" class="btn btn-danger" href="Login.jsp">Log out</a></h1></div></div>
	
	<c:choose>
		<c:when test="${ result }">
			Your review was successfully submitted
		</c:when>
		<c:otherwise>
			Oops! Your review was too long, please try submitting one with less than 100 characters.
		</c:otherwise>
	</c:choose>

</body>
</html>

<!-- This page should let the user know if their review was successfully submitted or updated, or a failure message if something went wrong -->