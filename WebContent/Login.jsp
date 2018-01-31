<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Welcome! Log in here</title>
			<script>
				function validateForm() {
				    var x = document.forms["loginForm"]["password"].value;
				    var z = document.forms["loginForm"]["userName"].value;
				    
				    if (z == "") {
				        alert("Username must be filled out");
				        return false;
				    }
				    
				    if (x == "") {
				        alert("Password must be filled out");
				        return false;
				    }
				}
			</script>
	</head>
	<body>
		<!--TODO: Why am I having trouble redirecting to the servlets from forms?-->
		<form action=Login name="loginForm" onsubmit="return validateForm()" method="post">
		
			User Name: <input type=text name=userName><br>
			Password: <input type=password name=password><br>
			<input type=submit value="Log in"> <br> 
		
		</form>
		<br>
		<a href="Registration.jsp">Register</a>	
	</body>
</html>

<!-- Clicking the submit button on the form should call the login servlet. -->
<!-- DONE No session generation of the fields is required for this assignment. -->
<!-- DONE Clicking the registration link should lead to the registration page. -->
