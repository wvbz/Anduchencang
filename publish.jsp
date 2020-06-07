<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>发布项目</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

    <div id="apply">
    <h3 class="text-center text-white pt-5">发布项目</h3>
    <div class="container">
        <div id="publish-row" class="row justify-content-center align-items-center">
            <div id="publish-column" class="col-md-6">
                <div id="publish-box" class="col-md-12">
                    <form id="publish-form" class="form" action="PublishServlet" method="post">
                        <h3 class="text-center text-info">发布项目</h3>
                        <div class="form-group">
                            <label for="pro_name" class="text-info">项目名称：</label><br>
                            <input type="text" name="pro_name" id="pro_name" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="pro_type" class="text-info">项目类型：</label><br>
                            <input type="text" name="pro_type" id="pro_type" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="pro_place" class="text-info">项目地点：</label><br>
                            <input type="text" name="pro_place" id="pro_place" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="v_num" class="text-info">招募人数：</label><br>
                            <input type="text" name="v_num" id="v_num" class="form-control">
                        </div>
                        <div class="form-group custom-control-inline">
                            <label for="pro_s_time" class="text-info">开始日期：</label>
                            <input type="text" name="pro_s_time" id="pro_s_time" class="form-control col-md-4">&nbsp;
                            <label for="pro_e_time" class="text-info">结束日期：</label>
                            <input type="text" name="pro_e_time" id="pro_e_time" class="form-control col-md-4">
                        </div>
                        <div class="form-group">
                            <label for="pro_intro" class="text-info">项目简介：</label><br>
                            <input type="text" name="pro_intro" id="pro_intro" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="pro_info" class="text-info">项目详情：</label><br>
                            <input type="text" name="pro_info" id="pro_info" class="form-control form-control-lg">
                        </div><br>
                        <div class="form-group">
                                <input type="submit" name="submit" class="btn btn-info btn-md pull-left" value="取消">
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                <input type="submit" name="submit" class="btn btn-info btn-md pull-right" value="确认提交">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>