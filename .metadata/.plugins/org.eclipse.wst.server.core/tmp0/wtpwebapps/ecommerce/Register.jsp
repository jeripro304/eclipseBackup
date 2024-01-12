<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
a {
  color: #007bff; 
  text-decoration: none;
}
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

        input[type="text"],
        input[type="date"],
        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"],
        input[type="reset"] {
            padding: 10px 20px;
            background-color: #007BFF;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-right: 10px;
        }
    </style>
</head>
<body>
<center>
<form action="Register">
<h3>Registration</h3>
<table>
<tr><td>Name </td><td><input type="text"                   name="name"  required="required"></td></tr>
<tr><td>DOB </td><td><input type="date"                    name="dob" required="required"></td></tr>
<tr><td>phone number </td><td><input type="text"           name="phno"  required="required"></td></tr>
<tr><td>Email </td><td><input type="email"                 name="email"  required="required"></td></tr>
<tr><td>password </td><td><input type="password"           name="pass" required="required"></td></tr>
</table>
<input type="submit" ><input type="reset"><br><br>

<a href="login.jsp">Already have a account Sign In</a>
</form>
</center>
<script>        
function validateForm() {
	var name = document.forms["myForm"]["name"].value;
	var dob = document.forms["myForm"]["dob"].value;
	var phno = document.forms["myForm"]["phno"].value;
	var email = document.forms["myForm"]["email"].value;
	var pass = document.forms["myForm"]["pass"].value;
	if (name === "" || email === "" || dob===""||phno ==="" ||pass ==="") {
		alert("Name and Email must be filled out");
		return false; 
		} 
	} 
	</script>
</body>
</html>