<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<pre> 
Your Seats booked Successfully, Check your details below	
	
Name: ${username}		  Email: ${email}
		
From: ${stlocation}            To: ${destination} 

Service: ${transportation}               Class: ${comfort} 

Travel Date: ${traveldate}    Time: ${timing}  

Number of Seats Booked: ${noofseats} 
                
		 
	</pre>
<a href="home.jsp">Back</a>
</body>
</html>