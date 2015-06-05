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
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script language="JavaScript" src="js/calendar/tcal.js"></script>
    <link rel="stylesheet" href="js/calendar/tcal.css">
    <title>Result</title>
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
                        <div>Flight id:</div>
                        <div id="values">${item.id}</div>
                    </div>
                    <div class="box">
                        <div>Direction:</div>
                        <div id="values">${from} - ${to}</div>
                    </div>
                    <div class="box">
                        <div>Flight date:</div>
                        <div id="values">${item.flightDate}</div>
                    </div>
                    <div class="box">
                        <div>Place:</div>
                        <div id="values"><mytag:free freePlaces="${item.id}"/></div>
                    </div>
                    <div class="box">
                        <div>Airplane:</div>
                        <div id="values"><mytag:vendor vendorName="${item.airplanesId}"/></div>
                    </div>
                    <div class="box">
                        <div>Additional services:</div>
                        <div id="values">${priboarding/100} + ${baggage/100}</div>
                    </div>
                    <div class="box">
                        <div>Price:</div>
                        <div id="values">${item.price/100} + ${newprice/100}</div>
                    </div>
                    <div class="box">
                        <div>Total cost:</div>
                        <div id="values">${total/100}</div>
                    </div>

                </div>
                <div id="flightFooter">
                    <div style="text-align:right">
                        <div id="line">
                            <form name="registerForm" method="POST" action="Controller" id="form">
                                <input type="hidden" name="command" value="pay"/>
                                <input type="hidden" name="flight" value="${item}"/>
                                <input name="submit" type="submit" value="Pay" id="link"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<div id="footer">
    <div id="realfooter"> BroAirlines. By Dennis Kryachko. 2015. EPAM</div>
</div>
</body>
</html>
