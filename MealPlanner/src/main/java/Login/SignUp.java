package Login;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cs313.mealplanner.Kitchen;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


public class SignUp extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html;charset=UTF-8");
            
            // DB only requires that these two exist...
            String email = request.getParameter("email");
            String password= request.getParameter("password");
            // ...the rest are allowed to be NULL
            String name = request.getParameter("name");
            String dob = request.getParameter("dob");
            String gender = request.getParameter("gender");
            String fHeight = request.getParameter("fHeight"); // needs to be an INT
            String iHeight = request.getParameter("iHeight"); // needs to be an INT
            String weight = request.getParameter("weight"); // needs to be an INT
            String activity = request.getParameter("activity");
            String goal = request.getParameter("goal"); // needs to be an INT
            // height is gonna be in inches. Another uninformed DB design decision on my part... sorry!
            int height = (fHeight != null && iHeight != null)? 
                    (Integer.parseInt(fHeight) * 12) + Integer.parseInt(iHeight) : null;
            
            Map user_info = new HashMap();
            user_info.put("name", name);
            user_info.put("dob", dob);
            user_info.put("gender", gender);
            user_info.put("height", height);
            user_info.put("weight", Integer.parseInt(weight));
            user_info.put("activity", activity);
            user_info.put("goal", Integer.parseInt(goal));
            
            Kitchen kitchen = new Kitchen();
            int affected_rows = kitchen.createNewAccount(email, password, user_info);
            
            //  This should already have been validated client-side. But just in case...
            if (email == null || password == null || (affected_rows != 1) ) {
                response.sendRedirect("index.jsp");
            } else {
                Map profile_info = kitchen.getAccountInfo(email, password);
                request.getSession().setAttribute("profile_info", profile_info); // so we have mealplan_id in a session var
                request.getSession().setAttribute("email", email); //redundant, but that's ok.
                response.sendRedirect("week_plan.jsp");
            }
       /*     
       try{
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kitchen", "root", "");
            Statement st = con.createStatement();
            //ResultSet rs;
            int i = st.executeUpdate("INSERT INTO users VALUES ('" + email + "','" + password + "','" + name + "','" + dob + "','" + gender + "','" + fHeight + "','" + iHeight + "','" + weight + "','" + activity + "','" + goal + "')" );
            if (i > 0) {
                 response.sendRedirect("week_plan.jsp");
            } else {
                response.sendRedirect("index.jsp");
            } 
       }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            } */
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
