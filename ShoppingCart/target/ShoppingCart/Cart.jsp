<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> --%>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
	<h1>Shopping Cart</h1>
</head>
<body>
	<table>
    <tr>
        <th>Product Name</th>
        <th>Quantity</th>
    </tr>
    <c:forEach var="value" items="${sessionScope.map}">  <!-- for each loop: for each value in session -->
        <tr>
        <td><c:out value="${value.key}" /></td>			<!-- display name (the key of the map) -->
        <td><c:out value="${value.value}"/></td>		<!-- display price (the value of the map)-->
        <td><a href="Ordered.jsp" value="${value.key}" scope="session"/>>Buy</a> </td> <!-- go to Ordered page in order to display a confirmation message -->
 
        
        </tr>		<!-- close table row -->
    </c:forEach>	<!-- close for each loop -->
</table>
</body>
</html>