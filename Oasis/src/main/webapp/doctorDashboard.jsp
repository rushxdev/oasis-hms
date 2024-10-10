<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Dashboard</title>
    <link rel="stylesheet" href="dashboard.css">
</head>
<body>
    
    <div class="container">
        <!-- Top Bar -->
        <div class="top-bar">
            <div class="hospital-name">
                <img src="img/hms.png" alt="Hospital Icon" class="hospital-icon"> Oasis Hospital Management System
            </div>
            <div class="user-info">
                <img src="img/user.png" alt="User Icon" class="user-icon">
                <div class="user-details">
                    <!-- Display Username and Role from Session -->
                    <span class="user-name"><%= session.getAttribute("username") %></span>
                    <br>
                    <span class="user-role" id="user-role"><%= session.getAttribute("role") %></span>
                </div>
                <!-- Log Out button directly in the top bar -->
                <a href="LogoutServlet" id="logout-btn" class="logout-btn">Log Out</a>
            </div>
        </div>
    </div>
    
        <!-- Sidebar -->
            <!-- Sidebar -->
       <!-- Inside the sidebar -->
       <aside class="sidebar">
        <ul class="sidebar-menu">
            <li id="dashboard">
                <a href="doctorDashboard.jsp">Dashboard</a>
            </li>
            <li id="view-patient details">
                <a href="viewPatients.jsp"> <img src="img/icon1.png" alt="View Patients Icon" class="sidebar-icon">View Patient Details</a>
            </li>
            <li id="add-sessions">
                <a href="addSessions.jsp"><img src="img/icon2.png" alt="Add Sessions Icon" class="sidebar-icon">Add Sessions</a>
            </li>
            <li id="my-appointments">
                <a href="manageSessions.jsp"><img src="img/icon3.png" alt="Manage Sessions Icon" class="sidebar-icon">Manage Sessions</a>
            </li>
            <li id="health-records">
                <a href="medicineInventory.jsp"> <img src="img/icon4.png" alt="Medicine Inventory Icon" class="sidebar-icon">Medicine Inventory</a>
            </li>
        </ul>
    </aside>
       
    <!-- Dashboard Section -->
<section id="dashboard-section" class="dashboard-section">
    <h2>Dashboard</h2>
    <div class="dashboard-grid">
        <div class="dashboard-box" onclick="window.location.href='viewPatients.jsp';">
            <img src="img/icon1.png" alt="view-patient Icon">
            <h3>View patient details</h3>
            <p>View registered patients information.</p>
        </div>
        <div class="dashboard-box" onclick="window.location.href='addSessions.jsp';">
            <img src="img/icon2.png" alt="Add Sessions Icon">
            <h3>Add Sessions</h3>
            <p>Add your session times.</p>
        </div>
        <div class="dashboard-box" onclick="window.location.href='manageSessions.jsp';">
            <img src="img/icon3.png" alt="Manage Sessions Icon">
            <h3>Manage Sessions</h3>
            <p>Check and manage sessions.</p>
        </div>
        <div class="dashboard-box" onclick="window.location.href='medicineInventory.jsp';">
            <img src="img/icon4.png" alt="Medicine Inventory Icon">
            <h3>Medicine Inventory</h3>
            <p>View medicine available in Hospital.</p>
        </div>
    </div>
</section>

        <!-- Bottom Bar -->
        <div class="bottom-bar">
            <p>© 2024 Oasis Hospital Management System | All Rights Reserved</p>
        </div>

    <script src="script.js"></script>
</body>
</html>