<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body{
            background-image: url(${pageContext.request.contextPath}/images/m11.jpg);
            background-attachment: fixed;
            background-repeat: no-repeat;
            background-size: 100% 100%;
        }
        .all {
            background: rgb(250,250,250);
            width: 500px;
            height: 400px;
            margin: 100px auto;
            border: 1px #ccc solid;
            border-radius: 3px;
        }

        .input {
            height: 40px;
            width: 420px;
            margin-left: 30px;
            border-radius: 5px;
            outline: none;
            border: 1px #ccc solid;
            padding-left: 10px;
        }

        h1 {
            text-align: center;
        }

        span {
            margin-left: 30px;
            color: rgb(173, 159, 159);
        }

        .all div {
            margin-top: 20px;
        }

        .submit {
            color: white;
            background-color: rgb(45, 147, 214);
            width: 70px;
            height: 40px;
            outline: none;
            border: 1px #ccc solid;
            border-radius: 5px;
            float: right;
            margin-right: 37px;
        }

        .register {
            height: 40px;
            line-height: 40px;
            float: left;
            margin-left: 33px;
            text-decoration: none;
            color: black;
        }

        .register:hover {
            color: rgb(45, 147, 214);
            font-size: 20px;
        }
        h1{
            margin-top: 125px;
        }
        .back {
            position: absolute;
            top: 120px;
            left: 230px;
            cursor: pointer;
        }

        .back p {
            width: 50px;
            height: 30px;
            border: 2px #000000 solid;
            padding-left: 10px;
            line-height: 30px;
        }
    </style>
</head>

<body>
<div>
    <h1>密码修改</h1>
</div>
<form action="${pageContext.request.contextPath}/user_changePassword.action">
<div class="all">
    <div>
        <span>请输入当前密码</span>
    </div>
    <div>
        <input type="text" class="input" placeholder="请输入当前密码..." name="pwd">
    </div>
    <div>
        <span>请输入新密码</span>
    </div>
    <div>
        <input type="password" class="input" placeholder="请输入新密码..." name="npwd">
    </div>
    <div>
        <span>再次输入新密码</span>
    </div>
    <div>
        <input type="text" class="input" placeholder="再次输入新密码..." name="tpwd">
    </div>
    <div>
        <input type="submit" value="提交" class="submit">
    </div>


</div>
</form>
<div class="back">
    <p onclick="javascript:history.back();">返回</p>
</div>
<%--<script>--%>
<%--    $(function() {--%>
<%--        $(".back").click(function() {--%>
<%--            window.location.href = "${pageContext.request.contextPath}/WEB-INF/pages/jsp/main.jsp";--%>
<%--        })--%>
<%--    })--%>
<%--</script>--%>

</body>
</html>
