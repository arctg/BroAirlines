<%--
  Created by IntelliJ IDEA.
  User: dennis
  Date: 25.05.2015
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setBundle basename="manager.messages"/>
<html>
<head>
    <title><fmt:message key="error.title"/></title>
</head>
<body>
<h3>${error}</h3>
</body>
</html>
