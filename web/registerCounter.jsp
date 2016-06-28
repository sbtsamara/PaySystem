<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.home.dao.Registration" %>
<%@ page import="ru.home.dao.Service" %><%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 28.06.16
  Time: 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Показания счетчика</title>
    <link rel="stylesheet" href="css/table.css">

</head>
<body>
    <%ArrayList<Registration> registrations = (ArrayList<Registration>) session.getAttribute("registrations");%>
    <%Service service = (Service) session.getAttribute("service");%>
    <%pageContext.setAttribute("registrations",registrations,PageContext.PAGE_SCOPE);%>
    <div class="top">
        <div class="topText">
            <p>Ввод показаний счетчика по услуге <%=service.getServiceName()%></p>
        </div>

        <form class="exit" action="/backServlet" method="get">
            <input class="submit" type="submit" value="Назад"/>
        </form>
    </div>

    <div class="body">
        <h3>Показания счетчика</h3>
        <div class="formPayments">
            <table>
                <tr>
                    <th>Номер показания</th>
                    <th>Дата сдачи</th>
                    <th>Значение</th>
                </tr>
                <c:forEach items="${registrations}" var="registration" varStatus="status">
                    <tr>
                        <td>${registration.regId}</td>
                        <td>${registration.regDate}</td>
                        <td>${registration.regValue}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
