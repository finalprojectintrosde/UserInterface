package com.userinterface.introsde.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.processcentric.motivationalsentences.ws.ProcessCentricMotivationalSentencesModel;
import com.processcentric.motivationalsentences.ws.ProcessCentricMotivationalSentencesService;
import com.storageservice.person.ws.Person;

public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {

		try {
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			String email = request.getParameter("email");
			String birthdate = request.getParameter("birthdate");
			String genre = request.getParameter("genre");
			String lifeStyle = request.getParameter("lifeStyle");
			String pw = request.getParameter("password");
			
			System.out.println(firstname+" "+lastname+" "+ birthdate+" "+genre+" "+email+" "+lifeStyle+" "+pw);
			ProcessCentricMotivationalSentencesService procSentences = new ProcessCentricMotivationalSentencesService();
			ProcessCentricMotivationalSentencesModel api = procSentences
					.getProcessCentricMotivationalSentencesImplPort();
			
			Person p=new Person();
			p.setFirstname(firstname);
			p.setLastname(lastname);
			p.setEmail(email);
			p.setBirthdate(birthdate);
			p.setGenre(genre);
			p.setIdLifeStyle(Integer.parseInt(lifeStyle));
			p.setPassword(pw);
			
			int id=api.registration(p);
			
			request.getSession().setAttribute("idPerson", id);

			response.sendRedirect("FitbitUserInfo");
		} catch (Exception e) {
			System.out.println(e);
			response.sendRedirect("Registration.jsp");
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
