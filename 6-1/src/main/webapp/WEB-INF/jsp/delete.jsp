<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="itemDelete.title"/></title>
</head>
<body>
<form:form modelAttribute="item" action="delete.html">
<form:hidden path="itemId"/>
	<div align="center" class="body">
		<h2><font color="green"><spring:message code="itemDelete.title"/></font></h2>
		<table>
			<tr height="40px">
				<td>상품명</td>
				<td><form:input path="itemName" cssClass="itemName" disabled="true"/></td>
			</tr>
			<tr height="40px">
				<td>가격</td>
				<td><form:input path="price" cssClass="price" disabled="true"/></td>
			</tr>
			<tr height="40px">
				<td>파일</td>
				<td><img alt="" src="<c:url value='image.html'>
					<c:param name='itemId' value='${item.itemId }'></c:param></c:url>" width="210" height="240"></td>
					<!--url : image.html?itemId=${itemId} -->
			</tr>
			<tr height="40px">
				<td>설명</td>
				<td><form:textarea path="description" disabled="true"/></td>
			</tr>
		</table><br/>
		<input type="submit" value="삭 제"/><br/><br/>
		<a href="index.html">■ 돌아가기</a><br/>
		<a href="../j_spring_security_logout">■ 로그아웃 하기</a>
	</div>
</form:form>
</body>
</html>