/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs313.mealplannerdbpoc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 *
 * @author nathanulmer
 */
@WebServlet(name = "new_account", urlPatterns = {"/new_account"})
public class new_account extends HttpServlet {

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
            out.println("<title>Servlet new_account</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> This has been added to the database </h1>");
            out.println("<p> Username (email) = "+request.getSession().getAttribute("email")+"</p>");
            out.println("<p> User Password = "+request.getSession().getAttribute("pass")+"</p>");        
            out.println("<p> User ID in database = "+request.getSession().getAttribute("user_id")+"</p>");  
            out.println("<hr/> <p> Full Query Response Object = "+request.getSession().getAttribute("query_results")+"</p>");  
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
        
        String insert_statement = "INSERT INTO users (email, password) "+
                "VALUES ('"+request.getParameter("username")+
                "', '"+request.getParameter("password")+"')";
        
        JDBC_thing jdbc = new JDBC_thing();
        jdbc.setQuery(insert_statement);
        Map query_results = jdbc.doTheThing();
        
        if ((int)query_results.get("rows affected") == 1) {
            String select_statement = "SELECT * FROM users "
                    + "WHERE email = '"+request.getParameter("username")+"'";
            jdbc.setQuery(select_statement);
            query_results = jdbc.doTheThing();
            
            request.getSession().setAttribute("email", query_results.get("email"));
            request.getSession().setAttribute("pass", query_results.get("password"));
            request.getSession().setAttribute("user_id", query_results.get("id"));
            request.getSession().setAttribute("query_results", query_results);
        }
        
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
