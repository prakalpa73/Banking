<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Banking Management</title>
<style type="text/css">
body{
background-color:orange;
font-type:verdana;
font-size:20;
}
table{
background-color:#936;
width:500px;
pading:24px;
color:white;
font-size:18px;
border-radius:10px;
}
tr{
height:45px;
}
a{
    color:white;
    text-decoration:none;
    cursor:pointer;
   }
</style>
</head>
<body>
<h1 align=center>Banking System</h1>
<hr size=3 color=blue width=90%>
<br><br><br>
<form action="Login" method="post">
<table align=center>
<% String status= (String)request.getAttribute("INVALID");
	if(status!=null)
		out.print("<tr><td colspan=2 align=right>"+status+"</td></tr>");
 String st1= (String)request.getAttribute("Created");
	if(st1!=null)
		out.print("<tr><td colspan=2 align=right>"+st1+"</td></tr>");
%>
<tr>
<td>Username</td>
<td><input type=text name=uid size=30 autofocus required placeholder="User-id"></td>
</tr>
<tr>
<td>Password</td>
<td><input type=password name=pwd size=30 required placeholder="Password"></td>
</tr>
<tr>
<td colspan=2 align=center>
<input type=submit value="Log In">
</td>
</tr>

<tr>
<td colspan=2 align=center><a href="create_ac.jsp">create account ?</a>
</td>
</tr>
</table>
</form>
</body>
</html>