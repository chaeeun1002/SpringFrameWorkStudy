<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${RESULT == 'nologin' }">
		<h3 align="center">상품을 담으시려면 로그인을 해야합니다.</h3>
	</c:when>
</c:choose>
<form:form modelAttribute="user" action="../cart/login.html" method="post">
	아이디 : <form:input path="id" size="12"/>
	<font color="red"><form:errors path="id"/></font><br/>
	패스워드 : <form:password path="password" size="12"/>
	<font color="red"><form:errors path="password"/></font><br/>
	<input type="submit" value="로그인"/>
</form:form>
<div align="right">
	<a href="../home/entryform.html">가입하기</a>
</div>
</body>
</html>