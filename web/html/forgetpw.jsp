<%--
  Created by IntelliJ IDEA.
  User: 吖灬桀
  Date: 2019/10/24
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>找回密码</title>
    <link rel="stylesheet" href="../lib/css/bootstrap.min.css">
    <script src="../lib/jquery-3.4.1/jquery-3.4.1.min.js"></script>
</head>
<style>
    #all {
        width: 30%;
        height: 40%;
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
        <input name="account" id="account" class="form-control" placeholder="账号"
               aria-describedby="basic-addon1">
    </div>
    <br>
    <%--新密码--%>
    <div class="input-group">
        <span class="input-group-addon">新密码</span>
        <input name="pw" id="pw" type="password" class="form-control" placeholder="密码"
               aria-describedby="basic-addon1">
    </div>
    <br>
    <%--验证码--%>
    <div class="input-group">
        <span class="input-group-addon">验证码</span>
        <input name="verification" id="verification" class="form-control" placeholder="验证码"
               aria-describedby="basic-addon1">
    </div>
    <br>
    <%--邮箱--%>
    <div class="input-group">
        <div class="col-sm-9">
            <input name="email" id="email" class="form-control" placeholder="输入邮箱"
                   aria-describedby="basic-addon1" value="2625452312@qq.com">
        </div>
        <div class="col-sm-3"><input type="button" class="btn btn-info" value="获取验证码" onclick="Obtain()"></div>
    </div>
    <%--错误提示--%>
    <span id="s"></span>
    <br><br>
    <%--按钮区--%>
    <div>
        <nav aria-label="...">
            <ul class="pager">
                <li class="previous"><a href="../login.jsp"><span aria-hidden="true">&larr;</span> 返回</a></li>
                <li><input type="button" class="btn btn-success" value="修改" onclick="update()"></li>
            </ul>
        </nav>
    </div>
</div>
</body>
<script>
    function Obtain() {
        $.post({
            url: "/email",
            data: {email: $("#email").val()},
            dataType: "text",
            success: function (data) {
                if (data == "0") {
                    s.innerText = "发送成功";
                    s.style.color = "green";
                } else {
                    alert("发送失败");
                }
            }
        });
    }

    function update() {
        $.post({
            url: "/login/update",
            data: {account: $("#account").val(), pw: $("#pw").val(), verification: $("#verification").val()},
            dataType: "text",
            success: function (data) {
                if (data == "3") {
                    s.innerText = "验证码过期";
                    s.style.color = "red";
                } else
                if (data == "2") {
                    alert("修改成功，点击返回登录页面")
                    window.location.href = "../login.jsp";
                } else if (data == "1") {
                    s.innerText = "不能与旧密码一致";
                    s.style.color = "red";
                } else if (data == "0") {
                    s.innerText = "验证码错误";
                    s.style.color = "red";
                }
            }
        });
    }
</script>
</html>
