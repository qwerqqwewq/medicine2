<%--
  Created by IntelliJ IDEA.
  User: wei
  Date: 2020/5/20
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            background: rgb(238, 238, 238);
        }
        .big {
            width: 1500px;
            height: 750px;
            background: rgb(250, 250, 250);
            margin: 0 auto;
            margin-top: 70px;
            position: relative;
            border: 2px #ccc solid;
            border-radius: 5px;
        }

        .topleft,
        .topright {
            width: 652px;
            height: 25px;
            margin-top: 20px;
            background: rgb(45, 147, 214);
            float: left;
            margin-left: 70px;
            border: 1px #ccc solid;
            border-radius: 5px;
            text-align: center;
        }

        .left,
        .right {
            width: 650px;
            height: 500px;
            background: rgb(250, 250, 250);
            float: left;
            margin-left: 70px;
            border: 2px #ccc solid;
            border-radius: 5px;
        }

        .left>div {
            height: 60px;
            line-height: 80px;
        }

        .left span,
        .right span {
            margin-left: 40px;
        }

        .right>div {
            height: 60px;
            line-height: 80px;
            width: 100%;
        }

        .right input {
            width: 400px;
            height: 35px;
            float: right;
            margin-top: 24px;
            margin-right: 100px;
            outline: none;
            border: 1px #ccc solid;
            border-radius: 5px;
            padding-left: 10px;
        }

        .down {
            position: absolute;
            bottom: 30px;
            left: 0;
            width: 100%;
            height: 100px;
            background: rgb(250, 250, 250);
        }

        .down input {
            float: right;
            width: 100px;
            height: 40px;
            margin-top: 25px;
            margin-right: 60px;
            outline: none;
            border: 1px #ccc solid;
            border-radius: 5px;
            color: white;
            background-color: rgb(45, 147, 214);
        }
    </style>
</head>
<body>
<div class="big">
    <form action="${pageContext.request.contextPath}/kind_updateKind.action">
        <div class="topleft">
            <span>当前信息</span>
        </div>
        <div class="topright">
            <span>修改信息</span>
        </div>
        <div class="left">
            <c:forEach items="${kinds}" var="kind">
            <div>
                <span>药品类别编码</span>
                <span>${kind.kindCode}</span>
            </div>
            <div>
                <span>药品类别</span>
                <span>${kind.kindRemark}</span>
            </div>
            </c:forEach>

        </div>
        <div class="right">
            <c:forEach items="${kinds}" var="kind">
            <div>
                <span>类别编码</span>
                <input type="text" name="KindCode" value="${kind.kindCode}">
            </div>
            <div>
                <span>药品类别</span>
                <input type="text" name="KindRemark" value="${kind.kindRemark}">
            </div>
            </c:forEach>
        </div>
        <div class="down">
            <input type="submit" value="提交">
        </div>
    </form>
</div>
</body>
</html>
