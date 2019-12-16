<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false" %>

<html>
<head>
    <%--    <title>${u.username}</title>--%>
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