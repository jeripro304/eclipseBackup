<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="userhome.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }

        center {
            margin-top: 20px;
        }

        label {
            font-size: 24px;
            font-weight: bold;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }

        th {
            background-color: #007BFF;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        a {
            text-decoration: none;
            margin-right: 10px;
            padding: 5px 10px;
            border: 1px solid #007BFF;
            background-color: #007BFF;
            color: #fff;
            border-radius: 5px;
        }

        a:hover {
            background-color: #0056b3;
        }

        i {
            font-style: italic;
        }
    </style>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<sql:setDataSource var="db" 
			driver="com.mysql.cj.jdbc.Driver"
			url="jdbc:mysql://localhost:3306/ekart"
			user="root"
			password="root"/>
<center>
<label><b>VIEW CART</b></label>
<table>
<tr>
<th><b>PRODUCT NAME</b></th>
<th><b>PRODUCT DESCRIPTION</b></th>
<th><b>PRODUCT PRICE</b></th>
<th><b>STOCK AVAILABILITY</b></th>
<th><b>YOUR CART QTY</b></th>
<th><b>REMOVE FROM CART</b></th>
<th><b>BUY</b></th>
</tr>
<c:forEach var="i" items="${cartlist}">
<tr>
<td><c:out value="${i.pname}"></c:out></td>
<td><c:out value="${i.pdesc}"></c:out></td>
<td><c:out value="${i.pprice}"></c:out></td>
<td><c:choose>
        <c:when test="${i.pqty > 0}">
            Available
        </c:when>
        <c:otherwise>
            Not Available
        </c:otherwise>
    </c:choose></td>
<td><sql:query var="stockQuery" dataSource="${db}">
        SELECT qtycart FROM cart WHERE pid = ${i.pid}
    </sql:query>
    <c:forEach var="stockRow" items="${stockQuery.rows}">
        <c:out value="${stockRow.qtycart}"></c:out>
       
    </c:forEach>
     </td>
<td><a href="remvovefromcart?id=${i.pid}">REMOVE</a></td>
<td><a href="purchase.jsp?id=${i.pid}&name=${i.pname}&desc=${i.pdesc}&price=${i.pprice}&qty=${i.pqty}&qtycart=${stockRow.qtycart}">BUY</a></td>
</tr>
</c:forEach>
</table><br><br>
<a href="userhome.jsp"><i>Go back to user home page</i></a>
</center>
</body>
</html>