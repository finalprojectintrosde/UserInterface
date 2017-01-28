<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html  lang="en">
<head>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href='css/login.css' rel='stylesheet'>
<title>Registration</title>
</head>
<body>
<div>
	<form action='Registration'>
		<h2>Registration</h2>
			<div class="input-group">
  <span class="input-group-addon" id="basic-addon1"><b>Firstname</b></span>
		 <input name='firstname' type='text' placeholder='Firstname' class="form-control" required autofocus>
		 </div>
		 <br>
	<div class="input-group">
  <span class="input-group-addon" id="basic-addon1"><b>Lastname</b></span>
		<input name='lastname' type='text' placeholder='Lastname' class="form-control" required>
		</div>
		 <br>
		<div class="input-group">
  <span class="input-group-addon" id="basic-addon1"><b>Email</b></span>
		<input name='email' type='email' placeholder='Email' class="form-control" required>
		</div>
		 <br>
		<div class="input-group">
  <span class="input-group-addon" id="basic-addon1"><b>Birthdate</b></span>
		<input name='birthdate' type='date' class="form-control" required>
		</div>
		 <br>
		<div class="input-group">
  <span class="input-group-addon" id="basic-addon1"><b>Gender</b></span>
 <label class="radio-inline">
         <input type="radio" name="genre" value="m" checked> Male
         </label>
 <label class="radio-inline">
          <input type="radio" name="genre" value="f"> Female
          </label>
        </div>
         <br>
		<div class="input-group">
  <span class="input-group-addon" id="basic-addon1"><b>Life style</b></span>
        <select name="lifeStyle" class="form-control">
        	<option selected disabled>Life style</option>
  			<option value="1">Little to no activity</option>
  			<option value="2">Light activity</option>
  			<option value="3">Moderate activity</option>
  			<option value="4">Heavy activity</option>
  			<option value="5">Very heavy activity</option>
		</select>
        </div>
         <br>
      <div class="input-group">
  <span class="input-group-addon" id="basic-addon1"><b>Password</b></span>
		<input name='password' type='password' placeholder='Password' class="form-control" required>
		</div>
		 <br>
		<button class="btn btn-primary" type='submit' class="btn btn-default">Register</button>
	</form>
	</div>
</body>
</html>