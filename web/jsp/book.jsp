<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 04.06.2015
  Time: 14:34
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
    <title><fmt:message key="book.title"/></title>
    <script type="text/javascript">
        function noBack(){window.history.forward();}
        noBack();
        window.onload=noBack;
        window.onpageshow=function(evt){if(evt.persisted)noBack();}
        window.onunload=function(){void(0);}
    </script>
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

            </div>

            <c:set var="item" value="${flight}"/>
            <c:set var="newprice" value="${newprice}"/>
            <c:set var="from" value="${from}"/>
            <c:set var="to" value="${to}"/>
            <c:set var="priboarding" value="${priboarding}"/>
            <c:set var="baggage" value="${baggage}"/>
            <c:set var="totalCost" value="${totalCost}"/>

            <div id="flight">
                <div id="flightHeader"></div>
                <div>
                    <div class="box">
                        <div><fmt:message key="flightid"/>:</div>
                        <div id="values">${item.id}</div>
                    </div>
                    <div class="box">
                        <div><fmt:message key="direction"/>:</div>
                        <div id="values">${from} - ${to}</div>
                    </div>
                    <div class="box">
                        <div><fmt:message key="flightdate"/>:</div>
                        <div id="values">${item.flightDate}</div>
                    </div>
                    <div class="box">
                        <div><fmt:message key="place"/>:</div>
                        <div id="values"><mytag:free freePlaces="${item.id}"/></div>
                    </div>
                    <div class="box">
                        <div><fmt:message key="airplane"/>:</div>
                        <div id="values"><mytag:vendor vendorName="${item.airplanesId}"/></div>
                    </div>
                    <div class="box">
                        <div><fmt:message key="additionalservices"/>:</div>
                        <div id="values">${priboarding/100} + ${baggage/100}</div>
                    </div>
                    <div class="box">
                        <div><fmt:message key="price"/>:</div>
                        <div id="values">${item.price/100} + ${newprice/100}</div>
                    </div>
                    <div class="box">
                        <div><fmt:message key="totalcost"/>:</div>
                        <div id="values">${total/100}</div>
                    </div>

                </div>
                <div id="flightFooter">
                    <div style="text-align:right">
                        <div id="line">
                            <form name="registerForm" method="POST" action="Controller" id="form">
                                <input type="hidden" name="command" value="pay"/>
                                <input type="hidden" name="flight" value="${item}"/>
                                <input name="submit" type="submit" value="<fmt:message key="pay"/>" id="link"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<div id="footer">
    <div id="realfooter"> BroAirlines. By Dennis Kryachko. 2015. &#60;epam&#62;</div>
</div>
</body>
</html>
