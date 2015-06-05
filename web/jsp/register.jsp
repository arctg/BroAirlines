<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 24.05.2015
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Register</title>
</head>
<div style="padding-top: 100px">
    <h3 id="title">Register</h3>
</div>
</hr id="line">
<div>
    <div align="center" id="centre">
        <form name="registerForm" method="POST" action="Controller">
            <input type="hidden" name="command" value="register"/>
            First name:<br/>
            <input type="text" name="fname" value="" size="32" maxlength="32" required autocomplete="off"> <br/>
            Last name:<br/>
            <input type="text" name="lname" value="" size="32" maxlength="32" required autocomplete="off"><br/>
            Emaila:<br/>
            <input type="text" name="newemail" value="" size="32" maxlength="32" required autocomplete="off"><br/>
            Passworda:<br/>
            <input type="password" name="newpasswd" value="" size="32" maxlength="32" required autocomplete="off"><br/>
            <td>Phone:<br/>(for example: 0501234567)<br/></td>
            <input type="text" name="phone" value="" size="12" maxlength="12" required autocomplete="off"><br/>
            <input type="submit" value="Go!" id="link">
        </form>
        <form name="registerForm" method="POST" action="Controller">
            <input type="hidden" name="command" value="gotologin"/>
            <input type="submit" value="Login to system" id="link">
        </form>
    </div>
</div>
</body>
</html>