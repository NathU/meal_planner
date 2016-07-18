package Login;

import cs313.mealplanner.Kitchen;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "SignUp", urlPatterns = {"/SignUp"})
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
            int hf, hi, h = 0;
            hf = (fHeight != null && !fHeight.equals("")) ? Integer.parseInt(fHeight) : 0;
            hi = (iHeight != null && !iHeight.equals("")) ? Integer.parseInt(iHeight) : 0;
            h = (12 * hf) + hi;
            
            int w = (weight != null && !weight.equals(""))? Integer.parseInt(weight) : 0;
            int g = (goal != null && !goal.equals(""))? Integer.parseInt(goal) : 0;
            
            Map user_info = new HashMap();
            user_info.put("name", name);
            user_info.put("dob", dob);
            user_info.put("gender", gender);
            user_info.put("height", h);
            user_info.put("weight", w);
            user_info.put("activity", activity);
            user_info.put("goal", g);
            
            Kitchen kitchen = new Kitchen(); // use THIS for the live site on OpenShift
            //Kitchen kitchen = new Kitchen("root", ""); // for testing on my machine...
            int affected_rows = 0;
            affected_rows = kitchen.createNewAccount(email, password, user_info);
            

            if (affected_rows == 0 ) {
                response.sendRedirect("index.jsp");
            } else {
                Map profile_info = kitchen.getAccountInfo(email, password);
                request.getSession().setAttribute("profile_info", profile_info); // so we have mealplan_id in a session var
                request.getSession().setAttribute("email", email); //redundant, but that's ok.
                response.sendRedirect("view_week_plan");
                //tempFunc(request, response); // just for testing purposes again.
            }
    }
    
    protected void tempFunc(HttpServletRequest request, HttpServletResponse response)
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
            out.println("<h3> This is just to test the servlet and make sure stuff works... </h3> <hr/>");
            out.println("<p>All user profile info: <br/>" + request.getSession().getAttribute("profile_info") + "</p>");
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
