<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/head.jsp"%>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>layout 后台大布局 - Layui</title>
    <script type="text/javascript" src="/static/js/module/index.js"></script>
    <style>
        /*左侧导航*/
        .layui-tree-skin-sidebar li i{
            color: rgba(255,255,255,.7);
            display: none;
        }
        .layui-tree-skin-sidebar li a cite{
            color: rgba(255,255,255,.7)
        }
        .layui-tree-skin-sidebar li .layui-tree-spread{
            display: block;
            position: absolute;
            right: 30px;
        }
        .layui-tree-skin-sidebar li{
            line-height: 45px;
            position: relative;
        }
        .layui-tree-skin-sidebar li ul{
            margin-left: 0;
            background: rgba(0,0,0,.3);
        }
        .layui-tree-skin-sidebar li ul a{
            padding-left: 20px;
        }
        .layui-tree-skin-sidebar li a{
            height: 45px;
            border-left: 5px solid transparent;
            box-sizing: border-box;
            width: 100%;
        }
        .layui-tree-skin-sidebar li a:hover{
            background: #4E5465;
            color: #fff;
            border-left: 5px solid #009688;
        }
        .layui-tree-skin-sidebar li a.active{
            background: #009688;
        }
        .x-iframe{
            width: 100%;
            height: 100%;
        }
        .layui-tab-item{
            width: 100%;
            height: 100%;
        }
        .layui-layout-admin .layui-body{bottom:0}
    </style>
    <%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">超鹏汽车维修系统</div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="">控制台</a></li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="" class="layui-nav-img">
                    ${user_IN_SESSION.name}
                </a>

            </li>
            <li class="layui-nav-item"><a href="/logout">注销</a></li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <div id="sidemenubar" lay-filter="test"></div>
        </div>
    </div>

    <div class="layui-body">
        <div class="layui-tab tab" lay-filter="mainTab" lay-allowclose="false" style=" height: 100%;">
            <ul class="layui-tab-title">
                <li class="home"><i class="layui-icon">&#xe68e;</i>我的桌面</li>
            </ul>
            <div class="layui-tab-content" style=" height: 100%;">
                <div class="layui-tab-item layui-show" style="height: 100%;">
                    <iframe src='/common/video' frameborder="0" scrolling="yes" class="x-iframe"></iframe>

                </div>
            </div>
        </div>
    </div>

</div>
<script>
    //JavaScript代码区域
    layui.use('element', function(){
        var element = layui.element;

    });
</script>
</body>
</html>
