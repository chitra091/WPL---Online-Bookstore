<%-- 
    Document   : login
    Created on : Nov 30, 2015, 11:03:51 PM
    Author     : eric
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/BookStore/css/login.css">
        <title>LOGIN</title>
    </head>
    <body>
        <div id="bg">
        <div class="container" style="margin-top:10%">
            <div class="col-md-3 col-md-offset-4">
              <div class="panel member_signin">
                <div class="panel-body">
                  <div class="fa_user">
                    <i class="fa fa-user"></i>
                  </div>
                  <p class="member">Member Login</p>
                  <form role="form" class="loginform" action="userLogin" method="POST">
                    <div class="form-group">
                      <label class="sr-only">Email address</label>
                      <div class="input-group">
                        <input type="text" class="form-control" id="userName" name="userName"
                          placeholder="Username">
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="sr-only">Password</label>
                      <div class="input-group">
                        <input type="password" class="form-control" id="password" name="password"
                          placeholder="Password">
                      </div>
                    </div>
                    <div class="controls">
                          <button id="login" class="btn btn-success" >LOGIN</button>
                        </div>                   
                  </form>
                  <p class="forgotpass"><a href="register" class="small">Register?</a></p>
                </div>
              </div>
            </div>
          </div>
        </div>
    </body>
</html>
