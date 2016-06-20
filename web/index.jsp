<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
  <title>Start page</title>
</head>
<body>
<a href="myServlet">click me</a>


<form action="startServlet" method="post">
  Login:    <input type="text" name="login"/>
  Password: <input type="password" name="password"/>
  <input type="submit" name="enter" value="Login In"/>
  <input type="submit" name="register" value="Registration"/>
</form>
<p style="color:red">
    <c:if test="${param.error == 'invalidLoginPassword'}">
      Неверный логин или пароль. Попробуйте ещё раз.
    </c:if>
</p>
<p style="color:red">
  <c:if test="${param.error == 'invalidLoginPassword'}">
    Неверный логин или пароль. Попробуйте ещё раз.
  </c:if>
</p>
<p style="color:blue">
  <c:if test="${param.error == 'loginRequuired'}">
    Вы вышли. Войдите.
  </c:if>
</p>
<%



%>
</body>
</html>