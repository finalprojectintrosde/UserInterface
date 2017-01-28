<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='css/chat.css' rel='stylesheet'>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"><script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Application information</title>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Motivational Coach</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="ChatRequests">Home</a></li>
      <li><a href="PersonInformation">Personal information</a></li>
      <li class="active"><a href="#">Application information</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li><a href="Logout">Logout</a></li>
    </ul>
  </div>
</nav>
<div class="container">
    <div class="row">
<div class="panel panel-default">
<div class="panel-heading"><div style="background-color:#3d6da7; margin-top:30px;"><h3>Information about Motivational Coach Application</h3></div></div></div>
<br>
</div>

Our project goal was trying to generate sentences and advice that would persuade the user to do more physical activity. The calculation are based on real time data monitoring.<br>
The application is composed by two different System logics, one used in order to generate the motivational sentences based on users and external conditions while the other one is in charge to change the Fitbit goals of the users drawing on the progress or the difficulties encountered by him/her.
<br>
<h3>ADAPTER SERVICE: </h3>
<a href="https://adapterservice.herokuapp.com" target="_blank">https://adapterservice.herokuapp.com</a>
<br><br>
<ul>
<li><b>Bmi:</b> thanks to external <a href="https://market.mashape.com/nviror/bmi-calculator" target="_blank">API</a> calculates the BMI of a person through weight, height, age and gender.</li>
<li><b>Weather:</b> uses external <a href="https://market.mashape.com/fyhao/weather-13#weatherdata" target="_blank">API</a> to get current weather though coordinates and formats the response.</li>
<li><b>WeatherForecast:</b> uses external <a href="https://market.mashape.com/fyhao/weather-13#weatherdata" target="_blank">API</a> to get weather forecast for the next 10 days though coordinates and formats the response.</li>
<li><b>FitbitActivities:</b> uses external <a href="https://dev.fitbit.com/docs/activity/#browse-activity-types" target="_blank">Fitbit API</a> to get a list of all activities.</li>
<li><b>FitbitDailyActivitySummary:</b> uses external <a href="https://dev.fitbit.com/docs/activity/#get-daily-activity-summary" target="_blank">Fitbit API</a> to get the summary of the activity performed by person. </li>
<li><b>FitbitBodyGoal:</b> uses external <a href="https://dev.fitbit.com/docs/body/#get-body-goals" target="_blank">Fitbit API</a> to get a list of all activities to get goals (weight, distance, steps, calories) of a person.</li>
<li><b>FitbitWeightLogs:</b> uses external <a href="https://dev.fitbit.com/docs/body/#get-weight-logs" target="_blank">Fitbit API</a> to get a list of all activities all logs weight of a person. </li>
<li><b>FitbitFavoriteActivities: </b>uses external <a href="https://dev.fitbit.com/docs/activity/#get-favorite-activities" target="_blank">Fitbit API</a> to favorite activity of a person. </li>
<li><b>FitbitProfile:</b> uses external <a href="https://dev.fitbit.com/docs/user/#get-profile" target="_blank">Fitbit API</a> to get a list of all activities to get person information. </li>
</ul>

<h3>LOCAL DATABASE SERVICE (REST):</h3> 
<a href="https://localdbservice.herokuapp.com/localdbservice/person" target="_blank">https://localdbservice.herokuapp.com/localdbservice/person</a>
<br><br>
This service exposes method to access to the local database where are stored all the users with their lifestyles and Levels (based on goal achieved).

<h3>STORAGE SERVICE BMI (SOAP):</h3>
<a href="https://storageservicebmi.herokuapp.com/ws/storageServiceBmi?wsdl" target="_blank">https://storageservicebmi.herokuapp.com/ws/storageServiceBmi?wsdl</a>
<br><br>
<ul>
<li><b>CalculateAndSaveBmi:</b> calls the Adapter service in order to calculate the BMI of a person and stores it into the DB</li>
<li><b>PeriodBmiDifference:</b>  returns the difference of BMI in a determined period of time</li>
<li><b>StatusBmiDifference:</b>  returns a string which contains the difference status of a person (based on BMI) in a determined period of time</li>
<li><b>getBmyByIdPerson:</b>  returns the BMI of a person</li>
</ul>

<h3>STORAGE SERVICE SPORT (SOAP): </h3>
<a href="https://storageservicesport.herokuapp.com/ws/storageServiceSport?wsdl" target="_blank">https://storageservicesport.herokuapp.com/ws/storageServiceSport?wsdl</a>
<br><br>
<ul>
<li><b>getSportsByWeather: </b>returns all the sports related to a particular condition (cloudy, sunny, rain, snow)</li>
<li><b>getActivityBySport: </b>returns a random activity related to a sport present in the DB. Activities are the sports present in the Fitbit DB and their relative information for instance mets index. If the activity searched is still not in the local DB of the service, it will be searched through the Fitbit API and then saved in the DB.</li>
<li><b>getSportsList: </b>returns all the sports stored in the DB</li>
</ul>

<h3>STORAGE SERVICE FITBIT (SOAP):</h3>
<a href="https://storageservicefitbit.herokuapp.com/ws/storageServiceFitBit?wsdl" target="_blank">https://storageservicefitbit.herokuapp.com/ws/storageServiceFitBit?wsdl</a>
<br><br>
<ul>
<li><b>getWeightHeight: </b>get Fitbit weight and height of a person thanks to Adapter Service through Fitbit external API</li>
<li><b>getDailyGoal: </b>get Fitbit daily goals of a person and calculate how far the person are in order to achieve them thanks to Adapter Service through Fitbit external API</li>
<li><b>PeriodWeightDifference: </b>get Fitbit weight difference during a period of time of a person thanks to Adapter Service through Fitbit external API</li>
<li><b>getWeightGoal: </b>get Fitbit weight goal of a person  and calculate how far the person are in order to achieve it thanks to Adapter Service through Fitbit external API</li>
</ul>

<h3>STORAGE SERVICE PERSON (SOAP):</h3> 
<a href="https://storageserviceperson.herokuapp.com/ws/storageServicePerson?wsdl" target="_blank">https://storageserviceperson.herokuapp.com/ws/storageServicePerson?wsdl</a>
<br><br>
<ul>
<li><b>getPersonInformation:</b> get person information from Local Database Service</li>
<li><b>updatePerson:</b> pass to Local Database Service the Person that must be modified</li>
<li><b>registration: </b>pass to Local Database Service a new Person</li>
<li><b>login: </b>pass to Local Database Service email and password of a person</li>
</ul>

<h3>STORAGE SERVICE WEATHER (SOAP):</h3>
<a href="https://storageserviceweather.herokuapp.com/ws/storageServiceWeather?wsdl" target="_blank">https://storageserviceweather.herokuapp.com/ws/storageServiceWeather?wsdl</a>
<br><br>
<ul>
<li><b>getForecastByLatLng:</b> get weather forecast by latitude and longitude from Adapter Service</li>
<li><b>getWeatherByLatLng:</b> get current weather by latitude and longitude from Adapter Service</li>
</ul>

<h3>BUSINESS LOGIC SERVICE GOAL (SOAP):</h3> 
<a href="https://businesslogicservicegoal.herokuapp.com/ws/businessLogicServiceGoal?wsdl" target="_blank">https://businesslogicservicegoal.herokuapp.com/ws/businessLogicServiceGoal?wsdl</a>
<br><br>
<ul>
<li><b>ChangeWeightControl:</b> increases or decreases weight goal according to its algorithm</li>
<li><b>ChangeDistancetControl: </b>increases or decreases weight goal according to its algorithm</li>
<li><b>ChangeCaloriesControl:</b> increases or decreases weight goal according to its algorithm</li>
<li><b>ChangeStepsControl:</b> increases or decreases weight goal according to its algorithm</li>
</ul>

<h3>BUSINESS LOGIC SERVICE SENTENCE (SOAP):</h3>
<a href="https://businesslogicsentences.herokuapp.com/ws/businessLogic?wsdl" target="_blank">https://businesslogicsentences.herokuapp.com/ws/businessLogic?wsdl</a>
<br><br>
<ul>
<li><b>DailyMotivationalWeather:</b> generate a motivational sentence based on the current weather and the sports related to the weather according to its algorithm</li>
<li><b>DailyMotivationalCalories:</b> calculate on a random sport and for a random number of hours how many calories the person actually will burn and generate a motivational sentence based on it  according to its algorithm</li>
<li><b>motivationBasedonBmiStatus:</b> generate a motivational sentence according to its algorithm based on the bmi status changing of the person during a period of time</li>
<li><b>motivationBasedOnBmiValueDifference:</b> generate a motivational sentence according to its algorithm based on the bmi value changing of the person during a period of time</li>
<li><b>motivationBasedOnWeightDifference:</b> generate a motivational sentence according to its algorithm based on the weight changing of the person during a period of time taking into account his/her weight goal</li>
<li><b>motivationBasedOnGoalSteps:</b> generate a motivational sentence according to its algorithm based on the person daily steps goal and how far the person is in order to achieve it.</li>
<li><b>motivationBasedOnFavouriteActivities:</b> generate a motivational sentence according to its algorithm based on the favorite activities of the person</li>
<li><b>motivationBasedOnForecast:</b> generate a motivational sentence or advice according to the forecast of the week</li>
<li><b>verifyAndIncrementDailyGoalActivity:</b> check if the person achieved is daily goals and just in case, increment the number of goals achieved stored in the local DB.</li>
</ul>

<h3>PROCESS CENTRIC SERVICE GOAL (SOAP):</h3>
<a href="https://processcentricgoals.herokuapp.com/ws/businessLogicServiceGoal?wsdl" target="_blank">https://processcentricgoals.herokuapp.com/ws/businessLogicServiceGoal?wsdl</a>
<br><br>
<ul>
<li><b>checkWeight:</b> get required data from storage services and calls Business Logic Service Goal which controls if it is necessary to change the weight goal</li>
<li><b>checkDistance:</b> get required data from storage services and calls Business Logic Service Goal which controls if it is necessary to change the distance goal</li>
<li><b>checkCalories:</b> get required data from storage services and calls Business Logic Service Goal which controls if it is necessary to change the calories goal</li>
<li><b>checkSteps:</b> get required data from storage services and calls Business Logic Service Goal which controls if it is necessary to change the steps goal</li>
</ul>

<h3>PROCESS CENTRIC SERVICE SENTENCE (SOAP):</h3>
<a href="https://processcentricsentences.herokuapp.com/ws/processCentircMotivationalSentences?wsdl" target="_blank">https://processcentricsentences.herokuapp.com/ws/processCentircMotivationalSentences?wsdl</a>
<br><br>
<ul>
<li><b>registration:</b> pass required data to the storage services in order to register a new user, return the id of the person saved.</li>
<li><b>login:</b> pass required data to the storage service in order to log in,return the id of the person if succeed.</li>
<li><b>DailyMotivationalWeatherCalls:</b> get required data from storage services and calls Business Logic Service Sentences which will generate the sentence, return the sentence generated.</li>
<li><b>DailyMotivationalCaloriesCalls: </b>get required data from storage services and calls Business Logic Service Sentences which will generate the sentence, return the sentence generated.</li>
<li>All the others service methods present in the Process Centric follow the same logic and their lifecycle and functionalities are basically the same: get required data from storage services and calls Business Logic Service Sentences which will generate the sentence, return the sentence generated.</li>
</ul>

</div>
<br><br>

</body>
</html>