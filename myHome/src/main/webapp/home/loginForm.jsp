<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="user" action="../login/template.html" method="post">
	���̵� : <form:input path="id" size="12"/>
	<font color="red"><form:errors path="id"/></font><br/>
	�н����� : <form:input path="password" size="12"/>
	<font color="red"><form:errors path="password"/></font><br/>
	<input type="submit" value="�α���"/>
	<input type="reset" value="���"/>
</form:form>
</body>
</html>





