/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs313.mealplanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "RecipeInfo", urlPatterns = {"/RecipeInfo"})
public class RecipeInfo extends HttpServlet {

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
        
         String uri = request.getParameter("r");
         ObjectMapper mapper = new ObjectMapper();
         Map<String, Object> map = mapper.readValue(
               uriBuilder.build().toURL(), Map.class
         );
         List list = (List)map.get("hits");
         
         for (Object item : list) {
            Map<String, Object> innerMap = (Map<String, Object>)item;               
            String jsonInString2 = mapper.writeValueAsString(innerMap.get("recipe"));
                    
            if (jsonInString2.contains(uri)) {     
               Map<String, Object> map2 = mapper.readValue(jsonInString2, Map.class);
               request.setAttribute("mealTitle", map2.get("label"));
               request.setAttribute("image", map2.get("image"));
               request.setAttribute("url", map2.get("sourceUrl"));
               List ingredient = (List) map2.get("ingredientLines");
               String ingredients = ingredient.toString();
               ingredients = ingredients.replace("[", "");
               ingredients = ingredients.replace("]", "");
               request.setAttribute("ingredientL", map2.get("ingredientLines"));
               request.setAttribute("ingredients", ingredients);
               request.setAttribute("calories", map2.get("calories"));
            }
         }
         request.setAttribute("q", request.getParameter("q"));
         request.setAttribute("from", request.getParameter("from"));
         request.setAttribute("to", request.getParameter("to"));
         
         request.getRequestDispatcher("recipe.jsp").forward(request, response);
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
