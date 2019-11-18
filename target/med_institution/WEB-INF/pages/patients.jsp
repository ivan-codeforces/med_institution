<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Patients</title>
</head>

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>

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
                    <th scope="col">Edit</th>
                </tr>
                </thead>

                <c:if test="${!empty listPatients}">
                    <c:forEach items="${listPatients}" var="patient">
                        <tr>
                            <td>${patient.id}</td>
                            <td><a href="/patientData/${patient.id}">${patient.firstName} ${patient.lastName}</a></td>
                            <td>${patient.address}</td>
                            <td>${patient.phone}</td>
                            <td>${patient.ssn}</td>
                            <td><a href="<c:url value='/patients/${patient.id}'/>">Edit</a></td>
                        </tr>
                    </c:forEach>
                </c:if>
            </table>
        </div>
        <div class="col-md-3 mb-3 px-4 py-4">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">New Patient
            </button>

            <!-- Modal -->
            <c:url var="addPatient" value="/patients"/>
            <form:form action="${addPatient}" modelAttribute="patient">
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
                 aria-labelledby="exampleModalLabel"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Add new Patient</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <div class="form-row">
                                <div class="col-md-6 mb-3">
                                    <form:label path="firstName">First name</form:label>
                                    <form:input path="firstName" type="text" class="form-control"
                                                id="validationServer01"
                                                placeholder="First name"/>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <form:label path="lastName">Last name</form:label>
                                    <form:input path="lastName" type="text" class="form-control"
                                                id="validationServer02"
                                                placeholder="Last name"/>
                                </div>
                            </div>
                            <div class="form-row">
                                <div class="col-md-6 mb-3">
                                    <form:label path="passport">Passport</form:label>
                                    <form:input path="passport" type="text" class="form-control"
                                                id="validationServer03"
                                                placeholder="Passport"/>
                                </div>
                                <div class="form-row">
                                    <div class="col-md-6 mb-3">
                                        <form:label path="phone">Phone</form:label>
                                        <form:input path="phone" type="text" class="form-control"
                                                    id="validationServer05"
                                                    placeholder="Phone"/>
                                    </div>
                                    <div class="col-md-6 mb-3">
                                        <form:label path="email">E-Mail</form:label>
                                        <form:input path="email" type="text" class="form-control"
                                                    id="validationServer06"
                                                    placeholder="E-Mail"/>
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <form:label path="address">Address</form:label>
                                    <form:input path="address" type="text" class="form-control" id="validationServer07"
                                                placeholder="Address"/>
                                </div>
                                <div class="mb-3">
                                    <form:label path="ssn">Social security number</form:label>
                                    <form:input path="ssn" type="text" class="form-control" id="validationServer08"
                                                placeholder="Social security number"/>
                                </div>
                            </div>
                            <div class="modal-footer">

                                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                                <button type="submit" value="<spring:message text="Add Patient"/>" class="btn btn-primary">Add</button>
                            </div>
                        </div>
                    </div>
                </div>
                </form:form>
            </div>
        </div>
    </div>

</div>
</body>
</html>
