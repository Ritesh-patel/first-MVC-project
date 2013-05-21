/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.lab1.controller.book;
import com.lab1.controller.book_data;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ritz
 */
@WebServlet(name = "showBooks", urlPatterns = {"/showBooks"})
public class showBooks extends HttpServlet {

    //connection cn=new connection();
    //Connection con=null;
    //ResultSet rs;
    //PreparedStatement ps;
    //Statement st;
    book_data bd=new book_data();
    RequestDispatcher rd;
    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
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
        try {
            /* TODO output your page here. You may use following sample code. */
            /*out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet showBooks</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet showBooks at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
            doPost(request,response);
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {        
        //System.out.println();
        //System.out.println("got u....");
        
        ArrayList<book> list=new ArrayList<book>();
        list=bd.getList();
        if(list==null)
            System.out.println("null_list");
        
            //String str="got ya";
        request.setAttribute("book_Info", list);
        rd=request.getRequestDispatcher("/bookCart.jsp");
        rd.forward(request, response);
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
