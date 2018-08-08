<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>

<head>
    <title>Food List</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/> ">
</head>

<body>


<h3>Food List:</h3>
</body>

<table border="1" cellpadding="8" cellspacing="0">

    <thead>
    <tr>
        <th>Description</th>
        <th>Score</th>
        <th>Vote for</th>
        <th>Vote against</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="meal" items="${mealList}">
        <tr>
            <td>${meal.description}</td>
            <td>${meal.votesCount}</td>
            <td>
                <a href="/foodList/vote_for/${meal.id}"><h2>+</h2></a>
            </td>

            <td>
                <a href="/foodList/vote_against/${meal.id}"><h2>-</h2></a>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>

<button onclick="window.history.back()" type="button">Back</button>

</html>