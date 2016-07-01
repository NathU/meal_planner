<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 
<html> 
    <head> 
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> 
        <title>Person List</title>
        <script type="text/javascript"> 
            function goToPersonData(data) {
                document.getElementById("name").value = data;
                document.getElementById("submitButton").click();
            }
        </script>
    </head>
    <body>
        <form action='showPersonInfo' method='post'> 
            <input id='name' name='name' type='text' style='visibility: hidden' value=''/>
            <input id='submitButton' type='submit' style='visibility: hidden'/>
        </form>
        
        <h2> Here's the list of people </h2>
        <hr/> <ul>
        <c:forEach var="name" items="${name_list}" > 
            <li> <span style='cursor: pointer' onclick="goToPersonData('${name}')"> ${name}</span> </li>
        </c:forEach>
        </ul>
    </body>
</html>