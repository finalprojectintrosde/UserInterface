<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html  lang="en">
<head>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<link href='css/login.css' rel='stylesheet'>
<title>Log In</title>
</head>
<body>
<div>	
<form action='Login'>
		<h2>Log In</h2>
		<div class="input-group">
  <span class="input-group-addon" id="basic-addon1"><b>@</b></span>
  <input name='email' type='email' class="form-control" placeholder="Email" aria-describedby="basic-addon1" required autofocus>
  
</div><br>
<div class="input-group">
  <span class="input-group-addon glyphicon glyphicon-lock" id="basic-addon1"></span>

		<input name='password' type='password'class="form-control" placeholder='Password'aria-describedby="basic-addon1" required><br>
		</div><br>
		<button class="btn btn-primary" type='submit' class="btn btn-default">Log In</button>
	</form>
	</div><br>
	<a href='Registration.jsp'>Register</a>
</body>
</html>