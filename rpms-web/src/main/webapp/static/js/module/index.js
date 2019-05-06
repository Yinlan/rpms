layui.use(['element','layer','jquery','tree'], function(){
    var element = layui.element;
    var layer = layui.layer;
    var $ = layui.jquery;

/*    var menuData =  [ //节点
        {
            name: '维修工单管理'
            ,id: '1'
            ,children: [
                {
                    name: '维修工单'
                    ,id: '11'
                    ,url: '/maintenance/index'
                }, {
                    name: '工单明细'
                    ,id: '12'
                    ,url: '/maintenance/index'
                }
            ]
        }, {
            name: '结算工单管理'
            ,id: '2'
            ,children: [
                {
                    name: '结算工单'
                    ,id: '21'
                    ,url: '/maintenance/index'
                }, {
                    name: '取消结算单'
                    ,id: '22'
                    ,url: '/maintenancebuild/index'
                }
            ]
        },
        {
            name: '部门管理'
            ,id: '7'
            ,children: [
                {
                    name: '员工'
                    ,id: '71'
                    ,url: '/employee/index'
                }, {
                    name: '部门管理'
                    ,id: '72'
                    ,url: '/department/index'
                }
            ]
        },
        {
            name: '系统管理'
            ,id: '3'
            ,children: [
                {
                    name: '支付方式管理'
                    ,id: '31'
                    ,url: '/paytype/index'
                }, {
                    name: '维修人员管理'
                    ,id: '32'
                    ,url: '/opt/index'
                },
                {
                    name: '系统权限管理'
                    ,id: '33'
                    ,url: '/permission/index'
                },
                {
                    name: '系统角色管理'
                    ,id: '34'
                    ,url: '/role/index'
                },
                {
                    name: '系统菜单'
                    ,id: '35'
                    ,url: '/menu/index'
                },
                {
                    name: '系统日志'
                    ,id: '36'
                    ,url: ''
                },{
                    name: '结算单查询'
                    ,id: '37'
                    ,url: ''
                }
            ]
        },{
            name: '还车管理'
            ,id: '4'
            ,url: '/returncar/index'
        },
        {
            name: '配件管理'
            ,id: '5'
            ,url: '/parts/index'
        },{
            name: '第三方登录管理'
            ,id: '6'
            ,url: ''
        }
    ]*/

    var menuDataStr = $.ajax({
        url: "/util/menu",
        async: false
    }).responseText;
   var menuData=JSON.parse(menuDataStr);
    console.debug(menuData);
    layui.tree({
        elem: '#sidemenubar' //传入元素选择器
        ,skin: 'sidebar'  //自定义tree样式的类名
        ,nodes:menuData  //节点数据
        ,click: function(node,item){
            //node即为当前点击的节点数据,item就是被点击的a标签对象了
            //导航按钮选中当前
            $('#sidemenubar a').removeClass('active');
            $(item).addClass('active');
            $(item).siblings('.layui-tree-spread').click();
            console.debug(node);
            //如果该节点有url就添加新tab
            if (node.url) {
                var index=node.id;
                //遍历打开的窗口，如果当前点击的选项已经打开，则跳转到对应窗口去，不再执行for外面的两条语句，创建新窗口
                for (var i = 0; i <$('.x-iframe').length; i++) {
                    if($('.x-iframe').eq(i).attr('tab-id')==index){
                        tab.tabChange(index);
                        // event.stopPropagation();//阻止冒泡事件
                        return;
                    }
                };
                tab.tabAdd(node.name,node.url,node.id);
                tab.tabChange(index);
            }
        }
    });

    //点击新增子页面
    var tab = {
        tabAdd:function(title,url,id){
            element.tabAdd('mainTab',{
                title: title,
                content: '<iframe tab-id="'+id+'" frameborder="0" src="'+url+'" scrolling="yes" class="x-iframe"></iframe>',
                id: id
            })
        },
        tabDelete:function(othis){
            element.tabDelete('mainTab',id);
            othis.addClass('layui-btn-disabled');
        },
        tabChange:function(id){
            //切换到指定Tab项
            element.tabChange('mainTab', id); //切换到：用户管理
        }
    };
});