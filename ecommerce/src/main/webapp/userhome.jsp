<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*,ecommerce.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User home page</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }

        center {
            margin-top: 20px;
        }

        table {
            background-color: #fff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 1000px;
            margin: 0 auto;
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #007BFF;
            color: #fff;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background-color: #007BFF;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<%
	session.setAttribute("myList",new ArrayList<Product>());
%>
<center><form action="userhome">
<table>
<th><input type="submit" name="uh" value="HOME" formaction="userhome.jsp"></th>
<th><input type="submit" name="uh" value="VIEW PRODUCT" ></th>
<th><input type="submit" name="uh" value="SEARCH PRODUCT" ></th>
<th><input type="submit" name="uh" value="MYLIST" ></th>
<th><input type="submit" name="uh" value="MYCART" ></th>
<th><input type="submit" name="uh" value="LOG OUT"  ></th>
</table>
 </form>
</center>

</body>
</html>