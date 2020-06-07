<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>项目审核</title>
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
				<div class="container">
				<!-- top-hedader -->
			<div class="banner-info">
				<div class="col-md-7 header-right">
                     <h3 style="color:white">项目审核</h3>
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
								<li><b>时间 </b></li>
								<li><%=pro_s_time %>到<%=pro_e_time %></li>
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
                        <li>
							<ul class="address-text">
								<li><b>项目简介 </b></li>
								<li><a><%=pro_intro %></a></li>
							</ul>
						</li>
                        <li>
							<ul class="address-text">
								<li><b>项目资料 </b></li>
								<li><a><%=pro_info %></a></li>
							</ul>
						</li>

					</ul>
                    <br/><br/>
                    <input type="button" style="font-size:20px;margin-left:50px;color:#FFFFFF;width:100px;height:40px;background-color:#C0C0C0;border-radius:5px;border:1px solid #C0C0C0" value="通过">
                    <input type="button" style="font-size:20px;margin-left:50px;color:#FFFFFF;width:100px;height:40px;background-color:#C0C0C0;border-radius:5px;border:1px solid #C0C0C0" value="不通过">
                    <input type="button" style="font-size:20px;margin-left:50px;color:#FFFFFF;width:100px;height:40px;background-color:#C0C0C0;border-radius:5px;border:1px solid #C0C0C0" value="返回">

                </div>
				<div class="col-md-5 header-left">
					<img src="images/pic8.jpg" alt="" style="margin-top:150px">
				</div>
				<div class="clearfix"> </div>

		      </div>
			</div>
		</div>
	</div>


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

