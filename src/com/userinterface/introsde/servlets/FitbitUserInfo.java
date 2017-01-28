package com.userinterface.introsde.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FitbitUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String access_token = (String) request.getSession().getAttribute("access_token");
		String user_id = (String) request.getSession().getAttribute("user_id");
		String refresh_token = (String) request.getSession().getAttribute("refresh_token");
		
		String from = request.getParameter("from");
		if (from == null) {
			response.sendRedirect("FitbitSignin");
		} else {

			request.getSession().setAttribute("access_token", access_token);
			request.getSession().setAttribute("user_id", user_id);
			request.getSession().setAttribute("refresh_token", refresh_token);

			response.sendRedirect("LatLng");

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}