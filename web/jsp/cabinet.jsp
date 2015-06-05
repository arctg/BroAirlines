<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 28.05.2015
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="/jstl/mytags.tld" prefix="mytag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Cabinet</title>
</head>
<body>
<div id="header">
    <div id="hello">Hello, <mytag:hello email="${sessionScope.client.getEmail()}"/></div>
    <h3 id="title">BroAirlines</h3>
    <div id="realheader">
        <div id="line">
            <form name="registerForm" method="POST" action="Controller" id="form">
                <input type="hidden" name="command" value="logout" s/>
                <input name="submit" type="submit" value="Logout" id="link"/>
            </form>
        </div>
        <div id="line">
            <form name="registerForm" method="POST" action="Controller" id="form">
                <input type="hidden" name="command" value="gotocabinet"/>
                <input type="submit" value="Cabinet" id="link">
            </form>
        </div>
        <div id="line">
            <form name="registerForm" method="POST" action="Controller" id="form">
                <input type="hidden" name="command" value="gotomain"/>
                <input name="submit" type="submit" value="Main" id="link"/>
            </form>
        </div>
        <mytag:adminButton admin="${sessionScope.client.admin}"/>
    </div>
</div>
<div id="content">
    <div id="content1"></div>
</div>
<div id="footer">
    <div id="realfooter"> BroAirlines. By Dennis Kryachko. 2015. EPAM</div>
</div>
</body>
</html>
