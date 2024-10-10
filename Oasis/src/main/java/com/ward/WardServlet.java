package com.ward;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/WardServlet")
public class WardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private WardDAO wardDAO;
	
	public void init() {
		
		wardDAO = new WardDAO();
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		switch (action) {
		case "new": 
			showNewForm(request, response);
		break;
		
		case "insert": 
			insertWard(request, response);
		break;
		
		case "delete": 
			deleteWard(request, response);
		break;
		
		case "edit": 
			showEditForm(request, response);
		break;
		
		case "update": 
			updateWard(request, response);
		break;
		
		default:
			listWards(request, response);
			break;
		}
		
	}
	
	private void listWards(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Ward> wardList = wardDAO.getAllWards();
		
		request.setAttribute("wardList", wardList);
		request.getRequestDispatcher("wardList.jsp").forward(request, response);
		
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("addWard.jsp").forward(request, response);
		
	}
	
	private void insertWard(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String name = request.getParameter("name");
		int numberOfBeds = Integer.parseInt(request.getParameter("numberOfBeds"));
		String department = request.getParameter("department");
		
		Ward newWard = new Ward();
		
		newWard.setName(name);
		newWard.setNumberOfBeds(numberOfBeds);
		newWard.setDepartment(department);
		
		wardDAO.insertWard(newWard);
		response.sendRedirect("WardServlet?action=list");
		
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int wardId = Integer.parseInt(request.getParameter("wardId"));
		Ward existingWard = wardDAO.getWardById(wardId);
		request.setAttribute("ward", existingWard);
		request.getRequestDispatcher("editWard.jsp").forward(request, response);
		
	}
	
	private void updateWard(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int wardId = Integer.parseInt(request.getParameter("wardId"));
		String name = request.getParameter("name");
		int numberOfBeds = Integer.parseInt(request.getParameter("numberOfBeds"));
		String department = request.getParameter("department");
		
		Ward ward = new Ward(wardId, name, numberOfBeds, department);
		wardDAO.updateWard(ward);
		response.sendRedirect("WardServlet?action=list");
		
	}
	
	private void deleteWard(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int wardId = Integer.parseInt(request.getParameter("wardId"));
		wardDAO.deleteWard(wardId);
		response.sendRedirect("WardServlet?action=list");
		
	}


}
