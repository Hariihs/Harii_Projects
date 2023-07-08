<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="changepassword" method="post" autocomplete="off">
		
		<label>New password</label>
		<input type="password" id="password" name="newpass"> 
		
		<label>Confirm New password</label>
		<input type="password" id="confirmpassword" name="confirmnewpass"> 
		
		<button type="button" onClick = "checkPassword()">Check your password</button>
		
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
			        document.getElementById("submitbtn").style.visibility = "visible";			        
			 }
		</script>
		
		<input type="submit" id="submitbtn" value="Change password" style="visibility:hidden">
	</form>
</body>
</html>