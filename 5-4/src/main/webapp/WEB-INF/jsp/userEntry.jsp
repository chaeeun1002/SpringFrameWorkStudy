<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>사용자 등록 화면</title>
</head>
<body>
<h2>사용자 등록 화면</h2>
<div align="center" class="body">
	<form:form modelAttribute="user" method="post" action="userEntry.html">
		<spring:hasBindErrors name="user">
			<font color="red">
				<c:forEach var="error" items="${errors.globalErrors }">
					<spring:message code="${error.code }"/>
				</c:forEach>
			</font>
		</spring:hasBindErrors>
		<table>
			<tr height="40px">
				<td>사용자ID</td>
				<td>
					<form:input path="userId" mexlength="20" cssClass="userId"/>
					<font color="red">
						<form:errors path="userId"/>
					</font>
				</td>
			</tr>
			<tr height="40px">
				<td>패스워드</td>
				<td>
					<form:input path="password" mexlength="20" cssClass="password"/>
					<font color="red">
						<form:errors path="password"/>
					</font>
				</td>
			</tr>
			<tr height="40px">
				<td>이름</td>
				<td>
					<form:input path="userName" mexlength="20" cssClass="userName"/>
					<font color="red">
						<form:errors path="userName"/>
					</font>
				</td>
			</tr>
			<tr height="40px">
				<td>우편번호</td>
				<td>
					<form:input path="postCode" mexlength="8" cssClass="postCode"/>
					<font color="red">
						<form:errors path="postCode"/>
					</font>
				</td>
			</tr>
			<tr height="40px">
				<td>주소</td>
				<td>
					<form:input path="address" mexlength="50" cssClass="address"/>
					<font color="red">
						<form:errors path="address"/>
					</font>
				</td>
			</tr>
			<tr height="40px">
				<td>이메일</td>
				<td>
					<form:input path="email" mexlength="50" cssClass="email"/>
					<font color="red">
						<form:errors path="email"/>
					</font>
				</td>
			</tr>
			<tr height="40px">
				<td>직업</td>
				<td>
					<form:select path="job" cssClass="jobs">
						<form:option value="회사원" label="회사원"/>
						<form:option value="주부" label="주부"/>
						<form:option value="학생" label="학생"/>
						<form:option value="기타" label="기타"/>
					</form:select>
					<font color="red">
						<form:errors path="userName"/>
					</font>
				</td>
			</tr>
			<tr height="40px">
				<td>생년월일</td>
				<td>
					<form:input path="birthday" mexlength="10" cssClass="birthday"/>
					<font color="red">
						<form:errors path="birthday"/>
					</font>
				</td>
			</tr>
		</table>
		<table>
			<tr>
				<td height="40px" align="center">
					<input type="submit" value="등록" name="btnSubmit"/>
				</td>
				<td height="40px" align="center">
					<input type="reset" value="취소" name="btnReset"/>
				</td>
			</tr>
		</table>
	</form:form>
</div>
</body>
</html>