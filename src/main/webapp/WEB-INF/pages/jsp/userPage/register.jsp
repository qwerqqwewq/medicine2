<%--
  Created by IntelliJ IDEA.
  User: wei
  Date: 2020/5/8
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title></title>
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
      height: 390px;
      margin: 180px auto;
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

    h2 {
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

    .login {
      height: 40px;
      line-height: 40px;
      float: left;
      margin-left: 33px;
      text-decoration: none;
      color: black;
    }

    .login:hover {
      color: rgb(45, 147, 214);
      font-size: 20px;
    }
  </style>
</head>
<body>
<div class="all">
  <div>
    <span>账号</span>
  </div>
  <form method="post" action="${pageContext.request.contextPath}/user_regist.action">
  <div>
    <input name="name" type="text" class="input" placeholder="请输入账号...">
  </div>
  <div>
    <span>密码</span>
  </div>
  <div>
    <input name="pwd" type="password" class="input" placeholder="请输入密码...">
  </div>
    <div>
      <span>再次输入密码</span>
    </div>
    <div>
      <input name="tpwd" type="password" class="input" placeholder="请再次输入密码...">
    </div>
  <div>
    <input type="submit" value="注册" class="submit">
    <a href="${pageContext.request.contextPath}/user_loginpage.action" class="login">返回</a>
  </div>
  </form>
</div>
</body>
</html>
