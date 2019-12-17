<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
        <script src="https://unpkg.com/gijgo@1.9.13/js/gijgo.min.js" type="text/javascript"></script>
        <link href="https://unpkg.com/gijgo@1.9.13/css/gijgo.min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<jsp:include page="../pages/fragments/bodyHeader.jsp"/>
<div class="container">

    <div class="container">
        <div class="row">
            <div class="col">
                <div class="box d-flex flex-column justify-content-between">
                    <div class="item item-1 flex-shrink-0">Patient</div>
                    <br>
                    <div class="item item-2 flex-shrink-0">Age</div>
                    <br>
                    <div class="item item-3 flex-shrink-0">Doctor</div>
                </div>
            </div>
            <div class="col-6">
                <div class="box d-flex flex-column justify-content-between">
                    <div class="item item-1 flex-shrink-0">${medCase.ownerP.firstName} ${medCase.ownerP.lastName}</div>
                    <br>
                    <div class="item item-2 flex-shrink-0">2</div>
                    <br>
                    <div class="item item-3 flex-shrink-0">${medCase.ownerU.username}</div>
                </div>
            </div>
            <div class="col-2">
                <div class="box d-flex flex-column justify-content-between">
                    <div class="item item-1 flex-shrink-0">
                        <mark>${medCase.status}</mark>
                    </div>
                    <br>
                    <c:if test="${medCase.status=='INITIAL'}">
                        <form:form action="${medCase}" modelAttribute="medCase">
                            <button type="submit" value="<spring:message text="accept in work"/>"
                                    class="btn btn-primary">Accept in work
                            </button>
                        </form:form>
                    </c:if>
                    <c:if test="${medCase.status=='IN PROGRESS'}">
                        <form:form action="${medCase}" modelAttribute="medCase">
                            <button type="submit" value="<spring:message text="finalize"/>" class="btn btn-primary">
                                FINALIZE
                            </button>
                        </form:form>
                    </c:if>
                </div>
            </div>
        </div>
    </div>

<%--    Appointment--%>
    <div class="container">
        <div class="row">
            make an appointment
            <input id="datepicker" width="276" />
            <script>
                $('#datepicker').datepicker({
                    uiLibrary: 'bootstrap4'
                });
            </script>


            <div class="btn-group" role="group">
                <button id="btnGroupDrop1" type="button" class="btn btn dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dropdown
                </button>
                <c:forEach items="${}" var="">
                <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
                    <a class="dropdown-item" href="#">Выпадающая ссылка</a>
                </div>
                </c:forEach>
            </div>



        </div>
    </div>

<%--    Diagnosys--%>
    <br>
    <c:if test="${medCase.status=='IN PROGRESS'}">
        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="box d-flex flex-column justify-content-between">
                        <div class="item item-1 flex-shrink-0">Patient</div>
                        <br>
                        <div class="item item-2 flex-shrink-0">Age</div>
                        <br>
                        <div class="item item-3 flex-shrink-0">Doctor</div>
                    </div>
                </div>
                <div class="col">

                </div>
            </div>
        </div>
    </c:if>


</div>
</body>
</html>