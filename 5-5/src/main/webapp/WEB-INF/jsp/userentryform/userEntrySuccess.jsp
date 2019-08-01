<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>사용자 등록 완료 화면</title>
</head>
<body>
<h2>사용자 등록 완료</h2>
<div align="center" class="body">
	<b><font color="red">등록이 완료되었습니다.</font></b>
	<table>
		<tr height="40px">
			<td>사용자ID</td>
			<td>${user.userId }</td>
		</tr>
		<tr height="40px">
			<td>패스워드</td>
			<td>${user.password }</td>
		</tr>
		<tr height="40px">
			<td>이름</td>
			<td>${user.userName }</td>
		</tr>
		<tr height="40px">
			<td>우편번호</td>
			<td>${user.postCode }</td>
		</tr>
		<tr height="40px">
			<td>주소</td>
			<td>${user.address }</td>
		</tr>
		<tr height="40px">
			<td>이메일</td>
			<td>${user.email }</td>
		</tr>
		<tr height="40px">
			<td>직업</td>
			<td>${user.job }</td>
		</tr>
		<tr height="40px">
			<td>생년월일</td>
			<td>${user.birthday }</td>
		</tr>
	</table>
</div>
</body>
</html>