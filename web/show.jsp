<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 17.06.16
  Time: 1:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    ITEM: <%= request.getSession().getAttribute("item")%>
</body>
</html>
