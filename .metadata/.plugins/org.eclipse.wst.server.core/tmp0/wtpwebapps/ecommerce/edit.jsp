<%@page import="org.apache.taglibs.standard.tag.el.sql.SetDataSourceTag"%>
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

        form {
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            margin: 0 auto;
        }

        label {
            font-size: 20px;
            font-weight: bold;
            display: block;
            margin-bottom: 20px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 10px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border-bottom: 1px solid #ccc;
        }

        th {
            background-color: #007BFF;
            color: white;
        }

        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #007BFF;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-top: 20px;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<center>
<form action="EditController" method="get">
<%
int pid=Integer.parseInt(request.getParameter("editid"));
session.setAttribute("editid",request.getParameter("editid"));%>
<sql:setDataSource var="db"
            driver="com.mysql.cj.jdbc.Driver"
            url="jdbc:mysql://localhost:3306/ekart"
            user="root"
            password="root"/>
<sql:query dataSource = "${db}" var = "rs">
        select * from product where pId=<%= pid %>
      </sql:query>
<label><b>EDIT PRODUCT DETAILS</b></label>
<table >
         <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Product Description</th>
            <th>Product Price</th>
            <th>Product Quantity</th>
         </tr>
         <c:forEach var = "p" items = "${rs.rows}">
            <tr>
               <td> <c:out value = "${p.pId}"/></td>
               <td> <c:out value = "${p.pName}"/></td>
               <td> <c:out value = "${p.pDesc}"/></td>
               <td> <input type="text" name="editprice" value="${p.price}"></td>
               <td> <input type="text" name="editqty" value="${p.pqty }"></td>
            </tr>
         </c:forEach>
      </table>
      <input type="submit" value="EDIT">
      </form>
</center>
</body>
</html>