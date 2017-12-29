<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>transaction</title>
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
<h1 align=center>Perform Fund Transfer Operation</h1>
<br><br>
<jsp:include page="topmenu.jsp"></jsp:include>
<br>
<form action="Transaction" method="post">
<fieldset>
<legend>Money Transfer...</legend>
<table>
<% String success= (String)request.getAttribute("SUCCESS");
	if(success!=null)
		out.print("<tr><td colspan=2 align=right>"+success+"</td></tr>");
%>
<tr>
<td>Account no.</td>
<td><input type="text" name="credit" size=30 required placeholder="Transfer To"></td>
</tr>
<tr>
<td>Amount</td>
<td><input type="text" name="amount" size=30 required placeholder="Amount"></td>
</tr>
<tr>
<td></td>
<td><input type=submit value="Proceed"></td>
</tr>

</table>
</fieldset>
</form>
</body>
</html>