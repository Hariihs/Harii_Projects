<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leave Management</title> 
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body>

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
		
		<!--
		<script>
		
		$(document).ready(function() {
			// Function to change form action.
			$("#logintype").change(function() {
			var selected = $(this).children(":selected").text();
			switch (selected) {
			case "Professor":
			$("#myform").attr('action', 'professorlogin');
			break;
			case "HOD":
			$("#myform").attr('action', 'hodlogin');
			break;
			case "Principal":
			$("#myform").attr('action', 'principallogin');
			break;
			default:
			$("#myform").attr('action', '#');
			}
			});
			// Function For Back Button
			$(".back").click(function() {
			parent.history.back();
			return false;
			});
			});
		
		</script> 
		-->
		
		<input type="submit" value="Log in">
		
	</form>
</body>
</html>