<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>发布者审核</title>
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
                 String pub_name = (String) request.getParameter("pub_name");
                 String pub_id = (String) request.getParameter("pub_id");
                 String pub_contact = (String) request.getParameter("pub_contact");
                 String pub_id_number = (String) request.getParameter("pub_id_number");
                    		%>
                  <form action="ShenheFabuzheServlet?pub_id=<%=pub_id %>" method="post">
		<!-- container -->
			<!-- header -->
			<div id="home" class="header" style="background-image:url(images/pic2.jpg)">
				<div class="container">
				<!-- top-hedader -->
			<div class="banner-info">
				<div class="col-md-7 header-right">
                     <h3 style="color:white">发布者审核</h3>
					<ul class="address">

					<li>
							<ul class="address-text">
								<li><b>用户名</b></li>
								<li ><%=pub_name %></li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>邮箱</b></li>
								<li id="pro_id"><%=pub_id %></li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>手机号 </b></li>
								<li><a><%=pub_contact %></a></li>
							</ul>
						</li>
						<li>
							<ul class="address-text">
								<li><b>身份证号 </b></li>
								<li><%=pub_id_number %></li>
							</ul>
						</li>
                    </ul>
                    <br/><br/>
                    <input type="button" style="font-size:20px;margin-left:50px;color:#FFFFFF;width:100px;height:40px;background-color:#C0C0C0;border-radius:5px;border:1px solid #C0C0C0" value="通过">
                    <input type="button" style="font-size:20px;margin-left:50px;color:#FFFFFF;width:100px;height:40px;background-color:#C0C0C0;border-radius:5px;border:1px solid #C0C0C0" value="不通过">
                    <input type="button" style="font-size:20px;margin-left:50px;color:#FFFFFF;width:100px;height:40px;background-color:#C0C0C0;border-radius:5px;border:1px solid #C0C0C0" value="返回">

                </div>
				<div class="col-md-5 header-left">
					<img src="images/pic8.jpg" alt="" style="margin-top:50px">
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

