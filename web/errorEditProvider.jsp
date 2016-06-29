<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vo4ik
  Date: 28.06.2016
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Редактирование провайдера</title>
    </head>
    <body>
        <h1 align="center">Ошибка, провайдер не изменен</h1>
        <form action="directoryProviderServlet" method="post">
            <button type="submit" name="errorEditProvider" value="true">Возврат</button>
        </form>

        <h2><%=request.getAttribute("er")%></h2>

        <c:forEach items="${requestScope.er}" var="values">
            <c:out value="${values}"></c:out>
        </c:forEach>
    </body>
</html>
