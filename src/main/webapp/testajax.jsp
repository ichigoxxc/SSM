<%--
  Created by IntelliJ IDEA.
  User: ichigoxxc
  Date: 2018/9/17
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <!--声明文档兼容模式，表示使用IE浏览器的最新模式-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!--设置视口的宽度(值为设备的理想宽度)，页面初始缩放值<理想宽度/可见宽度>-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>测试bootstrap、jquery、ajax</title>

    <!-- 引入Bootstrap核心样式文件 -->
    <link href="plugin/bootstrap-3.3.7/css/bootstrap.css" rel="stylesheet">

    <!-- 引入jQuery核心js文件 -->
    <script src="plugin/jquery-3.3.1/jquery-3.3.1.min.js"></script>
    <!-- 引入BootStrap核心js文件 -->
    <script src="plugin/bootstrap-3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="col-sm-4">
    <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
</div>
<div class="col-sm-4">
    <span id="showUsernameSpan">用户名提示：</span>
<%--
    <span id="showUsernameSpan" class="label label-success">用户名可用</span>
    <span id="showUsernameSpan" class="label label-danger">用户名不可用</span>
--%>
</div>

<div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
        <input type="submit" id="registButton" disabled="disabled" width="100" value="注册" border="0"
               style="background: url('images/register.gif') no-repeat scroll 0 0 rgba(0,0,0,0);
               height: 35px;width: 100px;color: white;" class="form-control">

    </div>
</div>



<script type="text/javascript">
    $(function () {
        $("input[name='username']").blur(function () {
            //1 确定请求路径
            var url = "${pageContext.request.contextPath}/userChecKServlet.do";
            //2 确定请求参数
            var params = {"username":$(this).val()};
            //3 发送ajax请求
            $.post(url,params,function(data){
                $("#showUsernameSpan").addClass("label");
                if(data.flag){
                    //4.2 可用，添加success样式（bootstrap提供），并移出按钮禁用
                    $("#showUsernameSpan").addClass("label-success");
                    $("#showUsernameSpan").removeClass("label-danger");
                    $("registButton").removeProp("disabled");
                } else{
                    //4.3 不可用，添加danger样式（bootstrap提供），并禁用按钮
                    $("#showUsernameSpan").addClass("label-danger");
                    $("#showUsernameSpan").removeClass("label-success");
                    $("registButton").prop("disabled","disabled");
                }
                //4.4 设置提示信息
                $("#showUsernameSpan").text(data.message);
            },"json");
        });
    });

</script>
</body>
</html>
