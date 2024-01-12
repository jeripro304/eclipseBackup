<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
background-image: url('images/home.jpg');
background-size: cover;
}
.form-container {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color:tomato;
            margin:1px solid black;
            
            background-color: #f7f7f7;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
 input {
            width: 100%;
            padding: 10px;
            font-weight:bold;
            margin-bottom: 10px;
            background-color:tomato;
            border: 1px solid #ccc;
            border-radius: 3px;
        }
</style>
</head>
<body>
<center>
<form class="form-container" action="PageController">
<input type="submit" name="page" value="Home">
<input type="submit" name="page" value="Register">
<input type="submit" name="page" value="Login">
</form>
</center>
</body>
</html>