<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leave Management</title>
</head>
<body>
	<form action="resetpassword" method="post" autocomplete="off">
		<pre>

<label for="password">Enter Password</label>    <input type="password" id="password" name="password" required> 
		
<label for="reenterpassword">Confirm Password</label>  <input type="password" id="confirmpassword" name="reenterpassword" required>						
		</pre> 
		
<button type="button" onClick="checkPassword()">Check Password</button>  
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
			        document.getElementById("resetbutton").style.visibility = "visible";			        
			 }
	</script>

<input type="submit" id="resetbutton" value="Reset Password" style="visibility:hidden">
				
	</form>
</body>
</html>