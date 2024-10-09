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
            <th>No of Beds</th>
            <th>Department</th>
            <th>Nurse in Charge</th>
            <th>Actions</th>
		</tr>
		
		<c:forEach var="ward" items="${wardList}">
            <tr>
                <td>${ward.wardId}</td>
                <td>${ward.name}</td>
                <td>${ward.noOfBeds}</td>
                <td>${ward.department}</td>
                <td>${ward.nurseInCharge}</td>
                <td>
                    <!-- Delete Form -->
                    <form action="WardServlet" method="post">
                        <input type="hidden" name="wardId" value="${ward.wardId}">
                        <button type="submit" name="action" value="delete">Delete</button>
                    </form>
                    <!-- Edit Form -->
                    <form action="editWard.jsp" method="post">
	                    <input type="hidden" name="action" value="editWard">
	                    <input type="hidden" name="wardId" value="${ward.wardId}">
	                    <button type="submit">Edit</button>
                	</form>
                </td>
            </tr>
        </c:forEach>
	
	</table>
	
</body>
</html>