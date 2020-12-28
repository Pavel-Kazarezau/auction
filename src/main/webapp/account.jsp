<%@ page import="by.kazarezov.bean.User" %>
<%@ page import="by.kazarezov.dao.impl.UsersDao" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 24.12.2020
  Time: 21:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body bgcolor="#faebd7">
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("login.html");
    }

    response.setHeader("Cache-Control", "no-cache, no-store, must-invalidate"); //HTTP 1.0
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setHeader("Expires", "0"); //Proxies

    String username = (String) session.getAttribute("username");
    String password = (String) session.getAttribute("password");

    UsersDao usersDao = UsersDao.getInstance();
    User user = null;
    try {
        user = usersDao.getUser(username, password);
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    } catch (SQLException throwables) {
        throwables.printStackTrace();
    }
%>

   <h1>User Info</h1>
    <div>
        <p>Username: ${user.username}</p>
        <p>First Name: ${user.fName}</p>
        <p>Last Name: ${user.lName}</p>
        <p>Email: ${user.email}</p>
        <p>Phone Number: ${user.phoneNumber}</p>
        <form action="logout" method="post">
            <input type="submit" value="logout">
        </form>
    </div>
</form>

</body>
</html>


