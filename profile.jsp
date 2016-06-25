<%-- 
    Document   : profile
    Created on : Nov 27, 2015, 2:35:50 AM
    Author     : eric
--%>

<%@page import="entity.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Customer customer = (Customer)request.getSession().getAttribute("customer"); %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/profile.css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="description" content="" />
	<meta name="keywords" content="" />
        <script src="/BookStore/js/jquery.min.js"></script>
        <script src="/BookStore/js/skel.min.js"></script>
        <script src="/BookStore/js/skel-layers.min.js"></script>
        <script src="/BookStore/js/init.js"></script>
        <script src="/BookStore/js/js-profile.js"></script>
        <title><%=customer.getUserName()%></title>
    </head>
   <body class="landing">
    <!-- Header -->
        <header id="header">
            <h1><a href="index.jsp"></a></h1>
            <nav id="nav">
                <ul>
                    <form id="home" class="logged" method="GET" action="com.bookstore.Loggedinhome">
                    </form>
                </ul>
            </nav>
        </header>

    <!-- Banner -->
        <section id="banner-profile">

                <h2>Hello <%=customer.getUserName()%>!</h2>

                <p>Welcome to your profile page</p>
                  <a href="showBooks" style="color:white;">Browse Books</a>
                   <a href="uploadBook" style="color:white;">Upload Books</a>
                   <a href="logout" style="color:white;">Logout</a>
                <ul class="actions">
                </ul>
        </section>

		<!-- One -->

        <section id="one" class="wrapper style1">
                <div class="container">
                        <header>
                                <section class="4u$ 12u$(small)">
                                        <i class="icon big rounded fa-user"></i>
                                        <h2><%=customer.getUserName()%></h2>
                                </section>												
                        </header>					
                </div>
                <div class="container">			
                        <form>
                            <lable for="email">Email:</lable>
                            <span class="preview" id="emailView"><%=customer.getEmail()%></span>
                            <input class="editable" type="text" name="email" id="email"  value=<%=customer.getEmail()%>></input>
                            <br/>
                            <br/>

                            <lable for="street">Street:</lable>
                            <span class="preview" id="streetView"><%=customer.getStreet()%></span>
                            <input class="editable" type="text" name="street" id="street"  value=<%=customer.getStreet()%>></input>
                            <br/>
                            <br/>

                            <lable for="city">City:</lable>
                            <span class="preview" id="cityView"><%=customer.getCity()%></span>
                            <input class="editable" type="text" name="city" id="city"  value=<%=customer.getCity()%>></input>
                            <br/>
                            <br/>

                            <lable for="zip">ZipCode:</lable>
                            <span class="preview" id="zipView"><%=customer.getZipcode()%></span>
                            <input class="editable" type="text" name="zip" id="zip"  value=<%=customer.getZipcode()%>></input>
                            <br/>
                            <br/>

                            <span class="action" data-mode="readyForEdit">[edit]</span>		
                        </form>
                </div>
        </section>		
		
		<!-- Footer -->

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
