<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit ward</title>
</head>
<body>
	
	<h1>Edit Ward</h1>
	
	<form action="WardServlet?action=update" method="post">
        <!-- Hidden field to store the Ward ID -->
        <input type="hidden" name="wardId" value="${ward.wardId}">
        
        <label for="name">Ward Name:</label>
        <input type="text" id="name" name="name" value="${ward.name}" required><br>

        <label for="numberOfBeds">Number of Beds:</label>
        <input type="number" id="numberOfBeds" name="numberOfBeds" value="${ward.numberOfBeds}" required><br>

        <label for="department">Department:</label>
        <input type="text" id="department" name="department" value="${ward.department}" required><br>

        <button type="submit">Update Ward</button>
    </form>
    
    
    <a href="WardServlet?action=list">Back to Ward List</a>

</body>
</html>