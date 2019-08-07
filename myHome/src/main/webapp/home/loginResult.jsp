<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:choose>
	<c:when test="${sessionScope.loginUser != null }">
		<h3 align="center"> 로그인 되었습니다.
		안녕하세요? ${sessionScope.loginUser } 님~~
		</h3>
	</c:when>
	<c:otherwise>
		<h3 align="center">
		로그인 되지 못했습니다. 아이디와 암호를 확인하세요.
		</h3>
	</c:otherwise>
</c:choose>
</body>
</html>