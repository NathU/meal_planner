/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs313.mealplanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.UriBuilder;

/**
 *
 * @author Rafael
 */
@WebServlet(name = "search", urlPatterns = {"/search"})
public class search extends HttpServlet {

   private static final String APPKEY = "a7e0b3a4d8c5e1216df450b43fa4539a";
   private static final String APPID = "85eb3545";
   private static final String APIURL ="https://api.edamam.com/search";
   
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
      UriBuilder uriBuilder = UriBuilder.fromUri(APIURL).
            queryParam("app_id", APPID).
            queryParam("app_key", APPKEY).
            queryParam("q", request.getParameter("q")).
            queryParam("from", request.getParameter("from")).
            queryParam("to", request.getParameter("to"));
        
      Map<String, Object> map = new ObjectMapper().readValue(uriBuilder.build().toURL(), Map.class);
        
      List recipes = (List) map.get("hits");
      request.setAttribute("hits", recipes);
      request.setAttribute("q", request.getParameter("q"));
      request.setAttribute("prevFrom", (Integer.parseInt(request.getParameter("from")) - 5));
      request.setAttribute("prevTo", (Integer.parseInt(request.getParameter("to")) - 5));
      request.setAttribute("nextFrom", request.getParameter("to"));
      request.setAttribute("nextTo", (Integer.parseInt(request.getParameter("to")) + 5));
      request.setAttribute("count", map.get("count"));
      request.getRequestDispatcher("recipe_search.jsp").forward(request, response);
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
