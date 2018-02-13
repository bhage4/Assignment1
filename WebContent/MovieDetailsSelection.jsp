<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="NiceLayout.css">
<title>Movie Details</title>
</head>
<body>
<div id="topsection"><div class="innertube"><h1>
<a type="button" class="btn btn-info" href="CustomerHomePage.jsp">Home</a>
<a type="button" class="btn btn-info" href="MovieSearchResults.jsp">Back</a>
<a type="button" class="btn btn-danger" href="ViewAndCheckoutShoppingCart.jsp">Add to Cart</a>
<a type="button" class="btn btn-danger" href="Login.jsp">Log out</a></h1></div></div>
<h2>Movie Details</h2>
<table>
  <tr>
    <th>Name</th>
    <th>Description</th>
    <th>Rating</th>
    <th>Poster</th>
    <th>Theater Name/Number</th>
    <th>Showtime</th>
    <th>Price</th>
    <th>Available Seats</th>
  </tr>
  <tr>
    <td>Interstellar</td>
    <td>It's a Sci-Fi movie</td>
    <td>5/5</td>
    <td><img src="https://images-na.ssl-images-amazon.com/images/I/61pbKJXv8IL.jpg"></td>
    <td>AMC West 10</td>
    <td>6:00pm</td>
    <td>$8.00</td>
    <td>12</td>
  </tr>
</table>
<h2>Reviews</h2>
<h3>4.5/5 Star Rating</h3>
<table>
  <tr>
    <th>Name</th>
    <th>Date</th>
    <th>Rating</th>
    <th>Content</th>
  </tr>
  <tr>
    <td>Jeff Phillips</td>
    <td>01/29/2018</td>
    <td>4/5</td>
    <td>It was a good movie</td>
  </tr>
</table>
</body>
</html>

<!-- This page must contain the following detailed information about a movie: -->
	<!-- Movie details -->
		<!-- Movie name -->
		<!-- Movie description -->
		<!-- Movie rating -->
		<!-- Movie poster -->
		<!-- Theatre name and number -->
		<!-- Showtime -->
		<!-- Price per seat -->
		<!-- Available Seats -->
	<!-- Viewer Reviews -->
		<!-- Display overall rating out of 5 stars. -->
		<!-- Display list of viewer reviews with the following details -->
		<!-- Name of the person -->
		<!-- Review date -->
		<!-- Rating out of 5 stars -->
		<!-- The contents of the review -->
<!-- For this assignment, use placeholder values for all variables. -->
<!-- Three buttons must appear on this page: the “Add to Cart” button, the “Back” button and “Home” button. -->
<!-- Clicking the “Add to Cart” should lead to the View&CheckoutShoppingCart.jsp page. -->
<!-- The “Back” button takes you back to the Movie Search Results page. -->
<!-- The “Home” button takes you back to the CustomerHomePage.jsp page. -->
<!-- The logout option should be available in this page as well. -->


<!-- o The movie is received from the Movie Search Results page. -->
<!-- o Displays the movie information data received from the Movie Search Results -->
<!-- servlet in a suitable format with the following data: -->
<!-- ! Movie details -->
<!-- ! Movie name -->
<!-- ! Movie description -->
<!-- ! Movie rating (e.g., G, PG, PG-13, R) -->
<!-- ! Movie poster -->
<!-- ! Theatre name and showroom number -->
<!-- ! Showtime -->
<!-- ! Price per seat -->
<!-- 3 -->
<!-- ! Number of available seats -->
<!-- ! Viewer Reviews -->
<!-- ! Display an overall rating out of 5 stars -->
<!-- ! Display list of viewer reviews with the following details -->
<!-- ! Name of the person -->
<!-- ! Review date -->
<!-- ! Rating out of 5 stars -->
<!-- ! The contents of the review -->
<!-- o Customer Reviews should be pulled from the database using the ReviewsDB class -->
<!-- o The page must have the option to select the ticket quantity. -->
<!-- o Clicking the “Add to Cart” button calls the Update Shopping Cart servlet, passing -->
<!-- the movie, ticket quantity and other necessary information. -->
<!-- o A button “Add Review” should be present that takes the user to the -->
<!-- CustomerReview JSP page, sending the movie information with it -->