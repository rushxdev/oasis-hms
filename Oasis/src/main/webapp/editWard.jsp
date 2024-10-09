<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Ward</title>
</head>
<body>

	<h1>Edit Ward</h1>
	
	<form action="WardServlet" method="post">
        <!-- Hidden field for ward ID -->
        <input type="hidden" name="wardId" value="${ward.wardId}">
        
        <label for="name">Name:</label>
        <input type="text" name="name" value="${ward.name}" required><br>
        
        <label for="noOfBeds">No of Beds:</label>
        <input type="number" name="noOfBeds" value="${ward.noOfBeds}" required><br>
        
        <label for="department">Department:</label>
        <input type="text" name="department" value="${ward.department}" required><br>
        
        <label for="nurseInCharge">Nurse in Charge:</label>
        <input type="text" name="nurseInCharge" value="${ward.nurseInCharge}" required><br>
        
        <button type="submit" name="action" value="update">Update Ward</button>
    </form>
    
    <li><a href="WardServlet?action=viewWards">Back</a></li>

</body>
</html>