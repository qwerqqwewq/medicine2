
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title></title>
    <script src="${pageContext.request.contextPath}/common/resource/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
    <style>

        .box {
            background: rgb(250,250,250);
            width: 1000px;
            height: 550px;
            margin: 150px auto;
            border: 1px #ccc solid;
            border-radius: 3px;
        }

        h2 {
            text-align: center;
        }

        input {
            height: 40px;
            width: 288px;
            margin-top: 25px;
            margin-left: 30px;
            border-radius: 5px;
            outline: none;
            border: 1px #ccc solid;
            padding-left: 10px;
        }

        strong {
            font-size: 25px;
            margin-left: 20px;
        }

        .submit {
            color: white;
            background-color: rgb(45, 147, 214);
            height: 70px;
            width: 90%;
            margin: 40px auto;
            border: 1px #ccc solid;
            margin-top: 50px;
            margin-right: 0;
            padding-left: 0;
            margin-left: 50px;
        }

        .back {
            position: absolute;
            top: 20px;
            left: 100px;
            cursor: pointer;
        }

        .back p {
            width: 50px;
            height: 30px;
            border: 2px skyblue solid;
            padding-left: 10px;
            line-height: 30px;
        }
        .other{
            float: right;
            margin-right: 300px;
        }
        .other a{
            color: white;
            text-decoration: none;
            background-color: rgb(45, 147, 214);
            border: 1px #ccc solid;
            font-size: 20px;
        }
    </style>
</head>
<body>
<div class="box1">
    <h1>医药管理系统</h1>
    <label><img src="${pageContext.request.contextPath}/images/ing.png"></label>
    <span>${sessionScope.user.username}</span>
</div>

<div class="box">
    <form action="${pageContext.request.contextPath}/user_addUser.action" method="post">
    <div>
        <h2>添加用户信息</h2>
    </div>
    <div>
        <input type="text" placeholder="姓名" name="name">
    </div>
    <div>
        <input type="text" placeholder="用户登陆名" name="userName">
    </div>
    <div>
        <input type="text" placeholder="权限等级" name="powerId">
    </div>
    <div>
        <input type="text" placeholder="身份" name="position">
    </div>
    <div>
        <input type="text" placeholder="密码" name="pwd">
        <input type="text" placeholder="再次输入密码" name="tpwd">
    </div>
    <div class="down">
        <input type="submit" value="提交" class="submit">
    </div>
    </form>
</div>
<div class="down1">
    <div class="span">
        <span><a href="${pageContext.request.contextPath}/user_passwordPage.action">修改密码</a></span>
    </div>
    <div>
        <span><a href="${pageContext.request.contextPath}/user_exitLogin.action">退出登录</a></span>
    </div>
</div>

<script>
    $(function() {
        $(".nav>li>a").click(function() {
            $(this).siblings("ul").stop().slideToggle(200);
        })
        $(".box1").children("span").click(function() {
            $(".down1").stop().slideToggle(200);
        })

    })
</script>
</body>
</html>
