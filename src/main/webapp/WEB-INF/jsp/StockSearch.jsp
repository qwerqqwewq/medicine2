<%--
  Created by IntelliJ IDEA.
  User: wei
  Date: 2020/5/8
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <script src="../jquery.min.js"></script>
  <style>
    body{
      background: rgb(238,238,238);
    }
    .box {
      background: rgb(250,250,250);
      width: 1000px;
      height: 700px;
      margin: 100px auto;
      border: 1px #ccc solid;
      border-radius: 3px;
    }

    .search {
      height: 40px;
      width: 500px;
      margin-top: 30px;
      margin-left: 100px;
      border-radius: 5px;
      outline: none;
      border: 1px #ccc solid;
      padding-left: 10px;
    }

    .submit,
    .high {
      color: white;
      height: 40px;
      width: 80px;
      margin-left: 90px;
      border: 1px #ccc solid;
      border-radius: 5px;
      background-color: rgb(45, 147, 214);
      cursor: pointer;
    }

    .high_submit {
      float: right;
      margin-right: 20px;
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
<div class="back">
  <p>back</p>
</div>
<form method="post" action="StockSearch">
<div class="box">
  <input type="text" class="search" placeholder="请输入需要查找的药品">
  <input type="submit" value="查询" class="submit">
</div>
</form>

<script>
  $(function() {
    $(".high").click(function() {
      $(".down").stop().slideToggle(200);
    })
    $(".back").click(function() {
      window.location.href = "main.html";
    })
  })
</script>
</body>
</html>
