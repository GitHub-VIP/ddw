<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>会员资料编辑-后台管理系统-Admin 1.0</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/weadmin.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>


<body>
<div class="weadmin-body">
    <form class="layui-form" action="${pageContext.request.contextPath}/item/update" method="post">

        <input type="hidden" name="id" id="id" value="${product.id}" />
        <div class="layui-form-item">
            <label class="layui-form-label">
                <span class="we-red">*</span>商品类别
            </label>
            <div class="layui-input-block">
                <select name="categoryId" lay-filter="categoryId">
                    <option value="1">手机</option>
                    <option value="2">书</option>
                    <option value="3">鞋子</option>
                    <option value="4">杯子</option>
                    <%--<c:if test="${product.categoryId==1}">
                        <option value="1" selected="selected">手机</option>
                    </c:if>
                    <c:if test="${product.categoryId==2}">
                        <option value="2" >书</option>
                    </c:if>
                    <c:if test="${product.categoryId==3}">
                        <option value="3" >鞋子</option>
                    </c:if>
                    <c:if test="${product.categoryId==4}">
                        <option value="4" >杯子</option>
                    </c:if>--%>
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label for="title" class="layui-form-label">
                <span class="we-red">*</span>商品名称
            </label>
            <div class="layui-input-inline">
                <input type="text" id="title" name="title" value="${product.title}" required="" required="" lay-verify="required"
                       autocomplete="off"
                       class="layui-input">
            </div>
        </div>
       <%-- <div class="layui-form-item">
            <label for="L_email" class="layui-form-label">
                <span class="we-red">*</span>手机
            </label>
            <div class="layui-input-inline">
                <input type="text" id="L_phone" name="phone" lay-verify="required|phone" autocomplete="" class="layui-input">
            </div>
        </div>--%>
        <div class="layui-form-item">
            <label for="subtitle" class="layui-form-label">
                <span class="we-red">*</span>商品简介
            </label>
            <div class="layui-input-inline">
                <input type="text" id="subtitle" name="subtitle" value="${product.subtitle}" required="" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="priceView" class="layui-form-label">
                <span class="we-red">*</span>商品价格
            </label>
            <div class="layui-input-inline">
                <input type="text" id="priceView" name="price" value="${product.price}" required="" lay-verify="number" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label for="inventory" class="layui-form-label">
                <span class="we-red">*</span>商品数量
            </label>
            <div class="layui-input-inline">
                <input type="text" id="inventory" name="inventory" value="${product.inventory}" required="" lay-verify="number" autocomplete="off"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="detail" class="layui-form-label">
                <span class="we-red">*</span>商品详情
            </label>
            <div class="layui-input-inline">
                <input type="text" id="detail" name="detail" value="${product.detail}" required="" lay-verify="required" autocomplete="off"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label for="modify" class="layui-form-label">
            </label>
            <button class="layui-btn" id="modify" lay-filter="modify" lay-submit="">确定修改</button>
        </div>
    </form>
</div>
<script type="text/javascript">
    layui.extend({
        admin: '{/}../../static/js/admin'
    });
    layui.use(['form', 'jquery', 'admin','layer'], function() {
        var form = layui.form,
            $ = layui.jquery,
            admin = layui.admin,
            layer = layui.layer;

        //页面初始化加载
       /* $(function(){
            setTimeout(function(){
                var dataId = $('input[name="dataId"]').val();
                var index = parent.layer.getFrameIndex(window.name);
                console.log(dataId);
                parent.$("#memberList tr").each(function(){
                    if($(this).attr('data-id')==dataId){
                        console.log($(this));
                        var tdArr=$(this).children('td');
                        var username = tdArr.eq(2).text(); //姓名
                        var sex = tdArr.eq(3).text(); //性别
                        var phone = tdArr.eq(4).text(); //电话
                        var email = tdArr.eq(5).text(); //邮箱
                        var address = tdArr.eq(6).text(); //地址

                        $('input[name="username"]').val(username);
                        //$('input[name="sex"]').val(sex);
                        console.log("sex:"+sex);
                        //$(':radio[name="sex"][value="' + sex + '"]').prop("checked", "checked");
                        $('input[name="sex"][value="'+sex+'"]').attr("checked",true);
                        //$("input[name='radioName'][value=2]").attr("checked",true);
                        $('input[name="phone"]').val(phone);
                        $('input[name="email"]').val(email);
                        $('input[name="address"]').val(address);

//								$('[name=sex]').each(function(i,item){
//								    if($(item).val()==res.sex){
//								        $(item).prop('checked',true);
//								        layui.use('form',function(){
//								        <span style="white-space:pre">  </span>var form = layui.form();
//								        <span style="white-space:pre">  </span>form.render();
//								    <span style="white-space:pre">  </span>});
//								    }
//								});
                    }else{

                        console.log("aaa");
                    }

                });
            },1000);

            //parent.$("#id").val();
            //var dataTr = parent.$("tr").find("td").attr('data-id','dataId');
        });*/

        //监听提交
        form.on('submit(modify)', function (data) {
            console.log(data);

            alert($(data.form).serialize());

            $.ajax({

                url: data.form.action,
                type: data.form.method,
                data: $(data.form).serialize(),

                success: function (rec) {
                    if (rec == 1) {
                        //setTimeout(function () {
                        layer.alert("修改成功", {icon: 6}, function () {
                            // 获得frame索引
                            var index = parent.layer.getFrameIndex(window.name);
                            //关闭当前frame
                            parent.layer.close(index);

                           /* 页面刷新
                            window.location.href = '';*/
                            //父类刷新
                            parent.location.reload();

                        });
                    }
                }

            })

            return false;

        })




      /*  //监听提交
        form.on('submit(update)', function(data) {
            console.log(data);
            //发异步，把数据提交给php
            layer.alert("修改成功", {
                icon: 6
            }, function() {
                // 获得frame索引
                var index = parent.layer.getFrameIndex(window.name);
                //关闭当前frame
                parent.layer.close(index);
            });
            return false;
        });*/

    });
</script>
</body>

</html>