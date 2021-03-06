/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;


import cs313.mealplanner.Kitchen;
import java.io.*;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");    
        String password = request.getParameter("password");
        
        Kitchen kitchen = new Kitchen(); // use THIS for the live site on OpenShift
        //Kitchen kitchen = new Kitchen("root", ""); // for testing on my machine...
        Map profile_info = new HashMap();
        profile_info = kitchen.getAccountInfo(email, password);
        
        if (profile_info.get("email") != null) {
            request.getSession().setAttribute("profile_info", profile_info); // so we have mealplan_id in a session var
            request.getSession().setAttribute("email", email); //redundant, but that's ok.
            
            request.getRequestDispatcher("view_week_plan").forward(request,response);
            
        } else {
            out.println("Invalid password <a href='index.jsp'>try again</a>");
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

  