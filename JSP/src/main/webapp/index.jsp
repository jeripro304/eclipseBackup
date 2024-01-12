
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL</title>
</head>
<body>
<form action="first" >
<sql:setDataSource var="db" 
			driver="com.mysql.cj.jdbc.Driver"
			url="jdbc:mysql://localhost:3306/prodapt"
			user="root"
			password="root"/>
			
<sql:query var="rs" dataSource="${db}">select * from student</sql:query>
<c:forEach var="s" items="${rs.rows}">
<table>
<!-- <tr><th>ID</tr><th>Name</th><th>Marks</th></tr> -->
<tr><td><c:out value="${s.sid}"></c:out><br></td><td><c:out value="${s.sname}"></c:out><br></td><td><c:out value="${s.marks}"></c:out><br></td></tr>
</table>
</c:forEach>


</form>
</body>
</html>