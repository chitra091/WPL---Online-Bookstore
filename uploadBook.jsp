<%-- 
    Document   : uploadBook
    Created on : Nov 30, 2015, 11:05:47 PM
    Author     : eric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>UPLOADBOOK</title>
    </head>
    <body>
        <div class="container">
              <div id="login-overlay" class="modal-dialog">
      <div class="modal-content">
          <div class="modal-header">
              <h4 class="modal-title" id="myModalLabel">Book for Sale</h4>
              <p>Enter Book details for Sale or go back to our <a href="./index.jsp">main site</a>.</p>
            </div>
          
            <div class="modal-body">
              
            
                <form id="registerForm" method="POST" action="books">
<!---form--->  <div class="form-group">
<!---input width--->    <div class="col-xs-6">
                        <label for="InputName">Author First Name</label>
                        <div class="input-group">
                        <input type="text" class="form-control" name="firstName" placeholder="Enter Author First Name" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                        <br>
                        <label for="InputTitle">Book Title</label>
                        <div class="input-group">
                        <input type="text" class="form-control" name="title" placeholder="Enter Book Title" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
<!--------------------------------------separator---------------------------------------------------------------> <hr>
                </div>
                </div>
                    <div class="form-group">
                    <div class="col-xs-6">

                        <label for="InputName">Author Last Name</label>
                        <div class="input-group">
                        <input type="text" class="form-control" name="lastName" placeholder="Enter Author Last Name" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
                    
                        <br>
                        <label for="InputPassword">Book ISBN</label>
                        <div class="input-group">
                        <input type="text" class="form-control" name="isbn" placeholder="Enter ISBN" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
<!--------------------------------------separator---------------------------------------------------------------> <hr>
                </div>       
                </div> 
                
                    <div class="form-group"> 
                        <div class="col-xs-12">
                        <label for="Publisher">Enter Publisher</label>
                        <div class="input-group">
                        <input type="text" class="form-control" name="publisher" placeholder="Enter Publisher" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
<!----------------------------break-------------------------------------------------------------> <br>
                     </div>
                 </div>

                        <div class="form-group">
                        <div class="col-xs-12">
                        <label for="Date">Enter Publish Date</label>
                        <div class="input-group">
                        <input type="text" class="form-control" name="publishDate" placeholder="Enter Publish Date" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                        </div>
<!----------------------------break-------------------------------------------------------------> <br> 
                    </div>                     
                </div>
             
                        <div class="form-group">
                        <div class="col-xs-12">
                        <label for="Category">Category</label>
                        <div class="input-group">
                        <input type="text" class="form-control" name="category" placeholder="Enter Category" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span>
                    </div>
<!----------------------------break-------------------------------------------------------------> <br> 
                    </div>
                    </div>

                        <div class="form-group">
                        <div class="col-xs-12">
                        <label for="Quantity">Quantity</label>
                        <div class="input-group">
                        <input type="number" class="form-control" name="quantity" placeholder="Enter Quantity" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span> 
                        </div>
<!----------------------------break-------------------------------------------------------------> <br>                     
                   </div>
                </div>
                        <div class="form-group">
                        <div class="col-xs-12">
                        <label for="Link">Book Picture Link</label>
                        <div class="input-group">
                        <input type="text" class="form-control" name="href" placeholder="Enter Book Picture Link" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span> 
                        </div>
<!----------------------------break-------------------------------------------------------------> <br>                     
                   </div>
                </div>
                <div class="form-group">
                        <div class="col-xs-12">
                        <label for="Price">Sell Price</label>
                        <div class="input-group">
                        <input type="number" class="form-control" name="price" placeholder="Enter Sell Price" required>
                        <span class="input-group-addon"><span class="glyphicon glyphicon-asterisk"></span></span> 
                        </div>
<!----------------------------break-------------------------------------------------------------> <br>                     
                   </div>
                </div>

                  <div class="form-group">
                  <div class="input-group-addon">
                  <input type="submit" name="submit" id="submit" value="Submit" class="btn btn-success pull-right">
                  
                  </div>
                </div>
                </form>
              </div><!---modal-body--->
          </div>
       </div>

        </div>
    </body>
</html>
