<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>

<html>
<head>
    <title>Main Page</title>
</head>

<body>
<jsp:include page="../pages/fragments/bodyHeader.jsp"/>

<div class="container">

    <ul class="nav nav-tabs">
        <li class="nav-item">
            <a class="nav-link active" href="#table-cases">Cases</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#">New case</a>
        </li>
    </ul>

<table class="table table-hover" id="table-cases">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Number of Case</th>
        <th scope="col">Status</th>
        <th scope="col">User</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>

    <c:if test="${!empty listCases}">

        <c:forEach items="${listCases}" var="medCase">
            <tr>
                <td>${medCase.id}</td>
                <td><a href="/caseData/${medCase.id}">${medCase.numberOfCase}</a></td>
                <td>${medCase.status}</td>
                <td><a href="/userData/${medCase.ownerU.id}">${medCase.ownerU.username}</a></td>
                <td><a href="<c:url value='/editCase/${medCase.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${medCase.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>

    </c:if>
</table>



    <form>
        <div class="form-group row">
            <label for="staticEmail" class="col-sm-2 col-form-label">Email</label>
            <div class="col-sm-10">
                <input type="text" readonly class="form-control-plaintext" id="staticEmail" value="email@example.com">
            </div>
        </div>
        <div class="form-group row">
            <label for="inputPassword" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword" placeholder="Password">
            </div>
        </div>
    </form>



<%--<c:url var="addAction" value="/medCase/add"/>--%>

<%--<form:form action="${addAction}" modelAttribute="medCase">--%>

<%--    <table>--%>
<%--        <tr>--%>
<%--            <td>--%>
<%--                <form:label path="numberOfCase">--%>
<%--                    <spring:message text="Number of Case"/>--%>
<%--                </form:label>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <form:input path="numberOfCase"/>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>--%>
<%--                <form:label path="status">--%>
<%--                    <spring:message text="Status"/>--%>
<%--                </form:label>--%>
<%--            </td>--%>
<%--            <td>--%>
<%--                <form:input path="status"/>--%>
<%--            </td>--%>
<%--        </tr>--%>

<%--        <tr>--%>
<%--            <td colspan="2">--%>
<%--                <c:if test="${!empty medCase.numberOfCase}">--%>
<%--                    <input type="submit"--%>
<%--                           value="<spring:message text="Edit Case"/>"/>--%>
<%--                </c:if>--%>
<%--                <c:if test="${empty medCase.numberOfCase}">--%>
<%--                    <input type="submit"--%>
<%--                           value="<spring:message text="Add Case"/>"/>--%>
<%--                </c:if>--%>
<%--            </td>--%>
<%--        </tr>--%>
<%--    </table>--%>
<%--</form:form>--%>
</div>

</body>
</html>