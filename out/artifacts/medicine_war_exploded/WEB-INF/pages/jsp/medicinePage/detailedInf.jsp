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
            width: 1000px;
            height: 650px;
            background: rgb(250, 250, 250);
            margin: 0 auto;
            margin-top: 70px;
            position: relative;
            border: 2px #ccc solid;
            border-radius: 5px;
        }
        
        .topleft{
            width: 652px;
            height: 25px;
            background: rgb(45, 147, 214);
            margin: 0 auto;
            margin-top: 50px;
            border: 1px #ccc solid;
            border-radius: 5px;
            text-align: center;
        }
        
        .left{
            width: 650px;
            height: 500px;
            background: rgb(250, 250, 250);
            
            margin: 0 auto;
            border: 2px #ccc solid;
            border-radius: 5px;
        }
        
        .left>div {
            height: 60px;
            line-height: 80px;
        }
        
        .left span{
            margin-left: 40px;
        }
        
        .back {
            position: absolute;
            top: 40px;
            left: 200px;
            cursor: pointer;
        }
        
        .back p {
            width: 45px;
            height: 30px;
            border: 2px skyblue solid;
            padding-left: 10px;
            line-height: 30px;
        }
    </style>
</head>

<body>
<div class="back">
    <p onclick="javascript:history.back();">back</p>
</div>
    <div class="big">
        <form>
            <div class="topleft">
                <span>详细信息</span>
            </div>

            <div class="left">
                <c:forEach items="${medicines}" var="medicine">
                <div>
                    <span>药品名</span>
                    <span>${medicine.medicineName}</span>
                </div>
                <div>
                    <span>药品编码</span>
                    <span>${medicine.medicineCode}</span>
                </div>
                <div>
                    <span>供应商编码</span>
                    <span>${medicine.firmByFirmCode.firmCode}</span>
                </div>
                <div>
                    <span>药品类别代码</span>
                    <span>${medicine.kindByKindCode.kindCode}</span>
                </div>
                <div>
                    <span>进价</span>
                    <span>${medicine.listPrice}</span>
                </div>
                <div>
                    <span>售价</span>
                    <span>${medicine.price}</span>
                </div>
                <div>
                    <span>生产日期</span>
                    <span>${medicine.firstDate}</span>
                </div>
                <div>
                    <span>有效日期</span>
                    <span>${medicine.usefullDate}</span>
                </div>
                </c:forEach>
            </div>
        </form>
    </div>
<%--    <script>--%>
<%--        $(function() {--%>
<%--            $(".back").click(function() {--%>
<%--                window.location.href = "${pageContext.request.contextPath}/medicine_medicinePage.action";--%>
<%--            })--%>
<%--        })--%>
<%--    </script>--%>

</body>

</html>