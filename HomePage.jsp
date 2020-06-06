<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%
<!DOCTYPE html>
<html lang="en">
	<head>
		<title>首页</title>
		<meta charset="utf-8">
		<meta name = "format-detection" content = "telephone=no" />
		<link rel="icon" href="images/favicon.ico">
		<link rel="shortcut icon" href="images/favicon.ico" />
		<link rel="stylesheet" href="css/owl.carousel.css">
		<link rel="stylesheet" href="css/slider.css">
		<link rel="stylesheet" href="css/style.css">
		<script src="js/jquery.js"></script>
		<script src="js/jquery-migrate-1.1.1.js"></script>
		<script src="js/script.js"></script>
		<script src="js/jquery.ui.totop.js"></script>
		<script src="js/superfish.js"></script>
		<script src="js/jquery.equalheights.js"></script>
		<script src="js/jquery.mobilemenu.js"></script>
		<script src="js/jquery.easing.1.3.js"></script>
		<script src="js/owl.carousel.js"></script>
		<script src="js/jquery.flexslider-min.js"></script>
		<script src="js/kwiks.js"></script>
		<script>
			$(document).ready(function(){
				$().UItoTop({ easingType: 'easeOutQuart' });
				var owl = $("#owl");
				owl.owlCarousel({
					items : 4, //10 items above 1000px browser width
					itemsDesktop : [995,3], //5 items between 1000px and 901px
					itemsDesktopSmall : [767, 2], // betweem 900px and 601px
					itemsTablet: [700, 2], //2 items between 600 and 0
					itemsMobile : [479, 1], // itemsMobile disabled - inherit from itemsTablet option
					navigation : true,
				});
			})
			var Main = Main || {};
			jQuery(window).load(function() {
				window.responsiveFlag = jQuery('#responsiveFlag').css('display');
				Main.gallery = new Gallery();
				jQuery(window).resize(function() {
					Main.gallery.update();
				});
			});
			function Gallery(){
				var self = this,
					container = jQuery('.flexslider'),
					clone = container.clone( false );
					this.init = function (){
						if( responsiveFlag == 'block' ){
						var slides = container.find('.slides');
						slides.kwicks({
							max : 500,
							spacing : 0
						}).find('li > a').click(function (){
							return false;
						});
						} else {
							container.flexslider();
						}
					}
					this.update = function () {
						var currentState = jQuery('#responsiveFlag').css('display');
						if(responsiveFlag != currentState) {
							responsiveFlag = currentState;
							container.replaceWith(clone);
							container = clone;
							clone = container.clone( false );
							this.init();
						}
					}
				this.init();
			}
		</script>
		<!--[if lt IE 8]>
		<div style=' clear: both; text-align:center; position: relative;'>
			<a href="http://windows.microsoft.com/en-US/internet-explorer/products/ie/home?ocid=ie6_countdown_bannercode">
				<img src="http://storage.ie6countdown.com/assets/100/images/banners/warning_bar_0000_us.jpg" border="0" height="42" width="820" alt="You are using an outdated browser. For a faster, safer browsing experience, upgrade for free today." />
			</a>
		</div>
		<![endif]-->
		<!--[if lt IE 9]>
		<script src="js/html5shiv.js"></script>
		<link rel="stylesheet" media="screen" href="css/ie.css">
		<![endif]-->
	</head>
	<body class="page1" id="top">
<!--==============================header=================================-->
		<header>
			<div class="clear"></div>
			<div class="container_12">
				<div class="grid_12">
					<h1>
						<a href="HomePage.jsp">
							<img src="images/logo.png" alt="Your Happy Family">
						</a>
					</h1>
					<div class="menu_block">
						<nav class="horizontal-nav full-width horizontalNav-notprocessed">
							<ul class="sf-menu">
								<li class="current"><a href="HomePage.jsp">首页</a>
									<ul>
										<li><a href="#">history</a></li>
										<li><a href="#">offers</a></li>
										<li><a href="#">news</a>
										<ul>
											<li><a href="#">fresh </a></li>
											<li><a href="#">archive</a></li>
										</ul>
									</ul>
								</li>
								<li><a href="index-1.jsp">志愿快讯</a></li>
								<li><a href="index-2.jsp">志愿项目</a></li>
								<li><a href="index-3.jsp">志愿团体</a></li>
								<li><a href="me.jsp">我的</a></li>
							</ul>
						</nav>
						<div class="clear"></div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</header>
		<div class="main">
<!--==============================Content=================================-->
			<div class="content">
				<div class="container_12">
					<div class="grid_8">
						<div class="flexslider">
							<ul class="slides">
								<li>
									<img src="images/page1_img1.jpg" alt="">
									<div class="flex-caption">
										<p>Hope</p>
									</div>
								</li>
								<li>
									<img src="images/page1_img2.jpg" alt="">
									<div class="flex-caption c2">
										<p>Volunteer</p>
									</div>
								</li>
								<li>
									<img src="images/page1_img3.jpg" alt="">
									<div class="flex-caption">
										<p>Love</p>
									</div>
								</li>
							</ul>
						</div>
						<span id="responsiveFlag"></span>
					</div>
					<div class="grid_4">
						<a href=" https://recruit.beijing2022.cn/index.do/" class="donate">冬奥会招募</a>
						<div class="text1">北京2022年冬奥会和冬残奥会赛会志愿者招募</div>
						<p>为深入践行“绿色、共享、开放、廉洁”的办奥理念，广泛汇聚海内外各界人士的力量，共同举办一届精彩、非凡、卓越的奥运盛会，自即日起，北京冬奥组委面向全球招募北京2022年冬奥会和冬残奥会赛会志愿者</p>
						赛会志愿者分为通用赛会志愿者、专业赛会志愿者两大类。其中，专业赛会志愿者是指具备赛会志愿服务所需要的专业知识、技能与经验，能提供专业化服务的赛会志愿者，包括但不限于：语言服务、医疗服务、驾驶服务等。专业赛会志愿者以外的其他志愿者均为通用赛会志愿者
					</div>
					<div class="clear"></div>
					<div class="grid_3">
						<div class="block2 maxheight">
							<div class="title">我们的使命</div>
							<div class="pad">
								为每一个需要提供渠道，为每一份爱心寻找契机。<br><br><div class="alright"><a href="#" class="btn">Read More</a></div>
							</div>
						</div>
					</div>
					<div class="grid_3">
						<div class="block2 maxheight">
							<div class="title">最新项目</div>
							<div class="pad">
								最近更新项目列表，点击“Read More”查看更多项目&具体信息<div class="alright"><a href="project.jsp" class="btn">Read More</a></div>
							</div>
						</div>
					</div>
					<div class="grid_3">
						<div class="block2 maxheight">
							<div class="title">志愿者</div>
							<div class="pad">
								查看个人信息、志愿项目<br><br><br> <div class="alright"><a href="me.jsp" class="btn">Read More</a></div>
							</div>
						</div>
					</div>
					<div class="grid_3">
						<div class="block2 maxheight">
							<div class="title">志愿团体</div>
							<div class="pad">查找志愿团体<br><br><br><div class="alright"><a href="index-3.jsp" class="btn">Read More</a></div></div>
						</div>
					</div>
					<div class="clear"></div>
					<div class="grid_12">
						<h2>You can help Them</h2>
						<div id="owl">
							<div class="item">
								<a href="#"><img src="images/page1_img4.jpg" alt="">Jim <br>
								8 years</a>
							</div>
							<div class="item it1">
								<a href="#"><img src="images/page1_img5.jpg" alt="">Ann <br>
								3 years</a>
							</div>
							<div class="item it2">
								<a href="#"><img src="images/page1_img6.jpg" alt="">Linda <br>
								5 years</a>
							</div>
							<div class="item it3">
								<a href="#"><img src="images/page1_img7.jpg" alt="">Mark  <br>
								6 years</a>
							</div>
							<div class="item">
								<a href="#"><img src="images/page1_img4.jpg" alt="">Jim <br>
								8 years</a>
							</div>
							<div class="item it1">
								<a href="#"><img src="images/page1_img5.jpg" alt="">Ann <br>
								3 years</a>
							</div>
							<div class="item it2">
								<a href="#"><img src="images/page1_img6.jpg" alt="">Linda <br>
								5 years</a>
							</div>
							<div class="item it3">
								<a href="#"><img src="images/page1_img7.jpg" alt="">Mark  <br>
								6 years</a>
							</div>
						</div>
					</div>
					<div class="grid_4">
						<h3 class="nowrap mb0">优秀志愿者</h3>
						<time class="st1" datetime="2013-01-01">05.03.2019</time>
						学雷锋志愿服务“四个100”先进典型“最美志愿者”叶如陵。叶如陵，1970年，29岁的中国医学科学院整形外科医院医生叶如陵随卫生部医疗队到西藏支援西藏医疗卫生事业。援藏原定期限是三年，可期满之后，他想像我们这样的人，北京太多，而西藏太少，西藏需要我们。
						<div class="alright"><a href="#" class="btn">Read More</a></div>
					</div>
					<div class="grid_7 prefix_1">
						<h3>关于我们</h3>
						<img src="images/page1_img8.jpg" alt="" class="img_inner fleft">
						<div class="extra_wrapper">
							<p>所有关于网站的问题，您可以免费联系我们 <span class="col1"></span>.</p>
							邮箱地址：17301128@bjtu.edu.cn <br> <br>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</div>
<!--==============================footer=================================-->
			<footer>
				<div class="hor bg3"></div>
				<div class="container_12">
					<div class="grid_12 ">
						<div class="socials">
							<a href="#"></a>
							<a href="#"></a>
							<a href="#"></a>
							<div class="clear"></div>
						</div>
						<div class="copy">
							&copy; Copyright &copy; 2020.Company name All rights reserved.
						</div>
					</div>
				</div>
			</footer>
		</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>