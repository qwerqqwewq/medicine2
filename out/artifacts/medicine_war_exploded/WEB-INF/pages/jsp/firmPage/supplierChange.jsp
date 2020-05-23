<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>

<head>
    <meta charset="utf-8">
    <style>
        body {
            background: rgb(238, 238, 238);
        }
        .big {
            width: 1500px;
            height: 550px;
            background: rgb(250, 250, 250);
            margin: 0 auto;
            margin-top: 70px;
            position: relative;
            border: 2px #ccc solid;
            border-radius: 5px;
        }
        
        .topleft,
        .topright {
            width: 652px;
            height: 25px;
            margin-top: 20px;
            background: rgb(45, 147, 214);
            float: left;
            margin-left: 70px;
            border: 1px #ccc solid;
            border-radius: 5px;
            text-align: center;
        }
        
        .left,
        .right {
            width: 650px;
            height: 330px;
            background: rgb(250, 250, 250);
            float: left;
            margin-left: 70px;
            border: 2px #ccc solid;
            border-radius: 5px;
        }
        
        .left>div {
            height: 60px;
            line-height: 80px;
        }
        
        .left span,
        .right span {
            margin-left: 40px;
        }
        
        .right>div {
            height: 60px;
            line-height: 80px;
            width: 100%;
        }
        
        .right input {
            width: 400px;
            height: 35px;
            float: right;
            margin-top: 24px;
            margin-right: 100px;
            outline: none;
            border: 1px #ccc solid;
            border-radius: 5px;
            padding-left: 10px;
        }
        
        .down {
            position: absolute;
            bottom: 20px;
            left: 0;
            width: 100%;
            height: 100px;
            background: rgb(250, 250, 250);
        }
        
        .down input {
            float: right;
            width: 100px;
            height: 40px;
            margin-top: 25px;
            margin-right: 60px;
            outline: none;
            border: 1px #ccc solid;
            border-radius: 5px;
            color: white;
            background-color: rgb(45, 147, 214);
        }
    </style>
</head>

<body>
    <div class="big">
        <form action="${pageContext.request.contextPath}/firm_updateFirm.action">
            <div class="topleft">
                <span>当前信息</span>
            </div>
            <div class="topright">
                <span>修改信息</span>
            </div>
            <div class="left">
                <c:forEach items="${firms}" var="firm">
                <div>
                    <span>供应商编码</span>
                    <span>${firm.firmCode}</span>
                </div>
                <div>
                    <span>供应商名称</span>
                    <span>${firm.firmName}</span>
                </div>
                <div>
                    <span>联系人</span>
                    <span>${firm.link}</span>
                </div>
                <div>
                    <span>联系人电话</span>
                    <span>${firm.linkTel}</span>
                </div>
                <div>
                    <span>所在城市</span>
                    <span>${firm.city}</span>
                </div>
                </c:forEach>
            </div>
            <div class="right">
                <div>
                    <span>供应商编码</span>
                    <input type="text" name="FirmCode" placeholder="供应商编码">
                </div>
                <div>
                    <span>供应商名称</span>
                    <input type="text" name="FirmName" placeholder="供应商名称">
                </div>
                <div>
                    <span>联系人</span>
                    <input type="text" name="Link" placeholder="联系人">
                </div>
                <div>
                    <span>联系人电话</span>
                    <input type="text" name="LinkTel" placeholder="联系人电话">
                </div>
                <div>
                    <span>所在城市</span>
                    <input type="text" name="City" placeholder="所在城市">
                </div>
                
                
            </div>
            <div class="down">
                <input type="submit" value="提交">
            </div>
        </form>
    </div>

</body>

</html>