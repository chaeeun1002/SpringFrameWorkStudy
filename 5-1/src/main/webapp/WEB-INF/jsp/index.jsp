<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>상품 목록 화면</title>
<link rel="stylesheet" type="text/css" href="css/5-1.css">
</head>
<body>
<div align="center" class="body">
	<h2>상품 목록 화면</h2>
	<table border="1">
		<tr class="header">
			<th align="center" width="80">상품ID</th>
			<th align="center" width="320">상품명</th>
			<th align="center" width="100">가격</th>
		</tr>
		<c:forEach items="${itemList }" var="item">
			<tr class="record">
				<td align="center">${item.itemId }</td>
				<td align="center">${item.itemName }</td>
				<td align="center">${item.price }</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>