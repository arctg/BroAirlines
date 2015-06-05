<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 25.05.2015
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Login</title>
</head>
<body>
<div style="padding-top: 100px">
    <h3 id="title">Login</h3>
</div>
<div>
    <div align="center" id="centre">

        <form name="loginForm" method="POST" action="Controller">
            <input type="hidden" name="command" value="login"/>
            Email:<br/>
            <input type="text" name="email" value="" size="32" maxlength="32" required autocomplete="off"><br/>
            Password:<br/>
            <input type="password" name="passwd" value="" size="32" maxlength="32" required autocomplete="off"><br/>
            <input type="submit" value="Login!" id="link">
        </form>

        <form name="loginForm" method="POST" action="Controller">

            <input type="hidden" name="command" value="gotoregister"/>
            <input type="submit" value="New user" id="link">

        </form>
    </div>
</div>

</body>
</html>