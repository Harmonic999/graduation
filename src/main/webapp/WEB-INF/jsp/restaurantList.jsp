<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>

<jsp:include page="fragments/headTag.jsp"/>

<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<script type="text/javascript" src="resources/js/datatableUtil.js" defer></script>
<script type="text/javascript" src="resources/js/restaurantDatatable.js" defer></script>

<div class="jumbotron">
    <div class="container">

        <h2>Restaurants:</h2>

        <hr>

        <table id="datatable" class="table table-striped" >

            <thead>
            <tr>
                <th>Name</th>
                <th>Score</th>
                <th></th>
                <th></th>
                <th></th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="restaurant" items="${restaurantList}">
                <tr>
                    <td>${restaurant.name}</td>
                    <td>${restaurant.votes_count}</td>
                    <td><button class="btn btn-primary">Explore Menu</button></td>
                    <td><a class="fa fa-pencil"></a></td>
                    <td><a class="fa fa-remove"></a></td>
                </tr>
            </c:forEach>

            </tbody>

        </table>
    </div>
</div>
<jsp:include page="fragments/bodyFooter.jsp"/>
</body>
</html>
