<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Leave Management</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
</head>
<body>

<form action="applyleave" method="post" autocomplete="off">
<pre>

        <label for="fromdate">From Date</label>            <label for="todate">To Date</label> 

    <input type="date" id="fromdate" name="fromdate" required>     <input type="date" id="todate" name="todate" required>
	
              <label for="reason">Reason for Leave</label>
    <textarea name="reason" id="reason" rows="2" cols="33" required></textarea>
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
			    $('#fromdate').attr('min', maxDate);  
			    $('#todate').attr('min', maxDate); 
			}); 
		</script>  
		 <script>
		 $("#todate").change(function () {
			    var startDate = document.getElementById("fromdate").value;
			    var endDate = document.getElementById("todate").value;

			    if ((Date.parse(startDate) >= Date.parse(endDate))) {
			        alert("End date should be greater than Start date");
			        document.getElementById("todate").value = "";
			    }
			}); 
		 </script>   
		 <script>
		 $("#fromdate").change(function () {
			    var startDate = document.getElementById("fromdate").value;
			    var endDate = document.getElementById("todate").value;

			    if ((Date.parse(startDate) >= Date.parse(endDate))) {
			        alert("End date should be greater than Start date");
			        document.getElementById("todate").value = "";
			    }
			}); 
		 </script>                  
                <input type="submit" value="Apply Leave"> <a href="hodhomepage.jsp">Home</a>
</pre> 
</form>

</body>
</html>