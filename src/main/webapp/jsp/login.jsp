<%--
  Created by IntelliJ IDEA.
  User: dnsbo
  Date: 08.09.2022
  Time: 17:11
  To change this template use File | Settings | File Templates.
--%>
<%--
  Created by IntelliJ IDEA.
  User: dnsbo
  Date: 08.09.2022
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Клуб Спортивных Судей</title>
    <link href="${pageContext.request.contextPath}/css/styleLogin.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="wrapper exmp2"></div>
<div class="login">
    <div class="login-screen">
        <div class="app-title">
            <h3>Клуб Спортивных Судей</h3>
        </div>
        <div class="login-form">
            <form method="get" action="home">
                <div class="control-group">
                    <label class="login-field-icon fui-user" for="LoginSecondName">
                        <input type="text" class="login-field" value="" placeholder="Фамилия" name="LoginSecondName"
                               id="LoginSecondName">
                    </label>
                </div>
                <div class="control-group">
                    <label class="login-field-icon fui-user" for="LoginName">
                        <input type="text" class="login-field" value="" placeholder="Имя" name="LoginName"
                               id="LoginName">
                    </label>
                </div>

                <div class="control-group">
                    <label class="login-field-icon fui-lock" for="LoginPassword">
                        <input type="password" class="login-field" value="" placeholder="Пароль" name="LoginPassword"
                               id="LoginPassword">
                    </label>
                </div>
                <input class="btn btn-primary btn-large btn-block" type="submit" value="Войти">
                <%--<a class="btn btn-primary btn-large btn-block" href="login">Войти</a>--%>
            </form>
        </div>
        <div class="login-form">
            <form method="post" action="login">
                <div class="control-group">
                    <input class="btn btn-primary btn-large btn-block" type="submit" value="Зарегистрироваться">
                    <%--<a class="login-link" href="login">Зарегистрироваться</a>--%>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>