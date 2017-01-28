package com.userinterface.introsde.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SetLatLng extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NamingException {
		HttpSession session = request.getSession();
		String lat=request.getParameter("lat");
		String  lng=request.getParameter("lng");
		session.setAttribute("lat", lat);
		session.setAttribute("lng", lng);
		
		PrintWriter out = response.getWriter();
		out.println("<h2>You are being redirected to Homepage, please wait.</h2>");
		
		response.sendRedirect("ChatRequests");
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
