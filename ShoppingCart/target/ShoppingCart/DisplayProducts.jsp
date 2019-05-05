<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 --%><!DOCTYPE html> 

<%@ page contentType="text/html;charset=UTF-8" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<html>
<head>
    <h1>Products Inventory</h1>
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
        <!-- Get the selected item name from DisplayProduct and go to UpdateCart in order to update the quantity -->
        <td><a href="UpdateCart.jsp" <c:set var="itemKey" value="${value.key}" scope="session"/>>Add to Cart</a> </td>
        
        </tr>		<!-- close table row -->
    </c:forEach>	<!-- close for each loop -->
</table>

<a href="Logout.jsp">Logout</a> <!-- Create a hyperlink for Logout page  -->
</body>
</html>
