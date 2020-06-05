<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
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
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
    <header>
    <div class="clear"></div>
    <div class="container_12">
        <div class="grid_12">
            <h1>
                <a href="HomePage.html">
                    <img src="images/logo.png" alt="Your Happy Family">
                </a>
            </h1>
            <div class="menu_block">
                <nav class="horizontal-nav full-width horizontalNav-notprocessed">
                    <ul class="sf-menu">
                        <li class="current"><a href="HomePage.html">首页</a>
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
                        <li><a href="index-1.html">志愿快讯</a></li>
                        <li><a href="index-2.html">志愿项目</a></li>
                        <li><a href="index-3.html">志愿团体</a></li>
                        <li><a href="index-4.html">我的</a></li>
                    </ul>
                </nav>
                <div class="clear"></div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</header>
    <div id="login">
        <h3 class="text-center text-white pt-5">用户登录</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="LoginServlet" method="post">
                            <h3 class="text-center text-info">用户登录</h3>
                            <div class="form-group">
                                <label for="username" class="text-info">用户名：</label><br>
                                <input type="text" name="username" id="username" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">密码：</label><br>
                                <input type="text" name="password" id="password" class="form-control">
                            </div>
                            <div class="form-group">
                                <label for="remember-me" class="text-info"><span>记住我</span> <span><input id="remember-me" name="remember-me" type="checkbox"></span></label><br>
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="确定">
                            </div>
                            <div id="register-link" class="text-right">
                                <a href="register.jsp" class="text-info">注册</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
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
                    &copy; Copyright &copy; 2020. All rights reserved.
                </div>
            </div>
        </div>
    </footer>
</body>
</html>