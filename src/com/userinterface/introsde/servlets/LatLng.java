package com.userinterface.introsde.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LatLng extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
        
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<h2>You are being redirected to Homepage, please wait.</h2>");
		out.println("<script>");
		out.println("window.onload = function() {navigator.geolocation.getCurrentPosition(showPosition);};");
		out.println("function showPosition(position) {");
		out.println("window.location = '/SetLatLng?lat=' + position.coords.latitude + '&lng=' + position.coords.longitude; ");
		out.println("}");
		out.println("</script>");
		out.println("</html>");
		out.println("</body>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
