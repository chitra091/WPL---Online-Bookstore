<%-- 
    Document   : register
    Created on : Nov 26, 2015, 10:18:25 PM
    Author     : eric
--%>

<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="" />
	<meta name="keywords" content="" />
        <script src="/BookStore/js/jquery.min.js"></script>
        <script type="text/javascript" src="/BookStore/js/formValidator.js"></script>        
	<script src="/BookStore/js/skel.min.js"></script>
	<script src="/BookStore/js/skel-layers.min.js"></script>
	<script src="/BookStore/js/init.js"></script>
        <title>REGISTRATION</title>
    </head>    
    <body class="landing">        
        <header id="header">
            <h1><a href="index.html"></a></h1>
		<nav id="nav">
                    <ul>
			<li id="home"><a href="index.jsp">home</a></li>
			<li><a href="generic.html" id="userLink">user</a></li>
                    </ul>
		</nav>
	</header>
        
        <!-- Banner -->
	<section id="banner-register">
            <h2>Reading</h2>
		<p>Make world better</p>
                <ul class="actions">
		</ul>
	</section>
        
        <section id="one" class="wrapper style1">
        <div class="container">
            <form class="form-horizontal" action='customers' method="POST">
                <fieldset>
                    <div id="legend">
                        <legend id="Register"><b>Register</b></legend>
                    </div>
                    <div class="control-group">
                      <!-- Username -->
                        <label class="control-label"  for="userName">Username</label>
                        <div class="controls">
                            <input type="text" id="userName" name="userName" placeholder="" class="input-xlarge">
                            <p class="help-block">Username can contain any letters or numbers, without spaces</p>
                        </div>
                    </div>

                    <div class="control-group">
                      <!-- E-mail -->
                        <label class="control-label" for="email">E-mail</label>
                        <div class="controls">
                            <input type="email" id="email" name="email" placeholder="" class="input-xlarge">
                            <p class="help-block">Please provide your E-mail</p>
                        </div>
                    </div>

                    <div class="control-group">
                        <!-- Password-->
                        <label class="control-label" for="password">Password</label>
                        <div class="controls">
                            <input type="password" id="password" name="password" placeholder="" class="input-xlarge">
                            <p class="help-block">Password should be at least 4 characters</p>
                        </div>
                    </div>
                    
                    <div class="control-group">
                        <!-- Password -->
                        <label class="control-label"  for="password_confirm">Password (Confirm)</label>
                        <div class="controls">
                          <input type="password" id="password_confirm" name="password_confirm" placeholder="" class="input-xlarge">
                          <p class="help-block">Please confirm password</p>
                        </div>
                    </div>

                    <div class="control-group">
                        <!-- Password -->
                        <label class="control-label"  for="street">Street</label>
                        <div class="controls">
                          <input type="text" id="street" name="street" placeholder="" class="input-xlarge">
                          <p class="help-block">Please provide Street Address</p>
                        </div>
                    </div>
                    
                    <div class="control-group">
                        <!-- Password -->
                        <label class="control-label"  for="city">City</label>
                        <div class="controls">
                          <input type="text" id="city" name="city" placeholder="" class="input-xlarge">
                          <p class="help-block">Please provide City Name</p>
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label"  for="zipcode">Zipcode</label>
                        <div class="controls">
                          <input type="text" id="zipcode" name="zipcode" placeholder="" class="input-xlarge">
                          <p class="help-block">Please provide Zipcode</p>
                        </div>
                    </div>
                     <div class="control-group">
                        <label class="control-label"  for="href">H-Link</label>
                        <div class="controls">
                          <input type="text" id="href" name="Href" placeholder="" class="input-xlarge">
                          <p class="help-block">Please provide Link for your Profile Picture</p>
                        </div>
                    </div>

                    <div class="control-group">
                      <!-- Button -->
                        <div class="controls">
                          <button class="btn btn-default">Register</button>
                        </div>
                    </div>
                </fieldset>
            </form>
        </div>
        </section>            
            
        <footer id="footer">
            <div class="container">
                    <div class="row">
                            <section class="4u 6u(medium) 12u$(small)">
                                    <h3>about us</h3>
                                    <p>We are group-5</p>
                                    <ul class="alt">															
                                    </ul>
                            </section>
                            <section class="4u 6u$(medium) 12u$(small)">
                                    <h3>Friendly links</h3>
                                    <p>Tenetur voluptate exercitationem eius tempora! Obcaecati suscipit, soluta earum blanditiis.</p>
                                    <ul class="alt">
                                            <li><a href="#">Lorem ipsum dolor sit amet.</a></li>
                                            <li><a href="#">Id inventore, qui necessitatibus sunt.</a></li>
                                            <li><a href="#">Deleniti eum odit nostrum eveniet.</a></li>
                                            <li><a href="#">Illum consectetur quibusdam eos corporis.</a></li>
                                    </ul>
                            </section>
                            <section class="4u$ 12u$(medium) 12u$(small)">
                                    <h3>Contact Us</h3>
                                    <ul class="icons">
                                            <li><a href="#" class="icon rounded fa-twitter"><span class="label">Twitter</span></a></li>
                                            <li><a href="#" class="icon rounded fa-facebook"><span class="label">Facebook</span></a></li>
                                            <li><a href="#" class="icon rounded fa-pinterest"><span class="label">Pinterest</span></a></li>
                                            <li><a href="#" class="icon rounded fa-google-plus"><span class="label">Google+</span></a></li>
                                            <li><a href="#" class="icon rounded fa-linkedin"><span class="label">LinkedIn</span></a></li>
                                    </ul>
                                    <ul class="tabular">
                                            <li>
                                                    <h3>Address</h3>
                                                    800 West Campbell Road<br>
                                                    Richardson, TX 75080-3021
                                            </li>
                                            <li>
                                                    <h3>Mail</h3>
                                                    <a href="#">someone@untitled.tld</a>
                                            </li>
                                            <li>
                                                    <h3>Phone</h3>
                                                    (000) 000-0000
                                            </li>
                                    </ul>
                            </section>
                    </div>
                    <ul class="copyright">
                            <li>&copy; Untitled. All rights reserved.</li>
                            <li>Design: <a href="http://templated.co">TEMPLATED + Group-5</a></li>
                            <li>Images: <a href="http://unsplash.com">Unsplash</a></li>
                    </ul>
            </div>
	</footer>
    </body>
</html>
