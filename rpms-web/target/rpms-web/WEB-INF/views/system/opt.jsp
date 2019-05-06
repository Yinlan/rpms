<%--
  Created by IntelliJ IDEA.
  User: peng
  Date: 2019/4/16
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../common/head.jsp"%>
    <script src="/static/js/module/opt.js"></script>
</head>
<body>
<table class="layui-hide" id="optDatagrid"></table>
<div id="toolbarDemo" class="layui-btn-container" style="display: none">
    <button class="layui-btn layui-btn-sm" data-type="add">添加</button>
    <button class="layui-btn layui-btn-sm" data-type="delete">删除</button>
    <button class="layui-btn layui-btn-sm" data-type="update">编辑</button>
    <div class="demoTable">
        <form id="optSeachForm">
            员工信息：
            <div class="layui-inline">
                <input class="layui-input"  name="optname"  autocomplete="off">
            </div>
            开始时间:
            <div class="layui-inline">
                <input class="layui-input" id="bignDate" name="bignDate"  autocomplete="off">
            </div>
            结束时间：
            <div class="layui-inline">
                <input class="layui-input" id="endDate" name="endDate"  autocomplete="off">
            </div>
            <%--button如果在form表单内部，它默认点击是submit提交--%>
            <button class="layui-btn" type="button" data-type="reload">搜索</button>
        </form>
    </div>
</div>
<div id="optDiv" >
    <div id="optFormDiv" style="display: none">
        <form class="layui-form" id="opt" lay-filter="opt" action="">
            <input type="hidden" id="id" name="optid" >
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">维修人员名称：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="optname" <%--lay-verify="required|checkName"--%> class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">年龄：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="age" <%--lay-verify="required|checkName"--%> class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">邮件地址：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="email" <%--lay-verify="required|checkName"--%> class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">聘请时间：</label>
                    <div class="layui-input-inline">
                        <input type="text" id="hiredate" name="hiredate" <%--lay-verify="required|checkName"--%> class="layui-input">
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
