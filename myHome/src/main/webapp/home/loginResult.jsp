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
		<h3 align="center"> �α��� �Ǿ����ϴ�.
		�ȳ��ϼ���? ${sessionScope.loginUser } ��~~
		</h3>
	</c:when>
	<c:otherwise>
		<h3 align="center">
		�α��� ���� ���߽��ϴ�. ���̵�� ��ȣ�� Ȯ���ϼ���.
		</h3>
	</c:otherwise>
</c:choose>
</body>
</html>