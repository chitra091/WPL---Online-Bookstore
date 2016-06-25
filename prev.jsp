<%-- 
    Document   : showBooks
    Created on : Nov 30, 2015, 11:37:55 PM
    Author     : eric
--%>

<%@page import="entity.Customer"%>
<%@page import="java.util.List"%>
<%@page import="entity.Books"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% List<Books> bookList =(List<Books>)request.getAttribute("bookList"); int index=3;
 int i=0; System.out.println("index in jsp" + session.getAttribute("index"));
 Object obj = session.getAttribute("index"); int value = Integer.parseInt(obj.toString()); System.out.println("value in jsp" + value); %>;
<%Customer customer = (Customer)request.getSession().getAttribute("customer"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Browsing Books</title>
    </head>
    
    <body>
        <div class="container">
            <div class="col-md-12  toppad  pull-right col-md-offset-5 ">
                <% if(customer == null){ %>
                    <A href="login" style="padding-right: 20px;">Login</A>
                    <A href="register" style="padding-right: 20px;">Register</A>
                    <% } else { %>
                    <label>Hi <%= customer.getUserName() %></label>
                    <A href="userLogout" >Logout</A>
                    <% } %>
                <br>
            </div>
        <div class="page-header">
            <h1 class="text-left"></h1>
            <form method="get" action="Search">
                <div class="control-group">
                <input type="search" name="searchtext" placeholder="Enter book category" />
                      <!-- Button -->
                        
                          <button class="btn btn-primary">Search</button>

                    </div>
            </form>
        </div>
  <div class="container" id="bookid">
      <%
       if((bookList.size() - value) > index) { %>
    <% for(i=0; i<index;i++){ %>
    <% int j=i%index; %>
    <% if(i%index==0){ %>
      <div class="row stylish-panel">
    <% } %>
        <div class="col-md-4" >
            <img src="<%= bookList.get(value).getHref() %>" alt="Book cover" class="img-rounded" width="200" height="200">
            <h2> <%= bookList.get(value).getCategory() %> </h2>
            <a href="bookDetails/?owner=<%=bookList.get(value).getBooksPK().getOwner() %>&isbn=<%=bookList.get(value).getBooksPK().getIsbn() %>" class="btn btn-primary" title="See more">Book Details</a>
        </div>
        <% if((j%index) == (index-1)){ %>
        </div> <br/>
        <% } 
        value++;
    }  }
    else{
        for(i=value; i<bookList.size();i++) {
        value++;
        int j=i%index; 
        if(i%index==0){ %>
        <div class="col-md-4" >
            <img src="<%= bookList.get(i).getHref() %>" alt="Book cover" class="img-rounded" width="200" height="200">
            <h2> <%= bookList.get(i).getCategory() %> </h2>
            <a href="bookDetails/?owner=<%=bookList.get(i).getBooksPK().getOwner() %>&isbn=<%=bookList.get(i).getBooksPK().getIsbn() %>" class="btn btn-primary" title="See more">Book Details</a>
        </div>
        <% if((j%index) == (index-1)){ %>
        </div> <br/>
        <% } 
    } }
}  session.setAttribute("index", value); %>
</div>
  </div>
      <div>
        <ul class="pager">
            <li <% if(value <= 3){ %> class="disabled" <% } %> ><a href="prev">Previous</a></li>
            <li <% if (value >= bookList.size()){ %> class="disabled" <% } %> ><a href="next">Next</a></li>
        </ul>
    </div>
</div>
<!-- /container -->
    </body>
</html>
