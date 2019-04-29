<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/4/29
  Time: 17:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  import="java.util.Map" %>
<%@ page import="com.usoft.entity.Employee" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Employee Add</title>
</head>
<body>

<form:form action="${pageContext.request.contextPath}/emp" method="post" modelAttribute="employee">
    <c:if test="${employee.id==null}">
        username:<form:input path="username"></form:input></br>
    </c:if>
    <c:if test="${employee.id!=null}">
        <form:hidden path="id"></form:hidden>
        <input type="hidden" name="_method" value="PUT"/>
    </c:if>
    password:<form:input path="password"></form:input></br>
    <%
        Map<Integer, Object> map = new HashMap();
        map.put(0 ,"男");
        map.put(1 ,"女");
        request.setAttribute("sex1",map);
    %>
    sex:<form:radiobuttons path="sex" items="${sex1}"></form:radiobuttons></br>
    departmentName:<form:select path="department.id" items="${departments}" itemLabel="name" itemValue="id"></form:select>
    </br><input type="submit" value="提交"/>
</form:form>

</body>
</html>
