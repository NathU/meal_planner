<%
    // this is to ensure protected pages cannot be accessed after logout.
response.setHeader("Cache-Control","no-cache"); //forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility

String userId = (String) session.getAttribute("email");
if (null == userId) {
	request.setAttribute("Error", "Session has ended.  Please login.");
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
}
%>

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
    <header>
        </header>
        <div class="content">
        <div align="right">
        <a href="logout.jsp" class="signoutlink">Log out</a>
        </div>        
        <h1>Recipe Search</h1>
        <form action="search" method="POST">
            <input type="submit" value="Search" class="button" />
            <input type="text" id="query" name="q" class="search" />
            <input type="hidden" name="from" value="0">
            <input type="hidden" name="to" value="5">  
        </form>
        <div class="recipe-header">
        <c:if test="${!empty hits}">
           <h2>Recipes</h2>
        </c:if>
        </div>
        <c:forEach var="hit" items="${hits}">
            <div class="recipe-hit">
                <div class="recipe-label">${hit.recipe.label}</div>
                <div class="calories"><fmt:formatNumber 
                    value="${hit.recipe.calories}" type="number" 
                    maxFractionDigits="0"/> Calories</div>
                <span>
                    <form action="" method="POST">
                        <input type="submit" value="Add" class="smallbutton" />
                        <input type="hidden" name="label" 
                               value="${hit.recipe.label}">
                        <input type="hidden" name="r" 
                               value="${hit.recipe.url}">
                    </form>
                    <form action="RecipeInfo" method="POST">
                        <input type="submit" value="View Recipe" class="smallbutton" />
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
                <input type="submit" value="Previous" class="button" />
                <input type="hidden" name="q" value="${q}"/>
                <input type="hidden" name="from" value="${prevFrom}">
                <input type="hidden" name="to" value="${prevTo}">
            </form>
            </c:if>        
            <c:if test="${!empty nextFrom && nextTo < count}">
            <form action="search" method="POST">
                <input type="submit" value="Next" class="button" />
                <input type="hidden" name="q" value="${q}"/>
                <input type="hidden" name="from" value="${nextFrom}">
                <input type="hidden" name="to" value="${nextTo}">
            </form>
            </c:if>
        </span>
        </div>
    </body>
</html>
