<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>添加订单-后台管理系统-Admin 1.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/weadmin.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/treeselect.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <%--<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/treeselect.js" charset="utf-8"></script>--%>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="weadmin-body">
    <form class="layui-form" action="${pageContext.request.contextPath}/item/add" method="post">
        <%--<div class="layui-form-item">
            <label for="categoryId" class="layui-form-label">
                <span class="we-red">*</span>商品类别
            </label>
            <div class="layui-input-inline">
                <input type="text" id="categoryId" name="categoryId" required="" lay-verify="required"  autocomplete="off" class="layui-input">
            </div>
        </div>--%>
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="we-red">*</span>商品类别
            </label>
            <div class="layui-input-block">
                <select name="categoryId" lay-filter="categoryId">
                    <option value="">请选择</option>
                    <option value="1">手机</option>
                    <option value="2">书</option>
                    <option value="3">鞋子</option>
                    <option value="4">杯子</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="title" class="layui-form-label">
                <span class="we-red">*</span>商品名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="title" name="title" required="" required="" lay-verify="required"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="subtitle" class="layui-form-label">
                <span class="we-red">*</span>商品简介
            </label>
            <div class="layui-input-inline">
                <input type="text" id="subtitle" name="subtitle" required="" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <%-- <div class="layui-form-item">
             <label for="images" class="layui-form-label">
                 <span class="we-red">*</span>商品图片
             </label>
             <div class="layui-input-inline">
                 <input type="text" id="images" name="images" required="" lay-verify="required" autocomplete="off"
                        class="layui-input">
             </div>
         </div>--%>
        <div class="layui-form-item layui-form-text">
            <label for="images" class="layui-form-label">
                <span class="we-red">*</span>商品图片
            </label>
            <div class="layui-input-block">
                <%--第一步--%>
                <textarea id="images" name="images" class="layui-textarea" style="display: none"></textarea>
            </div>

        </div>

            <input type="text" value="${images}">

        <div class="layui-form-item">
            <label for="priceView" class="layui-form-label">
                <span class="we-red">*</span>商品价格
            </label>
            <div class="layui-input-inline">
                <input type="text" id="priceView" name="price" required="" lay-verify="number" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="inventory" class="layui-form-label">
                <span class="we-red">*</span>商品数量
            </label>
            <div class="layui-input-inline">
                <input type="text" id="inventory" name="inventory" required="" lay-verify="number" autocomplete="off"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="detail" class="layui-form-label">
                <span class="we-red">*</span>商品详情
            </label>
            <div class="layui-input-inline">
                <input type="text" id="detail" name="detail" required="" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label for="add" class="layui-form-label">
            </label>
            <button id="add" class="layui-btn" lay-submit lay-filter="add">增加</button>
        </div>
    </form>
</div>

<%--$("#id").val(src);--%>

<script type="text/javascript">
    layui.extend({
        admin: '{/}../../static/js/admin'
    });
    layui.use(['form', 'admin', 'layer', 'layedit', 'jquery'], function () {
        var form = layui.form,
            admin = layui.admin,
            layer = layui.layer,
            layedit = layui.layedit;
        $ = layui.jquery;

        //监听提交
        form.on('submit(add)', function (data) {
            console.log(data);

            alert($(data.form).serialize());

            $.ajax({

                url: data.form.action,
                type: data.form.method,
                data: $(data.form).serialize(),

                success: function (rec) {
                    if (rec == 1) {
                        //setTimeout(function () {
                        layer.alert("增加成功", {icon: 6}, function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);

                            /*页面刷新
                            window.location.href = '';*/
                            //父类刷新
                            parent.location.reload();

                        });
                    }
                }

            })

            return false;

        })

        //初始化富文本编辑器
        layedit.build('images', {
            height: 100,//设置编辑器高度
            uploadImage: {
                url: '../../uploadImage',
                type: 'post',
                data:'json',

                
            },
        });
        layedit.getContent(index,function () {
            console.log(index);
        });
        //console.log(c);


    });

</script>


</body>

</html>