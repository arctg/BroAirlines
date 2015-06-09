<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 26.05.2015
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/jstl/mytags.tld" prefix="mytag" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="manager.messages"/>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script language="JavaScript" src="js/calendar/tcal.js"></script>
    <link rel="stylesheet" href="js/calendar/tcal.css">
    <script type="text/javascript">
        function noBack(){window.history.forward();}
        noBack();
        window.onload=noBack;
        window.onpageshow=function(evt){if(evt.persisted)noBack();}
        window.onunload=function(){void(0);}
    </script>
    <title><fmt:message key="adminpanel.title"/></title>
</head>
<body>
<div id="header">
    <div id="hello"><fmt:message key="hello"/>, <mytag:hello email="${sessionScope.client.getEmail()}"/></div>
    <div id="hello"><fmt:message key="todayis"/>: <mytag:todayis/></div>
    <h3 id="title">BroAirlines</h3>

    <div id="realheader">
        <div id="line">
            <form name="registerForm" method="POST" action="Controller" id="form">
                <input type="hidden" name="command" value="logout" s/>
                <input name="submit" type="submit" value="<fmt:message key="Logout"/>" id="link"/>
            </form>
        </div>
        <div id="line">
            <form name="registerForm" method="POST" action="Controller" id="form">
                <input type="hidden" name="command" value="gotocabinet"/>
                <input type="submit" value="<fmt:message key="Cabinet"/>" id="link">
            </form>
        </div>
        <div id="line">
            <form name="registerForm" method="POST" action="Controller" id="form">
                <input type="hidden" name="command" value="gotomain"/>
                <input name="submit" type="submit" value="<fmt:message key="Main"/>" id="link"/>
            </form>
        </div>
        <div id="line">
            <form name="registerForm" method="POST" action="Controller" id="form">
                <input type="hidden" name="command" value="gotoadminpanel" s/>
                <input name="submit" type="submit" value="<fmt:message key="AdminPanel"/>" id="link"/>
            </form>
        </div>
    </div>
</div>
<div id="content">
    <div id="content1">
        <div align="center" id="centre">
            <form name="addflight" method="POST" action="Controller">
                <input type="hidden" name="command" value="addflight"/>
                <fmt:message key="adminpanel.vendornameseats"/><br/>
                <select name="airplane" id="input">
                <c:forEach var="item" items="${airplane}">
                    <option  value="${item.id}" ${item.vendorName == selectedDept ? 'selected="selected"' : ''}>${item.vendorName}: ${item.numOfSeats}</option>
                </c:forEach>
                </select><br/>
                <fmt:message key="adminpanel.from"/><br/>
                <select name="fromcity" id="input">
                    <c:forEach var="item" items="${city}">
                        <option  value="${item.id}" ${item.getcName() == selectedDept ? 'selected="selected"' : ''}>${item.getcName()}</option>
                    </c:forEach>
                </select><br/>
                <fmt:message key="adminpanel.date"/><br/>
                <input  name="date" class="tcal" style="border: dotted 1px; border-radius: 3px"  value="" size="16" maxlength="16" required ><br/>
                <fmt:message key="adminpanel.to"/><br/>
                <select name="tocity" id="input">
                    <c:forEach var="item" items="${city}">
                        <option value="${item.id    }" ${item.getcName() == selectedDept ? 'selected="selected"' : ''}>${item.getcName()}</option>
                    </c:forEach>
                </select><br/>
                <fmt:message key="adminpanel.flightcost"/><br/>
                <input  name="price" id="input" type="number"  step="any" min="0" value="" size="6" maxlength="6" required><br/>
                <input type="submit" value="<fmt:message key="adminpanel.addflight"/>" id="link">
            </form>
        </div>
    </div>
</div>
<div id="footer">
    <div id="realfooter"> BroAirlines. By Dennis Kryachko. 2015. &#60;epam&#62; </div>
</div>

</body>
</html>
