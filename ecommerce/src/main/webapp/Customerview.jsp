<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.ArrayList"%>
    <%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer view</title>
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
<center>
<label><b>VIEW CUSTOMERS</b></label>
<table>
<tr>
<th><b>CUSTOMER NAME</b></th>
<th><b>CUSTOMER DOB</b></th>
<th><b>CUSTOMER PHNO</b></th>
<th><b>CUSTOMER EMAIL</b></th>
<th><b>CUSTOMER STATUS</b></th>
<th><b>SCOPE</b></th>

</tr>
<c:forEach var="i" items="${clist}">
<tr>
<td><c:out value="${i.name}"></c:out></td>
<td><c:out value="${i.dob}"></c:out></td>
<td><c:out value="${i.email}"></c:out></td>
<td><c:out value="${i.pass}"></c:out></td>

<td><c:out value="${i.scope}"></c:out></td>
<%-- <td><c:out value="${i.pass}"></c:out></td>--%>
 <td><a href="AdminCustomerController?name=${i.name}">APPROVE/INACTIVE</a>
 <%-- <a href="AdminCustomerController?name=${i.name}">INACTIVE</a> --%>
 <a href="DeleteCustomerController?delete=${i.name}">DELETE</a></td>
</tr>
</c:forEach>
</table><br><br>
<a href="AdminHome.jsp"><i>Go back to Admin menu</i></a>
</center>
</body>
</html>