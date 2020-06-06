    <%@ page language="java" contentType="text/html; charset=UTF-8"
             pageEncoding="UTF-8"%>
    <!DOCTYPE html>
        <html lang="en">
        <head>
        <title>我的</title>
        <meta charset="utf-8">
        <meta name = "format-detection" content = "telephone=no" />
        <link rel="icon" href="images/favicon.ico">
        <link rel="shortcut icon" href="images/favicon.ico" />
        <link rel="stylesheet" href="css/form.css">
        <link rel="stylesheet" href="css/style.css">
        <script src="js/jquery.js"></script>
        <script src="js/jquery-migrate-1.1.1.js"></script>
        <script src="js/script.js"></script>
        <script src="js/jquery.ui.totop.js"></script>
        <script src="js/superfish.js"></script>
        <script src="js/jquery.equalheights.js"></script>
        <script src="js/jquery.mobilemenu.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/TMForm.js"></script>
        <script>
        $(document).ready(function(){
        $().UItoTop({ easingType: 'easeOutQuart' });
        })
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
        <body class="" id="top">
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
        <li>
        <a href="HomePage.jsp">首页</a>
        <ul>
        <li><a href="#">history</a></li>
        <li><a href="#">offers</a></li>
        <li>
        <a href="#">news</a>
        <ul>
        <li><a href="#">fresh </a></li>
        <li><a href="#">archive</a></li>
        </ul>
        </li>
        </ul>
        </li>
        <li><a href="index-1.jsp">志愿快讯 </a></li>
        <li><a href="index-2.jsp">志愿项目</a></li>
        <li><a href="index-3.jsp">志愿团队 </a></li>
        <li class="current"><a href="me.jsp">我的</a></li>
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




        <div class="content"><div class="ic"></div>
        <div class="container_12">
        <div class="grid_8">
        <h3>发布者信息</h3>
        <img src="images/PmePhoto.jpg" alt="" class="img_inner left">
        <form id="form">
        <div class="success_wrapper">
        <div class="success-message">Contact form submitted</div>
        </div>


        <table class="table table-bordered" >

            <%
                                    String pub_id
                                    Publisher pub=request.getAttribute("pub");
                                    %>

        <thead>

        <tr>
        <td width="100" height="45">
        <a style="color:black;font-size:16px">发布者名称:</a>
        </td>
        <td>
        <a id="pub_id" style="color:black;font-size:16px"><%=pub_id%></a>
        </td>
        </tr>

        <tr>
        <td width="100" height="45">
        <a style="color:black;font-size:16px">已发布项目:</a>
        </td>
        <td>
        <a id="pub" style="color:black;font-size:16px"><%=pub %></a>
        </td>
        </tr>




        </thead>


        </table>



        <div>
        <div class="clear"></div>
        <div class="btns">

        <a href="project.jsp" data-type="reset" class="btn">返回</a>
        </div>
        </div>

        </form>
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

