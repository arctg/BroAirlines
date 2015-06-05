<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 24.05.2015
  Time: 18:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/jstl/mytags.tld" prefix="mytag" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script language="JavaScript" src="js/calendar/tcal.js"></script>
    <link rel="stylesheet" href="js/calendar/tcal.css">
    <title>Find flight</title>
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
    <div id="content1">
        <div align="center" id="centre">
            <form name="findflight" method="POST" action="Controller">
                <input type="hidden" name="command" value="findflight"/>
                From<br/>
                <select name="fromcity" id="input">
                    <c:forEach var="item" items="${city}">
                        <option value="${item.id}" ${item.getcName() == selectedDept ? 'selected="selected"' : ''}>${item.getcName()}</option>
                    </c:forEach>
                </select><br/>
                Begin date<br/>
                <input name="begindate" class="tcal" style="border: dotted 1px; border-radius: 3px" value="" size="16"
                       maxlength="16" required><br/>
                End date<br/>
                <input name="enddate" class="tcal" style="border: dotted 1px; border-radius: 3px" value="" size="16"
                       maxlength="16" required><br/>
                To<br/>
                <select name="tocity" id="input">
                    <c:forEach var="item" items="${city}">
                        <option value="${item.id}" ${item.getcName() == selectedDept ? 'selected="selected"' : ''}>${item.getcName()}</option>
                    </c:forEach>
                </select><br/>
                <input type="submit" value="Find flight" id="link">
            </form>
        </div>
    </div>
</div>
<div id="footer">
    <div id="realfooter"> BroAirlines. By Dennis Kryachko. 2015. EPAM</div>
</div>
</body>
</html>
