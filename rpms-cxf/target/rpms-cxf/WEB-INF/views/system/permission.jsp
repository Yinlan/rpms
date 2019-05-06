<%--
  Created by IntelliJ IDEA.
  User: peng
  Date: 2019/4/17
  Time: 16:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../common/head.jsp"%>
    <script src="/static/js/module/permission.js"></script>
</head>
<body>
<table class="layui-hide" id="permissionDatagrid"></table>
<div id="toolbarDemo" class="layui-btn-container" style="display: none">
    <button class="layui-btn layui-btn-sm" data-type="add">添加</button>
    <button class="layui-btn layui-btn-sm" data-type="delete">删除</button>
    <button class="layui-btn layui-btn-sm" data-type="update">编辑</button>
</div>
<div id="permissionDiv" >
    <div id="permissionFormDiv" style="display: none">
        <form class="layui-form" id="permission" lay-filter="permission" action="">
            <input type="hidden" id="id" name="id" >
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">权限名称：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="name" <%--lay-verify="required|checkName"--%> class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">权限描述：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="resource" <%--lay-verify="required|checkName"--%> class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">父菜单：</label>
                    <div class="layui-input-inline">
                        <select id="selectMenu"  name="menuId">

                        </select>
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
