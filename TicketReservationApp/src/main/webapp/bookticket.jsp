<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ticket Reservation</title> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</head>
<body>
	${seatsremaining} Seats Remaining. Hurry Up!!! Before it gets filled 
	<br> 
	<br> 
	<form action="bookseat" method="post" autocomplete="off"> 
		please check your Details carefully<br><br>  
		<pre>
Name: ${username}		
		
From: ${stlocation}            To: ${destination} 

Service: ${transportation}               Class: ${comfort} 

Travel Date: ${traveldate}    Time: ${timing}
                
		
<label for="noofseats">Number of seats </label><input type="number" name="noofseats" min="1" max="${seatsremaining}">  <input type="submit" value="Book Ticket"> 
		</pre>
	</form>
	
</body>
</html>