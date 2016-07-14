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
    </head>
    <body>
        <form method="post" action="ForgotPassword">
            <center>
            <table border="2" width="35%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Password Reset</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Please enter email</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>Please enter birthdate</td>
                        <td><input name="dob" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Submit" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Not a member?Register <a href="registration.jsp">here</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>