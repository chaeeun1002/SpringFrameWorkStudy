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
		<c:if test="${cartlogin == 'YES' }">
			<a href="../cart/login.html">■ 다시 로그인 하기</a>
		</c:if>
	</c:otherwise>
</c:choose>
<c:choose>
	<c:when test="${cartlogin == 'SUCCESS' }">
		<a href="#" onClick="self.close();opener.window.location.reload();">닫기</a>
	</c:when>
</c:choose>
</body>
</html>