<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 24.12.2020
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello ${user.fName}</title>
</head>
<body bgcolor="#faebd7">

    <h1>Hello ${user.fName} ${user.lName}</h1>
    <a href="auction.jsp">Go to auction</a>

</body >
</html>

<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.html");
    }

    response.setHeader("Cache-Control", "no-cache, no-store, must-invalidate"); //HTTP 1.0
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setHeader("Expires", "0"); //Proxies

%>
