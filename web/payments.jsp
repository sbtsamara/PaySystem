<%@ page import="ru.home.dao.Service" %>
<%@ page import="ru.home.utils.DbHelper" %><%--
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
</head>
<body>
    <% Service service= DbHelper.getEm().find(Service.class,Integer.parseInt(request.getParameter("serviceId")));%>
    <%=service.getServiceName()%>



</body>
</html>
