<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>CalcServlet</title>
</head>
<body>
<form action="/calc" method="post">
    <br>First number <input type="text" name="num1">
    Second number <input type="text" name="num2">
    </br>
    <input name="type" type="radio" value="add" checked> Addition
    <input name="type" type="radio" value="dim"> Diminution
    <input name="type" type="radio" value="mul"> Multiplication
    <input name="type" type="radio" value="div"> Division
    <br>
    <button>Calculate</button>
    </br>

    <c:if test="${requestScope.result != null}">
        ${requestScope.result}
    </c:if>

    <br><a href="/">Home</a></br>
</form>
</body>
</html>
