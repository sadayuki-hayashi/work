<%--
  Created by IntelliJ IDEA.
  User: saday
  Date: 2020/09/19
  Time: 18:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>list sample</title>
</head>
<body>
<c:forEach items="${products}" var="product" varStatus="status">
    <p>
        id: ${product.id}
        <br>
        name: ${product.name}
        <br>
        price: ${product.price}
    </p>
</c:forEach>
</body>
</html>
