<#-- @ftlvariable name="data" type="com.example.IndexData" -->
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="/static/styles.css">
    </head>
    <body>
        <ul>
        <#list data.items as item>
            <li>${item}</li>
        </#list>
        </ul>
    </body>
</html>