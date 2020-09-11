<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Account</title>
</head>
<body>
<form action="/account" method="post">
    <input name="name" tape="text" placeholder="name" required minlength="3" maxlength="16">
    <input name="password" tape="text" placeholder="password" required minlength="3" maxlength="16">
    <button>update</button>
    <br><a href="/">Home</a></br>
</form>
</body>
</html>
