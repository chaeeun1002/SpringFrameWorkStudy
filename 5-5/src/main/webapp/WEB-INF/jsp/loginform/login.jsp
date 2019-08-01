<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>로그인 화면</title>
<link rel="stylesheet" type="text/css" href="css/5-3.css">
</head>
<body>
<%@ include file="/WEB-INF/jsp/menu_header.jsp" %>
<div align="center" class="body">
<form:form modelAttribute="user" method="post" action="../loginform/login.html">
	<spring:hasBindErrors name="user">
		<font color="red">
			<c:forEach items="${errors.globalErrors }" var="error">
				<spring:message code="${error.code }"/>
			</c:forEach>
		</font>
	</spring:hasBindErrors>
	<table>
		<tr height="40px">
			<td>사용자 ID</td>
			<td>
				<form:input path="userId" cssClass="userId"/>
				<font color="red">
					<form:errors path="userId"/>
				</font>
			</td>
		</tr>
		<tr height="40px">
			<td>패스워드</td>
			<td>
				<form:password path="password" cssClass="password"/>
				<font color="red">
					<form:errors path="password"/>
				</font>
			</td>
		</tr>
	</table>
	<table>
		<tr>
			<td align="center"><input type="submit" value="로그인"/></td>
			<td align="center"><input type="reset" value="취소"/></td>
		</tr> 
	</table>
</form:form>
<a href="../userentryform/userEntry.html">■ 신규 가입자 등록</a>
</div>
</body>
</html>