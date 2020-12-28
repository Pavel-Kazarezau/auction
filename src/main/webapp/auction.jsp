<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 24.12.2020
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to auction</title>
</head>
<body bgcolor="#faebd7">
    <a href="account.jsp">Let's check your account</a>

</body>
</html>

<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.html");
    }

    response.setHeader("Cache-Control", "no-cache, no-store, must-invalidate"); //HTTP 1.0
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setHeader("Expires", "0"); //Proxies

%>