<%-- 
    Document   : index
    Created on : Jun 28, 2016, 10:26:51 PM
    Author     : Sam Fonua
    // js needed for input validation
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Meal Planner</title>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <div class="content">
            <form method="post" action="LoginController">
                <h1>Login</h2>
                
                    <table>
                        <tbody>
                            <tr>
                                <td>User Name</td>
                                <td><input type="text" name="email" value="" /></td>
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td><input type="password" name="password" value="" /></td>
                            </tr>
                        </tbody>
                    </table>
                <br>
                <input type="submit" value="Login" class="button" />
                <input type="reset" value="Reset" class="button" />
                <br>
                <br>
                <p>Not a member? Register <a href="registration.jsp">here</a>!</p>
                <p>Forgot Password? Click <a href="forgot.jsp">here</a>!</p>
            </form>
        </div>
    </body>
</html>
