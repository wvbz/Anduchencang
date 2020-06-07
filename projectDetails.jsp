<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>项目详情</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
 <!-- Custom Theme files -->
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <meta name="keywords" content="" />
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
	<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
			});
		</script>
 <!---- start-smoth-scrolling---->
</head>
	<body>
					<%
                 String pro_name = (String) request.getParameter("pro_name");
                 String pro_id = (String) request.getParameter("pro_id");
                 String type = (String) request.getParameter("type");
                 String pub_name = (String) request.getParameter("pub_name");
                 String pro_s_time = (String) request.getParameter("pro_s_time");
                 String pro_e_time = (String) request.getParameter("pro_e_time");
                 String place = (String) request.getParameter("place");
                 String v_num = (String) request.getParameter("v_num");
                 String pro_state = (String) request.getParameter("pro_state");
                 String pro_intro = (String) request.getParameter("pro_intro");
                 String pro_info = (String) request.getParameter("pro_info");

                    		%>
				<form action="ProjectDetaisServlet?pro_id=<%=pro_id %>" method="post">
		<!-- container -->
			<!-- header -->
			<div id="home" class="header">
				<a style="margin-left:15px;margin-top:15px;color:gray">返回</a>
				<div class="container">
				<!-- top-hedader -->
				<div class="top-header">
					<!-- /logo -->
					<!--top-nav---->
					<div class="top-nav">
					<div class="navigation">
					<div class="clearfix"></div>
				</div>
				<!-- /top-hedader -->
				</div>
			<div class="banner-info">
				<div class="col-md-7 header-right">

					<ul class="address">

					<li>
							<ul class="address-text">
								<li><b>项目名称</b></li>
								<li ><%=pro_name %></li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>项目编号</b></li>
								<li id="pro_id"><%=pro_id %></li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>项目类型 </b></li>
								<li><a><%=type %></a></li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>组织者名称 </b></li>
								<li><%=pub_name %></li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>时间 </b></li>
								<li><%=pro_s_time %>到<%=pro_e_time %></li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>地点 </b></li>
								<li><a> <%=place %></a></li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>招募人数 </b></li>
								<li><a><%=v_num %></a></li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>进行状态 </b></li>
								<li><a><%=pro_state %></a></li>
							</ul>
						</li>

					</ul>

				</div>
				<div class="col-md-5 header-left">
					<img src="images/pic9.jpg" alt="">
				</div>
				<div class="clearfix"> </div>

		      </div>
			</div>
		</div>
	</div>
			<!-- about -->
			<div id="about" class="about">
				<div class="col-md-6 about-left">
					<div id="owl-demo1" class="owl-carousel owl-carousel2">
					                <div class="item">
					                	<div class="about-left-grid">
											<h2>项目简介</h2>
											<p><%=pro_intro %></p>
											<ul>
												<li><a class="a-btn-a scroll" href="#port">报名</a></li>
												<li><a class="a-btn-h scroll" href="#contact">取消</a></li>
											</ul>
										</div>
					                </div>
						           <div class="item">
					                	<div class="about-left-grid">
											<h2>项目资料</h2>
											<p><%=pro_info %></p>
											<ul>
												<li><a class="a-btn-a scroll" href="#port">报名</a></li>
												<li><a class="a-btn-h scroll" href="#contact">取消</a></li>
											</ul>
										</div>
					                </div>
						   <div class="item">
					                	<div class="about-left-grid">
											<h2>项目培训</h2>
											<ul>
												<li><a class="a-btn-a scroll" href="#port">培训内容</a></li>
											</ul>
										</div>
					                </div>

					</div>
				</div>
				<div class="col-md-6 about-right">

				</div>
				<div class="clearfix"> </div>
							<link href="css/owl.carousel.css" rel="stylesheet">
							    <script src="js/owl.carousel.js"></script>
			<script>
				$(document).ready(function() {
					$("#owl-demo1").owlCarousel({
						items : 1,
						lazyLoad : false,
						autoPlay : true,
						navigation : false,
						navigationText :  false,
						pagination : true,
					});
				});
			</script>
			<!-- Feedback -->
			<script>
				$(document).ready(function() {
					$("#owl-demo3").owlCarousel({
						items : 1,
						lazyLoad : false,
						autoPlay : true,
						navigation : false,
						navigationText :  true,
						pagination :true,
					});
				});
			</script>
			</div>
			<!-- /about -->

		<!-- /container -->
<a href="#home" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
	<!--start-smooth-scrolling-->
						<script type="text/javascript">
									$(document).ready(function() {
										/*
										var defaults = {
								  			containerID: 'toTop', // fading element id
											containerHoverID: 'toTopHover', // fading element hover id
											scrollSpeed: 1200,
											easingType: 'linear'
								 		};
										*/

										$().UItoTop({ easingType: 'easeOutQuart' });

									});
								</script>
								<!--end-smooth-scrolling-->
<!-- //for bootstrap working -->
	<script src="js/bootstrap.js"></script>
</form>

	</body>
</html>

