<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>


/* .submit-buttom  {
            width: 70px
            padding: 10px;
            background-color: #007BFF;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
        } */
        
a {
  color: #0077cc;
  text-decoration: none;
}
a:hover {
  text-decoration: underline;
  color: #ff6600;
}
a:visited {
  color: #551a8b;
}
a:active {
  color: #ff0000;
}
</style> 
</head>
<body><center>
<form action="UserSearchProductController">
<table><tr><td><label>Search by name :</label><input type="text" name="custsearch"> </td></tr>
</table>
<input style="width:70px;" class="submitb" type="submit" class="submit-buttom">
<br><br>
<a href="userhome.jsp">Go to User Home</a>
</form>
</center>
</body>
</html>