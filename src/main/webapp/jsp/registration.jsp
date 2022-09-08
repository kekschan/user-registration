<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Клуб Спортивных Судей</title>
    <link href="${pageContext.request.contextPath}/css/styleRegistration.css" rel="stylesheet" type="text/css">

</head>
<body>
<div class="wrapper exmp2"></div>
<div class="login">
    <div class="login-screen">
        <div class="app-title">
            <h3>Регистрация</h3>
        </div>
        <div class="login-form">
            <form method="post" action="registration">
                <div class="control-group">
                    <input type="text" class="login-field" value="" placeholder="Введите вашу фамилию"
                           id="secondNameRegistration" name="secondNameRegistration">
                    <label class="login-field-icon fui-user" for="secondNameRegistration"></label>
                </div>

                <div class="control-group">
                    <input type="text" class="login-field" value="" placeholder="Введите ваше имя" id="nameRegistration"
                           name="nameRegistration">
                    <label class="login-field-icon fui-user" for="nameRegistration"></label>
                </div>

                <div class="control-group">
                    <input type="text" class="login-field" value="" placeholder="Ваша почта" id="emailRegistration"
                           name="emailRegistration">
                    <label class="login-field-icon fui-user" for="emailRegistration"></label>
                </div>

                <div class="control-group">
                    <input type="password" class="login-field" value="" placeholder="Придумайте пароль"
                           id="passwordRegistration" name="passwordRegistration">
                    <label class="login-field-icon fui-lock" for="passwordRegistration"></label>
                </div>
                <input class="btn btn-primary btn-large btn-block" type="submit" value="Зарегистрироваться">
            </form>
        </div>
    </div>
</div>
</body>
</html>