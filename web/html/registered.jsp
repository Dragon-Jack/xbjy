<%--
  Created by IntelliJ IDEA.
  User: 吖灬桀
  Date: 2019/10/24
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册账号</title>
    <link rel="stylesheet" href="../lib/css/bootstrap.min.css">
    <script src="../lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
</head>
<style>
    #all {
        width: 30%;
        height: 45%;
        margin-top: 10%;
        padding: 3%;
        box-shadow: 5px 5px;
        background-image: url("http://img.zcool.cn/community/03874df5954bcfda8012193a3893bcc.jpg");
    }
</style>
<body>
<div class="container" id="all">
    <form action="/reg" method="post">
    <%--姓名--%>
    <div class="input-group">
        <span class="input-group-addon">姓名</span>
        <input name="name" class="form-control" placeholder="输入2-5为中文"
               aria-describedby="basic-addon1" required pattern="^[\u4e00-\u9fa5]{2,5}$">
    </div>
        <br>
    <%--账号--%>
    <div class="input-group">
        <span class="input-group-addon">账号</span>
        <input name="account" class="form-control" placeholder="输入6-10位账号"
               aria-describedby="basic-addon1" required pattern="^[\d]{6,10}$">
    </div>
    <br>
        <%--密码--%>
        <div class="input-group">
            <span class="input-group-addon">密码</span>
            <input name="pw" type="password" class="form-control" placeholder="输入6-10位密码"
                   aria-describedby="basic-addon1" required pattern="^[\d]{6,10}$">
        </div>
        <br>
        <%--年龄--%>
        <div class="input-group">
            <span class="input-group-addon">年龄</span>
            <input name="age" class="form-control" placeholder="年龄"
                   aria-describedby="basic-addon1" required>
        </div>
        <br>
        <%--出生年月--%>
        <div class="input-group">
            <span class="input-group-addon">出生年月</span>
            <input name="born" type="date" class="form-control" placeholder="出生年月"
                   aria-describedby="basic-addon1" required>
        </div>
    <br>
    <%--错误提示--%>
    <span id="s"></span>
    <br>
    <%--按钮区--%>
    <div>
        <nav aria-label="...">
            <ul class="pager">
                <li class="previous"><a href="../login.jsp"><span aria-hidden="true">&larr;</span> 返回</a></li>
                <li><input type="submit" class="btn btn-success" value="注册"></li>
                <%--登录按钮--%>
            </ul>
        </nav>
    </div>
    </form>
</div>
</body>
</html>
