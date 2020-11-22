<html>
    <head>
        <link rel="stylesheet" href="/static/styles.css">
    </head>
    <span class="homeHeader">To see the info you have to enter password</span>
    <body>
    <#if error??>
        <p style="color:red;">${error}</p>
    </#if>
    <form action="/login" method="post" enctype="application/x-www-form-urlencoded">
        <div>Password:</div>
        <div><input type="text" name="password" /></div>
        <div><input type="submit" value="Login" /></div>
    </form>
    </body>
</html>