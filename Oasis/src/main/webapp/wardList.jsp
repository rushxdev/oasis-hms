<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ward List</title>
</head>
<body>

	<h1>Wards List</h1>
	
	<table border="1">
		<tr>
			<th>Ward ID</th>
            <th>Name</th>
            <th>Number of Beds</th>
            <th>Department</th>
            <th>Actions</th>
		</tr>
		
		<c:forEach var="ward" items="${wardList}">
            <tr>
                <td>${ward.wardId}</td>
                <td>${ward.name}</td>
                <td>${ward.numberOfBeds}</td>
                <td>${ward.department}</td>
                <td>
                    <!-- Delete Form -->
                    <a href="WardServlet?action=edit&wardId=${ward.wardId}">Edit</a>
                    <!-- Edit Form -->
                    <a href="WardServlet?action=delete&wardId=${ward.wardId}" onclick="return confirm('Are you sure?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
	
	</table>
	
	<a href="WardServlet?action=new">Add New Ward</a>
	
</body>
</html>