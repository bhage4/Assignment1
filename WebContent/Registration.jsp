<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register a New User</title>
<script>
	function validateForm() {
	    var x = document.forms["registrationForm"]["password"].value;
	    var y = document.forms["registrationForm"]["confirmPassword"].value;
	    var z = document.forms["registrationForm"]["userName"].value;
	    
	    if (z == "") {
	        alert("Username must be filled out");
	        return false;
	    }
	    
	    if (x == "") {
	        alert("Password must be filled out");
	        return false;
	    }
	    
	    if (y == "") {
	        alert("Confirmation password must be filled out");
	        return false;
	    }
	    
	    if (x != y) {
	        alert("Password and Confirmation of Password must match");
	        return false;
	    }
	}
</script>
</head>
<body>
		<h2> Register here</h2>
		
		<!--NOTE: I'm having trouble with the redirection here for some reason-nothing links to the registration servlet??-->
		<form action="Registration.java" name="registrationForm" onsubmit="return validateForm()" method="post">
		
			User Name: <input type=text name=userName><br>
			Password: <input type=password name=password><br>
			Confirm Password: <input type=password name=confirmPassword><br>
			<input type=submit value=Register> <br> 
		
		</form>
		
		<br>
		<br>
		
		<!-- Navigation links --> 
		<a href="Login.jsp"> Home Page </a> <br>
		
	
	</body>
</html>

<!-- DONE The page checks if the password and confirmation password match (agent side using JavaScript). -->
<!--  Clicking the submit button on the form should call the Registration servlet. It should check whether the user already exists or not. -->
<!--  No session generation of the fields is required for this assignment. -->