<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>


<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewpoint" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Main Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
    <%--    <!--    <%&#45;&#45;    <link rel="stylesheet" href="WEB-INF/css/main.css"/>&#45;&#45;%>-->--%>
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light stikcy-top">
    <a class="navbar-brand" href="../../index.jsp">Main</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="conteiner-fluid">
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="<c:url value="/medCases"/>">Cases<span
                            class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Features</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Pricing</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<table class="table table-hover" >
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Number of Case</th>
        <th scope="col">Status</th>
        <th scope="col">Edit</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>

    <c:if test="${!empty listCases}">
        <tbody>
        <c:forEach items="${listCases}" var="medCase">
            <tr>
                <td>${medCase.id}</td>
                <td><a href="/casedata/${medCase.numberOfCase}" target="_blank">${medCase.numberOfCase}</a></td>
                <td>${medCase.status}</td>
                <td><a href="<c:url value='/edit/${medCase.id}'/>">Edit</a></td>
                <td><a href="<c:url value='/remove/${medCase.id}'/>">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </c:if>
</table>


<h1>Add a Case</h1>

<c:url var="addAction" value="/medCase/add"/>

<form:form action="${addAction}" modelAttribute="medCase">
<form:form action="${addAction}" commandName="medCase">
    <table>
        <c:if test="${!empty medCase.numberOfCase}">
            <tr>
                <td>
                    <form:label path="id">
                        <spring:message text="ID"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="id" readonly="true" size="8" disabled="true"/>
                    <form:hidden path="id"/>
                </td>
            </tr>
        </c:if>
        <tr>
            <td>
                <form:label path="numberOfCase">
                    <spring:message text="Number of Case"/>
                </form:label>
            </td>
            <td>
                <form:input path="numberOfCase"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="status">
                    <spring:message text="Status"/>
                </form:label>
            </td>
            <td>
                <form:input path="status"/>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <c:if test="${!empty medCase.numberOfCase}">
                    <input type="submit"
                           value="<spring:message text="Edit Case"/>"/>
                </c:if>
                <c:if test="${empty medCase.numberOfCase}">
                    <input type="submit"
                           value="<spring:message text="Add Case"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</form:form>


</body>
</html>








<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>--%>
<%--<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>--%>
<%--<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@ page session="false" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>Cases</title>--%>

<%--</head>--%>
<%--<body>--%>
<%--<a href="../../index.jsp">Main menu</a>--%>

<%--<br/>--%>
<%--<br/>--%>

<%--<h1>Case List</h1>--%>

<%--<c:if test="${!empty listCases}">--%>
<%--    <table class="tg">--%>
<%--        <tr>--%>
<%--            <th width="80">ID</th>--%>
<%--            <th width="120">Number of Case</th>--%>
<%--            <th width="120">Status</th>--%>
<%--            <th width="60">Edit</th>--%>
<%--            <th width="60">Delete</th>--%>
<%--        </tr>--%>
<%--        <c:forEach items="${listCases}" var="medCase">--%>
<%--            <tr>--%>
<%--                <td>${medCase.id}</td>--%>
<%--                <td><a href="/casedata/${medCase.numberOfCase}" target="_blank">${medCase.numberOfCase}</a></td>--%>
<%--                <td>${medCase.status}</td>--%>
<%--                <td><a href="<c:url value='/edit/${medCase.id}'/>">Edit</a></td>--%>
<%--                <td><a href="<c:url value='/remove/${medCase.id}'/>">Delete</a></td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--</c:if>--%>


<%--<h1>Add a Case</h1>--%>

<%--<c:url var="addAction" value="/medCase/add"/>--%>

<%--<form:form action="${addAction}" modelAttribute="medCase">--%>
<%--&lt;%&ndash;<form:form action="${addAction}" commandName="medCase">&ndash;%&gt;--%>
<%--    <table>--%>
<%--        <c:if test="${!empty medCase.numberOfCase}">--%>
<%--            <tr>--%>
<%--                <td>--%>
<%--                    <form:label path="id">--%>
<%--                        <spring:message text="ID"/>--%>
<%--                    </form:label>--%>
<%--                </td>--%>
<%--                <td>--%>
<%--                    <form:input path="id" readonly="true" size="8" disabled="true"/>--%>
<%--                    <form:hidden path="id"/>--%>
<%--                </td>--%>
<%--            </tr>--%>
<%--        </c:if>--%>
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
<%--</body>--%>
<%--</html>--%>
