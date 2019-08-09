<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">상품 목록</h3>
<table border="1">
	<tr>
		<td width="40">상품번호</td>
		<td width="200">상품명</td>
		<td width="100">상품가격</td>
		<td width="70">원산지</td>
		<td width="120"></td>
	</tr>
	<c:forEach var="item" items="${ITEM_LIST }">
		<tr height="50">
			<td>${item.code }</td>
			<td><a href="../item/readDetail.html?CODE=${item.code  }">${item.name }</a></td>
			<td>
			<f:formatNumber type="currency" currencySymbol="" value="${item.price }" minFractionDigits="0"/>원
			</td>
			<td>${item.origin }</td>
			<td><a href="#" onClick="window.open('../cart/addCart.html?CODE=${item.code}','cart_result','width=400,height=300').focus()">장바구니 담기</a></td>
		</tr>
	</c:forEach>
</table>
<c:forEach var="page" begin="1" end="${COUNT }">
<a href="../item/read.html?pageNo=${page }">${page }</a>
</c:forEach>
</body>
</html>