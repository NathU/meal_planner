/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs313.mealplanner;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Meghan
 */
@WebServlet(name = "delete_recipe", urlPatterns = {"/delete_recipe"})
public class delete_recipe extends HttpServlet {

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
        
        String day_meal = request.getParameter("day_meal");
        
        Map mealplan = new HashMap();
        mealplan = (HashMap)(request.getSession().getAttribute("mealplan"));
        Map day = new HashMap();
        day = (HashMap)(mealplan.get(day_meal));
        
        int deleteMe_id = Integer.parseInt((String)day.get("id"));
        int mealplan_id = Integer.parseInt((String)mealplan.get("id"));
        
        Kitchen kitchen = new Kitchen(); // use THIS for the live site on OpenShift
        //Kitchen kitchen = new Kitchen("root", ""); // for testing on my machine...
        
        int affected_rows = kitchen.simpleDelete(day_meal, mealplan_id);
        
        request.getRequestDispatcher("view_week_plan").forward(request,response);
        
        /*
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
        }
        HttpSession session = request.getSession();
        //get day/meal that is getting deleted
        int recipe_id = (int)session.getAttribute("recipe_id");
        String day_meal = (String)session.getAttribute("day_meal");
        int mealplan_id = (int)session.getAttribute("mealplan_id");
        
        
        //get recipe info that is getting deleted
        
        //grab kitchen.java method for deleting method
        Kitchen kitchen = new Kitchen();
        kitchen.deleteRecipeFromPlan(recipe_id, day_meal, mealplan_id);
        
        if (kitchen.deleteRecipeFromPlan(recipe_id, day_meal, mealplan_id) != null) {
            out.println("Error. Please try again later");
        } else {
            response.sendRedirect("week_plan.jsp");
        }
        
        //check true/fals if deleted
        
        //loop back to week_plan.jsp
        */
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
