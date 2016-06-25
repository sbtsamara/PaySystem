<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.home.dao.Service" %>
<%@ page import="ru.home.utils.DbHelper" %>
<%@ page import="ru.home.dao.Abonent" %><%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 23.06.16
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payments</title>
    <link rel="stylesheet" href="css/table.css">
</head>
<body>
    <%

        Service service = DbHelper.getEm().find(Service.class,Integer.parseInt(request.getParameter("serviceId")));
        Abonent abonent = DbHelper.getEm().find(Abonent.class,Integer.parseInt(request.getParameter("abonentId")));
        pageContext.setAttribute("charges",abonent.getChargesByAbonentId(),PageContext.PAGE_SCOPE);
        session.setAttribute("abonent",abonent);
        session.setAttribute("service",service);
        session.setAttribute("serviceId",request.getParameter("serviceId"));
        session.setAttribute("abonentId",request.getParameter("abonentId"));
    %>
    Договор номер <%=abonent.getAbonentId()%> на предоставление услуги "<%=service.getServiceName()%>"
    <h2>Счета на оплату</h2>
    <table>
        <tr>
            <th>Номер счёта на оплату</th>
            <th>Сумма</th>
            <th>Начало периода</th>
            <th>Конец периода</th>
            <th>Квитанции</th>

        </tr>
    </table>
    <c:forEach items="${charges}" var="charge" varStatus="status">

        <table>
            <tr>
                <td>${charge.chargeId}</td>
                <td>${charge.chargeAmount}</td>
                <td>${charge.periodBeginDate}</td>
                <td>${charge.periodEndDate}</td>
                <c:if test="${charge.chargePaid == 'true'}">
                    <td>
                        <a href="${pageContext.servletContext.contextPath}/payments.jsp?chargeId=${charge.chargeId}&chargeAmount=${charge.chargeAmount}&periodBeginDate=${charge.periodBeginDate}&periodEndDate=${charge.periodEndDate}">Оплачено</a>
                    </td>
                </c:if>
                <c:if test="${charge.chargePaid == 'false'}">
                    <td>
                        <a href="${pageContext.servletContext.contextPath}/payments.jsp?chargeId=${charge.chargeId}&chargeAmount=${charge.chargeAmount}&periodBeginDate=${charge.periodBeginDate}&periodEndDate=${charge.periodEndDate}">Не оплачено</a>
                    </td>
                </c:if>
            </tr>
        </table>
    </c:forEach>
    </br>
    <form class="backButton" action="residentPage.jsp" method="post">
        <input type="submit" value="Назад"/>
    </form>

</body>
</html>
