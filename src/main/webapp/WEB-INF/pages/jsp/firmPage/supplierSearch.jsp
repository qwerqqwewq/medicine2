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
            height: 80px;
        }
        
        .down {
            width: 100%;
            height: 650px;
            overflow: auto;
            border: 1px #ccc solid;
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
        input {
            width: 190px;
            height: 30px;
            border: 1px #ccc solid;
            border-radius: 3px;
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
                <img src="${pageContext.request.contextPath}/images/m3.png" alt="#">
                <a href="javascript:;" class="m3">药品销售</a>
                <ul>
                    <li class="sale_search">查询销售信息</li>
                    <li class="sale_add">添加销售信息</li>
                </ul>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/images/m8.png" alt="#">
                <a href="javascript:;" class="m4">供应商</a>
                <ul style="display:block">
                    <li class="supplier_search">查询供应商信息</li>
                    <li class="supplier_add">添加供应商信息</li>
                </ul>
            </li>
        </ul>

    </div>
    <div class="box">
        <div class="up">
            <form action="${pageContext.request.contextPath}/firm_searchFirm.action">
            <div>
                <span>供应商编码</span>
                <input type="text" name="FirmCode">
                <span>供应商名称</span>
                <input type="text" name="FirmName">
            </div>
            <div>
                <input type="submit" value="查询" class="high_submit">
            </div>
            </form>
        </div>
        
        <div class="down">
            <div class="all-list">
                <table class="table-box1">
                        <tr>
                            <th>供应商名称</th>
                            <th>供应商编码</th>
                            <th>联系人</th>
                            <th>联系电话</th>
                            <th>所在城市</th>
                            <th>操作</th>
                        </tr>         
                    <c:forEach items="${firms}" var="firm">
                        <tr>
                            <td>${firm.firmName}</td>
                            <td>${firm.firmCode}</td>
                            <td>${firm.link}</td>
                            <td>${firm.linkTel}</td>
                            <td>${firm.city}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/firm_detailInf.action?FirmCode=${firm.firmCode}">查询详情</a>
                                <a href="${pageContext.request.contextPath}/firm_updatePage.action?FirmCode=${firm.firmCode}">编辑</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>

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
    <script>
        $(function() {
            $(".back").click(function() {
                window.location.href = "main.html";
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
                window.location.href = "${pageContext.request.contextPath}/kind_kindSearchPage.action";
            })
            $(".medClasses_add").click(function() {
                window.location.href = "${pageContext.request.contextPath}/kind_kindAddPage.action";
            })
        })
    </script>
</body>

</html>