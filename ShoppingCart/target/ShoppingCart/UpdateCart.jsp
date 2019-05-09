<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html> 

<html>
<head>
    <title>Update Values</title>
</head>
<body>
<h2>Enter the desired quantity:</h2>
<form action="updateCart" method="post"> <!-- create an action that will go to the updateCart servlet  -->
    <label>
        <input type="text" name="quantity">  <!-- create an input text called quantity -->
    </label>
    <input type="submit" value="Order"> <!-- creez un submit buton pe care scrie "Order" -->
</form>
<a href="DisplayProducts.jsp">Back</a> <!-- create an hyperlink to DisplayProducts called Back-->
</body>
</html>