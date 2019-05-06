<%--
  Created by IntelliJ IDEA.
  User: peng
  Date: 2019/4/18
  Time: 15:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../common/head.jsp"%>
    <script src="/static/js/module/employee.js"></script>
</head>
<body>
<table class="layui-hide" id="employeeDatagrid"></table>
<div id="toolbarDemo" class="layui-btn-container" style="display: none">
    <button class="layui-btn layui-btn-sm" data-type="add">添加</button>
    <button class="layui-btn layui-btn-sm" data-type="delete">删除</button>
    <button class="layui-btn layui-btn-sm" data-type="update">编辑</button>
</div>
<div id="employeeDiv" >
    <div id="employeeFormDiv" style="display: none">
        <form class="layui-form" id="employee" lay-filter="employee" action="">
            <input type="hidden" id="id" name="id" >
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">员工姓名：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="name" <%--lay-verify="required|checkName"--%> class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">密码：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="pwd" <%--lay-verify="required|checkName"--%> class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">年龄：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="age" <%--lay-verify="required|checkName"--%> class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">电话：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="tel" <%--lay-verify="required|checkName"--%> class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">邮件：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="email" <%--lay-verify="required|checkName"--%> class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">角色：</label>
                    <div class="layui-input-inline">
                        <select id="selectRole"  name="">

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
