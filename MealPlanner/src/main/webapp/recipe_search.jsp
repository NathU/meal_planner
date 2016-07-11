<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recipe Search</title>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <h1>Recipe Search</h1>
        <form action="search" method="POST">
            <input type="submit" value="Search" />
            <input type="text" id="query" name="q" />
            <input type="hidden" name="from" value="0">
            <input type="hidden" name="to" value="5">  
        </form>
        <c:if test="${!empty hits}">
           <h2>Recipes</h2>
        </c:if>
        <c:forEach var="hit" items="${hits}">
            <div class="recipe-hit">
                <div class="recipe-label">${hit.recipe.label}</div>
                <div class="calories"><fmt:formatNumber 
                    value="${hit.recipe.calories}" type="number" 
                    maxFractionDigits="0"/> Calories</div>
                <span>
                    <form action="" method="POST">
                        <input type="submit" value="Add" />
                        <input type="hidden" name="label" 
                               value="${hit.recipe.label}">
                        <input type="hidden" name="r" 
                               value="${hit.recipe.uri}">
                    </form>
                    <form action="RecipeInfo" method="POST">
                        <input type="submit" value="View Recipe" />
                        <input type="hidden" name="r" 
                           value="${hit.recipe.uri}">
                        <input type="hidden" name="q" value="${q}"/>
                        <input type="hidden" name="from" value="${prevTo}">
                        <input type="hidden" name="to" value="${nextFrom}">
                    </form>
                </span>
            </div>
        </c:forEach>
        <br/><br/>
        <span>
            <c:if test="${!empty prevFrom && prevTo > 0}">
            <form action="search" method="POST">
                <input type="submit" value="Previous" />
                <input type="hidden" name="q" value="${q}"/>
                <input type="hidden" name="from" value="${prevFrom}">
                <input type="hidden" name="to" value="${prevTo}">
            </form>
            </c:if>        
            <c:if test="${!empty nextFrom && nextTo < count}">
            <form action="search" method="POST">
                <input type="submit" value="Next" />
                <input type="hidden" name="q" value="${q}"/>
                <input type="hidden" name="from" value="${nextFrom}">
                <input type="hidden" name="to" value="${nextTo}">
            </form>
            </c:if>
        </span>
    </body>
</html>
