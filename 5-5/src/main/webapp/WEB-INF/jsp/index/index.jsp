<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>상품 목록 화면</title>
<link rel="stylesheet" type="text/css" href="../css/5-5.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<form:form method="post" action="../item/search.html">
<div align="center" class="body">
	<h2>상품 목록 화면</h2>
	상품명 검색&nbsp;<input type="text" name="itemName"/>
	<input type="submit" value="검색"/>
	<a href="../item/create.html">상품 등록</a>
	<table border="1">
		<tr class="header">
			<th align="center" width="80">상품ID</th>
			<th align="center" width="320">상품명</th>
			<th align="center" width="100">가격</th>
			<th align="center" width="80">편집</th>
			<th align="center" width="80">삭제</th>
		</tr>
		<c:forEach items="${itemList }" var="item">
			<tr class="record">
				<td align="center">${item.itemId }</td>
				<td align="center"><a href="../detail/detail.html?itemId=${item.itemId }">${item.itemName }</a></td>
				<td align="right">
					<f:formatNumber type="currency" currencySymbol="" value="${item.price }" minFractionDigits="0"/>원
					<!-- 가격앞에 원화표시를 하기 위한 태그 -->
				</td>
				<td align="center"><a href="<c:url value='../item/edit.html'><c:param name='itemId' value='${item.itemId }'></c:param></c:url>" >상품편집</a></td>
				<td align="center"><a href="<c:url value='../item/confirm.html'><c:param name='itemId' value='${item.itemId }'></c:param></c:url>" >상품삭제</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</form:form>
</body>
</html>