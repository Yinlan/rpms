<%--
  Created by IntelliJ IDEA.
  User: peng
  Date: 2019/4/16
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../common/head.jsp"%>
    <script src="/static/js/module/PayType.js"></script>
</head>
<body>
<table class="layui-hide" id="papTypeDatagrid"></table>
<div id="toolbarDemo" class="layui-btn-container" style="display: none">
    <button class="layui-btn layui-btn-sm" data-type="add">添加</button>
    <button class="layui-btn layui-btn-sm" data-type="delete">删除</button>
    <button class="layui-btn layui-btn-sm" data-type="update">编辑</button>
</div>
<div id="payTypeDiv" >
    <div id="payTypeFormDiv" style="display: none">
        <form class="layui-form" id="payType" lay-filter="payType" action="">
            <input type="hidden" id="id" name="payid" >
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">支付方式：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="paytypename" <%--lay-verify="required|checkName"--%> class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button type="button" class="layui-btn" lay-submit="" lay-filter="demo1" >立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>
