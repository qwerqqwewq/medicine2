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
            height: 750px;
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
            height: 500px;
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
            bottom: 30px;
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
    <form action="${pageContext.request.contextPath}/medicine_updateMedicine.action">
        <div class="topleft">
            <span>当前信息</span>
        </div>
        <div class="topright">
            <span>修改信息</span>
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
        <div class="right">
            <div>
                <span>药品名</span>
                <input type="text" name="MedicineName" placeholder="药品名">
            </div>
            <div>
                <span>药品编码</span>
                <input type="text" name="MedicineCode" placeholder="药品编码">
            </div>
            <div>
                <span>供应商编码</span>
                <input type="text" name="FirmCode" placeholder="供应商编码">
            </div>
            <div>
                <span>药品类别代码</span>
                <input type="text" name="KindCode" placeholder="药品类别代码">
            </div>
            <div>
                <span>进价</span>
                <input type="text" name="ListPrice" placeholder="进价">
            </div>
            <div>
                <span>售价</span>
                <input type="text" name="Price" placeholder="售价">
            </div>
            <div>
                <span>生产日期</span>
                <input type="text" name="FirstDate" placeholder="生产日期">
            </div>
            <div>
                <span>有效日期</span>
                <input type="text" name="UsefullDate" placeholder="有效日期">
            </div>

        </div>
        <div class="down">
            <input type="submit" value="提交">
        </div>
    </form>
</div>

</body>

</html>