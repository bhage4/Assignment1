<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="NiceLayout.css">
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
		<div id="topsection"><div class="innertube"><h1>
		<a type="button" class="btn btn-info" href="Login.jsp">Back to Login</a>  Register Below:</h1></div></div>
		<br>
		<form action=Registration name="registrationForm" onsubmit="return validateForm()">
		
			User Name: <input type=text name=userName><br>
			Password: <input type=password name=password><br>
			Confirm Password: <input type=password name=confirmPassword><br><br>
			<input class="btn btn-success" type=submit value=Register> <br> 
		
		</form>
		
		
	
	</body>
</html>

<!-- DONE The page checks if the password and confirmation password match (agent side using JavaScript). -->
<!--  DONE Clicking the submit button on the form should call the Registration servlet. It should check whether the user already exists or not. -->
<!--  DONE No session generation of the fields is required for this assignment. -->