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
            <th scope="col">Patient</th>
            <th scope="col">Status</th>
            <th scope="col">User</th>
            <th scope="col">Edit</th>
            <th scope="col">Delete</th>
        </tr>
        </thead>

        <c:if test="${!empty listCases}">

            <c:forEach items="${listCases}" var="medCase">
                <tr>
                    <td><a href="/caseData/${medCase.id}">${medCase.id}</a></td>
                    <td>
                        <a href="/patientData/${medCase.ownerP.id}">${medCase.ownerP.firstName} ${medCase.ownerP.lastName}</a>
                    </td>
                    <td>${medCase.status}</td>
                    <td><a href="/userData/${medCase.ownerU.id}">${medCase.ownerU.username}</a></td>
                    <td><a href="<c:url value='/editCase/${medCase.id}'/>">Edit</a></td>
                    <td><a href="<c:url value='/remove/${medCase.id}'/>">Delete</a></td>
                </tr>
            </c:forEach>

        </c:if>
    </table>

    <div id="pagination">
        <c:url value="/medCases" var="prev">
            <c:param name="page" value="${page-1}"/>
        </c:url>
        <c:if test="${page > 1}">
        <a href="<c:out value="${prev}" />" class="pn prev">Prev</a>
        </c:if>
        <c:forEach begin="1" end="${maxPages}" step="1" varStatus="i">
        <c:choose>
        <c:when test="${page == i.index}">
        <span>${i.index}</span>
        </c:when>
        <c:otherwise>
        <c:url value="/medCases" var="url">
            <c:param name="page" value="${i.index}"/>
        </c:url>
        <a href='<c:out value="${url}" />'>${i.index}</a>
        </c:otherwise>
        </c:choose>
        </c:forEach>
        <c:url value="/medCases" var="next">
            <c:param name="page" value="${page + 1}"/>
        </c:url>
        <c:if test="${page + 1 <= maxPages}">
        <a href='<c:out value="${next}" />' class="pn next">Next</a>
        </c:if>

<%--    <c:url var="addAction" value="/medCase/add"/>--%>

<%--    <form:form action="${addAction}" modelAttribute="medCase">--%>

<%--        <table>--%>
<%--            <tr>--%>
<%--                <td>--%>
<%--                    <form:label path="numberOfCase">--%>
<%--                        <spring:message text="Number of Case"/>--%>
<%--                    </form:label>--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                    <form:input path="numberOfCase"/>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--            <tr>--%>
<%--                <td>--%>
<%--                    <form:label path="status">--%>
<%--                        <spring:message text="Status"/>--%>
<%--                    </form:label>--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                    <form:input path="status"/>--%>
<%--                </td>--%>
<%--            </tr>--%>

<%--            <tr>--%>
<%--                <td colspan="2">--%>
<%--                    <c:if test="${!empty medCase.numberOfCase}">--%>
<%--                        <input type="submit"--%>
<%--                               value="<spring:message text="Edit Case"/>"/>--%>
<%--                    </c:if>--%>
<%--                    <c:if test="${empty medCase.numberOfCase}">--%>
<%--                        <input type="submit"--%>
<%--                               value="<spring:message text="Add Case"/>"/>--%>
<%--                    </c:if>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </table>--%>
<%--    </form:form>--%>
<%--</div>--%>

</body>
</html>