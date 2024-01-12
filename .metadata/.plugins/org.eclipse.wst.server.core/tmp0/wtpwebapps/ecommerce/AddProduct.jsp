<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
a.button {
  display: inline-block;
  padding: 10px 20px;
  background-color: #007bff; /* Button background color */
  color: #fff; /* Button text color */
  text-decoration: none;
  border-radius: 4px; /* Rounded corners */
  font-weight: bold;
  text-align: center;
  cursor: pointer;
  transition: background-color 0.3s ease; /* Smooth transition for hover effect */
}
       body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
        }

        center {
            margin-top: 20px;
        }

        h4 {
            font-size: 20px;
            font-weight: bold;
        }

        table {
            border-collapse: collapse;
            width: 80%;
            max-width: 500px;
            margin: 20px auto;
        }

        th, td {
            padding: 10px;
            border: 1px solid #ccc;
        }

        th {
            background-color: #007BFF;
            color: white;
        }

        input[type="text"] {
            width: 90%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"], input[type="reset"] {
            padding: 10px 20px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-right: 10px;
        }

        input[type="submit"]:hover, input[type="reset"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<center>
<form class="myForm" action="ProductController" method="get">
<h4>Add product details</h4>
<table>
<tr><td>Product id :</td><td><input type="text" name="pid"  required="required"> </td></tr>
<tr><td>Product Name :</td><td><input type="text" name="pname" required="required" ></td></tr>
<tr><td>Product Description :</td><td><input type="text" name="pdesc" required="required"></td></tr>
<tr><td>Product Quantity :</td><td><input type="text" name="pqty" required="required"></td></tr>
<tr><td>Product Price :</td><td><input type="text" name="price" required="required"></td></tr>

</table>
<input  type="submit" name="Add Product" ><input type="reset"><br><br><a href="AdminHome.jsp">Admin Home</a>
</form>
</center>

</body>
</html>