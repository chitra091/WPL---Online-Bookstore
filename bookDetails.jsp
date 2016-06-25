<%-- 
    Document   : bookDetails
    Created on : Dec 1, 2015, 4:22:07 AM
    Author     : eric
--%>

<%@page import="entity.Books"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Books book = (Books)request.getSession().getAttribute("book"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title><%=book.getTitle()%></title>
		
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="css/bootstrap.min.css">

		<!-- Optional theme -->
		<link rel="stylesheet" href="css/bootstrap-theme.min.css">
                <script src="/BookStore/js/bookDetails.js"></script>
                <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
                <script src="//code.jquery.com/jquery-1.10.2.js"></script>
                <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	
	</head>
	<body>
	  <div class="container">
               <div class="col-md-2  toppad  pull-right col-md-offset-3 ">
               <A href="/BookStore/cart" style="margin-left: 2%;">My Shopping Cart</A>
               </div>
            <div class="row">
            <div class="col-md-9  toppad  pull-right col-md-offset-3 ">
                <br><br>
                <A href="/BookStore/showBooks" class="action" style="padding-right: 30px;" data-type="edit" >Continue Shopping</A>
               
                <br>               
            </div>
            <div class="col-xs-12 col-sm-12 col-md-6 col-lg-6 col-xs-offset-0 col-sm-offset-0 col-md-offset-3 col-lg-offset-3 toppad" >
                <div class="panel panel-info">
                <div class="panel-heading">
                    <h3 class="panel-title">Magic Online Book Store</h3>
                </div>
                <div class="panel-body">
                    <div class="row">
                        <div class="col-md-3 col-lg-3 " align="center"> <img alt="Book Pic" id="href" src="<%=book.getHref() %>" class="img-circle img-responsive"> </div>
                            <div class=" col-md-9 col-lg-9 "> 
                                <table class="table table-user-information">
                                    <tbody>
                                        <tr>
                                            <td>BookName:</td>
                                            <td id="title"><%=book.getTitle() %></td>
                                        </tr>
                                        <tr>
                                            <td>ISBN:</td>
                                            <td class="preview" id="isbn"><%=book.getBooksPK().getIsbn() %></td>                                           
                                        </tr>
                                        <tr>
                                          <td>Author:</td>
                                          <td class="preview" id="StreetPreview"><%=book.getFirstName()+" "+book.getLastName() %></td>                                                                                 
                                        </tr>                 
                                        <tr>
                                        <tr>
                                            <td>Publisher:</td>
                                            <td class="preview" id="CityPreview"><%=book.getPublisher() %></td>                                           
                                        </tr>
                                        <tr>
                                            <td>Price:</td>
                                             <td class="preview" id="price"><%=book.getPrice() %></td>                                            
                                        </tr>                                      
                                    </tbody>
                                </table>
                               <div id="dialog" title="Dialog Title">Item Has been added to Cart</div>
                                        <label>Qty: </label>
                                        <input type="number" id="qty"/>
                                        <button type="submit" id="addToCart" class="btn btn-success">Add to Cart</button>
                            </div>
                        
                    </div>
                </div>
                        
                </div>
            </div>
        </div>
      </div>

	</body>
</html>
