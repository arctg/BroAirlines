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
                <div>Direction: ${requestScope.fromcity.getcName()} - ${requestScope.tocity.getcName()}</div>
                <div>Date: ${requestScope.begindate} - ${requestScope.enddate}</div>
            </div>

            <c:forEach var="item" items="${flightList}">
                <div id="flight">
                    <div id="flightHeader"></div>
                    <div>
                        <div class="box">
                            <div>Flight id:</div>
                            <div id="values">${item.id}</div>
                        </div>
                        <div class="box">
                            <div>Free places:</div>
                            <div id="values"><mytag:free freePlaces="${item.id}"/></div>
                        </div>
                        <div class="box">
                            <div>Airplane:</div>
                            <div id="values"><mytag:vendor vendorName="${item.airplanesId}"/></div>
                        </div>
                        <div class="box">
                            <div>Price:</div>
                            <div id="values">${item.price/100} + <mytag:price addPrice="${item}"/></div>
                        </div>
                        <div class="box">
                            <div>Flight date:</div>
                            <div id="values">${item.flightDate}</div>
                        </div>
                    </div>
                    <div id="flightFooter">
                        <div style="text-align:right">
                            <div class="box">
                                <form name="registerForm" method="POST" action="Controller" id="form">
                                    <div><input type="checkbox" name="baggage" value="true">Baggage</div>
                                    <div><input type="checkbox" name="priboarding" value="true">Priority boarding</div>
                            </div>
                            <div id="line">
                                <input type="hidden" name="command" value="gotobook"/>
                                <input type="hidden" name="flightId" value=${item.id} />
                                <input type="hidden" name="from" value="${requestScope.fromcity.getcName()}"/>
                                <input type="hidden" name="to" value="${requestScope.tocity.getcName()}"/>
                                <input name="submit" type="submit" value="Order" id="link"/>
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
    <div id="realfooter"> BroAirlines. By Dennis Kryachko. 2015. EPAM</div>
</div>
</body>
</html>
