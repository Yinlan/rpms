<%--
  Created by IntelliJ IDEA.
  User: peng
  Date: 2019/4/15
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../common/head.jsp"%>
    <script src="/static/js/module/Parts.js"></script>

</head>
<body>
<%--数据表格--%>
<table class="layui-hide" id="partsDatagrid"></table>
<div id="toolbarDemo" class="layui-btn-container" style="display: none">
    <button class="layui-btn layui-btn-sm" data-type="add">添加</button>
    <button class="layui-btn layui-btn-sm" data-type="delete">删除</button>
    <button class="layui-btn layui-btn-sm" data-type="update">编辑</button>
    <button class="layui-btn layui-btn-sm" data-type="updateDB">更新索引库</button>
    <div class="demoTable">
        <form id="partsSeachForm">
            配件信息：
            <div class="layui-inline">
                <input class="layui-input" name="partsname"  autocomplete="off">
            </div>
            <%--button如果在form表单内部，它默认点击是submit提交--%>
            <button class="layui-btn" type="button" data-type="reload">搜索</button>
        </form>
    </div>
</div>
<div id="partsDiv" >
    <div id="partsFormDiv" style="display: none">
        <form class="layui-form" id="parts" lay-filter="parts" action="">
            <input type="hidden" id="id" name="pid" value="">
            <input type="hidden" value="10" name="warnnum">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">配件名称：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="partsname" lay-verify="required|checkName" class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">配件价格：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="num"  class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">配件数量：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="price"  id="price" class="layui-input" style="z-index: 19891015;">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">配件描述：</label>
                    <div class="layui-input-inline">
                        <textarea name="context" placeholder="请输入内容" class="layui-textarea"></textarea>
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
