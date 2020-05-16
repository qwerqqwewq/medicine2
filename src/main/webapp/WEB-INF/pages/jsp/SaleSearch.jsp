<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            width: 100%;
            height: 550px;
            overflow: auto;
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
    </style>
</head>

<body>
    <div class="box1">
        <h1>医药管理系统</h1>
        <label><img src="${pageContext.request.contextPath}/images/ing.png"></label>
        <span>名字</span>
    </div>
    <div class="left">
        <ul class="nav">
            <li>
                <img src="${pageContext.request.contextPath}/images/m1.png" alt="#">
                <a href="javascript:" class="m1">药品管理</a>
                <ul>
                    <li class="med_search">查询药品</li>
                    <li class="med_add">添加药品</li>
                </ul>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/images/m2.png" alt="#">
                <a href="javascript:" class="m2">药品库存</a>
                <ul>
                    <li class="stock_search">查询库存信息</li>
                    <li class="stock_add">添加库存信息</li>
                </ul>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/images/m7.png" alt="#">
                <a href="javascript:" class="m3">药品销售</a>
                <ul style="display:block">
                    <li class="sale_search">查询销售信息</li>
                    <li class="sale_add">添加销售信息</li>
                </ul>
            </li>
            <li>
                <img src="${pageContext.request.contextPath}/images/m4.png" alt="#">
                <a href="javascript:" class="m4">供应商</a>
                <ul>
                    <li class="supplier_search">查询供应商信息</li>
                    <li class="supplier_add">添加供应商信息</li>
                </ul>
            </li>
        </ul>

    </div>
    <div class="box">
        <div class="up">
            <div>
                <span>销售编码</span>
                <input type="text">
                <span>销售员编码</span>
                <input type="text">
                <span>客户编码</span>
                <input type="text">
            </div>
            <div>
                <span>金额上限</span>
                <input type="text">
                <span>金额下限</span>
                <input type="text">
            </div>
            <div>
                <span>销售日期</span>
                <input type="text" placeholder="xxxx-xx-xx">
                <span>到</span>
                <input type="text" placeholder="xxxx-xx-xx">
            </div>
            <div>
                <input type="submit" value="查询" class="high_submit">
            </div>
        </div>
        
        <div class="down">
            <div class="all-list">
                <table class="table-box1">
                        <tr>
                            <th>销售编码</th>
                            <th>销售员编码</th>
                            <th>客户编码</th>
                            <th>销售日期</th>
                            <th>总金额</th>
                            <th>操作</th>
                        </tr>         
                    <c:forEach items="${sales}" var="sale">
                        <tr>
                            <td>${sale.SaleName}</td>
                            <td>${sale.UserId}</td>
                            <td>${sale.CustomerCode}</td>
                            <td>${sale.SaleDate}</td>
                            <td>${sale.Amount}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/WEB-INF/pages/jsp">编辑</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

    </div>
    <div class="down1">
        <div class="span">
            <span><a href="${pageContext.request.contextPath}/WEB-INF/pages/jsp/changepassword.jsp">修改密码</a></span>
        </div>
        <div>
            <span>退出登录</span>
        </div>
    </div>
    <script>
        $(function() {
            $(".back").click(function() {
                window.location.href = "${pageContext.request.contextPath}/WEB_INF/pages/jsp/main.jsp";
            })
            $(".high").click(function() {
                $(".down").stop().slideToggle(200);
            })
            $(".back").click(function() {
                window.location.href = "${pageContext.request.contextPath}/WEB_INF/pages/jsp/main.jsp";
            })
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
                window.location.href = "${pageContext.request.contextPath}/WEB_INF/pages/jsp/search.jsp";
            })
            $(".med_add").click(function() {
                window.location.href = "${pageContext.request.contextPath}/WEB_INF/pages/jsp/add.jsp";
            })
            $(".stock_search").click(function() {
                window.location.href = "${pageContext.request.contextPath}/WEB_INF/pages/jsp/stockSearch.jsp";
            })
            $(".stock_add").click(function() {
                window.location.href = "${pageContext.request.contextPath}/WEB_INF/pages/jsp/stockAdd.jsp";
            })
            $(".sale_search").click(function() {
                window.location.href = "${pageContext.request.contextPath}/WEB_INF/pages/jsp/saleSearch.jsp";
            })
            $(".sale_add").click(function() {
                window.location.href = "${pageContext.request.contextPath}/WEB_INF/pages/jsp/saleAdd.jsp";
            })
            $(".supplier_search").click(function() {
                window.location.href = "${pageContext.request.contextPath}/WEB_INF/pages/jsp/supplierSearch.jsp";
            })
            $(".supplier_add").click(function() {
                window.location.href = "${pageContext.request.contextPath}/WEB_INF/pages/jsp/supplierAdd.jsp";
            })
        })
    </script>
</body>

</html>