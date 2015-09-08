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
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="manager.messages"/>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title><fmt:message key="cabinet.title"/></title>
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
                <div><fmt:message key="myorders"/>:</div>
                <div></div>
            </div>

            <c:forEach var="item" items="${trueOrderList}">
                <div id="flight">
                    <div id="flightHeader"></div>
                    <div>
                        <div class="box">
                            <div><fmt:message key="orderid"/>:</div>
                            <div id="values">${item.id}</div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="flightid"/>:</div>
                            <div id="values">${item.flightsId}</div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="airplane"/>:</div>
                            <div id="values"><mytag:vendorbyflight flightId="${item.flightsId}"/></div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="flightdate"/>:</div>
                            <div id="values"><mytag:flightDateByFlightId flightId="${item.flightsId}"/></div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="direction"/>:</div>
                            <div id="values"><mytag:direction id="${item.flightsId}"/></div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="priorityboarding"/>:</div>
                            <div id="values"><mytag:onetoyes one="${item.priorityBoard}"/></div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="baggage"/>:</div>
                            <div id="values"><mytag:onetoyes one="${item.laggage}"/></div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="totalcost"/>:</div>
                            <div id="values">${item.orderPrice/100}</div>
                        </div>
                    </div>
                    <div id="flightFooter">
                        <div style="text-align:right">
                            <div id="line">
                                <form name="registerForm" method="POST" action="Controller" id="form">
                                    <input type="hidden" name="command" value="deleteorder"/>
                                    <input type="hidden" name="orderId" value="${item.id}"/>
                                    <input name="submit" type="submit" value="<fmt:message key="cancelorder"/>" id="link"/>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div align="center" id="centre">
            <div style="margin-bottom: 30px; margin-top: 10px; text-align: center; font-family: Tahoma; font-size: 13px;">
                <div><fmt:message key="upcomingflights"/>:</div>
                <div></div>
            </div>
            <c:forEach var="item" items="${nearTrueOrderList}">
                <div id="flight">
                    <div id="flightHeader"></div>
                    <div>
                        <div class="box">
                            <div><fmt:message key="orderid"/>:</div>
                            <div id="values">${item.id}</div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="flightid"/>:</div>
                            <div id="values">${item.flightsId}</div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="airplane"/>:</div>
                            <div id="values"><mytag:vendorbyflight flightId="${item.flightsId}"/></div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="flightdate"/>:</div>
                            <div id="values"><mytag:flightDateByFlightId flightId="${item.flightsId}"/></div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="direction"/>:</div>
                            <div id="values"><mytag:direction id="${item.flightsId}"/></div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="priorityboarding"/>:</div>
                            <div id="values"><mytag:onetoyes one="${item.priorityBoard}"/></div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="baggage"/>:</div>
                            <div id="values"><mytag:onetoyes one="${item.laggage}"/></div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="totalcost"/>:</div>
                            <div id="values">${item.orderPrice/100}</div>
                        </div>
                    </div>
                    <div id="flightFooter">
                        <div style="text-align:right">
                            <div id="line">
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div align="center" id="centre">
            <div style="margin-bottom: 30px; margin-top: 10px; text-align: center; font-family: Tahoma; font-size: 13px;">
                <div><fmt:message key="mypastorders"/>:</div>
                <div></div>
            </div>

            <c:forEach var="item" items="${falseOrderList}">
                <div id="flight">
                    <div id="flightHeader"></div>
                    <div>
                        <div class="box">
                            <div><fmt:message key="orderid"/>:</div>
                            <div id="values">${item.id}</div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="flightid"/>:</div>
                            <div id="values">${item.flightsId}</div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="airplane"/>:</div>
                            <div id="values"><mytag:vendorbyflight flightId="${item.flightsId}"/></div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="flightdate"/>:</div>
                            <div id="values"><mytag:flightDateByFlightId flightId="${item.flightsId}"/></div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="direction"/>:</div>
                            <div id="values"><mytag:direction id="${item.flightsId}"/></div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="priorityboarding"/>:</div>
                            <div id="values"><mytag:onetoyes one="${item.priorityBoard}"/></div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="baggage"/>:</div>
                            <div id="values"><mytag:onetoyes one="${item.laggage}"/></div>
                        </div>
                        <div class="box">
                            <div><fmt:message key="totalcost"/>:</div>
                            <div id="values">${item.orderPrice/100}</div>
                        </div>
                    </div>
                    <div id="flightFooter">
                        <div style="text-align:right">
                            <div id="line">
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</div>
<div id="footer">
    <div id="realfooter"> BroAirlines. <mytag:ver/> By Dennis Kryachko. 2015. &#60;trainee&#62;</div>
</div>
</body>
</html>
