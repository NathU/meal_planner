/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs313.mealplanner;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nathanulmer
 */
@WebServlet(name = "view_week_plan", urlPatterns = {"/view_week_plan"})
public class view_week_plan extends HttpServlet {

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
        Map temp = (HashMap)(request.getSession().getAttribute("profile_info"));
        Map mealplan = new HashMap();
        
        Kitchen kitchen = new Kitchen(); // use THIS for the live site on OpenShift
        //Kitchen kitchen = new Kitchen("root", ""); // for testing on my machine...
        
        int mealplan_id = Integer.parseInt((String)temp.get("mealplan_id"));
        mealplan = kitchen.getMealPlan(mealplan_id);
        request.getSession().setAttribute("mealplan", mealplan);       
        
        request.getRequestDispatcher("week_plan.jsp").forward(request, response);
        //processRequest(request, response); //this is for testing purposes. if you want to see what the data looks like, go here instead of week_plan.jsp
    }
    
    
    
    
    
    
    
    
    
    
    
    
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet view_week_plan</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h3> This is just to test the servlet and make sure it works... </h3> <hr/>");
           
            Map temp = (HashMap)(request.getSession().getAttribute("profile_info"));
            out.println("<p>temp Map should contain profile info: <br/>" + temp + "</p>");
            
            out.println("<p>temp Map contains mealplanID : <br/>" + Integer.parseInt((String)temp.get("mealplan_id")) + "</p>");
            
            out.println("<p>profile info: <br/>" + request.getSession().getAttribute("profile_info") + "</p>");
            out.println("<p>meal plan info: <br/>" + request.getSession().getAttribute("mealplan") + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
