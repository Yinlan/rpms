<%--
  Created by IntelliJ IDEA.
  User: peng
  Date: 2019/4/15
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../common/head.jsp"%>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=BsyizLI7RHmnR6XbkwqyrKkROt6hX0FI"></script>
    <script src="/static/js/module/MantenanceCar.js"></script>

</head>
<body>
<%--数据表格--%>
<table class="layui-hide" id="maintenanceCarDatagrid"></table>
<div id="toolbarDemo" class="layui-btn-container" style="display: none">
    <button class="layui-btn layui-btn-sm" data-type="toAddress">还车地址路线</button>
</div>

</body>

</html>
