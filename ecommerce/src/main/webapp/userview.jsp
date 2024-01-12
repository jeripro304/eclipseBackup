<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<%-- <jsp:useBean id="product" class="ecommerce.model.Product"></jsp:useBean>
 --%><center>
<label><b>VIEW PRODUCTS</b></label>
<table>
<tr>
<th><b>PRODUCT NAME</b></th>
<th><b>PRODUCT DESCRIPTION</b></th>
<th><b>PRODUCT PRICE</b></th>
<th><b>ADD TO WISH LIST</b></th>
<th><b>ADD TO CART</b></th>
<th><b>BUY</b></th>
</tr>
<c:forEach var="i" items="${prolist}">
<tr>
<td><c:out value="${i.pname}"></c:out></td>	
<td><c:out value="${i.pdesc}"></c:out></td>
<td><c:out value="${i.pprice}"></c:out></td>
<td><a href="mylist?id=${i.pid }">ADD</a></td>
<td><a href="cart?id=${i.pid }">ADD</a></td>
<td><a href="purchase?id=${i.pid}">BUY</a></td>
</tr>
</c:forEach>
</table><br><br>
<a href="userhome.jsp"><i>Go back to user home page</i></a>
</center>
</body>
</html>