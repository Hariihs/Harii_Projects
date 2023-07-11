<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leave Management</title>
</head>
<body>
	
	<h5>Sorry you have entered wrong email or password or designation</h5>
	
	<form action="login" id="myform" method="post" autocomplete="off">
		
		<label for="mail">Mail</label>
		<br><input type="email" id="mail" name="mail" placeholder="example@mail.com" required>
		
		<br><br>
		<label for="password">Password</label>
		<br><input type="password" id="password" name="password" required> 
		
		<br><br>
		<select name="designation" id="logintype" required> 
				<option value="">Select login type</option>
			  	<option value="Professor">Professor</option>
			    <option value="HOD">HOD</option>
			    <option value="Principal">Principal</option>
		</select> 
		
		<input type="submit" value="Log in">
		
	</form>
</body>
</html>