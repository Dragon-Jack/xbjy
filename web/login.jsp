<%--
  Created by IntelliJ IDEA.
  User: FTKJ
  Date: 2019/10/17
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="lib/css/bootstrap.min.css">
    <script src="lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
</head>
<style>
    #all {
        width: 30%;
        height: 43%;
        margin-top: 10%;
        padding: 3%;
        box-shadow: 5px 5px;
        background-image: url("http://img.zcool.cn/community/03874df5954bcfda8012193a3893bcc.jpg");
    }

</style>
<body>
<div class="container" id="all">
    <%--账号--%>
    <div class="input-group">
        <span class="input-group-addon">账号</span>
        <input name="account" id="account" type="text" class="form-control" placeholder="账号"
               aria-describedby="basic-addon1">
    </div>
    <br>
    <%--密码--%>
    <div class="input-group">
        <span class="input-group-addon">密码</span>
        <input name="pw" id="pw" type="password" class="form-control" placeholder="密码"
               aria-describedby="basic-addon1">
    </div>
    <br>
    <%--图片验证--%>
    <div class="input-group">
        <%--文本框--%>
        <div class="col-sm-9">
            <input id="pic" name="pic" type="text" class="form-control" placeholder="图片验证"
                   aria-describedby="basic-addon1">
        </div>
        <%--图片--%>
        <div class="col-sm-3">
            <img id="yzm_img" name="yzm_img" onclick="pic()" src="/pic"
                 style="cursor:pointer;width: 100px;height: 34px;margin: 0;border-radius: 3px;"/>
        </div>
    </div>
    <br>
    <%--错误提示--%>
    <span id="s"></span>
        <br><br>
        <%--功能按钮区--%>
        <div class="input-group">
            <div class="col-sm-6">
            <input id="free" value="1" type="checkbox" aria-describedby="basic-addon1"><b> 自动登录</b>
            </div>
            <div class="col-sm-6">
                <input value="1" type="checkbox" aria-describedby="basic-addon1"><b> 记住密码</b>
            </div>
        </div>
        <br>
    <%--按钮区--%>
    <div>
        <nav aria-label="...">
            <ul class="pager">
                <li class="previous"><a href="html/forgetpw.jsp"><span aria-hidden="true">&larr;</span> 忘记密码</a></li>
                <li><input type="button" class="btn btn-info" value="登录" onclick="login()"></li>
                <%--登录按钮--%>
                <li class="next"><a href="html/registered.jsp">注册账号 <span aria-hidden="true">&rarr;</span></a></li>
            </ul>
        </nav>

    </div>
</div>
</body>
<script>
    function pic() {
        document.getElementById("yzm_img").src = document.getElementById("yzm_img").src + "?nocache=" + new Date().getTime();
    }

    function login() {
        $.post({
            url: "/login",
            data: {account: $("#account").val(), pw: $("#pw").val(), pic: $("#pic").val(),free:$("#free").val()},
            dataType: "text",
            success: function (data) {
                if (data == "0") {
                    window.location.href = "html/main.jsp";
                } else if (data == "1") {
                    s.innerText = "密码不正确";
                    s.style.color = "red";
                } else if (data == "2") {
                    s.innerText = "验证码不正确";
                    s.style.color = "red";
                }
            }
        });
    }
</script>
</html>
