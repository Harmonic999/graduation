<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <title>Food List</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/> ">
</head>

<body>

<h2>Lunch menu:</h2>

<hr>

<table width="30%" border="1" cellpadding="8" cellspacing="0">

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

    <tr>
        <td colspan="3"><a href="/restaurants/${restaurantName}/${restaurantId}/menu/create/">Add New Food</a></td>
    </tr>

    </tbody>

</table>

</body>
</html>