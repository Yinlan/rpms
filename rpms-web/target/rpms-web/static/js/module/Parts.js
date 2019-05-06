layui.use(['table','jquery','layer','form'], function() {
    //引入layui组件 每个模块需要引入且定义出来
    var table = layui.table;
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;

    form.verify({
        //检查名字存在异步请求问题 发送ajax同步请求
        checkName:function(value,item){

            var html = $.ajax({
                url: "/car/checkName",
                data:{"partsname": value, "pid": $("input[name='pid']").val()},
                async: false
            }).responseText;
            console.debug(html);
            if(html =='false'){
                return "配件已存在请修改";
            }
        }
    });

    table.render({
        elem: '#partsDatagrid'
        ,url:'/car/page'
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
        ,id:'partsList'
        ,cols: [[
            {type:'checkbox'}
            ,{field:'pid', width:80, title: '配件编号', sort: true}
            ,{field:'partsname', width:80, title: '配件名称'}
            ,{field:'price', width:80, title: '价格', sort: true}
            ,{field:'num', width:80, title: '数量'}
            ,{field:'warnnum', width:80, title: '警告数量'}
            ,{field:'context', width:80, title: '配件描述'}
            ,{field:'createtime', width:80, title: '创建时间'}
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
    var Allmethods={
        reload(){
            table.reload('partsList', {
                where: $("#partsSeachForm").serializeObject()
                ,url: '/car/search'
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        },
        updateDB(){
            table.reload('partsList', {
                where: $("#partsSeachForm").serializeObject()
                ,url: '/car/updateDb'
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        },
        add(){
            //清空form表单
            $("#parts").clearForm();
            $("#id").val('');
            //表示弹出窗体
            layer.open({
                type: 1,
                offset: '100px',
                title:'添加配件',
                area: ['450px', '400px'],
                content: $("#partsFormDiv"), //这里content是一个普通的String
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
            var checkStatus = table.checkStatus('partsList');
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
                ids.push(obj.pid);
            });
            layer.confirm('你确认删除吗?', {icon: 3, title:'提示'}, function(index){

                $.get("/car/delete",{"ids":ids.toString()},function(result){
                    if(result.success){
                       /* window.parent.location.reload();*/
                        //重新加载表格数据
                        table.reload('partsList');
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
            $("#parts").clearForm();
            //通过id拿到表格选中的行
            var checkStatus = table.checkStatus('partsList');
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
            //表示弹出窗体
            layer.open({
                type: 1,
                title:'修改维修单',
                offset: '100px',
                area: ['450px', '400px'],
                content: $("#partsFormDiv"), //通过id拿到弹出的表单
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
            /*
            if(row.opt){
                row["optid"] = row.opt.optid;
            }*/
            //部门为对象不为空 将行添加属性方便展示
            //回显
            form.val("parts", row);

        }
    }
    form.on('submit(demo1)', function(data) {
        console.debug(data);
        //拿到隐藏域的id 辨别是否是修改  有id是修改 没有id是新增
        var url = "/car/save";
        $.post(url, data.field, function (result) {
            if(result.success){
                //提示用户信息，添加数据成功
                layer.msg("操作数据成功");
                //关闭窗口
                layer.closeAll();
                //刷新界面
                table.reload('partsList');
            }else{
                layer.alert("操作失败", {
                    "title":"错误",
                    "icon":2
                });
            }
        });
    })
})
