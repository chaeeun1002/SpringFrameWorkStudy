<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
				prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
body {
	font-family: 'HYHeadLine', 'HY견고딕', 'HYPost';
	font-size : 18px;
}
#join {
	padding-left : 30px;
	font-size : 12px;
}
#header {
	width:800px;	
	margin:0 auto; 
	background:red;
}
#wrap {
	width:800px; 
	height:330px; 
	margin:0 auto;
}
#aside {
	width:200px; 
	height:100%; 
	float:left; 
	background:orange;
}
#content{
	width:600px; 
	height:100%; 
	float:right;
	background-image:url(imgs/5.jpg);
	background-size:600px 330px;
}
</style>
</head>
<body>
<div id="header">
	<img alt="" src="imgs/logo.gif">
</div>
<div id="wrap">
	<div id="aside">
		<fieldset>
			<c:choose>
				<c:when test="${sessionScope.loginUser != null }">
					<jsp:include page="logoutForm.jsp"/>
				</c:when>
				<c:when test="${HEADER != null }">
					<jsp:include page="${HEADER }"/>
				</c:when>
				<c:otherwise>
					<jsp:include page="../login/login.html"></jsp:include>
				</c:otherwise>
			</c:choose>
			<p><a href="../home/intro.html?BODY=intro.jsp">소개</a><br/>
			<a href="">공지사항</a><br/>
			<a href="../home/bbsTemplate.html">자유게시판 쓰기</a><br/>
			<a href="../read/read.html">자유게시판 읽기</a><br/>
			<a href="../item/itemTemplate.html">상품정보 등록</a><br/>
			<a href="../item/read.html">상품목록 보기</a><br/>
			<a href="">장바구니 보기</a><br/>
			<a href="">이미지 게시판 작성/답글</a><br/>
			<a href="">이미지 게시판 읽기</a>
		</fieldset>
	</div>
	<div id="content">
		<c:choose>
			<c:when test="${BODY != null }">
				<jsp:include page="${BODY }"/>
			</c:when>
			<c:otherwise>
				<jsp:include page="front.jsp"/>
			</c:otherwise>
		</c:choose>
	</div>
</div>
</body>
</html>












