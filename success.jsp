<%
    if ((session.getAttribute("email") == null) || (session.getAttribute("email") == "")) {
%>
You are not logged in<br/>
<a href="index.jsp">Please Login</a>
<%} 
    else {
%>
Welcome <%=session.getAttribute("email")%>
<a href='logout.jsp'>Log out</a>
<%
    }
%>