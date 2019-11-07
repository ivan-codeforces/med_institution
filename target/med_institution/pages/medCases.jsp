<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cases</title>
<%--    <link href="<c:url value="/res/style.css"/>" rel="stylesheet" type="text/css"/>--%>
<%--    <link rel="icon" type="image/png" href="<c:url value="/res/favicon.png"/>"/>--%>
</head>
<h2>Cases</h2>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Status</th>
        <th>Number Of Case</th>
    </tr>
    <c:forEach  items="${medCasesList}" var="medCase">
        <tr>
            <td>${medCase.id}</td>
            <td>${medCase.status}</td>
            <td>${medCase.numberOfCase}</td>
        </tr>
    </c:forEach>
</table>
<a href="/">Index</a>
</body>