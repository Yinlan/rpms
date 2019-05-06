<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="login_container"></div>
</body>
</html>
<%--引入微信的js支持--%>
<script type="text/javascript" src="http://res.wx.qq.com/connect/zh_CN/htmledition/js/wxLogin.js"></script>
<script type="text/javascript">
    var obj = new WxLogin({
        self_redirect:false,
        id:"login_container",
        appid: "wxd853562a0548a7d0",
        scope: "snsapi_login",
        redirect_uri: "http://bugtracker.itsource.cn/callback",
        state: "xxx",
        style: "white",
        href: ""
    });
</script>
