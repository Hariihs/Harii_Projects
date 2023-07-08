<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</head>
<body>
	<form action="ticketdetails" method="post" autocomplete="off">
	
		<label for="startlocation">Start Location:</label>		  
			<select name="start" id="start" required> 
				<option value="">Select</option>
			  	<option value="Bangalore">Bangalore</option>
			    <option value="Chennai">Chennai</option>
			    <option value="Hyderabad">Hyderabad</option>
		    </select>
	
		<label for="destination">Destination:</label>		  
			<select name="destination" id="destination" required> 
				<option value="">Select</option> 
			  	<option value="Bangalore">Bangalore</option>
			    <option value="Chennai">Chennai</option>
			    <option value="Hyderabad">Hyderabad</option>
		    </select> 
		 
		<div>
			<label for="transportation">Transportation:</label> 
			<select name="transportation" id="transportation" required> 
				<option value="">Select</option>
			  	<option value="Bus">Bus</option>
			    <option value="Train">Train</option>
		  	</select> 
		  	
		  	<input type="radio" id="ac" name="comfort" value="AC" required>
  			<label for="ac">AC</label>
  			<input type="radio" id="nonac" name="comfort" value="NonAc">
  			<label for="nonac">Non-AC</label> 
		</div>   
		
		<div>
			<label for="inputdate">Select your Travel Date:</label>
  			<input type="date" id="inputdate" name="inputdate" required> 
  			
  			<input type="radio" id="timingmrng" name="timing" value="10:30" required>
  			<label for="timingmrng">10.30 a.m</label>
  			<input type="radio" id="timingnght" name="timing" value="22:30">
  			<label for="timingnght">10:30 p.m</label>
  				
		</div> 
		<script type="text/javascript">
			$(function(){
			    var dtToday = new Date();
			 
			    var month = dtToday.getMonth() + 1;
			    var day = dtToday.getDate();
			    var year = dtToday.getFullYear();
			    if(month < 10)
			        month = '0' + month.toString();
			    if(day < 10)
			     day = '0' + day.toString();
			    var maxDate = year + '-' + month + '-' + day;
			    $('#inputdate').attr('min', maxDate);
			});
		</script> 
		 
		 
		 <input type="submit" value="Check for Seat Details" id = "seatdetailsbtn">
	</form>
</body>
</html>