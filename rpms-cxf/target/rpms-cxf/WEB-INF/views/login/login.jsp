
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>超鹏汽车维修系统</title>
    <!-- metatags-->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
    function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!-- Meta tag Keywords -->
    <!-- Custom-Style-Sheet -->
    <link href="/static/login/css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
    <link href="/static/login/css/style.css" rel="stylesheet" type="text/css" media="all"/><!--style_sheet-->
    <link rel="stylesheet" href="/static/login/css/flexslider.css" type="text/css" media="screen" property="" />
    <link rel="stylesheet" href="/static/login/css/font-awesome.css"> <!-- Font-Awesome_Icons-CSS -->
    <!--//Custom-Style-Sheet -->
    <!--online_fonts-->

    <!--//online_fonts-->
</head>
<body>
<div class="w3l-head">
    <h1>超鹏汽车维修系统</h1>
</div>
<div class="w3l-main">
    <div class="w3l-left-side">

        <div class="flexslider">
            <ul class="slides">
                <li>
                    <img style="margin-top: 80px" src="/static/login/images/1.jpg" alt="image"/>
                </li>
                <li>
                    <img style="margin-top: 80px" src="/static/login/images/2.jpg" alt="image"/>
                </li>
                <li>
                    <img style="margin-top: 90px" src="/static/login/images/3.jpg" alt="image"/>
                </li>
                <li>
                    <img style="margin-top: 80px" src="/static/login/images/4.jpg" alt="image"/>
                </li>
                <li>
                    <img style="margin-top: 80px" src="/static/login/images/5.jpg" alt="image"/>
                </li>
                <li>
                    <img style="margin-top: 80px" src="/static/login/images/6.jpg" alt="image"/>
                </li>
                <li>
                    <img style="margin-top: 80px" src="/static/login/images/7.jpg" alt="image"/>
                </li>
                <li>
                    <img style="margin-top: 80px" src="/static/login/images/8.jpg" alt="image"/>
                </li>
            </ul>
        </div>
    </div>

    <div class="w3l-rigt-side">
        <form action="#" method="post">
            <div class="w3l-signin">
                <a class="w3_play_icon1" href="#small-dialog1"> 登  录</a>
            </div>
            <div class="w3l-signup">
                <a class="w3_play_icon1" href="#small-dialog2"> 注  册</a>
            </div>
            <div style="margin-left: 200px">
                <a  href="#"><img style="width:30px; height:30px; border-radius:50%; " src="/static/login/images/QQ.jpg"></a>
                <a  href="/wechat"><img style="width:30px; height:30px; border-radius:50%; " src="/static/login/images/wx.webp"></a>
                <a  href="#"><img style="width:30px; height:30px; border-radius:50%; " src="/static/login/images/wb.jpeg"></a>
            </div>
            <div class="clear"></div>
        </form>
    </div>
    <div class="clear"></div>
</div>

<!--sign in form -->
<div id="small-dialog1" class="mfp-hide">
    <div class="wthree-container">
        <div class="wthree-form">
            <div class="agileits-2">
                <h2>登  录</h2>
            </div>
            <form action="#" method="post">
                <div class="w3-user">
                    <span><i class="fa fa-user-o" aria-hidden="true"></i></span>
                    <input type="text" id="username" name="username" placeholder="请输入账号" >
                </div>
                <div class="clear"></div>
                <div class="w3-psw">
                    <span><i class="fa fa-key" aria-hidden="true"></i></span>
                    <input type="password" id="password" name="password" placeholder="请输入密码" >
                </div>
                <div class="clear"></div>
                <div class="w3l-check">
                    <input type="checkbox" class="checkbox">
                    <span><a href="#">忘记密码 ?</a></span>
                </div>
                <div class="clear"></div>
                <div class="signin">
                    <button class="login100-form-btn" onclick="login()">
                        登陆
                    </button>
                </div>
                <div class="clear"></div>
            </form>
        </div>
    </div>
</div>
<!--sign in form -->
<!-- for register popup -->

<!--sign up form -->
<div id="small-dialog2" class="mfp-hide">
    <div class="wthree-container">
        <div class="wthree-form bg">
            <div class="agileits-2">
                <h2>注  册</h2>
            </div>
            <form action="#" method="post">
                <div class="w3-user">
                    <span><i class="fa fa-user-o" aria-hidden="true"></i></span>
                    <input type="text" name="name" placeholder="请输入账号" required="">
                </div>
                <div class="clear"></div>
                <div class="w3-email">
                    <span><i class="fa fa-envelope" aria-hidden="true"></i></span>
                    <input type="email" name="email" placeholder="请输入邮箱" required=""/>
                </div>
                <div class="clear"></div>
                <div class="w3-psw">
                    <span><i class="fa fa-key" aria-hidden="true"></i></span>
                    <input type="password" name="password" placeholder="请输入密码" required="">
                </div>
                <div class="w3-cpsw">
                    <span><i class="fa fa-key" aria-hidden="true"></i></span>
                    <input type="password" name="password" placeholder="再次输入密码" required="">
                </div>
                <div class="clear"></div>
                <div class="w3l-check">
                    <input type="checkbox" class="checkbox">
                    <span style="color: #6fcfff">阅读并接受<a style="color: #9b20b7" href="https://passport.baidu.com/static/passpc-account/html/protocal.html">《华云汽车用户协议》</a></span>
                </div>
                <div class="clear"></div>
                <div class="signin">
                    <input type="submit" value="注  册">
                </div>
                <div class="clear"></div>
            </form>
        </div>
    </div>
</div>
<!--sign up form -->
<!--sign in form -->
<!-- //for register popup -->


<script type="text/javascript" src="/static/login/js/jquery-2.1.4.min.js"></script>

<!-- pop-up-box-js-file -->
<script src="/static/login/js/jquery.magnific-popup.js" type="text/javascript"></script>
<!--//pop-up-box-js-file -->
<script>
    $(document).ready(function() {
        $('.w3_play_icon,.w3_play_icon1,.w3_play_icon2').magnificPopup({
            type: 'inline',
            fixedContentPos: false,
            fixedBgPos: true,
            overflowY: 'auto',
            closeBtnInside: true,
            preloader: false,
            midClick: true,
            removalDelay: 300,
            mainClass: 'my-mfp-zoom-in'
        });

    });
</script>
<!-- flexSlider -->
<script defer src="/static/login/js/jquery.flexslider.js"></script>
<script type="text/javascript">
    $(window).load(function(){
        $('.flexslider').flexslider({
            animation: "slide",
            start: function(slider){
                $('body').removeClass('loading');
            }
        });
        function login() {
            /*登陆发生ajax请求*/
            var username = $('#username').val();
            var password = $('#password').val();

            var obj = {
                username,
                password,
            };
            //jQuery的post请求
            $.post("/login", obj, function (res) {
                console.debug(res);
                if (res.sucessful) {
                    console.debug(7777);
                    /*window.location.href = "/main";*/
                } else {
                    $.messager.alert('警告', '警告消息' + res.mig);
                }
            });
        }

        })
</script>
<!-- //flexSlider -->
</body>
</html>
