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
<h3 align="center">��ǰ ���</h3>
<table border="1">
	<tr>
		<td width="40">��ǰ��ȣ</td>
		<td width="200">��ǰ��</td>
		<td width="100">��ǰ����</td>
		<td width="70">������</td>
		<td width="120"></td>
	</tr>
	<c:forEach var="item" items="${ITEM_LIST }">
		<tr height="50">
			<td>${item.code }</td>
			<td><a href="../item/readDetail.html?CODE=${item.code  }">${item.name }</a></td>
			<td>
			<f:formatNumber type="currency" currencySymbol="" value="${item.price }" minFractionDigits="0"/>��
			</td>
			<td>${item.origin }</td>
			<td><a href="#" onClick="window.open('../cart/addCart.html?CODE=${item.code}','cart_result','width=400,height=300').focus()">��ٱ��� ���</a></td>
		</tr>
	</c:forEach>
</table>
<c:forEach var="page" begin="1" end="${COUNT }">
<a href="../item/read.html?pageNo=${page }">${page }</a>
</c:forEach>
</body>
</html>