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
<script type="text/javascript">
function validate(frm){
	if(frm.name.value == ""){
		alert("��ǰ���� �Է����ּ���.");
		document.frm.name.focus();
		return false;
	}
	if(frm.price.value == ""){
		alert("������ �Է����ּ���.");
		document.frm.price.focus();
		return false;
	}
	if(!frm.origin[0].checked && !frm.origin[1].checked){
		alert("�������� �����ϼ���.");
		document.frm.origin[0].focus();
		return false;
	}
	if(confirm("�Է��� �������� ����Ͻðڽ��ϱ�?")){
		
	}else{
		return false;
	}
}
</script>
<h3 align="center">��ǰ ���� ���</h3><br/>
<form:form name="frm" modelAttribute="itemInfo" action="../item/write.html" method="post" onSubmit="return validate(this)">
��ǰ�� : <form:input path="name" cssClass="name"/><br/><br/>
��ǰ���� : <form:input path="price" cssClass="price"/><br/><br/>
��ǰ���� : <form:textarea rows="3" cols="80" path="info" cssClass="info"/><br/><br/>
�ܱ��� : <form:radiobutton path="origin" value="FOR"/>
������ : <form:radiobutton path="origin" value="KOR"/><br/><br/>
<div align="center">
<input type="submit" value="���"/>
<input type="submit" value="���"/>
</div>
</form:form>
</body>
</html>