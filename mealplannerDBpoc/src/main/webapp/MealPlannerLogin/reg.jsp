<%-- 
    Document   : reg
    Created on : Jun 27, 2016, 11:07:52 AM
    Author     : samue
--%>

<%@ page import ="java.sql.*" %>
<%    
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String email = request.getParameter("email");
    String pass = request.getParameter("pass");
    String dob = request.getParameter("dob");
    String gender = request.getParameter("gender");
    String fHeight = request.getParameter("fHeight");
    String iHeight = request.getParameter("iHeight");
    String weight = request.getParameter("weight");
    Class.forName("com.mysql.jdbc.Driver");
    java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login",
            "root", "");
    Statement st = con.createStatement();
    //ResultSet rs;
    int i = st.executeUpdate("INSERT INTO users VALUES ('" + fname + "','" + lname + "','" + email + "','" + dob + "','" + gender + "','" + weight + "','" + pass + "','" + fHeight + "','" + iHeight + "')" );
    if (i > 0) {
        response.sendRedirect("welcome.jsp");
    } else {
        response.sendRedirect("index.jsp");
    }
%>
