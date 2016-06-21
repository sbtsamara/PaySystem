<%@ page import="ru.home.dao.User" %>
<%@ page import="ru.home.dao.Resident" %>
<%@ page import="ru.home.utils.DbHelper" %>
<%@ page import="ru.home.dao.Address" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.home.dao.Abonent" %><%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 20.06.16
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
        User user = (User) session.getAttribute("user");
        Address address = user.getAddressesByAddressId();
    %>
<script>
    function validLogin(){

        alert ( "Please enter mrbool Login Name." );

    }
</script>
<html>
<head>
    <title>Resident Page</title>
</head>
<body>
    Здравствуйте, <%=user.getUserId()%>!
    <form action="changePassword.jsp" method="post">
        <input type="submit" name="change_password" value="Сменить пароль"/>
    </form>
    <form action="index.jsp" method="post">
        <input type="submit" name="exit" value="Выйти"/>
    </form>

    <select>
        <% for (Abonent abonent :address.getAbonentsesByAddressId()) {
            String option = String.valueOf(abonent.getAbonentAccount());
        %>
        <option value="<%= option %>"><%= option %></option>
        <% } %>
    </select>
</body>
</html>
