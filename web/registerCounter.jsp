<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.home.dao.Registration" %>
<%@ page import="ru.home.dao.Service" %>
<%@ page import="ru.home.utils.DbHelper" %>
<%@ page import="java.util.Date" %>
<%@ page import="javafx.scene.input.DataFormat" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
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
            <p>Ввод показаний счетчика по услуге "<%=service.getServiceName()%>"</p>
        </div>

        <form class="exit" action="/backServlet" method="get">
            <input class="submit" type="submit" value="Назад"/>
        </form>
    </div>

    <div class="body">
        <div class="formAdd">
            <form action="/addRegServlet" method="get">
                <input class="textBox" type="text" name="value" placeholder="Показание счетчика"/>
                <input class="textBox" type="date" name="date"/>
                <div class="add"><input class="submit" type="submit" value="Добавить"/></div>
            </form>
        </div>
        <%String checker = (String) session.getAttribute("checker");
            if (checker!=null && checker.equals("false")){%>
        <div class="middleText">
            <p>Заполните все поля!!!</p>
        </div>

        <%}else {%>
        </br>
        <%}%>
        <h3>Показания счетчика</h3>
        <div class="formReg">
            <table>
                <tr>
                    <th>Дата сдачи</th>
                    <th>Значение</th>
                </tr>
                <c:forEach items="${registrations}" var="registration" varStatus="status">
                    <tr>
                        <td>${registration.regDate}</td>
                        <td>${registration.regValue}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>

    <%
        String serviceId = (String) session.getAttribute("serviceId");
        String abonentId = (String) session.getAttribute("abonentId");

        String s = "/charges.jsp?serviceId="+serviceId+"&abonentId="+abonentId;
        request.getSession().setAttribute("back",s);
    %>
</body>
</html>
