<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>待审核</title>
    <style>
table.dataintable {
  margin-top:15px;
  border-collapse:collapse;
  border:1px solid #aaa;
  width:100%;
}

table.dataintable th {
  vertical-align:baseline;
  padding:5px 15px 5px 6px;
  background-color:#66CCFF;
  border:1px solid #66CCFF;
  text-align:left;
  color:#fff;
}

table.dataintable td {
  vertical-align:text-top;
  padding:6px 15px 6px 6px;
  border:1px solid #aaa;
}

table.dataintable tr:nth-child(odd) {
  background-color:#F5F5F5;
}

table.dataintable tr:nth-child(even) {
  background-color:#fff;
}
    </style>
</head>
<body>
<div>
    <a style="margin-left:15px;margin-top:15px;color:gray">返回</a>
</div>
     <div>
         <h3 style="color:#66CCFF">待审核项目</h3>
         <form id="daishen_project" class="form" action="LoginServlet" method="post">
         <div style="margin-left:30px">
             <div>
                          <table class="dataintable" style="width:1150px">
                              <thead >
                              <tr>
                                  <th style="width:100px"> 序号</th>
                                  <th class="hidden-phone" style="width:700px">项目名称</th>
                                  <th></th>
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach var="Project" items="${ dsProject}" varStatus="status">
                              <tr>
                                  <td ><a href="" style="color:#707070;font-size:14px">${ status.index + 1}</a></td>
                                  <td style="font-size:14px" >${ Project.pro_name}</td>
                                  <td >
                                      <button name="examine" href="" style="width:70px;height:32px;background-color:#66CCFF;color:white;;border-radius:3px;border:1px solid #66CCFF">查看</button>
                                  </td>
                              </tr>
                              </c:forEach>
                              </tbody>
                          </table>
                      </div>
                 </div>
             </form>
     </div>
          <div>
         <h3 style="color:#66CCFF">待审核发布者</h3>
         <form id="daishen_volunteer" class="form" action="LoginServlet" method="post">
         <div style="margin-left:30px">
             <div>
                          <table class="dataintable" style="width:1150px">
                              <thead >
                              <tr>
                                  <th style="width:100px"> 序号</th>
                                  <th class="hidden-phone" style="width:700px">发布者名称</th>
                                  <th></th>
                              </tr>
                              </thead>
                              <tbody>
                              <c:forEach var="Publisher" items="${ dsPublisher}" varStatus="status">
                              <tr>
                                  <td ><a href="" style="color:#707070;font-size:14px">${ status.index + 1}</a></td>
                                  <td class="hidden-phone" style="font-size:14px" >${ Publisher.pub_name}</td>
                                  <td >
                                      <button name="examine" href="" style="width:70px;height:32px;background-color:#66CCFF;color:white;;border-radius:3px;border:1px solid #66CCFF">查看</button>
                                  </td>
                              </tr>
                              </c:forEach>
                              </tbody>
                          </table>
                      </div>
                 </div>
             </form>
     </div>

</body>
</html>