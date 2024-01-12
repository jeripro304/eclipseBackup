<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
   <%
    String pid = request.getParameter("id");
    String price = request.getParameter("price");
    String pqty=request.getParameter("qty");
    session.setAttribute("qty", pqty);
    session.setAttribute("pid", pid);

	/* int qtycart=Integer.parseInt(cartqty); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
        }
        center {
            margin-top: 50px;
        }
        h2 {
            color: #333;
        }
        table {
            border-collapse: collapse;
            width: 80%;
            margin-top: 20px;
        }
        table, th, td {
            border: 1px solid #ddd;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</style>
</head>
<body><form action="purchase"  >
<center>

<%-- <%String status = ""; %>
<c:choose>
    <c:when test="${pqty1>'0'}">
    <% status = "Stock Available"; %>
    </c:when>
    <c:otherwise>
    <% status = "Not Available"; %>
    </c:otherwise>
</c:choose> --%>


<h2>PURCHASE PAGE</h2>
<table>
<tr><td>Product name :</td><td><%=request.getParameter("name") %></tr>
<tr><td>Product desc :</td><td><%=request.getParameter("desc") %></tr>
<tr><td>Product price per qty:</td><td><%=request.getParameter("price") %></tr>
<%-- <tr><td>Stock Availability</td><td><%=status %></tr> --%>


</table>
<input type="submit" name="purchase" value="PAY">
</center>
</form>

</body>
</html>