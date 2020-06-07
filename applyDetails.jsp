<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>报名详情</title>
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

    <div id="applyDetails">
    <h3 class="text-center text-white pt-5">报名志愿者信息</h3>
    <div class="container">
        <div id="login-row" class="row justify-content-center align-items-center">
            <div id="login-column" class="col-md-6">
                <div id="login-box" class="col-md-12">
                    <form id="login-form" class="form" action="ApplyServlet" method="post">
                        <h3 class="text-center text-info">报名志愿者信息</h3>
                        <div class="form-group">
                            <label  class="text-info">志愿者姓名：</label><br>
                            <div class="card  bg-light">
                                <div class="card-body">
                                    <%=applyDetails.name/%>
                                </div>
                        </div>
                        <div class="form-group">
                            <label  class="text-info">身份证号：</label><br>
                            <div class="card  bg-light">
                                <div class="card-body">
                                    <%=applyDetails.idnumber%>
                                </div>
                        </div>
                        <div class="form-group">
                            <label  class="text-info">手机号：</label><br>
                            <div class="card  bg-light">
                                <div class="card-body">
                                    <%=applyDetails.phone number%>
                                </div>
                        </div>
                        <div class="form-group">
                            <label  class="text-info">职业：</label><br>
                            <div class="card  bg-light">
                                <div class="card-body">
                                    <%=applyDetails.career%>
                                </div>
                        </div>
                        <div class="form-group">
                            <label  class="text-info">个人简介</label><br>
                            <div class="card  bg-light">
                                <div class="card-body">
                                    <%=applyDetails.registration_info%>
                                </div>
                        </div><br><br>
                        <div class="form-group">
                            <input type="submit" name="submit" class="btn btn-info btn-md pull-left" value="暂不通过">
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                            <input type="submit" name="submit" class="btn btn-info btn-md pull-right" value="通过申请">

                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>