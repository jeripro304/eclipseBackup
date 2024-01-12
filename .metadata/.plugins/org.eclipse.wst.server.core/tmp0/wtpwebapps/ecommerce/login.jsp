<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
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
            max-width: 400px;
            margin: 0 auto;
        }

        h3 {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
        }

        table {
            border-collapse: collapse;
            width: 100%;
        }

        td {
            padding: 10px;
        }

        input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"], input[type="reset"] {
            padding: 10px 20px;
            background-color: #007BFF;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-right: 10px;
        }

        a {
            text-decoration: none;
            color: #007BFF;
        }
    </style>
</head>
<body>
<center>
<form action="LoginController">
<h3>Login</h3>
<table>
<tr><td>Username :</td><td><input type="text" name="usname"></td></tr>
<tr><td>Password :</td><td><input type="text" name="passcode"></td></tr>
</table>
<input type = "submit" ><input type="reset"><br><br>
<a href="home.jsp">Go to Home Page</a>

</form>
</center>

</body>
</html>