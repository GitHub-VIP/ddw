//引入admin.js(webapp/static/js/admin.js)
//itemlist.js(webapp/static/js/itemlist.js)
layui.extend({
    admin: '{/}../../static/js/admin'
});
//按需加载admin.js
layui.use(['admin', 'jquery', 'table','form','layer'], function () {
    //初始化变量
    var admin = layui.admin,
        $ = layui.jquery,
        table = layui.table,
        form=layui.form,
        layer = layui.layer;
    //对表格进行渲染
    table.render({
            //什么是表格属性：page,elem,url,cols
            //什么是列属性：type,field,title
            //开启分页
            page: true,
            //渲染的容器是谁
            elem: '#articleList',
            //异步提交请求给后台返回JSON
            url: '../../items',
            //要显示的表头是什么
            cols: [[
            {type: 'checkbox'},
            {field: 'id', title: '商品编号'},
            {field: 'title', title: '商品标题'},
            {field: 'subtitle', title: '商品副标题'},
            /*{field: 'picture', title: '商品主图'},*/
            {field: 'images', title: '商品图片'},
            {field: 'detail', title: '商品详情'},
            {field: 'price', title: '商品价格'},
            {field: 'inventory', title: '库存'},
            {field: 'catName', title: '商品类别'},
            {field: 'status', title: '商品状态', templet: '#myTpl'},
           /* {field: 'status', title: '商品状态', templet: '#shelfTpl'},*/
            {field: 'modify', title: '编辑', templet:'#operateTpl'}

        ]],

        // //当执行完渲染之后的回调（table.render）
         done:function(res,curr,count){
             //val() 相当于js中的value，一般用于文本框、单选按钮、复选按钮取值
             //text() 相当于js中的innerText,一般用于设置文本和取值
             //html() 相当于js中的innerHTML,一般用于设置HTML和取值
             //<div id="mydiv"><strong>你好</strong></div>
             //$("#mydiv").text() ===> 你好
             //$("#mydiv").html() ===> <strong>你好</strong>
             $("[data-field='status']").children().each(function(){
                 if($(this).text() == '1'){
                    $(this).text('正常');
                 }else if ($(this).text() == '2'){
                    $(this).text('下架');
                 }
             });
         }

    });

    //定义active
    var active = {
        reload:function(){
            //val text html
            var title = $.trim($("#title").val());
            if(title.length > 0){
                table.reload('articleList',{
                    page:{curr:1},
                    where:{title:title}
                });
            }

        },
        getCheckData:function(){
            //获取选中行的数据
            var data = table.checkStatus("articleList").data;
            //判断是否有选中行
            if(data.length > 0){
                //有选中行
                //创建一个空数组
                var ids = [];
                //遍历data
                for(var i=0;i<data.length;i++){
                    ids.push(data[i].id);
                }
                //异步提交到后台 ids
                $.post(
                    '../../item/batch',
                    {'ids[]': ids},
                    function (data) {
                        //至少删除一条记录
                        if (data > 0) {
                            //停留在原来页面刷新
                            $('.layui-laypage-btn').click();
                            layer.msg("恭喜，删除成功！", {icon: 1});
                        }
                    },
                    'json'
                );
            }else{
                //没有选中行
                layer.msg("请至少选中一行再批量删除！", {icon: 2});
            }
        }
    };


    //点击"批量删除"按钮触发的事件
    $(".demoTable .layui-btn-danger").on('click', function () {
        // //获取按钮的data-type属性
        var type = $(this).data("type");//getCheckData
        // //判断active这个变量中是否具有getCheckData属性，若有，则调用，若无，则什么都不做
        active[type] ? active[type].call(this) : '';
    });

    //点击"模糊查询"按钮触发的事件
    $(".layui-row .layui-btn").on('click',function(){
        //获取相关属性
        var type = $(this).data('type');//reload
        //判断active对象有没有这个属性
        active[type] ? active[type].call(this) : '';

    });

    // 得到商品状态值  修改正常|下架
    form.on('switch(status)', function (obj) {
        //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        //debugger;
        //当前元素
        var data = $(obj.elem);
        //遍历父级tr，取第一个，然后查找第二个td，取值
        var id = data.parents('tr').first().find('td').eq(1).text();
        var check = obj.elem.checked;

        var status = obj.value;
        //console.log(status);

        $.post(
            //url:这次异步请求提交给谁处理,string
            '../../item/status',
            //data:提交什么给后台处理,object
            {'status': status, 'id': id},
            //success:成功的回调函数,function
            function (data) {
                if (data > 0) {
                    //停留在原来页面刷新
                    $('.layui-laypage-btn').click();
                    layer.msg("修改成功！", {icon: 1});
                }
            },
            //dataType:返回类型,string
            'json'
        );
    });

    //监听行工具事件
   /* form.on('switch(status)', function(obj){ //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
        var data = $(obj.elem);//获得当前行数据
        var id = data.parents('tr').first().find('td').eq(1).text();
        var status = data.val();

        var check = obj.elem.checked;


        $.ajax({
           /!* url: "../../update",*!/
            url:'../../item/status',
            type: 'post',
            data:{ id:id,
                status:status
            },
            dataType: 'JSON',

        })
    });*/





});