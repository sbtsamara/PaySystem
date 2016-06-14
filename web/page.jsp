<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 13.06.16
  Time: 1:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
      String login = request.getParameter("login");
      String password = request.getParameter("password");

    %>
    <p>Login: <%=login%></p>
    <p>Password: <%=password%></p>

</body>
</html>
