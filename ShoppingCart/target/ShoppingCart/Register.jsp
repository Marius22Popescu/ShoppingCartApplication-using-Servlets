<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Register</title>
</head>
<body>
<form action="register" method="post">					<!-- create an action that will go to the register servlet  -->
    User Name: <input type="text" name="uname">			<!-- create an input text called uname -->
    Password: <input type="password" name="pwd">		<!-- create an input password called pwd -->
    First Name: <input type="text" name = fname">
    Last Name: <input type="text" name = lname">
    <input type="submit" value="Register">				<!-- creez un submit buton pe care scrie "Registeg" -->
</form>
<a href="index.jsp">Log in</a>							<!-- create an hyperlink to index.jsp called Log in-->
</body>
</html>