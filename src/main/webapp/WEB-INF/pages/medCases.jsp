<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Cases</title>
</head>

<body>
<jsp:include page="../pages/fragments/bodyHeader.jsp"/>

<div class="container">
    <table class="table table-hover" id="table-cases">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Number of Case</th>
            <th scope="col">Patient</th>
            <th scope="col">Status</th>
            <th scope="col">User</th>

        </tr>
        </thead>

        <c:if test="${!empty listCases}">

            <c:forEach items="${listCases}" var="medCase">
                <tr>
                    <td>${medCase.id}</td>
                    <td><a href="/caseData/${medCase.id}">${medCase.numberOfCase}</a></td>
                    <td>
                        <a href="/patientData/${medCase.ownerP.id}">${medCase.ownerP.firstName} ${medCase.ownerP.lastName}</a>
                    </td>
                    <td>${medCase.status}</td>
                    <td><a href="/userData/${medCase.ownerU.id}">${medCase.ownerU.username}</a></td>
                </tr>
            </c:forEach>

        </c:if>
    </table>
</div>

</body>
</html>