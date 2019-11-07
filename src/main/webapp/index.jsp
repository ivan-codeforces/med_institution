<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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
                    <a class="nav-link" href="<c:url value="/medCases"/>">Cases<span class="sr-only">(current)</span></a>
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
<%--<nav class="navbar navbar-expand-md navbar-light bg-ligth stikcy-top">--%>
<%--    <div class="conteiner-fluid">--%>

<%--        <button class="navbar-toggler" type="button" data-toggle="collapse" data-targer="#navbarResponsive">--%>
<%--            <span class="navbar-toggler-icon"></span>--%>
<%--        </button>--%>
<%--        <div class="collaps navbar-collaps" id="navbarResponsive">--%>
<%--            <ul class="navbar-nav ml-auto">--%>
<%--                <li class="nav-item active">--%>
<%--                    <a href="#" class="nav-link">Main</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a href="#" class="nav-link">About</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a href="#" class="nav-link">Contacts</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a href="#" class="nav-link">Services</a>--%>
<%--                </li>--%>
<%--                <li class="nav-item">--%>
<%--                    <a href="#" class="nav-link">Team</a>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>

</body>
</html>

