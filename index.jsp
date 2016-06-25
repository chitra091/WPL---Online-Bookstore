<%-- 
    Document   : index2
    Created on : Dec 4, 2015, 2:12:50 PM
    Author     : Wei-Cheng
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" 
	pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
		<meta charset="UTF-8">
		<title>BookStore</title>
		<meta http-equiv="content-type" content="text/html; charset=utf-8"/>
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		<script src="/BookStore/js/jquery.min.js"></script>
		<script src="/BookStore/js/skel.min.js"></script>
		<script src="/BookStore/js/skel-layers.min.js"></script>
		<script src="/BookStore/js/init.js"></script>
		<noscript>		
		</noscript>		
</head>
<body class="landing">
	
		<!-- Header -->
			<header id="header">
				<h1><a href="index.jsp"></a></h1>
				<nav id="nav">
					<ul>
						<li id="home"><a href="index.jsp">home</a></li>
						<li><a href="generic.jsp" id="userLink">user</a></li>
					</ul>
				</nav>
			</header>

		<!-- Banner -->
			<section id="banner">
				<h2>Find Book?</h2>
				<p>Best book selected by our exclusive authors and editors</p>
				<ul class="actions">
					<li>
						<a href="register" class="button big">register?</a>
						<a id ="loginButton" href="login" class="button big">Login</a>
                                                <a href="showBooks" class="button big">Browse</a>
                                                <a href="GoogleLogin" class="button big">GoogleLogin</a>
						<!--
                                                <div id=loginBlock>
							<form >
								<lable for="name"  class="fix">Name:</lable>
								<input type="text" name="name" id="name"/>
								<lable for="password"  class="fix">password:</lable>
								<input type="password" name="password" id="password"/>
								<input type="submit" name="login" id="login" value="login"/>
							</form>
						</div>
						-->	
							
					</li>
				</ul>
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