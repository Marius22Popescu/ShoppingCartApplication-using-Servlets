<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Failure</title>
</head>
<body>
<h2>Welcome to the Shopping Cart!</h2>
<h3 style='color:red'>Invalid Username or Password!</h>
<form action="login" method="post">
	<input type ="text" name="uname">
	<input type ="password" name="pwd">
	<input type ="submit" name="submit">
</form>
<a href="Login.jsp">Register</a>
</body>
</html>