<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品一覧</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/list.css" type="text/css">
<script src="${pageContext.request.contextPath}/resources/js/list.js" type="text/javascript"></script>
</head>
<body>
	<div class="main">
		<div class ="mainContent">
			<form action="list.do" method="POST">
				<div class="searchArea">
					<div class="inlineArea productArea">
						<div class="inlineArea headerArea">商品名</div>
						<div class="inlineArea inputArea">
							<input type="text" class="" value="${goodsSearchForm.productname}" name="productname"/>
						</div>
					</div>
					<div class="inlineArea priceArea">
						<div class="inlineArea">値段</div>
						<div class="inlineArea"><input type="number" min="0" class="number" value="${goodsSearchForm.priceMin}" name="priceMin" class="searchNumInput"/></div>
						<div class="inlineArea">～</div>
						<div class="inlineArea"><input type="number" min="0" class="number" value="${goodsSearchForm.priceMax}" name="priceMax" class="searchNumInput"/></div>
					</div>
				</div>
				<div class="btnArea">
					<div>
						<input type="submit" value="検索" class="searchBtn"/>
					</div>
				</div>
			</form>
		</div>

		<div class ="listArea">
			<table class="tableHeader">
				<tr>
					<th class="productIdHeader">商品ID</th>
					<th class="productName">商品名</th>
					<th class="priceHeader">値段</th>
					<th class="sellerId">出品者</th>
					<th class="detail">商品詳細</th>
				</tr>
			</table>
			<c:if test="${GoodsList.size() > 0}">
				<div class="tableDiv">
					<table class="tableList">
						<c:forEach var="goods" items="${GoodsList}" >
							<tr>
								<td class="productIdData">${goods.productid}</td>
								<td class="productName">${goods.productname}</td>
								<td class="priceValue"><fmt:formatNumber value="${goods.price}" pattern="\###,###" /></td>
								<td class="sellerId">${goods.sellerid}</td>
								<td class="detail"><input type="button" value="商品詳細" onclick="thisProductDetail(${goods.productid})" /></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</c:if>
		</div>
		<div class="newProductArea">
			<input type="button" value="新規出品" onclick="createNewProduct()" class="newProductBtn"/>
		</div>
	</div>
</body>
</html>
