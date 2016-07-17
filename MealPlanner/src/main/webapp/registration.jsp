<%-- 
    Document   : registration
    Created on : Jun 27, 2016, 10:52:04 AM
    Author     : samuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <div class="content">
        <form method="post" action="SignUp">
            <h1>Enter Information Here</h1>
            <center>
            <table>
                <tbody>
                    <tr>
                        <td>Name</td>
                        <td><input type="text" name="name" value="" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td>Date of Birth</td>
                        <td><input type="text" name="dob" value="" /></td>
                    </tr>
                    <tr>
                        <td>Gender</td>
                        <td><input type="radio" name="gender" value="Male" /> Male 
                            <input type="radio" name="gender" value="Female" /> Female
                        </td>
                    </tr>
                    <tr>
                        <td>Height</td>
                        <td> ft <select type="text" name="fHeight" value="">
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        
                        </select> in <select type="text" name="iHeight" value="" />
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        </td-->  
                        </td>
                    </tr>
                    <tr>
                        <td>Weight</td>
                        <td><input type="text" name="weight" value="" /></td>
                    </tr>
                    <tr>
                        <td>Activity Level</td>
                        <td>
                            <select name="activity">
                            <option value="light_activity">Light Activity</option>
                            <option value="medium_activity">Medium Activity</option>
                            <option value="high_activity">High Activity</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Weekly Weight Loss Goal (in lbs)</td>
                        <td>
                            <select name="goal">
                                <option value="0">0</option>
                                <option value="1">1</option> 
                                <option value="2">2</option>
                            </select>
                        </td>
                    </tr>                    
                    <tr>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td colspan="2"></td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="Submit" class="button" />
            <input type="reset" value="Reset" class="button" />
            <p>Already registered!! <a href="index.jsp">Login Here</a></p>
        </form>
            </div>
    </body>
</html>
