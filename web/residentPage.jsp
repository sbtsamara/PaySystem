<%@ page import="ru.home.utils.DbHelper" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ru.home.dao.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 20.06.16
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<html>
<head>
    <title>Resident Page</title>
    <link rel="stylesheet" href="css/table.css">

</head>
<body>
    <%
        User user = (User) session.getAttribute("user");
        Address address = user.getAddressesByAddressId();
        pageContext.setAttribute("abonents",address.getAbonentsByAddressId(),PageContext.PAGE_SCOPE);

    %>
    <p>Здравствуйте, <%=user.getUserId()%>!</p>

    <div>
        <form class="change" action="changePassword.jsp"  method="post">
            <input class="submit" type="submit" name="change_password" value="Сменить пароль"/>
        </form>
        <form class="exit" action="index.jsp" method="post">
            <input class="submit" type="submit" name="exit" value="Выйти"/>
        </form>
    </div>

        <h2>Договоры по адресу ул. <%=address.getStreet()%> д. <%=address.getHouse()%> кв. <%=address.getApartment()%></h2>
            <table>
                <tr>
                    <th>Номер договора</th>
                    <th>Лицевой счёт</th>

                </tr>
            </table>
        <c:forEach items="${abonents}" var="abonent" varStatus="status">

            <table>
                <tr>
                    <td>${abonent.abonentId}</td>
                    <td>
                        <a href="${pageContext.servletContext.contextPath}/charges.jsp?serviceId=${abonent.serviceId}&abonentId=${abonent.abonentId}">${abonent.abonentAccount}</a>
                    </td>
                </tr>
            </table>
        </c:forEach>
</body>
</html>
