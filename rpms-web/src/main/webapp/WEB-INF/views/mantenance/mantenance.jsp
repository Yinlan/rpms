
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
   <%@include file="../common/head.jsp"%>
    <script src="/static/js/module/Mantenance.js"></script>
    <style>
        .tangram-suggestion-main{
            z-index: 19891025; position: absolute; display: none; left: 516px; top: 265px; width: 190px;
        }
    </style>
</head>
<body>
<%--数据表格--%>
<table class="layui-hide" id="maintenanceDatagrid"></table>

<%--按钮组--%>
    <div id="toolbarDemo" class="layui-btn-container" style="display: none">
        <button class="layui-btn layui-btn-sm" data-type="add">添加</button>
        <button class="layui-btn layui-btn-sm" data-type="delete">删除</button>
        <button class="layui-btn layui-btn-sm" data-type="update">编辑</button>
        <button class="layui-btn layui-btn-sm" data-type="addItem">新增明细</button>
        <button class="layui-btn layui-btn-sm" data-type="addBuild">订单结算</button>
        <div class="demoTable">
            <form id="maintenceSeachForm">
                车牌号：
                <div class="layui-inline">
                    <input class="layui-input" name="carnum"  autocomplete="off">
                </div>
                <%--button如果在form表单内部，它默认点击是submit提交--%>
                <button class="layui-btn" type="button" data-type="reload">搜索</button>
            </form>
        </div>
    </div>

<%--用来新增或者修改的form 初始状态为隐藏--%>
<%--显示form的div--%>
<div id="maintenanceFormDiv" >
<div id="maintenanceForm" style="display: none">
    <form class="layui-form" id="maintenance" lay-filter="maintenance" action="">
        <input type="hidden" id="id" name="mainid">
        <div class="layui-form-item">
            <div class="layui-inline">
                <label class="layui-form-label">客户姓名：</label>
                <div class="layui-input-inline">
                    <input type="text" name="custormer" <%--lay-verify="required|length|checkName"--%> class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">车牌号：</label>
                <div class="layui-input-inline">
                    <input type="text" name="carnum" <%--lay-verify="email--%>" class="layui-input">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">客户地址：</label>
                <div class="layui-input-inline">
                <input type="text" name="address"  id="address" class="layui-input" style="z-index: 19891015;">
                </div>
            </div>
            <div class="layui-inline">
                <label class="layui-form-label">维修员：</label>
                <div class="layui-input-inline">
                    <select id="selectOtpid"  name="optid">

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
<div id="ItemDatagrid"  style="display: none">
    <table class="layui-table" id="maintenanceItemDatagrid"></table>
</div>
<div id="toolbarItem" class="layui-btn-container" style="display: none">
    <button class="layui-btn layui-btn-sm" data-type="add">添加</button>
    <button class="layui-btn layui-btn-sm" data-type="delete">删除</button>
    <button class="layui-btn layui-btn-sm" data-type="update">编辑</button>
</div>

<div id="maintenanceItemFormDiv" >
    <div id="maintenanceItemForm" style="display: none">
        <form class="layui-form" id="maintenanceItem" lay-filter="maintenanceItem" action="">
            <input type="hidden" id="Itemid" name="itemid">
            <%-- <input type="hidden" id="mainid" name="mainid">--%>
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">汽车维修零件：</label>
                    <div class="layui-input-inline">
                        <select id="selectItemParts"  name="pid">

                        </select>
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">零件数量：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="num" <%--lay-verify="email"--%>  class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">零件金额：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="amt1" <%--lay-verify="number" --%>  class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">工时费：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="amt2" <%--lay-verify="number" --%>  class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">维修人员</label>
                    <div class="layui-input-inline">
                        <select id="selectItemOtpid"  name="opid">

                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button type="button" class="layui-btn" lay-submit="" lay-filter="demo2" >立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
</div>
<div id="maintenanceBuildFormDiv" >
    <div id="maintenanceBuildForm" style="display: none">
        <form class="layui-form" id="maintenanceBuild" lay-filter="maintenance" action="">
            <input type="hidden" id="Buildid" name="mainid">
            <div class="layui-form-item">
                <div class="layui-inline">
                    <label class="layui-form-label">客户姓名：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="custormer" <%--lay-verify="required|length|checkName"--%> class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">应付金额：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="reAmount" <%--lay-verify="email"--%>  class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">实付金额：</label>
                    <div class="layui-input-inline">
                        <input type="text" name="payAmount" <%--lay-verify="number" --%>  class="layui-input">
                    </div>
                </div>
                <div class="layui-inline">
                    <label class="layui-form-label">支付方式：</label>
                    <div class="layui-input-inline">
                        <select id="BuildselectPayid"  name="payid">

                        </select>
                    </div>
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button type="button" class="layui-btn" lay-submit="" lay-filter="demo3" >立即提交</button>
                    <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
<script type="text/javascript">
    loadMapAutocomplete("address");
    function loadMapAutocomplete(mySuggestId) {
        Ac = new BMap.Autocomplete( //建立一个自动完成的对象
            {
                "input": address,
            });
    }

</script>

</html>
