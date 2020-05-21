<%--
  Created by IntelliJ IDEA.
  User: wei
  Date: 2020/5/8
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>

<head>
  <meta charset="utf-8">
  <script src="${pageContext.request.contextPath}/common/resource/jquery.min.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
</head>

<body>
<div class="box1">
  <h1>医药管理系统</h1>
  <label><img src="${pageContext.request.contextPath}/images/ing.png"></label>
  <span>${sessionScope.user.username}</span>
</div>
<form method="post">
  <div class="left">
    <ul class="nav">
      <li>
        <img src="${pageContext.request.contextPath}/images/m1.png" alt="#">
        <a href="javascript:;" class="m1">药品管理</a>
        <ul>
          <li class="med_search">查询药品</li>
          <li class="med_add">添加药品</li>
          <li class="medClasses_search">药品类别查询</li>
          <li class="medClasses_add">药品类别添加</li>
        </ul>
      </li>
      <li>
        <img src="${pageContext.request.contextPath}/images/m2.png" alt="#">
        <a href="javascript:;" class="m2">药品库存</a>
        <ul>
          <li class="stock_search">查询库存信息</li>
          <li class="stock_add">添加库存信息</li>
        </ul>
      </li>
      <li>
        <img src="${pageContext.request.contextPath}/images/m3.png" alt="#">
        <a href="javascript:;" class="m3">药品销售</a>
        <ul>
          <li class="sale_search">查询销售信息</li>
          <li class="sale_add">添加销售信息</li>
        </ul>
      </li>
      <li>
        <img src="${pageContext.request.contextPath}/images/m4.png" alt="#">
        <a href="javascript:;" class="m4">供应商</a>
        <ul>
          <li class="supplier_search">查询供应商信息</li>
          <li class="supplier_add">添加供应商信息</li>
        </ul>
      </li>
    </ul>

  </div>
  <div class="right">

  </div>
  <div class="down1">
    <div class="span">
      <span><a href="${pageContext.request.contextPath}/user_passwordPage.action">修改密码</a></span>
    </div>
    <div>
      <span><a href="${pageContext.request.contextPath}/user_exitLogin.action">退出登录</a></span>
    </div>
  </div>
</form>
<script>
  $(function() {
    $(".nav>li>a").click(function() {
      $(this).siblings("ul").stop().slideToggle(200);
    })
    $(".box1").children("span").click(function() {
      $(".down1").stop().slideToggle(200);
    })
    $(".m1").click(function() {
      var flag = $(this).siblings("img").attr("src");
      if (flag == "images/m1.png") {
        $(this).siblings("img").attr("src", "${pageContext.request.contextPath}/images/m5.png");
      } else {
        $(this).siblings("img").attr("src", "${pageContext.request.contextPath}/images/m1.png");
      }
    })
    $(".m2").click(function() {
      var flag = $(this).siblings("img").attr("src");
      if (flag == "images/m2.png") {
        $(this).siblings("img").attr("src", "${pageContext.request.contextPath}/images/m6.png");
      } else {
        $(this).siblings("img").attr("src", "${pageContext.request.contextPath}/images/m2.png");
      }
    })
    $(".m3").click(function() {
      var flag = $(this).siblings("img").attr("src");
      if (flag == "images/m3.png") {
        $(this).siblings("img").attr("src", "${pageContext.request.contextPath}/images/m7.png");
      } else {
        $(this).siblings("img").attr("src", "${pageContext.request.contextPath}/images/m3.png");
      }
    })
    $(".m4").click(function() {
      var flag = $(this).siblings("img").attr("src");
      if (flag == "images/m4.png") {
        $(this).siblings("img").attr("src", "${pageContext.request.contextPath}/images/m8.png");
      } else {
        $(this).siblings("img").attr("src", "${pageContext.request.contextPath}/images/m4.png");
      }
    })
    $(".med_search").click(function() {
      window.location.href = "${pageContext.request.contextPath}/medicine_medicinePage.action";
    })
    $(".med_add").click(function() {
      window.location.href = "${pageContext.request.contextPath}/medicine_addPage.action";
    })
    $(".stock_search").click(function() {
      window.location.href = "${pageContext.request.contextPath}/stock_stockSearchPage.action";
    })
    $(".stock_add").click(function() {
      window.location.href = "${pageContext.request.contextPath}/stock_stockAddPage.action";
    })
    $(".sale_search").click(function() {
      window.location.href = "${pageContext.request.contextPath}/sale_saleSearchPage.action";
    })
    $(".sale_add").click(function() {
      window.location.href = "${pageContext.request.contextPath}/sale_saleAddPage.action";
    })
    $(".supplier_search").click(function() {
      window.location.href = "${pageContext.request.contextPath}/firm_firmSearchPage.action";
    })
    $(".supplier_add").click(function() {
      window.location.href = "${pageContext.request.contextPath}/firm_firmAddPage.action";
    })
    $(".medClasses_search").click(function() {
      window.location.href = "${pageContext.request.contextPath}/kind_kindSearchPage.action";
    })
    $(".medClasses_add").click(function() {
      window.location.href = "${pageContext.request.contextPath}/kind_kindAddPage.action";
    })
  })
</script>
</body>

</html>
