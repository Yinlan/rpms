
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../common/head.jsp"%>
<script src="/static/js/module/MantenanceBuild.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--数据表格--%>
<table class="layui-hide" id="maintenanceBuildDatagrid"></table>
<%--按钮组--%>
<div id="toolbarDemo" class="layui-btn-container" style="display: none">
    <button class="layui-btn layui-btn-sm" data-type="delete">取消结算</button>
    <div class="demoTable">
        <form id="maintenceBuildSeachForm">
            客户：
            <div class="layui-inline">
                <input class="layui-input" name="custormer"  autocomplete="off">
            </div>
            <%--button如果在form表单内部，它默认点击是submit提交--%>
            <button class="layui-btn" type="button" data-type="reload">搜索</button>
        </form>
    </div>
</div>
</body>
</html>
