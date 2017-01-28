<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='css/chat.css' rel='stylesheet'>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Person information</title>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Motivational Coach</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="ChatRequests">Home</a></li>
      <li class="active"><a href="#">Personal information</a></li>
      <li><a href="AppInfo.jsp">Application information</a></li>
  
    </ul>
        <ul class="nav navbar-nav navbar-right">
    <li><a href="Logout">Logout</a></li>
    </ul>
  </div>
</nav>

<div class="container">
    <div class="row">
<div class="panel panel-default">
<div class="panel-heading"><div style="background-color:#3d6da7; margin-top:30px;"><h3>Your Personal information</h3></div></div></div>
<br>
<table align="center" class="goals">
<tr><td align="left"><b>Firstname:</b></td><td align="right">${Person.getFirstname()}</td></tr>
<tr><td align="left"><b>Lastname:</b></td><td align="right">${Person.getLastname()}</td></tr>
<tr><td align="left"><b>E-mail:</b></td><td align="right">${Person.getEmail()}</td></tr>
<tr><td align="left"><b>Genre:</b></td><td align="right">${Person.getGenre()}</td></tr>
<tr><td align="left"><b>Birthdate:</b></td><td align="right">${Person.getBirthdate()}</td></tr>
</table>
<br><br>
<div class="panel panel-default">
<div class="panel-heading"><div style="background-color:#3d6da7; margin-top:30px;"><h3>Your Fit information</h3></div></div></div>
<table align="center">
<br>
<tr><td align="left"><b>Lifestyle:</b></td><td align="right">${Person.getLifeStyle()}</td></tr>
<tr><td align="left"><b>Goal achieved:</b></td><td align="right">${Person.getNGoalAchieved()}</td></tr>
<tr><td align="left"><b>Goal checked by application:</b></td><td align="right">${Person.getNTotalGoal()}</td></tr>
<tr><td align="left"><b>Level:</b></td><td align="right">${Person.getLevel()}</td></tr>
<tr><td align="left"><b>Weight:</b></td><td align="right"><c:choose><c:when test="{$weight==null}">Weight not setted in fitbit</c:when><c:otherwise>${weight} kg	</c:otherwise></c:choose></td></tr>
<tr><td align="left"><b>Height:</b></td><td align="right"><c:choose><c:when test="{$height==null}">Height not setted in fitbit</c:when><c:otherwise>${height} kg	</c:otherwise></c:choose></td></tr>
<tr><td align="left"><b>Bmi value:</b></td><td align="right"><c:choose><c:when test="{$Bmi==null}">Weight and height not setted in fitbit impossible calculate bmi</c:when><c:otherwise>${Bmi.getValue()}</c:otherwise></c:choose></td></tr>
<tr><td align="left"><b>Bmi status:</b></td><td align="right"><c:choose><c:when test="{$Bmi==null}">Weight and height not setted in fitbit impossible calculate bmi</c:when><c:otherwise>${Bmi.getStatus()}</c:otherwise></c:choose></td></tr>
<tr><td align="left"><b>Bmi risk:</b></td><td align="right"><c:choose><c:when test="{$Bmi==null}">Weight and height not setted in fitbit impossible calculate bmi</c:when><c:otherwise>${Bmi.getRisk()}</c:otherwise></c:choose></td></tr>
</table>
<br><br>
<div class="panel panel-default">
<div class="panel-heading"><div style="background-color:#3d6da7; margin-top:30px;"><h3>Your Fitbit Goals</h3></div></div></div>
<table align="center" class="goals"><br>
<tr><td align="left"><b>Weight goal:</b></td><td align="right"> ${Goalweight} kg</td></tr>
<tr><td align="left"><b>Steps goal:</b></td><td align="right"> ${Goal.getSteps()} steps</td></tr>
<tr><td align="left"><b>Distance goal:</b></td><td align="right">${Goal.getDistance()} km.</td></tr>
<tr><td align="left"><b>Calories goal:</b></td><td align="right">${Goal.getCaloriesOut()} cal.</td></tr>

</table>
<br><br>
</div></div>
</body>
</html>