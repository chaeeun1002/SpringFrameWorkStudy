<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="itemAdd.title"/></title>
</head>
<body>
<form:form modelAttribute="item" action="register.html" enctype="multipart/form-data" method="post">
	<div align="center" class="body">
		<h2><font color="green"><spring:message code="itemAdd.title"/></font></h2>
		<table>
			<tr height="40px">
				<td>상품명</td>
				<td><form:input path="itemName" cssClass="itemName" maxlength="20"/></td>
				<td><font color="red"><form:errors path="itemName"/></font></td>
			</tr>
			<tr height="40px">
				<td>가격</td>
				<td><form:input path="price" cssClass="price" maxlength="20"/></td>
				<td><font color="red"><form:errors path="price"/></font></td>
			</tr>
			<tr height="40px">
				<td>파일</td>
				<td><input type="file" name="picture"/></td>
				<td></td>
			</tr>
			<tr height="40px">
				<td>설명</td>
				<td><form:input path="description" cssClass="description" maxlength="20"/></td>
				<td><font color="red"><form:errors path="description"/></font></td>
			</tr>
		</table><br/>
		<input type="submit" value="등 록"/><input type="reset" value="취 소"/><br/><br/>
		<a href="index.html">■ 돌아가기</a><br/>
		<a href="../j_spring_security_logout">■ 로그아웃 하기</a>
	</div>
</form:form>
</body>
</html>