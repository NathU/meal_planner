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
    </head>
    <body>
        <form method="post" action="LoginController">
            <center>
            <table border="2" width="35%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Login Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="password" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Not a member?Register <a href="registration.jsp">here</a>
                            Forgot Password? Click <a href="forgot.jsp">here</a>
                        </td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>