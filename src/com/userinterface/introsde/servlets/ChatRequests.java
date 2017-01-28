package com.userinterface.introsde.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.processcentric.goal.ws.ProcessCentricGoal;
import com.processcentric.goal.ws.ProcessCentricServiceGoal;
import com.processcentric.motivationalsentences.ws.ProcessCentricMotivationalSentencesModel;
import com.processcentric.motivationalsentences.ws.ProcessCentricMotivationalSentencesService;

public class ChatRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NamingException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
	
		response.setIntHeader("Refresh", 10);

		List<String> sentences = new ArrayList();
		List<String> currentTimes = new ArrayList();

		
		int idPerson=(Integer)session.getAttribute("idPerson");
		String access_token = (String)session.getAttribute("access_token");
		String refresh_token = (String)session.getAttribute("refresh_token");
		String user_id = (String)session.getAttribute("user_id");
		String lat = (String)session.getAttribute("lat");
		String lng = (String)session.getAttribute("lng");
		
		System.out.println(idPerson+" "+access_token+ " "+refresh_token+" "+" "+user_id+ " "+lat+ " "+lng);

		if (session.getAttribute("list") == null) {
			//first seesion time
			sentences.add(ServicesCall(idPerson, access_token, user_id, refresh_token, lat, lng));
			currentTimes.add(getCurrentTime());
			session.setAttribute("list", sentences);
			session.setAttribute("currentTimes", currentTimes);
		} else {
			sentences = (List<String>) session.getAttribute("list");
			currentTimes = (List<String>) session.getAttribute("currentTimes");	
			sentences.add(ServicesCall(idPerson, access_token, user_id, refresh_token, lat, lng));
			currentTimes.add(getCurrentTime());
			session.setAttribute("currentTimes", currentTimes);
			session.setAttribute("list", sentences);}
		
		if(getHour()==15 && session.getAttribute("checkgoal")==null){
			//check at the end of tthe day if the goal achieved
			ProcessCentricMotivationalSentencesService procSentences = new ProcessCentricMotivationalSentencesService();
			ProcessCentricMotivationalSentencesModel apiSentences = procSentences.getProcessCentricMotivationalSentencesImplPort();
			try{
				apiSentences.verifyAndIncrementDailyGoalAchieved(idPerson, access_token, user_id, refresh_token);
				currentTimes.add(getCurrentTime());
				sentences.add("your daily goal has been checked, I got my eye on you! don't give up");session.setAttribute("checkgoal", "true");
				session.setAttribute("currentTimes", currentTimes);
				session.setAttribute("list", sentences);}
			catch(Exception e){
				sentences.add("something went wrong on check your daily goal");
				
			}
	
		} 
			
		//resend to jsp
		javax.servlet.RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ChatView.jsp");
		dispatcher.forward(request, response);

	}
public int getHour(){
	Calendar calendar = new GregorianCalendar();
return 	calendar.get(Calendar.HOUR_OF_DAY);
}
	public String getCurrentTime() {
		//get time for chat
		Calendar calendar = new GregorianCalendar();
		String am_pm;
		int hour = calendar.get(Calendar.HOUR);
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND);
		if (calendar.get(Calendar.AM_PM) == 0)
			am_pm = "AM";
		else
			am_pm = "PM";

		String CT = hour + ":" + minute + ":" + second + " " + am_pm;
		
		
		return CT;
	
	}

	public String ServicesCall(int idPerson, String access_token, String user_id, String refresh_token, String lat,
			String lng) {
		int randomServiceToCall = getRandomNumber(2);
		String sentence;

		if (randomServiceToCall == 0) {
			ProcessCentricMotivationalSentencesService procSentences = new ProcessCentricMotivationalSentencesService();
			ProcessCentricMotivationalSentencesModel apiSentences = procSentences
					.getProcessCentricMotivationalSentencesImplPort();

			int randomMethodToCall = getRandomNumber(8);

			Date dateToday = new Date();
			String sTodayDate = new SimpleDateFormat("yyyy-MM-dd").format(dateToday);
			long DAY_IN_MS = 1000 * 60 * 60 * 24;
			Date dateToVerify = new Date(dateToday.getTime() - 15 * DAY_IN_MS);
			String sdateToVerify = new SimpleDateFormat("yyyy-MM-dd").format(dateToVerify);
			
			
			switch (randomMethodToCall) {
			case 0:
				try{sentence = apiSentences.motivationBasedOnFavouriteActivitiesCalls(access_token, user_id, refresh_token);}catch(Exception e){sentence="problem on get sentence regard Favourite Activity";};
				break;
			case 1:
				try{sentence = apiSentences.dailymotivationalCaloriesCalls(idPerson, access_token, user_id, refresh_token);}catch(Exception e){sentence="problem on get sentence regard Activity and Calories";};
				break;
			case 2:
				try{sentence = apiSentences.motivationBasedOnBmiValueDifferenceCalls(idPerson, sdateToVerify, access_token,
						user_id, refresh_token);}catch(Exception e){sentence="problem on get sentence ragard Bmi value difference";}
				break;
			case 3:
				try{sentence = apiSentences.motivationBaseOnBmiStatusCalls(idPerson, sdateToVerify, access_token, user_id,
						refresh_token);}catch(Exception e){sentence="problem on get sentence regard Bmi status difference";}
				break;
			case 4:
				try{
				sentence = apiSentences.motivationBasedOnGoalStepsCalls(access_token, user_id, refresh_token);}catch(Exception e){sentence="problem on get sentence regard steps missing to goal";}
				break;
			case 5:
				try{sentence = apiSentences.motivationBasedOnWeightDifferenceCalls(idPerson, sdateToVerify, sTodayDate,
						access_token, user_id, refresh_token);}catch(Exception e){sentence="problem on get sentence regard weighd changes";}
				break;
			case 6:
				try{
				sentence = apiSentences.dailymotivationalWeatherCalls(lat, lng);}catch(Exception e){sentence="problem on get sentence regard weather and sport";}
				break;
			default:
				try{sentence = apiSentences.motivationBasedonForecastCalls(lat, lng);}catch(Exception e){sentence="problem on get sentence regard weekly forecast";}

			}
		} else {
			ProcessCentricServiceGoal procGoal = new ProcessCentricServiceGoal();
			ProcessCentricGoal apiGoal = procGoal.getProcessCentricGoalImplPort();
			int randomMethodToCall = getRandomNumber(4);
			switch (randomMethodToCall) {
			case 0:
				try{sentence = apiGoal.checkCalories(idPerson, access_token, user_id, refresh_token);}catch(Exception e){sentence="problem on check for changing calories goal";}
				break;
			case 1:
				try{sentence = apiGoal.checkDistance(idPerson, access_token, user_id, refresh_token);}catch(Exception e){sentence="problem on check for changing distance goal";}
				break;
			case 2:
				try{sentence = apiGoal.checkSteps(idPerson, access_token, user_id, refresh_token);}catch(Exception e){sentence="problem on check for changing steps goal";}
				break;
			default:
				try{sentence = apiGoal.checkWeight(idPerson, access_token, user_id, refresh_token);}catch(Exception e){sentence="problem on check for changing weight goal";}
				break;
			}

		}

		return sentence;

	}

	

	public int getRandomNumber(int max) {
		Random randomGenerator;
		randomGenerator = new Random();
		int randomIndex = randomGenerator.nextInt(max);
		return randomIndex;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			processRequest(request, response);
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
