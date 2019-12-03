<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>${patient.firstName} ${patient.lastName}</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

</head>
<body>

<jsp:include page="../pages/fragments/bodyHeader.jsp"/>

<div class="container">
    <ul class="nav nav-tabs" role="tablist">
        <li class="nav-item">
            <a class="nav-link" href="#personalData" role="tab" data-toggle="tab">Personal Data</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="#cases" role="tab" data-toggle="tab">Cases</a>
        </li>
    </ul>
</div>

<div class="container">
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane" id="personalData">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Date of Birth</th>
                    <th scope="col">Phone</th>
                    <th scope="col">SSN</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tr>
                    <td>${patient.id}</td>
                    <td>${patient.firstName} ${patient.lastName}</td>
                    <td>${patient.dateOfBirth}</td>
                    <td>${patient.phone}</td>
                    <td>${patient.ssn}</td>
                    <td><a href="<c:url value='/remove/${patient.id}'/>">Delete</a></td>
                </tr>
            </table>
        </div>

        <div role="tabpanel" class="tab-pane" id="cases">
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
                <c:if test="${!empty listCasesByPatientId}">
                    <c:forEach items="${listCasesByPatientId}" var="medCase">
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
        </div>
    </div>
</div>

</body>
</html>