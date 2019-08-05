<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ǰ ��� ȭ��</title>
<link rel="stylesheet" type="text/css" href="../css/5-5.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<form:form method="post" action="../item/search.html">
<div align="center" class="body">
	<h2>��ǰ ��� ȭ��</h2>
	��ǰ�� �˻�&nbsp;<input type="text" name="itemName"/>
	<input type="submit" value="�˻�"/>
	<a href="../item/create.html">��ǰ ���</a>
	<table border="1">
		<tr class="header">
			<th align="center" width="80">��ǰID</th>
			<th align="center" width="320">��ǰ��</th>
			<th align="center" width="100">����</th>
			<th align="center" width="80">����</th>
			<th align="center" width="80">����</th>
		</tr>
		<c:forEach items="${itemList }" var="item">
			<tr class="record">
				<td align="center">${item.itemId }</td>
				<td align="center"><a href="../detail/detail.html?itemId=${item.itemId }">${item.itemName }</a></td>
				<td align="right">
					<f:formatNumber type="currency" currencySymbol="" value="${item.price }" minFractionDigits="0"/>��
					<!-- ���ݾտ� ��ȭǥ�ø� �ϱ� ���� �±� -->
				</td>
				<td align="center"><a href="<c:url value='../item/edit.html'><c:param name='itemId' value='${item.itemId }'></c:param></c:url>" >��ǰ����</a></td>
				<td align="center"><a href="<c:url value='../item/confirm.html'><c:param name='itemId' value='${item.itemId }'></c:param></c:url>" >��ǰ����</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
</form:form>
</body>
</html>