<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>${patient.firstName} ${patient.lastName}</title>

</head>
<body>

<jsp:include page="../pages/fragments/bodyHeader.jsp"/>

<div class="container">
    <div class="form-row">
        <div class="col-md-9 mb-3 py-4">
            <table class="table table-hover ">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">Name</th>
                    <th scope="col">Address</th>
                    <th scope="col">Phone</th>
                    <th scope="col">SSN</th>
                </tr>
                </thead>
                <tr>
                    <td>${patient.id}</td>
                    <td>${patient.firstName} ${patient.lastName}</td>
                    <td>${patient.address}</td>
                    <td>${patient.phone}</td>
                    <td>${patient.ssn}</td>
                </tr>
            </table>
        </div>
        <div class="col-md-3 mb-3 px-4 py-4">

<%--            <c:url var="addCase" value="/medCase/add"/>--%>
<%--            <form action="${addCase}" modelAttribute="patient">--%>
<%--                <button type="submit" class="btn btn-primary">New Case</button>--%>
<%--            </form>--%>
        </div>
    </div>
</div>

</body>
</html>