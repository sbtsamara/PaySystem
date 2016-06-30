<%@ page import="ru.home.dao.User" %><%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 21.06.16
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Change Password</title>
    <link rel="stylesheet" href="css/style.css">

</head>

<body>

<div class="login-page">
    <div class="form">
        <form action="changePassword" method="post">
            <input type="password" name="old_password" placeholder="Старый пароль"/></br>
            <input type="password" name="new_password" placeholder="Новый пароль"/></br>
            <input type="password" name="confirm" placeholder="Подтверждение"/></br>
            <input class="button" type="submit" name="ok" value="ОК"/>
        </form>
        <%User user = (User) session.getAttribute("user");
            if (user.getRoleId().equals("RES")){%>
        <form action="residentPage.jsp" method="post">
            <input class="button" type="submit" name="cancel" value="Отмена"/>
        </form>
        <%}%>
        <%if (user.getRoleId().equals("ADM")){%>
        <form action="adminPage.jsp" method="post">
            <input class="button" type="submit" name="cancel" value="Отмена"/>
        </form>
        <%}%>
        <p class="text">Неверный пароль!!!</p>
    </div>
</div>
</body>
</html>