<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="fragments/headTag.jsp"/>
<link rel="stylesheet" href="resources/css/signin.css">
<body>

<body class="text-center">
<form:form class="form-signin" modelAttribute="userTo" action="${register ? 'register' : 'profile'}" method="post">

    <h1 class="h3 mb-3 font-weight-normal">${register ? 'Register' : 'Profile'}</h1>

        <input type="hidden" id="id" name="id" value="${userTo.id}">

        <input type="text" class="form-control" id="name" name="name" value="${register ? '' : userTo.name}"
               placeholder="Name">

        <input type="email" class="form-control" id="email" name="email" value="${register ?  '' : userTo.email}"
               placeholder="Email">

        <input type="password" class="form-control" id="password" name="password"
               placeholder="Password">

    <button class="btn btn-lg btn-primary btn-block" type="submit">Save</button>

</form:form>


</body>

<jsp:include page="fragments/bodyFooter.jsp"/>
</body>
</html>