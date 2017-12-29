<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>credit card transaction</title>
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
<h1 align=center>Authorized Credit Card Transaction</h1>
<br><br>
 <jsp:include page="topmenu.jsp"></jsp:include>
<br>
<form action="Credit_card" method="post">
<fieldset>
<legend>Credit Card Transaction</legend>
<table>
<% String status= (String)request.getAttribute("INVALID");
	if(status!=null)
		out.print("<tr><td colspan=2 align=right>"+status+"</td></tr>");
 String st1= (String)request.getAttribute("VALID");
	if(st1!=null)
		out.print("<tr><td colspan=2 align=right>"+st1+"</td></tr>");
%>
<tr>
<td>Name </td>
<td><input type=text size=30 placeholder="enter your user name" name=user></td>
</tr>

<tr>
<td>Card Number </td>
<td><input type=text size=30 placeholder="e.g-531979" name=card_no></td>
</tr>

<tr>
<td>CVV no. </td>
<td><input type=text size=30 placeholder="e.g-209" name=card_no></td>
</tr>

<tr>
<td>Amount </td>
<td><input type=text size=30 placeholder="amount" name=amount></td>
</tr>

<tr>
<td colspan=2 align=center><input type=submit value="Authorize"></td>
</tr>
</table>
</fieldset>
</form>
</body>
</html>