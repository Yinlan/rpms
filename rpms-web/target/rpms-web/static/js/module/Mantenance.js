layui.use(['table','jquery','layer','form'], function() {
    //引入layui组件 每个模块需要引入且定义出来
    var table = layui.table;
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;
    //拿到明细的最新层
    var addIndex;
    var totalres="";
    table.render({
        elem: '#maintenanceDatagrid'
        ,url:'/repair/page'
        ,toolbar:"#toolbarDemo"
        ,parseData: function(res) { //res 即为原始返回的数据
            totalres=res;
        return {
            "code": 0, //解析接口状态
            "msg":"", //解析提示文本
            "count":res.total?res.total:0, //解析数据长度
            "data": res.rows?res.rows:null //解析数据列表
             }
          }
          ,id:'maintenanceList'
        ,cols: [[
            {type:'checkbox'}
            ,{field:'mainid', width:80, title: 'ID', sort: true}
            ,{field:'custormer', width:80, title: '客户名'}
            ,{field:'carnum', width:80, title: '车牌号'}
            ,{field:'createtime', width:80, title: '订单生产时间'}
            ,{field:'status', title: '状态', width: 80,templet(d){
                    return d.status ? "<span style='color: green'>"+d.status+"</span>":"<span style='color: red'>"+d.status+"</span>";
                }}
            ,{field:'opt', width:80, title: '维修人员',templet: function(d){
                // console.debug(d.opt.optname);
                    return d.opt ? "<span style='color: green'>"+d.opt.optname+"</span>":"<span style='color: red'>暂无维修人员</span>";//特殊属性的特殊显示方法 对象展示
                }
              }
            ,{field:'address', width:80, title: '地址', sort: true}
        ]]
        ,page: true
        //数据渲染完毕之后，执行done函数内部的代码
        ,done: function(res, curr, count){
            /*注册点击事件*/
            $("button[data-type]").on("click",function () {
                var method=$(this).data("type");
                Allmethods[method]();
            });

        }
    });

    /*发生请求找到对应的员工*/
    $.get("/util/opt", function(data){
        var select= $("#selectOtpid");
        //将信息置空
        select.empty();
        //添加一个默认的选项
        select.append("<option value=''>请选择</option>");
        $.each(data, function (index, obj) {
            select.append("<option name='\"+obj.optid+\"' value='"+obj.optid+"'>"+obj.optname+"</option>");
        });
        //重新渲染select
        form.render('select');

    });
    /*发生请求找到对应的维修配件*/
    $.get("/util/parts", function(data){
        var select= $("#selectItemParts");
        //将信息置空
        select.empty();
        //添加一个默认的选项
        select.append("<option value=''>请选择</option>");
        $.each(data, function (index, obj) {
            select.append("<option name='\"+obj.pid+\"' value='"+obj.pid+"'>"+obj.partsname+"</option>");
        });
        //重新渲染select
        form.render('select');
    });
    /*发生请求找到对应的支付方式*/
    $.get("/util/paytype", function(data){
        var select= $("#BuildselectPayid");
        //将信息置空
        select.empty();
        //添加一个默认的选项
        select.append("<option value=''>请选择</option>");
        $.each(data, function (index, obj) {
            select.append("<option name='\"+obj.payid+\"' value='"+obj.payid+"'>"+obj.paytypename+"</option>");
        });
        //重新渲染select
        form.render('select');
    });

    var Allmethods={
        //加载界面
        reload(){
            //用来做高级查询的方法 提交额外参数
            //table.reload('idTest', {
            //url: '/api/table/search'
            //,where: {} //设定异步数据接口的额外参数
            //,height: 300
            //});

            table.reload('maintenanceList', {
                where: $("#maintenceSeachForm").serializeObject()
                ,url: '/repair/search'
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        },
        add(){
            //清空form表单
            $("#maintenanceForm").clearForm();
            //表示弹出窗体
            layer.open({
                type: 1,
                offset: '100px',
                title:'添加员工',
                area: ['450px', '400px'],
                content: $("#maintenanceForm"), //这里content是一个普通的String
                //这里content是一个普通的String
                success: function(layero, index){
                    var shades = $(".layui-layer-shade");//解决自带的阴影框覆盖问题
                    if(shades.length>1){
                        $(shades[1]).remove();
                    }
                }
            });
        },
        delete(){
//通过id拿到表格选中的行
            var checkStatus = table.checkStatus('maintenanceList');
            //获取选中的数据
            var rows = checkStatus.data;
            if(!rows.length){
                layer.alert('请选中数据进行删除!',{
                    icon: 2,
                    title :'提示'
                });
                return;
            }

            //定义一个数组，该数组专门用来存储id
            var ids = [];
            $.each(rows,function(index,obj){
                ids.push(obj.mainid);
            });
            layer.confirm('你确认删除吗?', {icon: 3, title:'提示'}, function(index){

                $.get("/repair/delete",{"ids":ids.toString()},function(result){
                    if(result.success){
                        window.parent.location.reload();
                        //重新加载表格数据
                        table.reload('maintenanceList');
                        //正常刷新界面，关闭窗口
                        layer.close(index);
                    }else{
                        //错误弹出信息提示
                        layer.alert(result.msg,{
                            icon: 2,
                            title :'错误'
                        })
                    }
                });

                //  根据指定弹出框对应的index进行删除
            });
        },
        update(){
            //表单进行清空
            $("#maintenance").clearForm();
            //通过id拿到表格选中的行
            var checkStatus = table.checkStatus('maintenanceList');
            //获取选中的数据
            var rows = checkStatus.data;

            //如果没有选中
            if(!rows.length){
                layer.alert('请选中数据进行修改!',{
                    icon: 2,
                    title :'提示'
                });
                return;
            }
            //表示弹出窗体
            layer.open({
                type: 1,
                title:'修改维修单',
                offset: '100px',
                area: ['450px', '400px'],
                content: $("#maintenanceForm"), //通过id拿到弹出的表单
                success: function(layero, index){
                    //成功打开窗体 消除遮蔽
                    var shades = $(".layui-layer-shade");
                    if(shades.length>1){
                        $(shades[1]).remove();
                    }
                }

            });
            //如果多选 返回第一个选中的行
            var row = rows[0];
            if(row.opt){
                row["optid"] = row.opt.optid;
            }
            //部门为对象不为空 将行添加属性方便展示
            console.debug(row);
            //回显
            form.val("maintenance", row);

        },
        /*addItem(){
        点击一个只显示不修改 后面做

            //通过id拿到表格选中的行
            var checkStatus = table.checkStatus('maintenanceList');

            //获取选中的数据
            var rows = checkStatus.data;
            console.debug(rows);
            //如果没有选中
            if(!rows.length){
                layer.alert('请选中数据进行修改!',{
                    icon: 2,
                    title :'提示'
                });
                return;
            }
            //如果多选 返回第一个选中的行
            var row = rows[0];

            //拿到维修员工对象
            var opt;
            for(var i of totalres.rows ){
              if(i.mainid===rows[0].mainid){
                  opt=i.opt;
              }

            }
            //表示弹出窗体
            layer.open({
                type: 1,
                title:'维修单明细',
                area: ['640px', '450px'],
                content: $("#ItemDatagrid"), //通过id拿到弹出的明细数据表格
                //关闭刷新界面
                cancel: function(index, layero){
                    //刷新界面
                    table.reload('maintenanceList');
                    window.parent.location.reload();
                        return true;
                },
                success: function(layero, index){

                    table.render({
                        elem: '#maintenanceItemDatagrid'
                        ,data:checkStatus.data[0]. maintenanceItems
                        ,area: ['1500px', '1500px']
                        ,size:'sm'
                        ,id:'maintenanceList'
                        ,parseData: function(res) { //res 即为原始返回的数据
                            return {
                                "code": 0, //解析接口状态
                                "msg":"", //解析提示文本
                                "count":res.length, //解析数据长度
                                "data": res //解析数据列表
                            }
                        }
                        ,cols: [[
                            {field:'itemid', width:80, title: '明细编号', sort: true}
                            ,{field:'mainid', width:80, title: '主单编号'}
                            ,{field:'parts', width:80, title: '维修零件',
                                templet: function(d){
                                    return "<span style='color: deeppink'>"+d.parts.partsname+"</span>";//特殊属性的特殊显示方法 对象展示
                                }
                            }
                            ,{field:'amt1', width:80, title: '配件价格'}
                            ,{field:'amt2', width:80, title: '工时费'}
                            ,{field:'num', width:80, title: '配件数量'}
                            ,{field:'totalamt', width:80, title: '总金额'}
                            ,{field:'opt', width:80, title: '维修人员',templet: function(d){
                                    return opt ? "<span style='color: green'>"+opt.optname+"</span>":"<span style='color: red'>暂无维修人员</span>";//特殊属性的特殊显示方法 对象展示
                                }
                            }
                        ]]
                        ,page: true


                    });
                    //成功打开窗体 消除遮蔽
                    var shades = $(".layui-layer-shade");
                    if(shades.length>1){
                        $(shades[1]).remove();
                    }

                }

            });
        }*/
        addItem(){

            //通过id拿到表格选中的行
            var checkStatus = table.checkStatus('maintenanceList');

            //获取选中的数据
            var rows = checkStatus.data;
            //如果没有选中
            if(!rows.length){
                layer.alert('请选中数据进行修改!',{
                    icon: 2,
                    title :'提示'
                });
                return;
            }
            //如果多选 返回第一个选中的行
            var row = rows[0];
            console.debug(rows[0].mainid);
            var Itemform= $("#maintenanceItem");
            //增加主单的id
            Itemform.append("<input type=hidden value="+rows[0].mainid+" name=mainid>");

            var select1= $("#selectItemOtpid");
            console.debug(rows[0]);
            //将信息置空
            select1.empty();
            //添加一个默认的选项
            if(rows[0].opt==null){
                select1.append("<option name='optid' value='-1'>暂无维修人员</option>");
            }else{
                select1.append("<option name='\"+rows[0].opt.optid+\"' value='"+rows[0].opt.optid+"'>"+rows[0].opt.optname+"</option>");
            }
            $.get("/util/parts", function(data){
                var select= $("#selectItemParts");
                //将信息置空
                select.empty();
                //添加一个默认的选项
                select.append("<option value=''>请选择</option>");
                $.each(data, function (index, obj) {
                    select.append("<option name='\"+obj.pid+\"' value='"+obj.pid+"'>"+obj.partsname+"</option>");
                });
                //重新渲染select
                form.render('select');
            });
            //重新渲染select
            form.render('select');

            //拿到维修员工对象
            var opt;
            for(var i of totalres.rows ){
              if(i.mainid===rows[0].mainid){
                  opt=i.opt;
              }
            }
            console.debug(checkStatus.data[0]. maintenanceItems);
            // 组装数据

            //表示弹出窗体
            layer.open({
                type: 1,
                title:'维修单明细',
                area: ['700px', '450px'],
                offset: '100px',
                content: $("#ItemDatagrid"), //通过id拿到弹出的明细数据表格

                success: function(layero, index){

                    table.render({
                        elem: '#maintenanceItemDatagrid'
                        ,toolbar:"#toolbarItem"
                        ,data:checkStatus.data[0]. maintenanceItems
                        ,area: ['1500px', '1500px']
                        ,size:'sm'
                        ,id:'maintenanceItemList'
                        ,url:'/repairItem/page?id='+rows[0].mainid
                        ,parseData: function(res) { //res 即为原始返回的数据
                            totalres=res;
                            return {
                                "code": 0, //解析接口状态
                                "msg":"", //解析提示文本
                                "count":res.total?res.total:0, //解析数据长度
                                "data": res.rows?res.rows:null //解析数据列表
                            }
                        }
                        ,cols: [[
                            {type:'checkbox'}
                            ,{field:'itemid', width:80, title: '明细编号', sort: true}
                            ,{field:'mainid', width:80, title: '主单编号'}
                            ,{field:'parts', width:80, title: '维修零件',
                                templet: function(d){
                                    return "<span style='color: deeppink'>"+d.parts.partsname+"</span>";//特殊属性的特殊显示方法 对象展示
                                }
                            }
                            ,{field:'amt1', width:80, title: '配件价格'}
                            ,{field:'amt2', width:80, title: '工时费'}
                            ,{field:'num', width:80, title: '配件数量'}
                            ,{field:'totalamt', width:80, title: '总金额'}
                            ,{field:'opt', width:80, title: '维修人员',templet: function(d){
                                    return opt ? "<span style='color: green'>"+opt.optname+"</span>":"<span style='color: red'>暂无维修人员</span>";//特殊属性的特殊显示方法 对象展示
                                }
                            }
                        ]]
                        ,page: true
                        ,done: function(res, curr, count) {
                            var shades = $(".layui-layer-shade");//解决自带的阴影框覆盖问题
                            if(shades.length>1){
                                $(shades[1]).remove();
                            }
                            /*注册点击事件*/
                            $("button[data-type]").on("click", function () {
                                var method = $(this).data("type");
                                console.debug(method);
                                Itemmethods[method]();
                            });

                        }


                    });
                    //明细的CRUD
                    var Itemmethods={
                        add(){
                            //清空form表单
                            $("#maintenanceItem").clearForm();
                            //表示弹出窗体
                            addIndex =layer.open({
                                type: 1,
                                offset: '100px',
                                title:'添加员工',
                                area: ['450px', '400px'],
                                content: $("#maintenanceItemForm"), //这里content是一个普通的String
                                //这里content是一个普通的String
                                success: function(layero, index){
                                    var shades = $(".layui-layer-shade");//解决自带的阴影框覆盖问题
                                    if(shades.length>1){
                                        $(shades[1]).remove();
                                    }
                                }
                            });
                            form.val("maintenanceItem", {
                                "itemid":""
                            });
                        },
                        delete(){
                            //通过id拿到表格选中的行
                            var checkStatus = table.checkStatus('maintenanceItemList');
                            //获取选中的数据
                            var rows = checkStatus.data;

                            if(!rows.length){
                                layer.alert('请选中数据进行删除!',{
                                    icon: 2,
                                    title :'提示'
                                });
                                return;
                            }
                            console.debug(rows);
                            //定义一个数组，该数组专门用来存储id
                            var ids = [];
                            $.each(rows,function(index,obj){
                                ids.push(obj.itemid);
                            });
                            layer.confirm('你确认删除吗?', {icon: 3, title:'提示'}, function(index){

                                $.get("/repairItem/delete",{"ids":ids.toString()},function(result){
                                    if(result.success){
                                        //重新加载表格数据
                                        table.reload('maintenanceItemList');
                                        layer.close(index);
                                    }else{
                                        //错误弹出信息提示
                                        layer.alert(result.msg,{
                                            icon: 2,
                                            title :'错误'
                                        })
                                    }
                                });

                                //  根据指定弹出框对应的index进行删除
                            });
                        },
                        update(){
                            //表单进行清空
                            $("#maintenanceItem").clearForm();
                            //通过id拿到表格选中的行
                            var checkStatus = table.checkStatus('maintenanceItemList');
                            //获取选中的数据
                            var rows = checkStatus.data;

                            //如果没有选中
                            if(!rows.length){
                                layer.alert('请选中数据进行修改!',{
                                    icon: 2,
                                    title :'提示'
                                });
                                return;
                            }
                            //表示弹出窗体
                            layer.open({
                                type: 1,
                                title:'修改明细单',
                                offset: '100px',
                                area: ['450px', '400px'],
                                content: $("#maintenanceItemForm"), //通过id拿到弹出的表单
                                success: function(layero, index){
                                    //成功打开窗体 消除遮蔽
                                    var shades = $(".layui-layer-shade");
                                    if(shades.length>1){
                                        $(shades[1]).remove();
                                    }
                                }
                            });

                            //如果多选 返回第一个选中的行
                            var row = rows[0];
                            if(row.parts){
                                row["pid"] = row.parts.pid;
                            }
                            //部门为对象不为空 将行添加属性方便展示
                            //回显
                            form.val("maintenanceItem", row);
                        }
                    }

                }

            });
        },
        //增加订单
        addBuild(){
            //通过id拿到表格选中的行
            var checkStatus = table.checkStatus('maintenanceList');

            //获取选中的数据
            var rows = checkStatus.data;
            //如果没有选中
            if(!rows.length){
                layer.alert('请选中数据进行修改!',{
                    icon: 2,
                    title :'提示'
                });
                return;
            }

            //表示弹出窗体
            layer.open({
                type: 1,
                offset: '100px',
                title:'订单结算',
                area: ['450px', '400px'],
                content: $("#maintenanceBuildForm"), //通过id拿到弹出的表单
                success: function(layero, index){
                    //成功打开窗体 消除遮蔽
                    var shades = $(".layui-layer-shade");
                    if(shades.length>1){
                        $(shades[1]).remove();
                    }
                }

            });
            //如果多选 返回第一个选中的行
            var row = rows[0];
            // if(row.opt){
            //     row["optid"] = row.opt.optid;
            // }
            //部门为对象不为空 将行添加属性方便展示
            console.debug(row);
            var total=0;
            for(var i of row.maintenanceItems){
                total+=i.totalamt;

            }
                row["reAmount"] = total;
                console.debug(row);
            //回显
            form.val("maintenance", row);

        },


    }
    //通过注册按钮 提交表单 其中回调的data中就是表单对象 data.field是表单的input的name对应的值
    form.on('submit(demo1)', function(data) {
        console.debug(data);
        //拿到隐藏域的id 辨别是否是修改  有id是修改 没有id是新增
        var url = "/repair/save";
        $.post(url, data.field, function (result) {
            if(result.success){
                //提示用户信息，添加数据成功
                layer.msg("操作数据成功");
                //关闭窗口
                layer.closeAll();
                //刷新界面
                table.reload('maintenanceList');
            }else{
                layer.alert("操作失败", {
                    "title":"错误",
                    "icon":2
                });
            }
        });
    })
    //通过注册按钮 提交表单 其中回调的data中就是表单对象 data.field是表单的input的name对应的值
    form.on('submit(demo2)', function(data) {
        console.debug(data.field);
        layer.close(layer.index);
        //拿到隐藏域的id 辨别是否是修改  有id是修改 没有id是新增
        var url = "/repairItem/save";
        $.post(url, data.field, function (result) {
            if(result.success){
                //提示用户信息，添加数据成功
                console.debug(addIndex);
                console.debug("index"+layer.index);
               layer.close(addIndex);
                // layer.msg("操作数据成功");
                //关闭窗口
                // layer.close(addIndex);

                //刷新界面
                table.reload('maintenanceItemList');
            }else{
                layer.close(addIndex);
                layer.alert(result.msg, {
                    "title":"错误",
                    "icon":2
                });
            }
        });
    })
    //通过注册按钮 提交表单 其中回调的data中就是表单对象 data.field是表单的input的name对应的值
    form.on('submit(demo3)', function(data) {
        console.debug(data.field);
        layer.close(layer.index);
        //拿到隐藏域的id 辨别是否是修改  有id是修改 没有id是新增
        var url = "/build/save";
        $.post(url, data.field, function (result) {
            if(result.success){
                //提示用户信息，添加数据成功
               layer.close(addIndex);
                // layer.msg("操作数据成功");
                //关闭窗口
                // layer.close(addIndex);

                //刷新界面
                table.reload('maintenanceList');
            }else{
                layer.close(addIndex);
                layer.alert("操作失败", {
                    "title":"错误",
                    "icon":2
                });
            }
        });
    })

})

