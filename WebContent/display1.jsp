<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="java.util.ArrayList,java.util.Iterator, a1.Account" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transaction Detail</title>
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
<h1 align=center>Transaction Detail</h1>
<br><br>
 <jsp:include page="topmenu.jsp"></jsp:include>
<br>
</head>
<body>

<table border=2 align=center>
    <tr>
        <th>own_acc</th>
        <th>type</th>
        <th>to_acc</th>
        <th>amount</th>
        <th>date</th>
    </tr>

    <%
        ArrayList<Account> dbooks=(ArrayList)request.getAttribute("account_details");
        Iterator it=dbooks.iterator();
        while(it.hasNext())
        {
            Account b=(Account)it.next();
    %>
    <tr>
        <td><%=b.own_acc%></td>
        <td><%=b.type%></td>
        <td><%=b.to_acc%></td>
        <td><%=b.amount%></td>
        <td><%=b.date%>></td> 
    </tr>
    <%
        }
    %>
    </table>

</body>
</html>