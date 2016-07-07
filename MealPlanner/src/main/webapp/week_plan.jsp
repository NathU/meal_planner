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
            <label>Daily Calorie Recommendation: </label> ${param.calorie_rec}
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
                    <td>${param.sun_l_recipe}</td>
                </tr>
                <tr>
                    <td>Supper</td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${param.sun_s_recipe}</td>
                </tr>
            </table>
        </div>
        <div id="monday">
            <h2>Sunday</h2>
            <table>
                <tr>
                    <td>Breakfast</td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${param.mon_b_recipe}</td>
                </tr>
                <tr>
                    <td>Lunch</td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${param.mon_l_recipe}</td>
                </tr>
                <tr>
                    <td>Supper</td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${param.mon_s_recipe}</td>
                </tr>
            </table>
        </div>
        <div id="tuesday">
            <h2>Tuesday:</h2>
            <table>
                <tr>
                    <td>Breakfast</td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${param.tues_b_recipe}</td>
                </tr>
                <tr>
                    <td>Lunch</td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${param.tues_l_recipe}</td>
                </tr>
                <tr>
                    <td>Supper</td> 
                    <!--Should these params be a loop so they can put in as many recipes as they want? -->
                    <td>${param.tues_s_recipe}</td>
                </tr>
            </table>
        </div>
    </div>
    <div id="wednesday">
        <h2>Wednesday:</h2>
        <table>
            <tr>
                <td>Breakfast</td> 
                <!--Should these params be a loop so they can put in as many recipes as they want? -->
                <td>${param.wed_b_recipe}</td>
            </tr>
            <tr>
                <td>Lunch</td> 
                <!--Should these params be a loop so they can put in as many recipes as they want? -->
                <td>${param.wed_l_recipe}</td>
            </tr>
            <tr>
                <td>Supper</td> 
                <!--Should these params be a loop so they can put in as many recipes as they want? -->
                <td>${param.wed_s_recipe}</td>
            </tr>
        </table>
    </div>
    <div id="thursday">
        <h2>Thursday:</h2>
        <table>
            <tr>
                <td>Breakfast</td> 
                <!--Should these params be a loop so they can put in as many recipes as they want? -->
                <td>${param.thu_b_recipe}</td>
            </tr>
            <tr>
                <td>Lunch</td> 
                <!--Should these params be a loop so they can put in as many recipes as they want? -->
                <td>${param.thu_l_recipe}</td>
            </tr>
            <tr>
                <td>Supper</td> 
                <!--Should these params be a loop so they can put in as many recipes as they want? -->
                <td>${param.thu_s_recipe}</td>
            </tr>
        </table>
    </div>
    <div id="friday">
        <h2>Friday:</h2>
        <table>
            <tr>
                <td>Breakfast</td> 
                <!--Should these params be a loop so they can put in as many recipes as they want? -->
                <td>${param.fri_b_recipe}</td>
            </tr>
            <tr>
                <td>Lunch</td> 
                <!--Should these params be a loop so they can put in as many recipes as they want? -->
                <td>${param.fri_l_recipe}</td>
            </tr>
            <tr>
                <td>Supper</td> 
                <!--Should these params be a loop so they can put in as many recipes as they want? -->
                <td>${param.fri_s_recipe}</td>
            </tr>
        </table>
    </div>
    <div id="saturday">
        <h2>Saturday:</h2>
        <table>
            <tr>
                <td>Breakfast</td> 
                <!--Should these params be a loop so they can put in as many recipes as they want? -->
                <td>${param.sat_b_recipe}</td>
            </tr>
            <tr>
                <td>Lunch</td> 
                <!--Should these params be a loop so they can put in as many recipes as they want? -->
                <td>${param.sat_l_recipe}</td>
            </tr>
            <tr>
                <td>Supper</td> 
                <!--Should these params be a loop so they can put in as many recipes as they want? -->
                <td>${param.sat_s_recipe}</td>
            </tr>
        </table>
    </div>
    <!--Link to sign in page-->
    <a href="">Not you? Sign in!</a>
</body>
</html>
