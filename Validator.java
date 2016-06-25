/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import entity.Customer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.CustomerResources;

/**
 *
 * @author eric
 */
@ServletSecurity(
    @HttpConstraint(transportGuarantee = ServletSecurity.TransportGuarantee.CONFIDENTIAL)
)
public class Validator extends HttpServlet {
    CustomerResources account = new CustomerResources();
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userPath = request.getServletPath();
        System.out.println("in validator get: "+userPath);
        
        if (userPath.equals("/userLogout")){
            //System.out.println("managed by /userLogout");
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            response.sendRedirect("/BookStore/index.jsp");
            //System.out.println("userName" + request.getParameter("userName"));
            //Customer customer = account.find_JSON(Customer.class, request.getParameter("userName"));
            //System.out.println("customer: " + customer.getUserName() + " already exists");
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
        System.out.println("In Validator post...........");
        String userPath = request.getServletPath();
        if(userPath.equals("/userLogin")){
            String userName = request.getParameter("userName");
            String ps = request.getParameter("password");
            String destination = "";
            if(response.getStatus() == 200){
                Customer customer = account.find_JSON(Customer.class, userName);
                if(customer == null || !customer.getPs().equals(ps)){
                    destination = "/BookStore/loginFailed";
                }else{
                    HttpSession session = request.getSession();
                    session.setAttribute("customer", customer);
                    destination = "/BookStore/profile";
                }
            }else{
                //to do loginFail.jsp
                destination = "/BookStore/loginFailed";
            }
            System.out.println("redirected to destination: " + destination);
            response.sendRedirect(destination);
        }
        //processRequest(request, response);
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
