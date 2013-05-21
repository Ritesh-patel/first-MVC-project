/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.lab1.controller.addToCart;
import com.lab1.controller.book_data;
import com.lab1.controller.getBookName;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "addToCartServlet", urlPatterns = {"/addToCartServlet"})
public class addToCartServlet extends HttpServlet {
    
    book_data bd=new book_data();
    RequestDispatcher rd;
    static addToCart atc=new addToCart();
    getBookName gbn=new getBookName();
    
    
    

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
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addToCartServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addToCartServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            throws ServletException, IOException 
    {         
        List<Long> isbn=new ArrayList<Long>();        
        List<Integer> qty=new ArrayList<Integer>();
        isbn=atc.getIsbn();
        qty=atc.getQty();
        List<String> bookName= new ArrayList<String>();
        try 
        {
            bookName=gbn.getName(isbn);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(addToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        long amount=gbn.getAmount(isbn, qty);
        
        request.setAttribute("amount", amount);
        request.setAttribute("isbn", isbn);
        request.setAttribute("qty", qty);
        request.setAttribute("bookName", bookName);
        
        
        rd=request.getRequestDispatcher("/checkOut.jsp");
        rd.forward(request, response);
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
            String str = request.getParameter("add");
            //System.out.println(str);
            long isbn= Long.parseLong(str);
            //System.out.println(isbn);
            atc.acceptIsbn(isbn);
            //System.out.println("HEHEHE");
            try 
            {
                int a=atc.getQty(isbn);
                a--;
                atc.removeBook(a,isbn);
            } 
            catch (SQLException ex) 
            {
                Logger.getLogger(addToCartServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("showBooks");
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
