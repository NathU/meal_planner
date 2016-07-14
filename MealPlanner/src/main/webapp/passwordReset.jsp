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
    </head>
    <body>
        <form method="post" action="UpdatePassword">
            <center>
            <table border="2" width="35%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Enter New Password</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>Password</td>
                        <td><input type="text" name="password" value="" /></td>
                    </tr>
                    <tr>
                        <td>Confirm Password</td>
                        <td><input type="password" name="" value="" /></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="Reset Password" /></td>
                    
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>