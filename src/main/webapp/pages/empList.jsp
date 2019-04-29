<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/29
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>EmpList</title>
    <script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery
/jquery-1.4.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $(".delete").click(function () {
                var href = $(this).attr("href");
                $("form").attr("action", href).submit();
                return false;

            });
        });
    </script>
</head>
<body>

    <form action="" method="post">
        <input type="hidden" name="_method" value="DELETE"/>
    </form>

    <a href="/emp">empAdd</a>

    <c:if test="${empty empList}">
        没有员工！！！
    </c:if>

    <c:if test="${not empty empList}">
        <table cellspacing="0" cellpadding="10" border="1">
            <tr>
                <th>ID</th>
                <th>username</th>
                <th>password</th>
                <th>sex</th>
                <th>department</th>
                <th>删除</th>
                <th>修改</th>
            </tr>
            <c:forEach items="${empList}" var="emp">
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.username}</td>
                    <td>${emp.password}</td>
                    <td>${emp.sex==0?"男":"女"}</td>
                    <td>${emp.department.name}</td>
                    <td><a class="delete" href="/emp/${emp.id}">删除</a></td>
                    <td><a class="update" href="/emp/${emp.id}">修改</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

</body>
</html>
