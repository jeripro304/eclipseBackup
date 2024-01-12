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
<th><b>PRODUCT ID</b></th>
<th><b>PRODUCT NAME</b></th>
<th><b>PRODUCT DESCRIPTION</b></th>
<th><b>PRODUCT PRICE</b></th>
<th><b>PRODUCT QUANTITY</b></th>
<th><b>EDIT PRODUCT DETAILS</b></th>
<th><b>DELETE PRODUCT DETAILS</b></th>
</tr>
<c:forEach var="i" items="${pList}">
<tr>
<td><c:out value="${i.pid}"></c:out></td>
<td><c:out value="${i.pname}"></c:out></td>
<td><c:out value="${i.pdesc}"></c:out></td>
<td><c:out value="${i.pprice}"></c:out></td>
<td><c:out value="${i.pqty}"></c:out></td>
<td><a href="edit.jsp?editid=${i.pid }">Edit</a></td>
<td><a href="DeleteController?deleteid=${i.pid}">Delete</a></td>
</tr>
</c:forEach>
</table><br><br>
<a href="AdminHome.jsp"><i>Go back to Admin menu</i></a>
</center>
</body>
</html>