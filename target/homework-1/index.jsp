<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <style>
        .top{
            margin-top: 20px;
        }
        .button{
            margin-left: 20px;
        }
    </style>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $('.submit').click(function () {
                $.post(
                    "loginServlet",
                    {"name":$('#name').val(),"pwd":$('#pwd').val()},
                    function (data) {
                        data=parseInt(data);
                        if(data===2){
                            alert('不存在此用户！！！');
                        }else{
                            if(data===0){
                                location.href='home.jsp';
                            }
                            else {
                                alert('密码错误！！！');
                            }
                        }
                    }
                );
            });
        })
    </script>
</head>
<body>
<form method="post">
    <div class="top">账号：
        <input id="name" type="text" name="name">
    </div>
    <div class="top">密码:
        <input id="pwd" type="text" name="pwd">
    </div>
    <div class="top">
        <input class="button submit" type="button" value="登录">
        <input class="button" type="reset" value="清空">
    </div>
</form>
</body>
</html>
