layui.use(['table','jquery','layer','form'], function() {
    //引入layui组件 每个模块需要引入且定义出来
    var table = layui.table;
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;

    table.render({
        elem: '#maintenanceBuildDatagrid'
        ,url:'/build/page'
        ,toolbar:"#toolbarDemo"
        ,parseData: function(res) { //res 即为原始返回的数据
            totalres=res;
            console.debug(res);
            return {
                "code": 0, //解析接口状态
                "msg":"", //解析提示文本
                "count":res.total?res.total:0, //解析数据长度
                "data": res.rows?res.rows:null //解析数据列表
            }
        }
        ,id:'maintenanceBuildList'
        ,cols: [[
            {type:'checkbox'}
            ,{field:'sid', width:80, title: 'ID', sort: true}
            ,{field:'custormer', width:80, title: '客户名'}
            ,{field:'mainid', width:80, title: '车牌号'}
            ,{field:'settedtime', width:80, title: '订单生产时间'}
            ,{field:'reAmount', width:80, title: '应付金额'}
            ,{field:'payAmount', width:80, title: '实付金额'}
            ,{field:'payType', width:80, title: '支付方式',templet: function(d){
                    // console.debug(d.opt.optname);
                    return d.payType ? "<span style='color: green'>"+d.payType.paytypename+"</span>":"<span style='color: red'>暂未结算</span>";//特殊属性的特殊显示方法 对象展示
                }
            }
            ,{field:'opt', width:80, title: '维修人员',templet: function(d){
                    // console.debug(d.opt.optname);
                    return d.opt ? "<span style='color: green'>"+d.opt.optname+"</span>":"<span style='color: red'>暂无维修人员</span>";//特殊属性的特殊显示方法 对象展示
                }
            }
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
            //用来做高级查询的方法 提交额外参数
            //table.reload('idTest', {
            //url: '/api/table/search'
            //,where: {} //设定异步数据接口的额外参数
            //,height: 300
            //});
            table.reload('maintenanceBuildList', {
                where: $("#maintenceBuildSeachForm").serializeObject()
                ,url: '/build/search'
                ,page: {
                    curr: 1 //重新从第 1 页开始
                }
            });
        },
        delete(){
        //通过id拿到表格选中的行
            var checkStatus = table.checkStatus('maintenanceBuildList');
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
                ids.push(obj.sid);
            });
            layer.confirm('你确认删除吗?', {icon: 3, title:'提示'}, function(index){

                $.get("/build/delete",{"ids":ids.toString()},function(result){
                    if(result.success){
                        window.parent.location.reload();
                        //重新加载表格数据
                        table.reload('maintenanceBuildList');
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
        }
    }

})