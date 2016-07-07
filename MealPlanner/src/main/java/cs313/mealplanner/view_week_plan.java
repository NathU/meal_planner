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
            out.println("<p>All user profile info: <br/>" + request.getSession().getAttribute("mealplan") + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
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
        Map temp = (HashMap)(request.getSession().getAttribute("profile_info"));
        /*ArrayList week_plan = new ArrayList();
        week_plan.add(temp.get("Sunday_breakfast"));
        week_plan.add(temp.get("Sunday_lunch"));
        week_plan.add(temp.get("Sunday_dinner"));
        week_plan.add(temp.get("Monday_breakfast"));
        week_plan.add(temp.get("Monday_lunch"));
        week_plan.add(temp.get("Monday_dinner"));
        week_plan.add(temp.get("Tuesday_breakfast"));
        week_plan.add(temp.get("Tuesday_lunch"));
        week_plan.add(temp.get("Tuesday_dinner"));
        week_plan.add(temp.get("Wednesday_breakfast"));
        week_plan.add(temp.get("Wednesday_lunch"));
        week_plan.add(temp.get("Wednesday_dinner"));
        week_plan.add(temp.get("Thursday_breakfast"));
        week_plan.add(temp.get("Thursday_lunch"));
        week_plan.add(temp.get("Thursday_dinner"));
        week_plan.add(temp.get("Friday_breakfast"));
        week_plan.add(temp.get("Friday_lunch"));
        week_plan.add(temp.get("Friday_dinner"));
        week_plan.add(temp.get("Saturday_breakfast"));
        week_plan.add(temp.get("Saturday_lunch"));
        week_plan.add(temp.get("Saturday_dinner"));*/
        
        Kitchen kitchen = new Kitchen();
        Map mealplan = new HashMap();
        mealplan = kitchen.getMealPlan(Integer.parseInt((String)(temp.get("mealplan_id"))));
        
        request.getSession().setAttribute("mealplan", mealplan);       
        
        request.getRequestDispatcher("week_plan.jsp").forward(request, response);
        //processRequest(request, response);
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
