<%-- 
    Document   : profile
    Created on : Jun 28, 2016, 11:49:01 PM
    Author     : Meghan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
    </head>
    <body>
        <label>Date of Birth: </label><input type="date" name="birthday" min="1900-01-02"> ${profile_info.dob}
        <br>
        <label>Gender: </label> <input type="radio" name="gender" value="male" checked>Male <input type="radio" name="gender" value="female"> Female
        <br>
        <label>Height: </label> <input type="text" name="feet" /> Feet <input type="text" name="inches" /> Inches
        <br>
        <label>Weight: </label> <input type="text" name="weight" /> Pounds 
        <br>
        <label>Activity: </label> 
        <select name="activity_level">
            <option value="light_activity">Light Activity</option>
            <option value="medium_activity">Medium Activity</option>
            <option value="high_activity">High Activity</option>
        </select>
        <br>
        <label>Weekly Weight Loss Goal (in lbs): </label>
        <select name="weight_loss_goal">
            <option value="0">0</option>
            <option value="1">1</option> 
            <option value="2">2</option>
        </select>
        <br>
        <input type="submit">
        
    </body>
</html>
