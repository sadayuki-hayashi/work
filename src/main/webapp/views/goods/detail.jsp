<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品更新</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/list.css" type="text/css">
<script src="${pageContext.request.contextPath}/resources/js/list.js" type="text/javascript"></script>
</head>
<body>
	<div class="main">
		<div class="errorArea">${goodsModel.errorMsg}</div>
		<form:form modelAttribute="goodsModel" method="POST" action="goodsUpdate.do">
			<form:hidden path="productid" />
			<table class="productTable">
				<tr>
					<td class="header">商品名<span class="fontRed">※</span></td>
					<td class="data">
						<form:input path="productname" cssClass="input" />
						<form:errors path="productname" />
					</td>
				</tr>
				<tr>
					<td class="header">値段<span class="fontRed">※</span></td>
					<td class="data">
						<form:input path="price" min="0" cssClass="input price"/>
						<form:errors path="price" />
					</td>
				</tr>
				<tr>
					<td class="header">出品者</td>
					<td class="data">
						<form:input path="sellerid" cssClass="input"/>
					</td>
				</tr>
				<tr>
					<td class="header">説明文</td>
					<td></td>
				</tr>
				<tr>
					<td colspan="2" class="data">
						<form:textarea path="description" cssClass="textArea"/>
					</td>
				</tr>
				<tr>
					<td colspan="2" class="btnArea">
						<input type="submit" value="更新" class="entryBtn" />
						<input type="button" value="戻る"  class="backBtn" onclick="initialList()"/>
					</td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>
