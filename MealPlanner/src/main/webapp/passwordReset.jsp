<%-- 
    Document   : passwordReset
    Created on : Jul 14, 2016, 12:21:59 AM
    Author     : Sam Fonua
// js needed for input validation
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Password Reset</title>
        <link rel="stylesheet" href="css/main.css">
    </head>
    <body>  

        <form method="post" action="UpdatePassword">
            <div class="content">
                <h1>Enter New Password</h1>
                <table>
                    <tbody>
                        <tr>
                            <td>Password</td>
                            <td><input type="text" name="password" value="" required /></td>
                        </tr>
                        <tr>
                            <td>Confirm Password</td>
                            <td><input type="password" name="" value="" required /></td>
                        </tr>
                    </tbody>
                </table>
                <br>
                <input type="submit" value="Reset Password" class="button" />
            </div>
        </form>

    </body>
</html>
