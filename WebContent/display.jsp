<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>statement</title>
<style>
body{
background-color:orange;
font-type:verdana;
font-size:20;
}
ul {
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #333;
}

li {
    float: left;
}

li a {
    display: block;
    color: white;
    text-align: center;
    padding: 14px 16px;
    text-decoration: none;
}

li a:hover {
    background-color: #111;
}
</style>
</head>
<body>
<h1 align=center>Display Statement</h1>
<br><br>
 <jsp:include page="topmenu.jsp"></jsp:include>
<br>
<form action="Display" method="post">
<fieldset>
<legend>Display Statement</legend>
<table>
<tr>
<td>Account No.</td>
<td><input type="int" placeholder="Enter ur a/c no." name=a_c size=30></td>
</tr>
<tr>
<td colspan=2 align=right><input type=submit value="Display"></td>
</tr>
</table>
<br>
<br>
</fieldset>
</form>
</body>
</html>