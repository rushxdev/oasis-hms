package com.ward;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/WardServlet")
public class WardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Ward> wardList = WardDAO.getAllWards();
		request.setAttribute("wardList", wardList);
		request.getRequestDispatcher("wardList.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if ("add".equals(action)) {
			int wardId = Integer.parseInt(request.getParameter("wardId"));
			String name = request.getParameter("name");
			int noOfBeds = Integer.parseInt(request.getParameter("noOfBeds"));
            String department = request.getParameter("department");
            String nurseInCharge = request.getParameter("nurseInCharge");
            
            Ward ward = new Ward(wardId, name, noOfBeds, department, nurseInCharge);
            WardDAO.addWard(ward);
            
		} else if ("update".equals(action)) {
			int wardId = Integer.parseInt(request.getParameter("wardId"));
            String name = request.getParameter("name");
            int noOfBeds = Integer.parseInt(request.getParameter("noOfBeds"));
            String department = request.getParameter("department");
            String nurseInCharge = request.getParameter("nurseInCharge");
            
            Ward ward = new Ward(wardId, name, noOfBeds, department, nurseInCharge);
            WardDAO.updateWard(ward);
            
		} else if ("delete".equals(action)) {
			int wardId = Integer.parseInt(request.getParameter("wardId"));
			WardDAO.deleteWard(wardId);
			
		}
		response.sendRedirect("WardServlet");
	}

}
