<%--
  Created by IntelliJ IDEA.
  User: wei
  Date: 2020/5/8
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <style>
    body{
      background: rgb(238,238,238);
    }
    .all-list {
      background: rgb(250,250,250);
      width: 1500px;
      height: 700px;
      margin: 100px auto;
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
<div class="all-list">
  <table class="table-box1">
    <tr>
      <th>药品名称</th>
      <th>药品编号</th>
      <th>药品种类</th>
      <th>供应商</th>
      <th>生产日期</th>
      <th>有效日期</th>
      <th>操作</th>
    </tr>
    <c:forEach items="${medicines}" var="medicine">
      <tr>
        <td>${t_medicine.MedicineName}</td>
        <td>${t_medicine.MedicineCode}</td>
        <td>${t_medicine.KindCode}</td>
        <td>${t_medicine.FirmCode}</td>
        <td>${t_medicine.FirstDate}</td>
        <td>${t_medicine.UsefullDate}</td>
        <td>
          <a href="/userInfo/to_update?sn=${uinfo.sn}">编辑</a>
          <a href="${pageContext.request.contextPath}/medicine_delete.action">删除</a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>
</body>
</html>
