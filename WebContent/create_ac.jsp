<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>create a/c</title>
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
<h1 align=center>Account Creation Screen</h1>
<br>
 <!--<ul>
  <li><a class="active" href="menu.jsp">Home</a></li>
  <li><a href="create_ac.jsp">Create Account</a></li>
  <li><a href="transactn.jsp">Transaction</a></li>
  <li><a href="display.jsp">Display Statement</a></li>
  <li><a href="credit_card.jsp">Credit Card Transaction</a></li>
</ul>-->

<form action="ac_creation" method="post">
<fieldset>
<legend>Account Creation Form</legend>
<table>
<tr>
<td>Username </td>
<td><input type=text name=uid required size=30></td>
</tr>

<tr>
<td>Name </td>
<td><input type=text name=name required size=30></td>
</tr>



<tr>
<td>Password </td>
<td><input type=password name=pwd required size=30></td>
</tr>

<tr>
<td>DOB</td>
<td><input type=text name=dob required size=30 placeholder="yyyy-mm-dd"></td>
</tr>

<tr>
<td>Address</td>
<td><textarea row=15 cols=22 name=text></textarea></td>
</tr>

<tr>
<td>E-mail</td>
<td><input type=email name=email required size=30></td>
</tr>

<tr>
<td>Type of a/c</td>
<td>
<select name=slt>
<option value="saving"> Saving Account </option>
<option value="current"> Current Account  </option>
</select>
</td>
</tr>

<tr>
<td colspan=2 align=center><input type=submit value="Submit"></td>
</tr>
</table>
</fieldset>
</form>
</body>
</html>