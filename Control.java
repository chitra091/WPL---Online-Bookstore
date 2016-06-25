
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Books;
import entity.BooksPK;
import entity.Customer;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.annotation.ServletSecurity.TransportGuarantee;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import model.BookRescources;
import model.CustomerResources;

/**
 *
 * @author eric
 */
@ServletSecurity(
    @HttpConstraint(transportGuarantee = TransportGuarantee.CONFIDENTIAL)
)
public class Control extends HttpServlet {
    CustomerResources account = new CustomerResources();
    BookRescources book = new BookRescources();
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
        String userPath = request.getServletPath();
        System.out.println("GET path at the beginning: " + userPath);
        String jspName = "";
        if(userPath.equals("/register")){           
            jspName = userPath;
        }if(userPath.equals("/profile")){
            HttpSession session = request.getSession();
            session.setAttribute("index", 0);
            if(session.getAttribute("customer") == null){
                jspName = "/login";
            }else{
                jspName = userPath;
            }
        }else if(userPath.equals("/login")){
            jspName = userPath;
        }else if(userPath.equals("/showBooks")){
            //To test showBooks.jsp, comment out following two line about list
            //create a list of Books object and pass to request.setAttribute();
            GenericType<List<Books>> gType = new GenericType<List<Books>>() {};
            List<Books> bookList = (List<Books>)book.findAll_JSON(gType);
            HttpSession session = request.getSession(false);
            request.setAttribute("bookList",bookList);
            session.setAttribute("index", 0);
            jspName = userPath;
        }else if(userPath.equals("/next")){
            GenericType<List<Books>> gType = new GenericType<List<Books>>() {};
            List<Books> bookList = (List<Books>)book.findAll_JSON(gType);
            HttpSession session = request.getSession(false);
            request.setAttribute("bookList",bookList);
            //System.out.println("index in nxt" + session.getAttribute("index"));
            jspName = userPath;
        }else if(userPath.equals("/prev")){
            GenericType<List<Books>> gType = new GenericType<List<Books>>() {};
            List<Books> bookList = (List<Books>)book.findAll_JSON(gType);
            HttpSession session = request.getSession(false);
            request.setAttribute("bookList",bookList);
            int i = (int)session.getAttribute("index");
            if(i%3==0){
                i = i-6;
            }
            else if(i%3==1){
                i = i-4;
            }
            else{
                i = i-5;
            }
            session.setAttribute("index", i);
            System.out.println("index in prev " + session.getAttribute("index"));
            jspName = userPath;
        }else if(userPath.equals("/uploadBook")){
            jspName = userPath;
        }else if(userPath.equals("/bookDetails")){
            String owner = request.getParameter("owner");
            String isbn = request.getParameter("isbn");
            if(owner != null && isbn != null){
                Books returnBook = book.find_Book(Books.class,isbn, owner);
                HttpSession session = request.getSession();
                session.setAttribute("index", 0);
                session.setAttribute("book",returnBook);
            }
            jspName = "/bookDetails";
        }else if(userPath.equals("/customerExist")){
            jspName = userPath;
        }else if(userPath.equals("/loginFailed")){
            jspName = userPath;
        }else if(userPath.equals("/logout")){
            jspName  = userPath;
        }else if(userPath.equals("/Search")){
            GenericType<List<Books>> gType = new GenericType<List<Books>>() {};
            List<Books> bookList = (List<Books>)book.findAll_JSON(gType);
            List<Books> returnbooklist = new ArrayList<Books>();
            for(int i=0; i<bookList.size();i++){
                if(bookList.get(i).getCategory().equals(request.getParameter("searchtext"))){
                    returnbooklist.add(bookList.get(i));
                }
            }
            System.out.println("booklist" + returnbooklist);
            request.setAttribute("bookList",returnbooklist);
            HttpSession session = request.getSession(false);
            session.setAttribute("index", 0);
            jspName = userPath;
        }else if(userPath.equals("/cart")){
            //System.out.println("cart!");
            HttpSession session = request.getSession();
            if(session.getAttribute("customer")==null){
                response.sendRedirect("/BookStore/login");
                return;
            }
            else{
                jspName = userPath;            
            }
        }else if(userPath.equals("/checkOut")){
            request.getSession().setAttribute("cart",null);
            request.getSession().setAttribute("sum",null);
            jspName = userPath;
        }else{
            System.out.println("mapped, but not handled");
        }
        String url = "/WEB-INF/view" + jspName + ".jsp";
        System.out.println("redirect page to " + url);
        try {
            request.getRequestDispatcher(url).forward(request, response);
       } catch (Exception ex) {
         ex.printStackTrace();
        }
        //processRequest(request, response);
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
        String userPath = request.getServletPath();
        String url = "";
        System.out.println("In control post: userPath : " + userPath);
        //joking
        if(userPath.equals("/books")){
            HttpSession session = request.getSession();
            session.setAttribute("index", 0);
            Customer customer =  (Customer)session.getAttribute("customer");
            if(customer == null) System.out.println("in control:session is null");
            else{
               //System.out.println("customer session: " + customer.getUserName());
            }
            //System.out.println("customer session: " + customer.getUserName());
            BooksPK pk= new BooksPK(request.getParameter("isbn"),  customer.getUserName());
            Books newBook = new Books(
                request.getParameter("title"),
                request.getParameter("firstName"),
                request.getParameter("lastName"),
                request.getParameter("publisher"),
                Float.parseFloat(request.getParameter("price")),
                request.getParameter("publishdate"),
                request.getParameter("category"),
                Integer.parseInt(request.getParameter("quantity")),
                request.getParameter("href"),
                pk
            );
            //To test comment out  Books comebackBook = book.create_JSON(newBook,Books.class);
            //create a Books object pass to session.setAttribute();
            Books comebackBook = book.create_JSON(newBook,Books.class);
            
            session.setAttribute("book", comebackBook);
            session.setAttribute("index", 0);
            response.sendRedirect("/BookStore/bookDetails"); 
        }else if(userPath.equals("/customers")){
            Customer customer = new Customer(
                request.getParameter("userName"),
                request.getParameter("email"),
                request.getParameter("password"),
                request.getParameter("street"),
                request.getParameter("city"),
                request.getParameter("zipcode"),
                request.getParameter("Href")); 
            Customer comebackCustomer = account.create_JSON(customer,Customer.class);
            
            //To test,create a new Customer object and pass to session.setAttribute()
            //Set if condition to true to test on user profile.jsp
            if(comebackCustomer != null){
                HttpSession session = request.getSession();
                session.setAttribute("customer", comebackCustomer);
                session.setAttribute("index", 0);
                response.sendRedirect("/BookStore/profile");
            }else{
                //todo javascript
                response.sendRedirect("/BookStore/customerExist");
            }
        }else if(userPath.equals("/update")){
            Customer customer = new Customer(  
                request.getParameter("userName"),
                request.getParameter("email"),
                request.getParameter("password"),
                request.getParameter("street"),
                request.getParameter("city"),
                request.getParameter("zipcode"),
                request.getParameter("Href"));
           
            Customer comebackCustomer = account.create_JSON(customer,Customer.class);
             /*after return type specified commend the line out*/
            //Customer comebackCustomer = customer;
            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(comebackCustomer);
            HttpSession session = request.getSession();
            response.setContentType("text/plain");
            response.getWriter().write(jsonInString);
           
        }else if(userPath.equals("/addToCart")){
            HttpSession session = request.getSession();
            Books Record = new Books();          
            Record.setPrice(Float.parseFloat(request.getParameter("price")));
            Record.setHref(request.getParameter("href"));
            Record.setTitle(request.getParameter("title"));
            Record.setQuantity(Integer.parseInt(request.getParameter("qty")));
            if(session.getAttribute("customer")==null){
                response.sendRedirect("/BookStore/login");
                return;
            }
         
                if(session.getAttribute("cart") == null){
                    double sum = 0;
                    List<Books> bookList = new LinkedList<>();
                    sum += Record.getPrice()*Record.getQuantity();
                    bookList.add(Record);
                    session.setAttribute("sum",sum);
                    session.setAttribute("cart", bookList);
                }else{
                    boolean inList = false;
                    List<Books> tempList = (List<Books>) session.getAttribute("cart");
                    double oldSum = Double.parseDouble(session.getAttribute("sum").toString());
                    for(int i=0; i<tempList.size(); i++){
                        if(Record.getTitle().equals(tempList.get(i).getTitle())){
                            int newQty =  tempList.get(i).getQuantity() + Record.getQuantity();
                            tempList.get(i).setQuantity(newQty);
                            inList = true;
                        }
                    }
                    if(!inList){
                        tempList.add(Record);
                    }
                    double newSum = oldSum + Record.getPrice()*Record.getQuantity();
                    session.setAttribute("sum",newSum);                  
                }
           
            List<Books> tempList =(List<Books>)session.getAttribute("cart");
            System.out.println("servlet tempList: " + tempList.size());
            //response.sendRedirect("/BookStore/cart");
            //return;
        }else if(userPath.equals("/checkId")){
            String id = request.getParameter("id");
            Customer result = account.find_JSON(Customer.class, id);
            if(result == null){
               response.setStatus(response.SC_OK);
            }else{
               response.setStatus(response.SC_BAD_REQUEST);
            }
        }else if(userPath.equals("/updateQty")){
            //System.out.println("qty....");
            Double sum = 0.0;
            String[] updateArr =  request.getParameterValues("a[]");
            System.out.println("updateArr: " + updateArr.length);
            List<Books> bookList = (List<Books>)request.getSession().getAttribute("cart");
            for (int i = 0; i < updateArr.length; i++) {
                if(Integer.parseInt(updateArr[i]) == 0){
                    bookList.remove(i);
                }else{
                    bookList.get(i).setQuantity(Integer.parseInt(updateArr[i]));
                    sum += bookList.get(i).getPrice()*Integer.parseInt(updateArr[i]);
                }
            
                //System.out.println("book: " + bookList.get(i).getTitle());
            }
            request.getSession().setAttribute("sum", sum);
            
        }
        
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