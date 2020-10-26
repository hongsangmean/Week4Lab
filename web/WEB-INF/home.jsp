<%-- 
    Document   : home
    Created on : Oct 7, 2020, 12:30:55 PM
    Author     : 703922
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>home Page</title>
    </head>
    <body>
         <h1>Home Page</h1>
        <h2>Hello ${username}.</h2>
        <form action="login" method="GET" name="logout">
            <input type="submit" name="logout" value="Log Out">
        </form>
    </body>
</html>
