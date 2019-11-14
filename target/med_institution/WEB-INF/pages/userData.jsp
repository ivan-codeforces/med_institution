<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>${user.username}</title>
</head>
<body>

<jsp:include page="../pages/fragments/bodyHeader.jsp"/>
<div class="container">
    <h1>${user.username}</h1>

    <table class="tg">
        <tr>
            <th>ID</th>
            <th>User name</th>
        </tr>
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
        </tr>
    </table>

<%--    <c:forEach items="${listCases}" var="medCase">--%>
<%--    --%>
<%--    </c:forEach>--%>

</div>
</body>
</html>