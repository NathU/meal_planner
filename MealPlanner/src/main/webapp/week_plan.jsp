<%-- 
    Document   : week_plan
    Created on : Jun 29, 2016, 4:57:11 PM
    Author     : Meghan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Week Plan Page</title>
    </head>
    <body>
        <div id="header">
            <h1>Week Plan</h1>
            
        </div>
        <div id="sunday">
            <h2>Sunday:</h2>
            <table>
                <tr>
                    <td>Breakfast: </td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${mealplan.Sunday_breakfast.label}</td>
                </tr>
                <tr>
                    <td>Lunch</td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${mealplan.Sunday_lunch.label}</td>
                </tr>
                <tr>
                    <td>Supper</td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${mealplan.Sunday_dinner.label}</td>
                </tr>
            </table>
        </div>
        
		<div id="monday">
            <h2>Monday:</h2>
            <table>
                <tr>
                    <td>Breakfast: </td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${mealplan.Monday_breakfast.label}</td>
                </tr>
                <tr>
                    <td>Lunch</td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${mealplan.Monday_lunch.label}</td>
                </tr>
                <tr>
                    <td>Supper</td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${mealplan.Monday_dinner.label}</td>
                </tr>
            </table>
        </div>
        
		<div id="tuesday">
            <h2>Tuesday:</h2>
            <table>
                <tr>
                    <td>Breakfast: </td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${mealplan.Tuesday_breakfast.label}</td>
                </tr>
                <tr>
                    <td>Lunch</td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${mealplan.Tuesday_lunch.label}</td>
                </tr>
                <tr>
                    <td>Supper</td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${mealplan.Tuesday_dinner.label}</td>
                </tr>
            </table>
        </div>
	
		<div id="wednesday">
            <h2>Wednesday:</h2>
            <table>
                <tr>
                    <td>Breakfast: </td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${mealplan.Wednesday_breakfast.label}</td>
                </tr>
                <tr>
                    <td>Lunch</td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${mealplan.Wednesday_lunch.label}</td>
                </tr>
                <tr>
                    <td>Supper</td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${mealplan.Wednesday_dinner.label}</td>
                </tr>
            </table>
        </div>	
	
		<div id="thursday">
            <h2>Thursday:</h2>
            <table>
                <tr>
                    <td>Breakfast: </td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${mealplan.Thursday_breakfast.label}</td>
                </tr>
                <tr>
                    <td>Lunch</td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${mealplan.Thursday_lunch.label}</td>
                </tr>
                <tr>
                    <td>Supper</td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${mealplan.Thursday_dinner.label}</td>
                </tr>
            </table>
        </div>
	
		<div id="friday">
            <h2>Friday:</h2>
            <table>
                <tr>
                    <td>Breakfast: </td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${mealplan.Friday_breakfast.label}</td>
                </tr>
                <tr>
                    <td>Lunch</td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${mealplan.Friday_lunch.label}</td>
                </tr>
                <tr>
                    <td>Supper</td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${mealplan.Friday_dinner.label}</td>
                </tr>
            </table>
        </div>
	
		<div id="saturday">
            <h2>Saturday:</h2>
            <table>
                <tr>
                    <td>Breakfast: </td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${mealplan.Saturday_breakfast.label}</td>
                </tr>
                <tr>
                    <td>Lunch</td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${mealplan.Saturday_lunch.label}</td>
                </tr>
                <tr>
                    <td>Supper</td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${mealplan.Saturday_dinner.label}</td>
                </tr>
            </table>
        </div>
	
	<!--Link to sign in page-->
    <a href="">Not you? Sign in!</a>
</body>
</html>
