<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<body>

<h2>${food.id == null ? 'Add food:' : 'Edit food:'}</h2>

<form method="post" action="/restaurants/${restaurantName}/${restaurantId}/menu/create_or_edit_food">

    <hr>
    <input type="hidden" name="foodId" value="${food.id}">

    <dl>
        <dt>Description:</dt>
        <dd><input type="text" value="${food.description}" size="40" name="description" required></dd>
    </dl>
    <hr>

    <button type="submit">Save</button>

</form>

</body>
</html>