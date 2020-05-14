<%@ taglib prefix="c" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wei
  Date: 2020/5/8
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title></title>
  <meta charset="utf-8">
  <script src="${pageContext.request.contextPath }/common/resource/jquery.min.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" type="text/css">
</head>
<body>
<div class="box1">
  <h1>医药管理系统</h1>
  <label><img src="images/ing.png"></label>
  <span>名字</span>
</div>
<form method="post" action="main">
<div class="left">

  <ul class="nav">
    <li>
      <img src="images/m1.png" alt="#">
      <a href="javascript:;" class="m1">药品管理</a>
      <ul>
        <li class="med_search">查询药品</li>
        <li class="med_add">添加药品</li>
        <li>修改药品信息</li>
      </ul>
    </li>
    <li>
      <img src="images/m2.png" alt="#">
      <a href="javascript:;" class="m2">药品库存</a>
      <ul>
        <li class="stock_search">查询库存信息</li>
        <li>修改库存信息</li>
      </ul>
    </li>
    <li>
      <img src="images/m3.png" alt="#">
      <a href="javascript:;" class="m3">药品销售</a>
      <ul>
        <li>查询销售信息</li>
        <li>添加销售信息</li>
      </ul>
    </li>
    <li>
      <img src="images/m4.png" alt="#">
      <a href="javascript:;" class="m4">供应商</a>
      <ul>
        <li>查询供应商信息</li>
        <li>添加供应商信息</li>
      </ul>
    </li>
  </ul>

</div>
  <div class="right">

  </div>
  <div class="down">
    <div class="span">
      <span>个人中心</span>
    </div>
    <div>
      <span>退出登录</span>
    </div>
  </div>
</form>
<script>
  $(function() {
    $(".nav>li>a").click(function() {
      $(this).siblings("ul").stop().slideToggle(200);
    })
    $(".box1").children("span").click(function() {
      $(".down").stop().slideToggle(200);
    })
    $(".m1").click(function() {
      var flag = $(this).siblings("img").attr("src");
      if (flag == "images/m1.png") {
        $(this).siblings("img").attr("src", "images/m5.png");
      } else {
        $(this).siblings("img").attr("src", "images/m1.png");
      }
    })
    $(".m2").click(function() {
      var flag = $(this).siblings("img").attr("src");
      if (flag == "images/m2.png") {
        $(this).siblings("img").attr("src", "images/m6.png");
      } else {
        $(this).siblings("img").attr("src", "images/m2.png");
      }
    })
    $(".m3").click(function() {
      var flag = $(this).siblings("img").attr("src");
      if (flag == "images/m3.png") {
        $(this).siblings("img").attr("src", "images/m7.png");
      } else {
        $(this).siblings("img").attr("src", "images/m3.png");
      }
    })
    $(".m4").click(function() {
      var flag = $(this).siblings("img").attr("src");
      if (flag == "images/m4.png") {
        $(this).siblings("img").attr("src", "images/m8.png");
      } else {
        $(this).siblings("img").attr("src", "images/m4.png");
      }
    })
    $(".med_search").click(function() {
      window.location.href = "search.html";
    })
    $(".med_add").click(function() {
      window.location.href = "add.html";
    })
    $(".stock_search").click(function() {
      window.location.href = "StockSearch.html";
    })
  })
</script>
</body>
</html>
