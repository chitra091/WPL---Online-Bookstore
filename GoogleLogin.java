/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eric
 */
@ServletSecurity(
    @HttpConstraint(transportGuarantee = ServletSecurity.TransportGuarantee.CONFIDENTIAL)
)
public class GoogleLogin extends HttpServlet {

    private final String clientId = 
            "187999547494-buv3igh304e6s0tp4ssrqgsp35e9uqp9.apps.googleusercontent.com";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StringBuilder oauthUrl = new StringBuilder().append("https://accounts.google.com/o/oauth2/auth")
            .append("?client_id=").append(clientId) // the client id from the api console registration
            .append("&response_type=code")
            .append("&scope=openid%20email") // scope is the api permissions we are requesting
            .append("&redirect_uri=http://localhost:8080/BookStore/callback") // the servlet that google redirects to after authorization
            .append("&state=")
            .append("&access_type=offline") // here we are asking to access to user's data while they are not signed in
            .append("&approval_prompt=force"); // this requires them to verify which account to use, if they are already signed in
        response.sendRedirect(oauthUrl.toString());
        
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
