layui.use(['table','jquery','layer','form'], function() {
    //引入layui组件 每个模块需要引入且定义出来
    var table = layui.table;
    var $ = layui.jquery;
    var layer = layui.layer;
    var form = layui.form;

    table.render({
        elem: '#maintenanceCarDatagrid'
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
        ,id:'maintenanceCarList'
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
    var Allmethods={
        toAddress(){
            //通过id拿到表格选中的行
            var checkStatus = table.checkStatus('maintenanceCarList');
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
            console.debug(rows[0].address);
            //表示弹出窗体
            layer.open({
                type: 2,
                title:'修改维修单',
                offset: '100px',
                area: ['450px', '400px'],
                content: '/util/map?address='+rows[0].address, //通过id拿到弹出的表单
                success: function(layero, index){
                    //成功打开窗体 消除遮蔽
                    var shades = $(".layui-layer-shade");
                    if(shades.length>1){
                        $(shades[1]).remove();
                    }
                }

            });
        }
    }
})
