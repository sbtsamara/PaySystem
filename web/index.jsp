<%@ page import="ru.home.dao.User" %>
<%@ page import="ru.home.utils.DbHelper" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
  <title>Start page</title>
</head>
<body>
    <form action="startServlet" method="post">
      Login:    <input type="text" name="login"/>
      Password: <input type="password" name="password"/>
      <input type="submit" name="enter" value="Login In"/>
    </form>
</body>
</html>