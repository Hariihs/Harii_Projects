<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leave Management</title>
</head>
<body>

	<form action="addstaff" method="post" autocomplete="off">
		<pre>
		
<label for="staffname">Name</label>	                   <label for="staffphone">Phone</label>	
<input type="text" name=staffname id="staffname" placeholder="Enter Name" required>   <input type="tel" name=staffphone id="staffphone" placeholder="123-456-7890" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" required>   <small>Format: 123-456-7890</small>

<label for="staffdepartment">Department</label>	 	   <label for="staffdesignation">Designation</label>
<input type="text" name=staffdepartment id="staffdepartment" placeholder="Department" required>   <select name="staffdesignation" id="staffdesignation" required>
																									    <option value="">Select</option>
																									    <option value="Professor">Professor</option>
																									    <option value="HOD">HOD</option>
																								  </select>	
		
<label for="staffemail">Email</label>	                   <label for="staffpassword">Password</label>
<input type="email" name=staffemail id="staffemail" placeholder="example@mail.com" required>   <input type="text" name=staffpassword id="staffpassword" placeholder="Set Password" required>   <input type="submit" value="Register">	
		
		</pre>
	
	</form>
</body>
</html>