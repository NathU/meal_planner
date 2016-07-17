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

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Week Plan Page</title>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <div class="content">
            <div align="right">
                <a href="logout.jsp" class="signoutlink">Log out</a>
            </div>
                <form action="search" method="POST">
                <input type="text" id="query" name="q" class="search" />
                <input type="submit" value="Search Recipes" class="button" />
                <input type="hidden" name="from" value="0">
                <input type="hidden" name="to" value="5">  
            </form>
            <div id="header">
                <h1>Week Plan</h1>

            </div>
            <div id="sunday">
                <h2>Sunday:</h2>
                <table>
                    <tr>
                        <td>Breakfast: </td> 
                        <c:set var="check" value="${mealplan.Sunday_breakfast.label}"/>
                        <c:if test="${check != null}">
                            <td> ${mealplan.Sunday_breakfast.label} </td>
                            <td><span id="delete">x</span></td>
                        </c:if>
                        <c:if test="${check == null}">
                            <td> &nbsp; </td>
                            <td> &nbsp; </td>
                        </c:if>
                    </tr>
                    <tr>
                        <td>Lunch:</td>                         
                        <c:set var="check" value="${mealplan.Sunday_lunch.label}"/>
                        <c:if test="${check != null}">
                            <td> ${mealplan.Sunday_lunch.label} </td>
                            <td><span id="delete">x</span></td>
                        </c:if>
                        <c:if test="${check == null}">
                            <td> &nbsp; </td>
                            <td> &nbsp; </td>
                        </c:if>
                    </tr>
                    <tr>
                        <td>Supper:</td>                         
                        <c:set var="check" value="${mealplan.Sunday_dinner.label}"/>
                        <c:if test="${check != null}">
                            <td> ${mealplan.Sunday_dinner.label} </td>
                            <td><span id="delete">x</span></td>
                        </c:if>
                        <c:if test="${check == null}">
                            <td> &nbsp; </td>
                            <td> &nbsp; </td>
                        </c:if>
                    </tr>
                </table>
            </div>

            <div id="monday">
                <h2>Monday:</h2>
                <table>
                    <tr>
                        <td>Breakfast: </td>                         
                        <c:set var="check" value="${mealplan.Monday_breakfast.label}"/>
                        <c:if test="${check != null}">
                            <td> ${mealplan.Monday_breakfast.label} </td>
                            <td><span id="delete">x</span></td>
                        </c:if>
                        <c:if test="${check == null}">
                            <td> &nbsp; </td>
                            <td> &nbsp; </td>
                        </c:if>
                    </tr>
                    <tr>
                        <td>Lunch:</td>                         
                        <c:set var="check" value="${mealplan.Monday_lunch.label}"/>
                        <c:if test="${check != null}">
                            <td> ${mealplan.Monday_lunch.label} </td>
                            <td><span id="delete">x</span></td>
                        </c:if>
                        <c:if test="${check == null}">
                            <td> &nbsp; </td>
                            <td> &nbsp; </td>
                        </c:if>
                    </tr>
                    <tr>
                        <td>Supper:</td>                         
                        <c:set var="check" value="${mealplan.Monday_dinner.label}"/>
                        <c:if test="${check != null}">
                            <td> ${mealplan.Monday_dinner.label} </td>
                            <td><span id="delete">x</span></td>
                        </c:if>
                        <c:if test="${check == null}">
                            <td> &nbsp; </td>
                            <td> &nbsp; </td>
                        </c:if>
                    </tr>
                </table>
            </div>

            <div id="tuesday">
                <h2>Tuesday:</h2>
                <table>
                    <tr>
                        <td>Breakfast: </td>                         
                        <c:set var="check" value="${mealplan.Tuesday_breakfast.label}"/>
                        <c:if test="${check != null}">
                            <td> ${mealplan.Tuesday_breakfast.label} </td>
                            <td><span id="delete">x</span></td>
                        </c:if>
                        <c:if test="${check == null}">
                            <td> &nbsp; </td>
                            <td> &nbsp; </td>
                        </c:if>
                    </tr>
                    <tr>
                        <td>Lunch:</td>                         
                        <c:set var="check" value="${mealplan.Tuesday_lunch.label}"/>
                        <c:if test="${check != null}">
                            <td> ${mealplan.Tuesday_lunch.label} </td>
                            <td><span id="delete">x</span></td>
                        </c:if>
                        <c:if test="${check == null}">
                            <td> &nbsp; </td>
                            <td> &nbsp; </td>
                        </c:if>
                    </tr>
                    <tr>
                        <td>Supper:</td> 
                        <c:set var="check" value="${mealplan.Tuesday_dinner.label}"/>
                        <c:if test="${check != null}">
                            <td> ${mealplan.Tuesday_dinner.label} </td>
                            <td><span id="delete">x</span></td>
                        </c:if>
                        <c:if test="${check == null}">
                            <td> &nbsp; </td>
                            <td> &nbsp; </td>
                        </c:if>
                    </tr>
                </table>
            </div>

            <div id="wednesday">
                <h2>Wednesday:</h2>
                <table>
                    <tr>
                        <td>Breakfast: </td> 
                        <c:set var="check" value="${mealplan.Wednesday_breakfast.label}"/>
                        <c:if test="${check != null}">
                            <td> ${mealplan.Wednesday_breakfast.label} </td>
                            <td><span id="delete">x</span></td>
                        </c:if>
                        <c:if test="${check == null}">
                            <td> &nbsp; </td>
                            <td> &nbsp; </td>
                        </c:if>
                    </tr>
                    <tr>
                        <td>Lunch:</td>                         
                        <c:set var="check" value="${mealplan.Wednesday_lunch.label}"/>
                        <c:if test="${check != null}">
                            <td> ${mealplan.Wednesday_lunch.label} </td>
                            <td><span id="delete">x</span></td>
                        </c:if>
                        <c:if test="${check == null}">
                            <td> &nbsp; </td>
                            <td> &nbsp; </td>
                        </c:if>
                    </tr>
                    <tr>
                        <td>Supper:</td> 
                        <c:set var="check" value="${mealplan.Wednesday_dinner.label}"/>
                        <c:if test="${check != null}">
                            <td> ${mealplan.Wednesday_dinner.label} </td>
                            <td><span id="delete">x</span></td>
                        </c:if>
                        <c:if test="${check == null}">
                            <td> &nbsp; </td>
                            <td> &nbsp; </td>
                        </c:if>
                    </tr>
                </table>
            </div>	

            <div id="thursday">
                <h2>Thursday:</h2>
                <table>
                    <tr>
                        <td>Breakfast: </td> 
                        <c:set var="check" value="${mealplan.Thursday_breakfast.label}"/>
                        <c:if test="${check != null}">
                            <td> ${mealplan.Thursday_breakfast.label} </td>
                            <td><span id="delete">x</span></td>
                        </c:if>
                        <c:if test="${check == null}">
                            <td> &nbsp; </td>
                            <td> &nbsp; </td>
                        </c:if>
                    </tr>
                    <tr>
                        <td>Lunch:</td> 
                        <c:set var="check" value="${mealplan.Thursday_lunch.label}"/>
                        <c:if test="${check != null}">
                            <td> ${mealplan.Thursday_lunch.label} </td>
                            <td><span id="delete">x</span></td>
                        </c:if>
                        <c:if test="${check == null}">
                            <td> &nbsp; </td>
                            <td> &nbsp; </td>
                        </c:if>
                    </tr>
                    <tr>
                        <td>Supper:</td> 
                        <c:set var="check" value="${mealplan.Thursday_dinner.label}"/>
                        <c:if test="${check != null}">
                            <td> ${mealplan.Thursday_dinner.label} </td>
                            <td><span id="delete">x</span></td>
                        </c:if>
                        <c:if test="${check == null}">
                            <td> &nbsp; </td>
                            <td> &nbsp; </td>
                        </c:if>
                    </tr>
                </table>
            </div>

            <div id="friday">
                <h2>Friday:</h2>
                <table>
                    <tr>
                        <td>Breakfast: </td> 
                        <c:set var="check" value="${mealplan.Friday_breakfast.label}"/>
                        <c:if test="${check != null}">
                            <td> ${mealplan.Friday_breakfast.label} </td>
                            <td><span id="delete">x</span></td>
                        </c:if>
                        <c:if test="${check == null}">
                            <td> &nbsp; </td>
                            <td> &nbsp; </td>
                        </c:if>
                    </tr>
                    <tr>
                        <td>Lunch:</td> 
                        <c:set var="check" value="${mealplan.Friday_lunch.label}"/>
                        <c:if test="${check != null}">
                            <td> ${mealplan.Friday_lunch.label} </td>
                            <td><span id="delete">x</span></td>
                        </c:if>
                        <c:if test="${check == null}">
                            <td> &nbsp; </td>
                            <td> &nbsp; </td>
                        </c:if>
                    </tr>
                    <tr>
                        <td>Supper:</td> 
                        <c:set var="check" value="${mealplan.Friday_dinner.label}"/>
                        <c:if test="${check != null}">
                            <td> ${mealplan.Friday_dinner.label} </td>
                            <td><span id="delete">x</span></td>
                        </c:if>
                        <c:if test="${check == null}">
                            <td> &nbsp; </td>
                            <td> &nbsp; </td>
                        </c:if>
                    </tr>
                </table>
            </div>

            <div id="saturday">
                <h2>Saturday:</h2>
                <table>
                    <tr>
                        <td>Breakfast: </td> 
                        <c:set var="check" value="${mealplan.Saturday_breakfast.label}"/>
                        <c:if test="${check != null}">
                            <td> ${mealplan.Saturday_breakfast.label} </td>
                            <td><span id="delete">x</span></td>
                        </c:if>
                        <c:if test="${check == null}">
                            <td> &nbsp; </td>
                            <td> &nbsp; </td>
                        </c:if>
                    </tr>
                    <tr>
                        <td>Lunch:</td> 
                        <c:set var="check" value="${mealplan.Saturday_lunch.label}"/>
                        <c:if test="${check != null}">
                            <td> ${mealplan.Saturday_lunch.label} </td>
                            <td><span id="delete">x</span></td>
                        </c:if>
                        <c:if test="${check == null}">
                            <td> &nbsp; </td>
                            <td> &nbsp; </td>
                        </c:if>
                    </tr>
                    <tr>
                        <td>Supper:</td> 
                        <c:set var="check" value="${mealplan.Saturday_dinner.label}"/>
                        <c:if test="${check != null}">
                            <td> ${mealplan.Saturday_dinner.label} </td>
                            <td><span id="delete">x</span></td>
                        </c:if>
                        <c:if test="${check == null}">
                            <td> &nbsp; </td>
                            <td> &nbsp; </td>
                        </c:if>
                    </tr>
                </table>
            </div>

        </div>
    </body>
</html>
