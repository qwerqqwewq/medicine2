<%--
  Created by IntelliJ IDEA.
  User: wei
  Date: 2020/5/8
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
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
        body{
            background: rgb(238,238,238);
        }
        .box {
            background: rgb(250,250,250);
            width: 1000px;
            height: 560px;
            margin: 100px auto;
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
  </style>
</head>
<body>
  <div class="box1">
    <h1>医药管理系统</h1>
    <label><img src="${pageContext.request.contextPath}/images/ing.png"></label>
    <span>${sessionScope.user.username}</span>
  </div>
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
            <img src="${pageContext.request.contextPath}/images/m7.png" alt="#">
            <a href="javascript:;" class="m3">药品销售</a>
            <ul style="display:block">
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
<form method="post" action="${pageContext.request.contextPath}/sale_add.action">
  <div class="box">
    <div>
        <h2>销售信息</h2>
    </div>
    <div>
        <input type="text" placeholder="销售编码" name="SaleNum">
    </div>
    <div>
        <input type="text" placeholder="客户编码" name="CustomerCode">
    </div>
    <div>
        <input type="text" placeholder="药品编码" name="MedicineCode">
    </div>
    <div>
        <h2>销售数量</h2>
    </div>
    <div>
        <input type="text" placeholder="数量" name="Number">
    </div>
    <div class="down">
        <input type="submit" value="提交" class="submit">
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
</form>
<script>
  $(function() {
    $(".back").click(function() {
      window.location.href = "${pageContext.request.contextPath}/medicine_medicinePage.action";
    })
    $(".nav>li>a").click(function() {
      $(this).siblings("ul").stop().slideToggle(200);
    })
    $(".box1").children("span").click(function() {
      $(".down1").stop().slideToggle(200);
    })
    $(".m1").click(function() {
      var flag = $(this).siblings("img").attr("src");
      if (flag == "${pageContext.request.contextPath}/images/m1.png") {
        $(this).siblings("img").attr("src", "${pageContext.request.contextPath}/images/m5.png");
      } else {
        $(this).siblings("img").attr("src", "${pageContext.request.contextPath}/images/m1.png");
      }
    })
    $(".m2").click(function() {
      var flag = $(this).siblings("img").attr("src");
      if (flag == "${pageContext.request.contextPath}/images/m2.png") {
        $(this).siblings("img").attr("src", "${pageContext.request.contextPath}/images/m6.png");
      } else {
        $(this).siblings("img").attr("src", "${pageContext.request.contextPath}/images/m2.png");
      }
    })
    $(".m3").click(function() {
      var flag = $(this).siblings("img").attr("src");
      if (flag == "${pageContext.request.contextPath}/images/m3.png") {
        $(this).siblings("img").attr("src", "${pageContext.request.contextPath}/images/m7.png");
      } else {
        $(this).siblings("img").attr("src", "${pageContext.request.contextPath}/images/m3.png");
      }
    })
    $(".m4").click(function() {
      var flag = $(this).siblings("img").attr("src");
      if (flag == "${pageContext.request.contextPath}/images/m4.png") {
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
          window.location.href = "${pageContext.request.contextPath}/firm_firmSearchPage.action";
      })
      $(".medClasses_add").click(function() {
          window.location.href = "${pageContext.request.contextPath}/firm_firmAddPage.action";
      })
  })
</script>
</body>
</html>
