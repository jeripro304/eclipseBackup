<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ECOMMERCE</title>
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
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #007BFF;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin: 5px;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<center>
<form action="AdminChoiceController" method="get">
<input type="submit" name="opr" value="ADD PRODUCT" >
<input type="submit" name="opr" value="VIEW PRODUCT" >
<input type="submit" name="opr" value="VIEW CUSTOMER">
<input type="submit" name="home" value="LOG OUT" formaction="home.jsp">
</form>

</center>
</form>
</body>
</html>