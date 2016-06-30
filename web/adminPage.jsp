<%--
  Created by IntelliJ IDEA.
  User: Vo4ik
  Date: 23.06.2016
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Admin Page</title>
    </head>
    <body>
        <form action=".jsp" method="post">
            <input type="submit" name="users_edit" value="Управление пользователями"/>
        </form>

        <form action="directoryProviderServlet" method="post">
            <input type="submit" name="directory_provide" value="Справочник поставщиков"/>
        </form>

        <form action=".jsp" method="post">
            <input type="submit" name="directory_service" value="Справочник управляющих компаний"/>
        </form>

        <form action="changePassword.jsp" method="post">
            <input type="submit" name="change_password" value="Сменить пароль"/>
        </form>

        <form action="index.jsp" method="post">
            <input type="submit" name="exit" value="Выйти"/>
        </form>
    </body>
</html>
