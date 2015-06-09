<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 24.05.2015
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <fmt:setBundle basename="manager.messages"/>
    <title><fmt:message key="Register.title"/></title>
</head>
<div style="padding-top: 100px">
    <h3 id="title"><fmt:message key="Register.head"/></h3>
</div>
</hr id="line">
<div>
    <div align="center" id="centre">
        <form name="registerForm" method="POST" action="Controller">
            <input type="hidden" name="command" value="register"/>
            <fmt:message key="Register.firstName"/>:<br/>
            <input type="text" name="fname" value="" size="32" maxlength="32" required autocomplete="off"> <br/>
            <fmt:message key="Register.lastName"/>:<br/>
            <input type="text" id="one" name="lname" value="" size="32" maxlength="32" required autocomplete="off"><br/>
            <fmt:message key="Register.email"/>:<br/>
            <input type="text" id="two" name="newemail" value="" size="32" maxlength="32" required autocomplete="off"><br/>
            <fmt:message key="Register.password"/><br/>
            <input type="password" name="newpasswd" value="" size="32" maxlength="32" required autocomplete="off"><br/>
            <td><fmt:message key="Register.phone"/>:<br/><fmt:message key="Register.example"/><br/></td>
            <input type="text" name="phone" value="" size="12" maxlength="12" required autocomplete="off"><br/>
            <input type="submit" value="<fmt:message key="Register.register"/>" id="link">
        </form>
        <form name="registerForm" method="POST" action="Controller">
            <input type="hidden" name="command" value="gotologin"/>
            <input type="submit" value="<fmt:message key="Register.login"/>" id="link">
        </form>
    </div>
</div>
</body>
</html>