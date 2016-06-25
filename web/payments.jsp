<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.home.dao.Charge" %>
<%@ page import="ru.home.utils.DbHelper" %>
<%@ page import="ru.home.dao.Payment" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="ru.home.dao.Service" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="org.hibernate.Session" %><%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 24.06.16
  Time: 1:34
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
        Charge charge = DbHelper.getEm().find(Charge.class,Integer.parseInt(request.getParameter("chargeId")));
        String periodEndDate = request.getParameter("periodEndDate");
        String periodBeginDate = request.getParameter("periodBeginDate");
        String chargeAmount = request.getParameter("chargeAmount");


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Calendar beginDate = Calendar.getInstance();
        String[] splitDate = periodBeginDate.split("-");
        beginDate.set(Integer.parseInt(splitDate[0]),Integer.parseInt(splitDate[1])-1,Integer.parseInt(splitDate[2]));

        Calendar endDate = Calendar.getInstance();
        splitDate = periodEndDate.split("-");
        endDate.set(Integer.parseInt(splitDate[0]),Integer.parseInt(splitDate[1])-1,Integer.parseInt(splitDate[2]));

        session.setAttribute("beginDate",beginDate);
        session.setAttribute("endDate",endDate);
        session.setAttribute("charge",charge);


        pageContext.setAttribute("payments",charge.getPaymentsByChargeId(),PageContext.PAGE_SCOPE);
        Service service = (Service) request.getSession().getAttribute("service");
    %>
    <div class="top">
        <div class="topText">
            <p>Квитанции на оплату услуги "<%=service.getServiceName()%>" по счету на оплату № <%=charge.getChargeId()%> на сумму $<%=chargeAmount%></p>
            </br>
            <p>Период с <%=dateFormat.format(beginDate.getTime())%> по <%=dateFormat.format(endDate.getTime())%></p>
        </div>
        <form class="exit" action="/backServlet" method="get">
            <input class="submit" type="submit" value="Назад"/>
        </form>
    </div>

    <div class="body">
        <h3>Квитанции</h3>
    <div class="formPayments">
    <table>

        <tr>
            <th>Номер квитанции</th>
            <th>Сумма квитанции</th>
            <th>Печать</th>
        </tr>
    <c:forEach items="${payments}" var="payment" varStatus="status">


            <tr>
                <td>${payment.paymentId}</td>
                <td>${payment.paymentAmount}</td>
                <td>
                    <a href="${pageContext.servletContext.contextPath}/pdfServlet?paymentId=${payment.paymentId}&chargeId=${payment.chargeId}&paymentAmount=${payment.paymentAmount}" target="_blank">Печать</a>
                </td>

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
