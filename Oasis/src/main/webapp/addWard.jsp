<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Ward</title>
</head>
<body>

		<h1>Add New Ward</h1>
   <form action="WardServlet?action=insert" method="post">
        <label for="name">Ward Name:</label>
        <input type="text" id="name" name="name" required><br>
        <label for="numberOfBeds">Number of Beds:</label>
        <input type="number" id="numberOfBeds" name="numberOfBeds" required><br>
        <label for="department">Department:</label>
        <input type="text" id="department" name="department" required><br>
        <button type="submit">Submit</button>
    </form>
    
    <a href="WardServlet?action=list">Back to Ward List</a>

</body>
</html>