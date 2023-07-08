<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body> 
	Heyyy ${username}, your account have created Successfully 
	Please Log in for further journey....
	<form action="signin" method="post" autocomplete="off"> 
		
		<div><label for="email">Email</label></div>
		<div><input type="text" id="email" name="email" placeholder="Enter your Email" required></div>  
		
		<div><label for="password">Password</label></div>
		<div><input type="password" id="password" name="password" placeholder="Enter your password" required></div> 
		
		
		<div><input type="submit" value="Sign In"></div>
	</form>
</body>
</html>