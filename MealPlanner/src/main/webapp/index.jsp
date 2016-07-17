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
        <script type="text/javascript" src="js/common.js"></script>
    </head>
    <body>
        
        <div class="content">
            <div id="myModal" class="modal">

            <!-- Modal content -->
            <div class="modal-content">
                <div id="healthtips"><p>The ULTIMATE Meal Planner Supreme Omega 2000 X52</p></div>
            </div>
        </div>
            <form method="post" action="LoginController">
                <h1>Login</h2>
                
                    <table>
                        <tbody>
                            <tr>
                                <td>User Name</td>
                                <td><input type="text" name="email" value="" required/></td>
                            </tr>
                            <tr>
                                <td>Password</td>
                                <td><input type="password" name="password" value="" required/></td>
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
        <script>
            function updateAnimation(){
                document.getElementById("myModal").style.display = "none";
            }

            document.addEventListener("animationend", updateAnimation, true);
        </script>
    </body>
</html>
