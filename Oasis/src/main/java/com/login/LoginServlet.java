package com.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        // Authenticate user
        User user = UserDAO.authenticate(username, password, role);

        if (user != null) {
            // User authenticated
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            
            // Redirect based on role
            switch (user.getRole()) {
                case "Patient":
                    response.sendRedirect("patientDashboard.jsp");
                    break;
                case "Doctor":
                    response.sendRedirect("doctorDashboard.jsp");
                    break;
                case "Nurse":
                    response.sendRedirect("nurseDashboard.jsp");
                    break;
                case "Pharmacist":
                    response.sendRedirect("pharmacistDashboard.jsp");
                    break;
            }
        } else {
            // Authentication failed
            response.sendRedirect("login.jsp?error=Invalid username or password");
        }
    }
}

