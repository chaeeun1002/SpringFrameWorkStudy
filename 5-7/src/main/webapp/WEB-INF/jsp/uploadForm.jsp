<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function validate(form) {
			if (form.title.value == "") {
				alert("제목을 입력하세요.");
				return false;
			}
			if (form.writer_name.value == "") {
				alert("닉네임을 입력하세요.");
				return false;
			}
			if (form.password.value == "") {
				alert("암호를 입력하세요.");
				return false;
			}
			if (form.imagename.value == "") {
				alert("이미지를 선택하세요.");
				return false;
			}
			if (form.content.value == "") {
				alert("글 내용을 입력하세요.");
				return false;
			}
			var result = confirm("정말로 저장하시겠습니까?");
			if (result == false)
				return false;
		}
	</script>
	<form:form modelAttribute="writing" action="../upload/write.html"
		method="post" enctype="multipart/form-data">
		<table border="1" width="100%">
			<tr>
				<td>글제목</td>
				<td><form:input path="title" size="40" /></td>
			</tr>
			<tr>
				<td>닉네임</td>
				<td><form:input path="writer_name" size="20" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><form:input path="email" size="20" /></td>
			</tr>
			<tr>
				<td>암호</td>
				<td><form:password path="password" size="20" /></td>
			</tr>
			<tr>
				<td>이미지</td>
				<td><input type="file" name="image"></td>
			</tr>
			<tr>
				<td>글내용</td>
				<td><form:textarea rows="8" cols="40" path="content"></form:textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="등 록" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
















