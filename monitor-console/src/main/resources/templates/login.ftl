<#assign base = request.contextPath >
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <script src="${base}/js/jquery.js"></script>
</head>
<body>

<div>
    <form>
        <#if error_message?exists>
            <h2>${error_message}</h2>
        </#if>
        用户名: <input id="username" type="text">
        <br>
        密码: <input id="password" type="text">
        <button type="submit" id="btn-submit">登录</button>
    </form>
</div>

<script type="text/javascript">
    $(function () {
        $('#btn-submit').click(function () {
            $.ajax({
                url: '${base}/login',
                data: {
                    username: $('#username').val(),
                    password: $('#password').val()
                },
                method:"POST",
                success: function (data) {

                }
            })
        });
    });
</script>

</body>
</html>