<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<html>
<head>
    <title>Start page</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="login-page">
    <div class="form">
        <form class="login-form" action="startServlet" method="post">
            <input type="text" name="login" placeholder="username"/>
            <input type="password" name="password" placeholder="password"/>
            <input type="submit" class="button" name="enter" value="Login In" />
            <p class="text">Неверный логин или пароль!!!</p>
        </form>
    </div>
</div>
</body>
</html>