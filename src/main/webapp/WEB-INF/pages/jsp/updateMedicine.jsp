<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <form>
        <div class="topleft">
            <span>当前信息</span>
        </div>
        <div class="topright">
            <span>修改信息</span>
        </div>
        <div class="left">
            <div>
                <span>药品名</span>
                <span>${medicine.MedicineName}</span>
            </div>
            <div>
                <span>药品编码</span>
                <span>${medicine.MedicineCode}</span>
            </div>
            <div>
                <span>供应商编码</span>
                <span>${medicine.FirmCode}</span>
            </div>
            <div>
                <span>药品类别代码</span>
                <span>${medicine.KindCode}</span>
            </div>
            <div>
                <span>进价</span>
                <span>${medicine.ListPrice}</span>
            </div>
            <div>
                <span>售价</span>
                <span>${medicine.Price}</span>
            </div>
            <div>
                <span>生产日期</span>
                <span>${medicine.FirstDate}</span>
            </div>
            <div>
                <span>有效日期</span>
                <span>${medicine.UsefullDate}</span>
            </div>
        </div>
        <div class="right">
            <div>
                <span>药品名</span>
                <input type="text" name="" placeholder="药品名">
            </div>
            <div>
                <span>药品编码</span>
                <input type="text" name="" placeholder="药品编码">
            </div>
            <div>
                <span>供应商编码</span>
                <input type="text" name="" placeholder="供应商编码">
            </div>
            <div>
                <span>药品类别代码</span>
                <input type="text" name="" placeholder="药品类别代码">
            </div>
            <div>
                <span>进价</span>
                <input type="text" name="" placeholder="进价">
            </div>
            <div>
                <span>售价</span>
                <input type="text" name="" placeholder="售价">
            </div>
            <div>
                <span>生产日期</span>
                <input type="text" name="" placeholder="生产日期">
            </div>
            <div>
                <span>有效日期</span>
                <input type="text" name="" placeholder="有效日期">
            </div>

        </div>
        <div class="down">
            <input type="submit" value="提交">
        </div>
    </form>
</div>

</body>

</html>