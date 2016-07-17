<%-- 
    Document   : forgot
    Created on : Jul 13, 2016, 11:31:02 PM
    Author     : Sam Fonua
    // js needed for input validation
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Forgot Password</title>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>
        <div class="content">
            <form method="post" action="ForgotPassword">
                <h1>Password Reset</h1>
                <table>
                    <tbody>
                        <tr>
                            <td>Please enter email</td>
                            <td><input type="text" name="email" value="" /></td>
                        </tr>
                        <tr>
                            <td>Please enter birth date</td>
                            <td><input name="dob" value="" /></td>
                        </tr>
                    </tbody>
                </table>
                <br>
                <input type="submit" value="Submit" class="button" />
                <br><br><br>
                <span>Not a member? Register <a href="registration.jsp">here</a></span>

            </form>
        </div>
    </body>
</html>
