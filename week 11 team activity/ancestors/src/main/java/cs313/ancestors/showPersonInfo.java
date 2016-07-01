/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs313.ancestors;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nathanulmer
 */
@WebServlet(name = "showPersonInfo", urlPatterns = {"/showPersonInfo"})
public class showPersonInfo extends HttpServlet {

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
            out.println("<title>person info</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Personal Info:</h1>");
            out.println(request.getSession().getAttribute("personal_info"));
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
        Map ancestors = (Map)(request.getSession().getAttribute("ancestors"));
        String my_name = request.getParameter("name");
        String my_dob = (String)(((Map)(ancestors.get(my_name))).get("dob"));
        int my_id = Integer.parseInt((String)(((Map)(ancestors.get(my_name))).get("id")));
        String my_children = "";
        String my_parents = "";
        
                
        JDBC_Query jdbc = new JDBC_Query();
        jdbc.setQueryString("SELECT * FROM child_of");
        Map r = jdbc.execute_query();
        for (int i = 0; i < r.size(); i++) {
            int c = Integer.parseInt((String)(((Map)(r.get(i))).get("child_id")));
            int p = Integer.parseInt((String)(((Map)(r.get(i))).get("parent_id")));
            if (c == my_id) {
                my_parents += getName(p, ancestors)+"<br/>";
            } else if (p == my_id) {
                my_children += getName(c, ancestors)+"<br/>";
            }
        }
        
        
        String personal_info = "<p>Name: "+my_name+"<br>Birthdate: "+my_dob+"</p>"
                + "<p>Children:<br>"+my_children+"</p><p>Parents:<br>"+my_parents+"</p>";
        request.getSession().setAttribute("personal_info", personal_info);       
        processRequest(request, response);
    }
    
    private String getName (int id, Map ancestors) {
        String str = null;
        for (String name : (Set<String>)(ancestors.keySet()) ) {
            int id_at_name = Integer.parseInt((String)(((Map)(ancestors.get(name))).get("id")));
            if ( id_at_name == id) {
                str = name;
                break;
            }
        }
        return str;
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
