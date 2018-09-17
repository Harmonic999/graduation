<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<nav class="navbar navbar-dark bg-primary">

    <div class="container">

        <a href="restaurants" class="navbar-brand">Restaurant Voting App</a>

        <sec:authorize access="isAuthenticated()">
            <div class="input-group-append">

                <button class="btn btn-primary mt-2 mb-2 mr-1" onclick="window.location='profile'">
                    Profile
                </button>

                <form:form class="form-inline my-2" action="logout" method="post">
                    <button class="btn btn-primary" type="submit">
                        Logout
                        <span class="fa fa-sign-out"></span>
                    </button>
                </form:form>
            </div>


        </sec:authorize>

        <sec:authorize access="isAnonymous()">
            <form:form class="form-inline my-2" id="login_form" action="spring_security_check" method="post">
                <input class="form-control mr-1" type="text" placeholder="Email" name="username">
                <input class="form-control mr-1" type="password" placeholder="Password" name="password">
                <button class="btn btn-success" type="submit">
                    <span class="fa fa-sign-in"></span>
                </button>
            </form:form>
        </sec:authorize>
    </div>
</nav>