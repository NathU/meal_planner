<%-- 
    Document   : registration
    Created on : Jun 27, 2016, 10:52:04 AM
    Author     : samue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
         <body>
        <form method="post" action="reg.jsp">
            <center>
            <table border="2" width="30%" cellpadding="5">
                <thead>
                    <tr>
                        <th colspan="2">Enter Information Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>First Name</td>
                        <td><input type="text" name="fname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Last Name</td>
                        <td><input type="text" name="lname" value="" /></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                        <td><input type="text" name="pass" value="" /></td>
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
                        <td><input type="submit" value="Submit" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>
                    <tr>
                        <td colspan="2">Already registered!! <a href="index.jsp">Login Here</a></td>
                    </tr>
                </tbody>
            </table>
            </center>
        </form>
    </body>
</html>
