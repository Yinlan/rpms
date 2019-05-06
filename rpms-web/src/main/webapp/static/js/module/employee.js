layui.use(['table','jquery','layer','form'], function() {
    //引入layui组件 每个模块需要引入且定义出来
    var table = layui.table;
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;

    table.render({
        elem: '#employeeDatagrid'
        ,url:'/employee/page'
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
        ,id:'employeeList'
        ,cols: [[
            {type:'checkbox'}
            ,{field:'id', width:80, title: '员工编号', sort: true}
            ,{field:'name', width:80, title: '员工账号'}
            ,{field:'pwd', width:80, title: '密码'}
            ,{field:'age', width:80, title: '年级'}
            ,{field:'tel', width:80, title: '电话号码'}
            ,{field:'email', width:80, title: '邮件'}
            ,{field:'roles', width:80, title: '角色',templet: function(d){
                 console.debug(d.roles);
                    return d.roles ? "<span style='color: green'>"+d.roles[0].name+"</span>":"<span style='color: red'>暂无维修人员</span>";//特殊属性的特殊显示方法 对象展示
                }}

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
    $.get("/util/role", function(data){
        var select= $("#selectRole");
        //将信息置空
        select.empty();
        //添加一个默认的选项
        select.append("<option value=''>请选择</option>");
        $.each(data, function (index, obj) {
            select.append("<option name='\"+obj.id+\"' value='"+obj.id+"'>"+obj.name+"</option>");
        });
        //重新渲染select
        form.render('select');

    });
    var Allmethods={
        add(){
            //清空form表单
            $("#employee").clearForm();
            //表示弹出窗体
            layer.open({
                type: 1,
                offset: '100px',
                title:'添加支付方式',
                area: ['450px', '400px'],
                content: $("#employeeFormDiv"), //这里content是一个普通的String
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
            var checkStatus = table.checkStatus('employeeList');
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
                ids.push(obj.id);
            });
            layer.confirm('你确认删除吗?', {icon: 3, title:'提示'}, function(index){

                $.get("/employee/delete",{"ids":ids.toString()},function(result){
                    if(result.success){
                        window.parent.location.reload();
                        //重新加载表格数据
                        table.reload('employeeList');
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
            $("#employee").clearForm();
            //通过id拿到表格选中的行
            var checkStatus = table.checkStatus('employeeList');
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
                content: $("#employeeFormDiv"), //通过id拿到弹出的表单
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
            if(row.roles){
               $("#selectRole").val(row.roles[0].id);
            }
            //部门为对象不为空 将行添加属性方便展示
            //回显
            form.val("employee", row);

        }
    }
    form.on('submit(demo1)', function(data) {
        console.debug(data);
        //拿到隐藏域的id 辨别是否是修改  有id是修改 没有id是新增
        var url = "/employee/save";
        $.post(url, {"str":JSON.stringify(data.field),"rid":$("#selectRole").val()}, function (result) {
            if(result.success){
                //提示用户信息，添加数据成功
                layer.msg("操作数据成功");
                //关闭窗口
                layer.closeAll();
                //刷新界面
                table.reload('employeeList');
            }else{
                layer.alert("操作失败", {
                    "title":"错误",
                    "icon":2
                });
            }
        });
    })
})
