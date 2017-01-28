package com.userinterface.introsde.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.storageservice.bmi.ws.Bmi;
import com.storageservice.bmi.ws.BmiApi;
import com.storageservice.bmi.ws.StorageServiceBmi;
import com.storageservice.fitbit.ws.Goal;
import com.storageservice.fitbit.ws.LocalApiFitBitModel;
import com.storageservice.fitbit.ws.StorageServiceFitBit;
import com.storageservice.fitbit.ws.WeightGoal;
import com.storageservice.person.ws.LocalApiPersonModel;
import com.storageservice.person.ws.Person;
import com.storageservice.person.ws.StorageServicePerson;


public class PersonInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NamingException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		StorageServicePerson personservice = new StorageServicePerson();
		StorageServiceBmi bmiservice = new StorageServiceBmi();
		BmiApi bmis = bmiservice.getBmiApiImplPort();
		LocalApiPersonModel people = personservice.getLocalApiPersonImplPort();
		StorageServiceFitBit fitbitservice = new StorageServiceFitBit();
		LocalApiFitBitModel fitbits = fitbitservice.getLocalApiFitBitImplPort();
		
		int idPerson=(Integer)session.getAttribute("idPerson");
		String access_token = (String)session.getAttribute("access_token");
		String refresh_token = (String)session.getAttribute("refresh_token");
		String user_id = (String)session.getAttribute("user_id");
		
		System.out.println(idPerson+" "+access_token+ " "+refresh_token+" "+" "+user_id);

		Person p= people.getPersonInformation(idPerson);
		Bmi bmi= bmis.getBmiByIdPerson(idPerson);
		WeightGoal weightgoal= fitbits.getWeightGoal(access_token, user_id, refresh_token);
		Goal goal=fitbits.getDailyGoal(access_token, user_id, refresh_token);
		com.storageservice.fitbit.ws.Person weightheight= fitbits.getWeightHeight(access_token, user_id, refresh_token);
		Double weight= weightheight.getWeight();
		Double height =weightheight.getHeight();
		if (bmi==null){
			try{com.storageservice.bmi.ws.Person PersonBmi = new com.storageservice.bmi.ws.Person();
			PersonBmi.setBirthdate(p.getBirthdate());
			PersonBmi.setGenre(p.getGenre());
			PersonBmi.setIdPerson(p.getIdPerson());
			bmi=bmis.calculateandSavebmi(PersonBmi,weight , height);}catch(Exception e){}
		}
		
		request.setAttribute("Goalweight", weightgoal.getGoalWeight());
		request.setAttribute("Goal", goal);
		request.setAttribute("Person", p);
		request.setAttribute("Bmi", bmi);
		request.setAttribute("weight",weight);
		request.setAttribute("height", height);
		
		//resend to jsp
				javax.servlet.RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/PersonInformation.jsp");
				dispatcher.forward(request, response);

		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
