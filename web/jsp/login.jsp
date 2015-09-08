    <%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 25.05.2015
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <fmt:setBundle basename="manager.messages" />
    <title><fmt:message key="Login.title"/></title>
</head>
<body>
<div style="padding-top: 100px">
    <h3 id="title"><fmt:message key="Login.head"/></h3>
</div>
<div>
    <div align="center" id="centre">

        <form name="loginForm" method="POST" action="Controller">
            <input type="hidden" name="command" value="login" />
            <fmt:message key="Login.email"/>:<br/>
            <input type="text" name="email" value="" size="32" maxlength="32" required autocomplete="off"><br/>
            <fmt:message key="Login.password"/>:<br/>
            <input type="password" name="passwd" value="" size="32" maxlength="32" required autocomplete="off"><br/>
            <input type="submit" value=<fmt:message key="Login.enter"/> id="link">
        </form>

        <form name="loginForm" method="POST" action="Controller">

            <input type="hidden" name="command" value="gotoregister"/>
            <input type="submit" value="<fmt:message key="Login.newUser"/>" id="link">

        </form>
    </div>
</div>

</body>
</html>