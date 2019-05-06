<%--
  Created by IntelliJ IDEA.
  User: peng
  Date: 2019/4/17
  Time: 20:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../common/head.jsp"%>
    <script src="/static/js/module/role.js"></script>
    <script type="text/javascript" src="/static/js/plugin/tableSelect.js"></script>
</head>
<body>
<table class="layui-hide" id="roleDatagrid"></table>
<div id="toolbarDemo" class="layui-btn-container" style="display: none">
    <button class="layui-btn layui-btn-sm" data-type="add">添加</button>
    <button class="layui-btn layui-btn-sm" data-type="delete">删除</button>
    <button class="layui-btn layui-btn-sm" data-type="update">编辑</button>
</div>
<div id="roleDiv" >
    <div id="roleFormDiv" style="display: none">
        <form class="layui-form" id="role" lay-filter="role" action="">
            <input type="hidden" id="id" name="id" >
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">角色名称：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="name" <%--lay-verify="required|checkName"--%> class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">sn：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="sn" <%--lay-verify="required|checkName"--%> class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">permission：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="permission" <%--lay-verify="required|checkName"--%> class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">选择权限：</label>
                    <div class="layui-input-inline">
                        <input style="width: 350px;font-size: x-small" type="text" name="" placeholder="权限列表" autocomplete="off" class="layui-input" id="demo"  ts-selected="">
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
