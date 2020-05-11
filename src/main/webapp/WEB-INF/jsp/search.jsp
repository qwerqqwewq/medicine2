<%--
  Created by IntelliJ IDEA.
  User: wei
  Date: 2020/5/8
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <script src="../jquery.min.js"></script>
  <style>
    body {
      background: rgb(238, 238, 238);
    }

    .box {
      background: rgb(250, 250, 250);
      width: 1000px;
      height: 700px;
      margin: 100px auto;
      border: 1px #ccc solid;
      border-radius: 3px;
      padding: 30px;
    }

    .box input {
      width: 190px;
      height: 30px;
    }

    .box div {
      margin-top: 20px;
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

    .high_submit {
      float: right;
      background-color: rgb(45, 147, 214);
      outline: none;
      color: white;
      border: 1px #ccc solid;
      border-radius: 5px;
    }

    .up {
      height: 180px;
    }

    .down {
      background: pink;
      width: 100%;
      height: 500px;
      overflow: auto;
    }
  </style>
</head>
<form>
<div class="back">
  <p>back</p>
</div>
<form method="post" action="search">
  <div class="box">
    <div class="up">
      <div>
        <span>药品名称</span>
        <input type="text">
        <span>药品类别代码</span>
        <input type="text">
        <span>供应商编码</span>
        <input type="text">
      </div>
      <div>
        <span>进价范围</span>
        <input type="text">
        <span>到</span>
        <input type="text">
        <span>售价范围</span>
        <input type="text">
        <span>到</span>
        <input type="text">
      </div>
      <div>
        <span>生产日期</span>
        <input type="text" placeholder="xxxx-xx-xx">
        <span>到</span>
        <input type="text" placeholder="xxxx-xx-xx">
        <span>有效日期</span>
        <input type="text" placeholder="xxxx-xx-xx">
        <span>到</span>
        <input type="text" placeholder="xxxx-xx-xx">
      </div>
      <div>
        <input type="submit" value="查询" class="high_submit">
      </div>
    </div>
    <div class="down">

    </div>

  </div>
</form>
  <script>
    $(function() {
      $(".back").click(function() {
        window.location.href = "main.html";
      })
    })
  </script>
</body>
</html>
