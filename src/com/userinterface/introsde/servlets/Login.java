package com.userinterface.introsde.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.processcentric.motivationalsentences.ws.ProcessCentricMotivationalSentencesModel;
import com.processcentric.motivationalsentences.ws.ProcessCentricMotivationalSentencesService;

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

		try {
			System.out.println(1);
			String email = request.getParameter("email");
			String pw = request.getParameter("password");
			System.out.println(2);

			ProcessCentricMotivationalSentencesService procSentences = new ProcessCentricMotivationalSentencesService();
			ProcessCentricMotivationalSentencesModel api = procSentences
					.getProcessCentricMotivationalSentencesImplPort();
			System.out.println(email+" "+pw);
	
			int id=api.login(email,pw);
			
			System.out.println(id);
			request.getSession().setAttribute("idPerson", id);

			response.sendRedirect("FitbitUserInfo");
		} catch (Exception e) {
			response.sendRedirect("/");
		}

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
