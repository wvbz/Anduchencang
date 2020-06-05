<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册</title>
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
    <div id="register">
        <h3 class="text-center text-white pt-5">用户注册</h3>
        <div class="container">
            <div id="login-row" class="row justify-content-center align-items-center">
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" action="RegisterServlet" method="post">
                            <%
                                String errorMessage2 = (String)request.getAttribute("errorMessage2");

                                if(errorMessage2 == null){
                                errorMessage2 = "输入您的密码";
                                }
                            %>
                            <h3 class="text-center text-info">用户注册</h3>
                            <div class="form-group">
                                <label for="username" class="text-info">用户名</label>
                                    <input type="username" class="form-control" id="username">
                            </div>
                            <div class="form-group">
                                 <label for="email" class="text-info">邮箱</label>
                                    <input type="email" class="form-control" id="email">
                            </div>
                            <div class="form-group row">
                                    <label for="Password" class="text-info">密码</label>
                                        <input type="password" class="form-control" id="Password"placeholder=<%= errorMessage2%>>
                                </div>
                            <div class="form-group row">
                                    <label for="Password" class="text-info">确认密码</label>
                                        <input type="password" class="form-control" >
                                </div>
                            <div class="form-group row">
                                    <label for="phonenumber" class="text-info">手机号</label>
                                        <input type="phonenumber" class="form-control" id="phonenumber">
                                </div>
                            <div class="form-group row">
                                    <label for="IDnumber" class="text-info">身份证号</label>
                                    <input type="IDnumber" class="form-control" id="IDnumber" aria-describedby="IDHelp">
                                    <small id="IDHelp" class="form-text text-muted">仅用于实名认证，我们不会向任何人泄露您的个人信息</small>
                                </div>
                            <label>
                                    <input type="radio" name="RadioGroup1" value="1" /> 志愿者 </label>
                            <label>
                                        <input type="radio" name="RadioGroup1" value="2" /> 志愿组织 </label>
                            <label>
                                        <input type="radio" name="RadioGroup1" value="3" /> 管理员</label>

                    </div>
                            <button type="submit" class="btn btn-primary">确定</button>
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