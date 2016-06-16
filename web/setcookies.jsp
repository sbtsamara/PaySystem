<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 17.06.16
  Time: 0:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
        String login = request.getParameter("login");
        if (login!=null){
            Cookie cookie = new Cookie("login",login);
            cookie.setMaxAge(365*24*60*60);
            response.addCookie(cookie);
        }

    %>
<html>
<head>
    <title>set cookies</title>
</head>
<body>
    <a href="showcookies.jsp">Show Cookie...</a>
</body>
</html>
