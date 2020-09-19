<%--
  Created by IntelliJ IDEA.
  User: saday
  Date: 2020/09/20
  Time: 3:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>organization list</title>
</head>
<body>
<c:forEach items="${organizations}" var="organization" varStatus="status">
id: ${organization.id}
<br>
name: ${organization.name}
<p>
    </c:forEach>
</body>
</html>

