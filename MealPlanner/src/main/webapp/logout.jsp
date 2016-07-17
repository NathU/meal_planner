<%-- 
    Document   : logout
    Created on : Jul 13, 2016, 8:35:20 PM
    Author     : Sam Fonua
--%>

<%
    // this is to ensure protected pages cannot be accessed after logout.
response.setHeader("Cache-Control","no-cache"); //forces caches to obtain a new copy of the page from the origin server
response.setHeader("Cache-Control","no-store"); //directs caches not to store the page under any circumstance
response.setDateHeader("Expires", 0); //causes the proxy cache to see the page as "stale"
response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility

String userId = (String) session.getAttribute("email");
if (null == userId) {
	request.setAttribute("Error", "Session has ended.  Please login.");
	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
	rd.forward(request, response);
}
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/main.css">
<div class="content">
<form action="Logout">
    
<table>	
	<tr>
		<td colspan="2"> Are you sure you would like to logout?</td>			
	</tr>		
	<tr>
		<td> 
			<input type="submit" id="submit" name="submit" value="OK" class="button"/>
		</td>
		<td> 
			<input type="submit" id="submit" name="submit" value="Cancel" class="button"/>
		</td>
	</tr>
</table>
        
<br/>

</form>
</div>
