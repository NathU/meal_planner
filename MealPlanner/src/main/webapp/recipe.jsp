<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recipe</title>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <h1>Recipe</h1>
        <div class="recipe-hit">
            <div class="recipe-label">${hit.recipe.label}</div>
            <div class="calories"><fmt:formatNumber 
                value="${hit.recipe.calories}" type="number" 
                maxFractionDigits="0"/> Calories
            </div>
        </div>
        <ul>
        <c:forEach var="ingredient" items="${ingredients}">
            <li>${ingredient}</li>    
        </c:forEach>
        </ul>
        <br/><br/>
        <form action="search" method="POST">
            <input type="submit" value="Done" />
            <input type="hidden" name="q" value="${q}"/>
            <input type="hidden" name="from" value="${from}">
            <input type="hidden" name="to" value="${to}">
        </form>
    </body>
</html>