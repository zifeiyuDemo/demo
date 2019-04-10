<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<style type="text/css">
    table {
        font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
        width: 100%;
        border-collapse: collapse;
    }
    td, th {
        font-size: 1em;
        border: 1px solid #5B4A42;
        padding: 3px 7px 2px 7px;
    }
    th {
        font-size: 1.1em;
        text-align: center;
        padding-top: 5px;
        padding-bottom: 4px;
        background-color: #24A9E1;
        color: #ffffff;
    }
</style>
<body>
    <h2>邮件消息通知</h2>
    <table id="customers">
        <!-- table 标题头 -->
        <tr>
            <th>姓名</th>
            <th>单据名称</th>
            <th>发起时间</th>
        </tr>
        <!-- table 单元格内容： 循环 赋值 -->
        <tr>
            <td>${name}</td>
            <td>${formName}</td>
            <td>${sendDate}</td>
        </tr>
    </table>
</body>
</html>