<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 20.06.16
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change Password</title>
</head>
<body>
    <form action="changePassword" method="post">
        Старый пароль:  <input type="password" name="old_password"/></br>
        Новый пароль:   <input type="password" name="new_password"/></br>
        Подтверждение:  <input type="password" name="confirm"/></br>

        <input type="submit" name="ok" value="ОК"/>
    </form>
    <form action="residentPage.jsp" method="post">
        <input type="submit" name="cancel" value="Отмена"/>
    </form>
</body>
</html>
