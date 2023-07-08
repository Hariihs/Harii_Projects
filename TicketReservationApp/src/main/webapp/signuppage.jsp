<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ticket Reservation</title>  
</head>
<body> 

	<form action="signup" method="post" autocomplete="off">
		
		<div><label for="username">User Name</label></div>
		<div><input type="text" id="username" name="username" placeholder="Enter your Name" required></div> 
		
		<div><label for="email">Email</label></div>
		<div><input type="email" id="email" name="email" placeholder="Enter your Email" required></div>
		
		<div><label for="password">Password</label></div>
		<div><input type="password" id="password" name="password" placeholder="Enter password"> </div>
		
		<div><label for="confirmpassword">Confirm Password</label></div>
		<div><input type="password" id="confirmpassword" placeholder="Re-enter password">
		<button type="button" onClick = "checkPassword()">Check your password</button>
		</div>  
		
		<script>
			function checkPassword() {
				password1 = document.getElementById("password").value;
			    password2 = document.getElementById("confirmpassword").value;;
			          
			    if (password1 == '')
			    	alert ("Please enter Password");
			 
			    else if (password2 == '')
			        alert ("Please enter confirm password");
			     
			    else if (password1 != password2)
			        alert ("\nPassword did not match: Please try again...");
			 
			    else
			        document.getElementById("signupbutton").style.visibility = "visible";			        
			 }
		</script>
		
		<div><input type="submit" value="Sign Up" id="signupbutton" style="visibility:hidden;"></div>
	</form>
</body>
</html>