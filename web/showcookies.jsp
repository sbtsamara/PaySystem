<%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 17.06.16
  Time: 0:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <%
        String nameCookie = "login";
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        if (cookies!=null){
            for (Cookie coo :cookies) {
                if (coo.getName().equals(nameCookie)){
                    cookie = coo;
                    break;
                }

            }
        }


    %>
<html>
<head>
    <title>Show cookies</title>
</head>
<body>
    <%if (cookie!=null){%>
        <%=cookie.getValue()%>
    <%}else{ %>
        Cookies not found!!!
    <%}%>

</body>
</html>
