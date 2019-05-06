<%--
  Created by IntelliJ IDEA.
  User: peng
  Date: 2019/4/16
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../common/head.jsp"%>
    <script src="/static/js/module/menu.js"></script>
</head>
<body>
<table class="layui-hide" id="menuDatagrid"></table>
<div id="toolbarDemo" class="layui-btn-container" style="display: none">
    <button class="layui-btn layui-btn-sm" data-type="add">添加</button>
    <button class="layui-btn layui-btn-sm" data-type="delete">删除</button>
    <button class="layui-btn layui-btn-sm" data-type="update">编辑</button>
</div>
<div id="menuDiv" >
    <div id="menuFormDiv" style="display: none">
        <form class="layui-form" id="menu" lay-filter="menu" action="">
            <input type="hidden" id="id" name="id" >
            <input type="hidden" id="icon" name="icon" >
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">编号：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="sn" <%--lay-verify="required|checkName"--%> class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">菜单名称：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="name" <%--lay-verify="required|checkName"--%> class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">父菜单：</label>
                    <div class="layui-input-inline">
                        <select id="selectMenu"  name="parent">

                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">图标：</label>

                    <div class="layui-input-inline">

                        <button type="button" class="layui-btn" id="test1">
                            <%--<input id="fileInt" type="file" name="multipartFile" class="layui-upload-file" >--%>
                                <i class="layui-icon">&#xe67c;</i>上传图片</button>
                        </button>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">地址：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="url" <%--lay-verify="required|checkName"--%> class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">介绍：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="intro" <%--lay-verify="required|checkName"--%> class="layui-input">
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
