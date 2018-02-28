<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="NiceLayout.css">
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
		<div id="topsection"><div class="innertube"><h1> Welcome to Movie App!
		</h1></div></div>
		<br>
	
		<form class="centered-form" action=Login name="loginForm" onsubmit="return validateForm()" method="post">
		
			User Name: <input type=text name=userName><br>
			Password: <input type=password name=password><br><br>
			<input class="btn btn-warning" type=submit value="Log in"><br><br>
			<a type="button" class="btn btn-info" href="Registration.jsp">Register</a>
		
		</form>
	
	</body>
</html>