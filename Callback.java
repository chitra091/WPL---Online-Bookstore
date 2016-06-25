/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
import com.google.common.collect.ImmutableMap;
import entity.Books;
import entity.Customer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import javax.servlet.annotation.HttpConstraint;
import javax.servlet.annotation.ServletSecurity;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import model.CustomerResources;
import org.json.simple.parser.ContainerFactory;
 

/**
 *
 * @author eric
 */
@ServletSecurity(
    @HttpConstraint(transportGuarantee = ServletSecurity.TransportGuarantee.CONFIDENTIAL)
)
public class Callback extends HttpServlet {
    CustomerResources account = new CustomerResources();
    private final String clientId = 
            "187999547494-buv3igh304e6s0tp4ssrqgsp35e9uqp9.apps.googleusercontent.com";
    
     private final String clientSecret = "jfnmq3dH6QgSa4hEGU1vsgEw";

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
         System.out.println("call back get called");
            if (request.getParameter("error") != null) {
                response.getWriter().println(request.getParameter("error"));
                return;
            }
    
   // google returns a code that can be exchanged for a access token
            String code = request.getParameter("code");
            String body = post("https://accounts.google.com/o/oauth2/token", ImmutableMap.<String,String>builder()
            .put("code", code)
            .put("client_id", clientId)
            .put("client_secret", clientSecret)
            .put("redirect_uri", "http://localhost:8080/BookStore/callback")
            .put("grant_type", "authorization_code").build());
            JSONObject jsonObject = null;
    
        // get the access token from json and request info from Google
        try {
         jsonObject = (JSONObject) new JSONParser().parse(body);
        } catch (ParseException e) {
         throw new RuntimeException("Unable to parse json " + body);
        }

        // google tokens expire after an hour, but since we requested offline access we can get a new token without user involvement via the refresh token
        String accessToken = (String) jsonObject.get("access_token");

        // you may want to store the access token in session
        request.getSession().setAttribute("access_token", accessToken);

        // get some info about the user with the access token
        String json = get(new StringBuilder("https://www.googleapis.com/oauth2/v1/userinfo?access_token=").append(accessToken).toString());

        // now we could store the email address in session
        
        // return the json of the user's basic info
        //response.getWriter().println(json);
        JSONParser parser = new JSONParser();
        String email=null;
        ContainerFactory containerFactory = new ContainerFactory(){
        public List creatArrayContainer() {
          return new LinkedList();
        }

        public Map createObjectContainer() {
          return new LinkedHashMap();
        }
        };     
        try {
          Map json1 = (Map)parser.parse(json, containerFactory);
          Iterator iter = json1.entrySet().iterator();
          while(iter.hasNext()){
            Map.Entry entry = (Map.Entry)iter.next();
            if(entry.getKey().equals("email")){
                email = (String) entry.getValue();
            }
          }
        }
        catch(ParseException e){
          System.out.println(e);
        }
        GenericType<List<Customer>> gType = new GenericType<List<Customer>>() {};
        List<Customer> custList = (List<Customer>)account.findAll_JSON(gType);
        boolean test = false;
        for(int i=0; i<custList.size();i++){
            if(custList.get(i).getEmail().equals(email)){
                HttpSession session = request.getSession();
                session.setAttribute("customer", custList.get(i));
                test = true;
                break;
            }
        }
        if(test == true){
            response.sendRedirect("/BookStore/profile");
        }
        else{
            response.sendRedirect("/BookStore/showBooks");
        }
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
            System.out.println("call back post called");
    }
    
    
    public String get(String url) throws ClientProtocolException, IOException {
        return execute(new HttpGet(url));
    }
    public String post(String url, Map<String,String> formParameters) throws ClientProtocolException, IOException { 
        HttpPost request = new HttpPost(url);
        List <NameValuePair> nvps = new ArrayList <NameValuePair>();
   
        for (String key : formParameters.keySet()) {
            nvps.add(new BasicNameValuePair(key, formParameters.get(key))); 
        }
 
        request.setEntity(new UrlEncodedFormEntity(nvps));
   
        return execute(request);
    }
    private String execute(HttpRequestBase request) throws ClientProtocolException, IOException {
        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse response = httpClient.execute(request);

        HttpEntity entity = response.getEntity();
           String body = EntityUtils.toString(entity);

        if (response.getStatusLine().getStatusCode() != 200) {
            throw new RuntimeException("Expected 200 but got " + response.getStatusLine().getStatusCode() + ", with body " + body);
        }

           return body;
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
