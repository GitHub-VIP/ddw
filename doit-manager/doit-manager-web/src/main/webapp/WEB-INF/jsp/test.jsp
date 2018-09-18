<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试layui</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/static/favicon.ico" type="image/x-icon" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/test.js" charset="utf-8"></script>
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/1.12.4/jquery.js"></script>
</head>
<body>
    <h1>hello world</h1>
    <button id="btnClick">点我</button>
    <script>
        $(function(){
            var obj = {'orderList':[{'versionItemId':893,'orderNum':1,'enable':1}]};
            $('#btnClick').click(function(){
                $.ajax({
                    url:'mytest',
                    type:'post',
                    dataType:'json',
                    contentType:'application/json',
                    data:JSON.stringify(obj),
                    success:function(data){
                        console.log(data);
                    }
                });
            });
        });
    </script>
</body>
</html>
