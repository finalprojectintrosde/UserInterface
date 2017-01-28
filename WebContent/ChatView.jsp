<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href='css/chat.css' rel='stylesheet'>
<link rel="stylesheet" href="http://www.w3schools.com/lib/w3.css">
<title>Chat</title>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"><script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"><script> window.onload = function() {
	window.scrollTo(0,document.body.scrollHeight);
};
</script>

</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Motivational Coach</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="PersonInformation">Personal information</a></li>
      <li><a href="AppInfo.jsp">Application information</a></li>
  
    </ul>
    <ul class="nav navbar-nav navbar-right">
    <li><a href="Logout">Logout</a></li>
    </ul>
  </div>
</nav>
<div  class="container">
    <div class="row">
        <div class="panel panel-default">
          <div class="panel-heading"><div style="background-color:#3d6da7; margin-top:30px;"><h3>Your best trusted coach's advices and his motivational sentences</h3></div></div></div>
          <div class="panel-body" style="padding:0px;">
            <div class="container">
            <c:set var="i" value="${0}"/>
            <c:forEach var="list" items="${sessionScope.list}">
                <div class="row message-bubble">
                <p class="text-muted"><b>Your motivational Coach</b></p>
                    <span><c:out value="${list}" /></span>
                    <font size="1"><c:out value="${sessionScope.currentTimes[i]}"/>
                    </font>
                </div>
                 <c:set var="i" value="${i+1}"/>
                </c:forEach>
                
            <div class="panel-footer">
          
                </div>
            </div>
          </div>
        </div>
    </div>



</body>
</html>