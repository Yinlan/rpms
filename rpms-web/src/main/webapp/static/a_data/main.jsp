
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
 <title>Title</title>
 <%@include file="../../WEB-INF/views/common/head.jsp"%>
 <script src="/static/js/module/main.js"></script>
 <script src="/static/js/module/navbar.js"></script>
 <script src="/static/js/module/common.js"></script>
 <script src="/static/js/module/addTab.js"></script>
</head>
<body>
<div class="layui-tab layui-tab-card site-demo-button" style="position: relative;">
    <div class="layui-side layui-bg-black" id="admin-side">
          <div class="layui-side-scroll">
           <ul class="layui-nav layui-nav-tree" id="nav"  lay-filter="demo"></ul>
          </div>
    </div>
</div>
<%--<div class="layui-tab layui-tab-card site-demo-button" style="position: relative;">
 <ul class="layui-nav layui-nav-tree layui-nav-side">
  <li class="layui-nav-item layui-nav-itemed">
   <a href="javascript:;">默认展开</a>
   <dl class="layui-nav-child">
    <dd>
     <a data-url="a" data-id="11" data-title="选项a" href="#" class="site-demo-active" data-type="tabAdd">选项a</a>
    </dd>
    <dd>
     <a href="#" data-url="b" data-title="选项b"  data-id="22" class="site-demo-active" data-type="tabAdd">选项b</a>
    </dd>
    <dd>
     <a href="">跳转</a>
    </dd>
   </dl>
  </li>
  <li class="layui-nav-item">
   <a href="javascript:;">解决方案</a>
   <dl class="layui-nav-child">
    <dd>
     <a href="">移动模块</a>
    </dd>
    <dd>
     <a href="">后台模版</a>
    </dd>
    <dd>
     <a href="">电商平台</a>
    </dd>
   </dl>
  </li>
  <li class="layui-nav-item">
   <a href="#" data-url="c" data-title="选项c"  data-id="33" class="site-demo-active" data-type="tabAdd">产品c</a>
  </li>
  <li class="layui-nav-item">
   <a href="">大数据</a>
  </li>
 </ul>

 <div class="layui-tab" lay-filter="demo" lay-allowclose="true" style="margin-left: 200px;">
  <ul class="layui-tab-title">
  </ul>
  <ul class="rightmenu" style="display: none;position: absolute;">
   <li data-type="closethis">关闭当前</li>
   <li data-type="closeall">关闭所有</li>
  </ul>
  <div class="layui-tab-content">
  </div>
 </div>

</div>--%>
<div class="layui-tab" lay-filter="demo2" lay-allowclose="true" style="margin-left: 200px;">
 <ul class="layui-tab-title">
 </ul>
 <ul class="rightmenu" style="display: none;position: absolute;">
  <li data-type="closethis">关闭当前</li>
  <li data-type="closeall">关闭所有</li>
 </ul>
 <div class="layui-tab-content">
 </div>
</div>

</body>
</html>
