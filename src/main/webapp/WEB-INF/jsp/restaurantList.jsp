<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>

<head>
    <title>Restaurants</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

</head>

<body>

<h2>Restaurants:</h2>

<hr>

<table cellpadding="8" cellspacing="0" id="restaurants_table" width="50%">

    <thead>
    <tr>
        <th>Name</th>
        <th>Score</th>
        <th>Menu</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="restaurant" items="${restaurantList}">
        <tr>
            <td>${restaurant.name}</td>
            <td>${restaurant.votes_count}</td>
            <td><a href="/restaurants/${restaurant.name}/${restaurant.id}/menu">Explore</a></td>
            <td><a href="/restaurants/edit/${restaurant.id}">Edit</a></td>
            <td><a href="/restaurants/delete/${restaurant.id}">Delete</a></td>
        </tr>
    </c:forEach>

    <tr>
        <td colspan="5"><a href="/restaurants/create">Add Restaurant</a></td>
    </tr>

    </tbody>

</table>

</body>
</html>
