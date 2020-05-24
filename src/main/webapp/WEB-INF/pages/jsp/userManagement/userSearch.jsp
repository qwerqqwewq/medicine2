<%--
  Created by IntelliJ IDEA.
  User: wei
  Date: 2020/5/24
  Time: 17:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title></title>
    <meta charset="utf-8">
    <script src="${pageContext.request.contextPath}/common/resource/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
    <style>
        body {
            background: rgb(238, 238, 238);
        }

        .box {
            background: rgb(250, 250, 250);
            width: 1550px;
            height: 754px;
            margin: 100px auto;
            border: 1px #ccc solid;
            border-radius: 3px;
            padding: 30px;

        }

        .box input {
            width: 190px;
            height: 30px;
            border: 1px #ccc solid;
            border-radius: 3px;
        }

        .box div {

        }



        .high_submit {
            margin-top: 20px;
            float: right;
            background-color: rgb(45, 147, 214);
            outline: none;
            color: white;
            border: 1px #ccc solid;
            border-radius: 5px;
        }

        .up {
            float: left;
            height: 100px;
        }

        .down {
            margin-top: 20px;
            width: 100%;
            height: 650px;
            overflow: auto;
            border: 1px #ccc solid;
        }
        .all-list {
            background: rgb(250,250,250);
            width: 1500px;
            height: 700px;
            margin: 30px auto;
            border: 1px #ccc solid;
            border-radius: 3px;
        }
        .table-box1{
            margin: 0 auto;
            width: 90%;
            border-bottom:1px #ccc solid;
            color:rgb(102,102,102);
            overflow: auto;
        }
        tr{
            border-bottom:1px #ccc solid;
        }
        .right {
            float: right;
            margin-top: 40px;
            height: 100px;
            width: 260px;



        }

        .right p {
            color: white;
            width: 72px;
            height: 32px;
            background-color: rgb(45, 147, 214);
            border: 1px #ccc;
            padding-left: 10px;
            line-height: 30px;
            border-radius: 1px;
            cursor: pointer;
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
    <div class="up">
        <form action="${pageContext.request.contextPath}/user_adminSearch.action">
        <div>

            <span>用户登陆名</span>
            <input type="text" name="userName">
        </div>
        <div>
            <input type="submit" value="查询" class="high_submit">
        </div>
        </form>
    </div>
    <div class="down">
        <div class="all-list">
            <table class="table-box1">
                <tr>
                    <th>ID</th>
                    <th>姓名</th>
                    <th>用户登陆名</th>
                    <th>密码</th>
                    <th>权限等级</th>
                    <th>权限操作</th>
                    <th>其他操作</th>
                </tr>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.id}</td>
                        <td>${user.name}</td>
                        <td>${user.username}</td>
                        <td>${user.password}</td>
                        <td>${user.powerByPowerId.power}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/user_setPower.action?UserId=${user.id}" onclick="javascript:return warring()">修改权限</a>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/user_reset.action?UserId=${user.id}">重置密码</a>
                            <a href="${pageContext.request.contextPath}/user_delete.action?UserId=${user.id}">删除用户</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </div>
    <div class="right">
        <p>添加用户</p>
    </div>

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
    function warring(){
        if(confirm('确定要修改吗')==true){
            return true;
        }else{
            return false;
        }
    }
    $(function() {
        $(".nav>li>a").click(function() {
            $(this).siblings("ul").stop().slideToggle(200);
        })
        $(".box1").children("span").click(function() {
            $(".down1").stop().slideToggle(200);
        })
        $(".right").click(function() {
            window.location.href = "${pageContext.request.contextPath}/user_adminAdd.action";
        })
    })
</script>
</body>
</html>
