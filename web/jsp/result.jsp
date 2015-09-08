<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 02.06.2015
  Time: 17:44
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
    <title><fmt:message key="result.title"/></title>
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
        <c:if test="${sessionScope.client.admin}">
            <div id="line">
                <form name="registerForm" method="POST" action="Controller" id="form">
                    <input type="hidden" name="command" value="gotoadminpanel" s/>
                    <input name="submit" type="submit" value="<fmt:message key="AdminPanel"/>" id="link"/>
                </form>
            </div>
        </c:if>
    </div>
</div>
<div id="content">
    <div id="content1">
        <div align="center" id="centre">
            <div style="margin-bottom: 30px; margin-top: 10px; text-align: center; font-family: Tahoma; font-size: 13px;">
                <div><fmt:message key="direction"/>: ${requestScope.fromcity.getcName()} - ${requestScope.tocity.getcName()}</div>
                <div><fmt:message key="result.date"/>: ${requestScope.begindate} - ${requestScope.enddate}</div>
            </div>

            <c:forEach var="item" items="${flightList}">
                <div id="flight">
                    <div id="flightHeader"></div>
                    <div>
                        <div class="box">
                            <div><fmt:message key="flightid"/>:</div>
                            <div id="values">${item.id}</div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="result.freeplaces"/>:</div>
                            <div id="values"><mytag:free freePlaces="${item.id}"/></div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="airplane"/>:</div>
                            <div id="values"><mytag:vendor vendorName="${item.airplanesId}"/></div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="price"/>:</div>
                            <div id="values">${item.price/100} + <mytag:price addPrice="${item}"/></div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="flightdate"/>:</div>
                            <div id="values">${item.flightDate}</div>
                        </div>
                    </div>
                    <div id="flightFooter">
                        <div style="text-align:right">
                            <div class="box">
                                <form name="registerForm" method="POST" action="Controller" id="form">
                                    <div><input type="checkbox" name="baggage" value="true"><fmt:message key="baggage"/></div>
                                    <div><input type="checkbox" name="priboarding" value="true"><fmt:message key="priorityboarding"/></div>
                            </div>
                            <div id="line">
                                <input type="hidden" name="command" value="gotobook"/>
                                <input type="hidden" name="flightId" value=${item.id} />
                                <input type="hidden" name="from" value="${requestScope.fromcity.getcName()}"/>
                                <input type="hidden" name="to" value="${requestScope.tocity.getcName()}"/>
                                <input name="submit" type="submit" value="<fmt:message key="placeanorder"/>" id="link"/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
</div>
<div id="footer">
    <div id="realfooter"> BroAirlines. <mytag:ver/> By Dennis Kryachko. 2015. &#60;trainee&#62; </div>
</div>
</body>
</html>
