<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<jsp:include page="fragments/headTag.jsp"/>
<body>
<jsp:include page="fragments/bodyHeader.jsp"/>
<script type="text/javascript" src="resources/js/datatableUtil.js" defer></script>
<script type="text/javascript" src="resources/js/foodDatatable.js" defer></script>

<div class="jumbotron">
    <div class="container">

        <h2>Lunch menu:</h2>

        <hr>

        <table id="datatable" class="table table-striped">

            <thead>
            <tr>
                <th>Description</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>

            <tbody>
            <c:forEach var="meal" items="${mealList}">
                <tr>
                    <td>${meal.description}</td>
                    <td><a href="/restaurants/${restaurantName}/${restaurantId}/menu/edit/${meal.id}">Edit</a></td>
                    <td><a href="/restaurants/${restaurantName}/${restaurantId}/menu/delete/${meal.id}">Delete</a></td>
                </tr>
            </c:forEach>

            </tbody>

        </table>
    </div>
</div>
<jsp:include page="fragments/bodyFooter.jsp"/>
</body>
</html>