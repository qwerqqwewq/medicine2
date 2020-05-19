<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>

<head>
    <meta charset="utf-8">
    <script src="${pageContext.request.contextPath}/common/resource/jquery.min.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
    <style>
        body {
            background: rgb(238, 238, 238);
        }
        
        .box {
            background: rgb(250, 250, 250);
            width: 1550px;
            height: 754px;
            margin: 100px auto;
            margin-right:30px;
            border: 1px #ccc solid;
            border-radius: 3px;
            padding: 30px;
            
        }
        
        .box input {
            width: 190px;
            height: 30px;
            border: 1px #ccc solid;
            border-radius: 3px;
        }
        
        .box div {
            
        }
        .up {
            margin-top: 15px;
            height: 240px;
        }
        
        .down {
            margin-top: 20px;
            width: 100%;
            height: 430px;
            overflow: auto;
            border: 1px #ccc solid;
        }
        .all-list {
            background: rgb(250,250,250);
            width: 1500px;
            height: 500px;
            margin: 30px auto;
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
        .down2{

        }
        .submit1 {
            color: white;
            background-color: rgb(45, 147, 214);
            width: 70px;
            height: 40px;
            outline: none;
            border: 1px #ccc solid;
            border-radius: 5px;
            float: left;
            margin-top: 25px;
            
        }
        .submit2 {
            color: white;
            background-color: rgb(45, 147, 214);
            width: 70px;
            height: 40px;
            outline: none;
            border: 1px #ccc solid;
            border-radius: 5px;
            float: right;
            margin-top: 20px;
            margin-right: 37px;
        }
        tr{
            border-bottom:1px #ccc solid;
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
            <img src="${pageContext.request.contextPath}/images/m5.png" alt="#">
            <a href="javascript:;" class="m1">药品管理</a>
            <ul>
                <li class="med_search">查询药品</li>
                <li class="med_add">添加药品</li>
            </ul>
        </li>
        <li>
            <img src="${pageContext.request.contextPath}/images/m2.png" alt="#">
            <a href="javascript:;" class="m2">药品库存</a>
            <ul style="display:block">
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
<form method="post" action="${pageContext.request.contextPath}/stock_add.action">
    <div class="box">
        <div class="up">
            <div>
                <h2>添加的药品名称</h2>
            </div>
            <div>

                <input type="text" placeholder="操作编码" name="StockNum">
<%--                <input type="text" placeholder="操作类型" name="WorkType">--%>
                <select name="WorkType">
                    <option value="0">出库</option>
                    <option value="1">入库</option>
                </select>

            </div>
            
            <div>
                <h2>操作数量</h2>
            </div>
            <div>
            <input type="text" placeholder="药品编码" name="MedicineCode">

                <input type="text" placeholder="操作数量" name="WorkNum">

            <input type="text" placeholder="单价" name="price">

            </div>
            <div>
                <input type="submit" value="提交" class="submit1">
            </div>

        </div>
        <div class="down">
            <div class="all-list">
                <table class="table-box1">
                        <tr>
                            <th>药品编码</th>
                            <th>操作编码</th>
                            <th>操作类型</th>
                            <th>单价</th>
                            <th>添加数量</th>
                        </tr>         
                    <c:forEach items="${list}" var="uinfo">
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

        </div>
        <div class="down2">
            <input type="submit" value="提交" class="submit2">

        </div>

    </div>
</form>
    <div class="down1">
        <div class="span">
            <span><a href="ChangePassword.html">修改密码</a></span>
        </div>
        <div>
            <span>退出登录</span>
        </div>
    </div>
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
        })
    </script>
</body>

</html>