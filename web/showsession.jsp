<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 17.06.16
  Time: 0:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
        String value = (String) session.getAttribute("inputtext");
    %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Session: <%=value%>
</body>
</html>
