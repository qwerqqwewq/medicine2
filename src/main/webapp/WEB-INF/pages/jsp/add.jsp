<%--
  Created by IntelliJ IDEA.
  User: wei
  Date: 2020/5/8
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <script src="${pageContext.request.contextPath}/common/resource/jquery.min.js"></script>
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

    span {
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
  </style>
</head>
<body>
<div class="back">
  <p>back</p>
</div>
<form method="post" action="${pageContext.request.contextPath}/medicine_add.action">
<div class="box">
  <div>
    <h2>基本信息</h2>
  </div>
  <div>
    <input type="text" placeholder="药品名" name="MedicineName">
  </div>
  <div>
    <input type="text" placeholder="药品编码" name="MedicineCode">
  </div>
  <div>
    <input type="text" placeholder="供应商编码" name="FirmCode">
  </div>
  <div>
    <input type="text" placeholder="药品类别代码" name="KindCode">
  </div>
  <div>
    <h2>详细信息</h2>
  </div>
  <div>
    <input type="text" placeholder="进价" name="ListPrice">
    <input type="text" placeholder="售价" name="Price">
    <input type="text" placeholder="库存" name="Stock">
  </div>
  <div>
    <input type="text" placeholder="生产日期" name="FirstDate">
    <input type="text" placeholder="有效日期" name="UsefullDate">
  </div>
  <div class="down">
    <input type="submit" value="提交" class="submit">
  </div>
</div>
</form>
<script>
  $(function() {
    $(".back").click(function() {
      window.location.href = "${pageContext.request.contextPath}/medicine_medicinePage.action";
    })
  })
</script>
</body>
</html>
