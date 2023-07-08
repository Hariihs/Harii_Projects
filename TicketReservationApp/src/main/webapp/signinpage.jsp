<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ticket Reservation</title>  
</head>

<body> 

	<div class="container">
	<div class="neonText">SIGN IN</div>
		<form action="signin" method="post" autocomplete="off"> 
		
		<div class="inputs">
			<label class="neonText">EMAIL</label>
		    <input type="email" name="email" placeholder="example@gmail.com" required> 
		    <label class="neonText" for="password">PASSWORD</label>
		    <input class="neonText"type="password" name="password" placeholder="Remember it!!!" required> 
		
		    <button type="submit">LOGIN</button>
		</div>
	    </form>
	 </div> 
	
</body>
</body>
</html>