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
        <div class="content">
        <div align="right">
        <a href="logout.jsp" class="signoutlink">Log out</a>
        </div>
        <h1>Recipe</h1>
        <img src="${image}" alt="Picture" height="150" width="150"><br/>
        <div class="recipe-hit">
            <div class="recipe-label">${mealTitle}</div>
            <div class="calories">
                <fmt:formatNumber value="${calories}" type="number" 
                                  maxFractionDigits="0"/> Calories
            </div>
        </div>
        <br/><br/>
        <p><b>Ingredients:</b></p>
        <p>${ingredients}</p>
        <form action="search" method="POST">
            <input type="submit" value="Done" class="button"/>
            <input type="hidden" name="q" value="${q}"/>
            <input type="hidden" name="from" value="${from}">
            <input type="hidden" name="to" value="${to}">
        </form>
        <input type="button" class="button" value="View Full Recipe" 
               onclick="window.open('${url}')">
        </div>
    </body>
</html>
