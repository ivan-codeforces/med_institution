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


    <table class="tg">
        <tr>
            <th>ID</th>
            <th>Number os case</th>
            <th>Status</th>
        </tr>
        <tr>
            <td>${medCase.id}</td>
            <td>${medCase.numberOfCase}</td>
            <td>${medCase.status}</td>
        </tr>
    </table>

</div>
</body>
</html>