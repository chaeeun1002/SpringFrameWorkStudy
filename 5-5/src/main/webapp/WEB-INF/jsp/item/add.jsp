<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title><spring:message code="itemAdd.title"/></title>
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<form:form modelAttribute="item" action="../item/register.html" enctype="multipart/form-data" method="post">
	<div align="center" class="body">
		<h2><font color="green"><spring:message code="itemAdd.title"/></font></h2>
		<table>
			<tr height="40px">
				<td>상품번호</td>
				<td><form:input path="itemId" cssClass="itemId" maxlength="20"/></td>
				<td><font color="red"><form:errors path="itemId"/></font></td>
			</tr>
			<tr height="40px">
				<td>상품이름</td>
				<td><form:input path="itemName" cssClass="itemName" maxlength="20"/></td>
				<td><font color="red"><form:errors path="itemName"/></font></td>
			</tr>
			<tr height="40px">
				<td>상품가격</td>
				<td><form:input path="price" cssClass="price" maxlength="6"/>&nbsp;원</td>
				<td><font color="red"><form:errors path="price"/></font></td>
			</tr>
			<tr height="40px">
				<td>파일</td>
				<td><input type="file" name="picture"/></td>
				<td></td>
			</tr>
			<tr height="40px">
				<td>상품설명</td>
				<td><form:textarea path="description" cssClass="description"/></td>
				<td><font color="red"><form:errors path="description"/></font></td>
			</tr>
		</table>
		<br/>
		<input type="submit" value="등록"/>
		<input type="reset" value="취소"/><br/><br/>
	</div>
</form:form>
<a href="index.html">돌아가기</a>
</body>
</html>