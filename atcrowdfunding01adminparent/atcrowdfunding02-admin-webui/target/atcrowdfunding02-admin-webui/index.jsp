<%--
  Created by IntelliJ IDEA.
  User: wutong
  Date: 2021/1/21
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>测试页面</title>
    <base href="http://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/">
    <script type="text/javascript" src="jquery/jquery-2.1.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#btn1").click(function () {
                $.ajax({
                    "url":"send/array.html",         //请求目标资源的地址
                    "type":"post",                   //请求方式
                    "data":{
                        "array":[5,8,12]
                    },                               //要发送的请求参数
                    "dataType":"text",               //如何对待服务器端返回的数据
                    "success":function (response) {  //服务器端成功处理请求后调用的回调函数
                        alert(response);
                    },
                    "error":function (response) {    //服务器端处理请求失败后调用的回调函数
                        alert(response);
                    }
                });
            });
        });

    </script>
</head>
<body>
    <a href="test/ssm.html">测试SSM整合的环境</a>
    <br/>
    <button id="btn1">Send [5,8,12] One</button>



</body>
</html>
