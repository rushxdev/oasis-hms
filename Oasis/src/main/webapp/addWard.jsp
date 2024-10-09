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
    <form action="WardServlet" method="post">
        <label for="name">Name:</label>
        <input type="text" name="name" required><br>
        <label for="noOfBeds">No of Beds:</label>
        <input type="number" name="noOfBeds" required><br>
        <label for="department">Department:</label>
        <input type="text" name="department" required><br>
        <label for="nurseInCharge">Nurse in Charge:</label>
        <input type="text" name="nurseInCharge" required><br>
        <button type="submit" name="action" value="add">Add Ward</button>
    </form>

</body>
</html>