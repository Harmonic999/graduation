<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/> ">
</head>
<body>

    <h2>${restaurant.id == null ? 'Add restaurant:' : 'Edit restaurant:'}</h2>

    <form method="post" action="/restaurants/createOrUpdate">

        <hr>
        <input type="hidden" name="id" value="${restaurant.id}">

        <dl>
            <dt>Name:</dt>
            <dd><input type="text" value="${restaurant.name}" size="40" name="name" required></dd>
        </dl>
        <hr>

        <button type="submit">Save</button>

    </form>

</body>
</html>
