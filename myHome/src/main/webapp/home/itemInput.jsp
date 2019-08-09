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
		alert("상품명을 입력해주세요.");
		document.frm.name.focus();
		return false;
	}
	if(frm.price.value == ""){
		alert("가격을 입력해주세요.");
		document.frm.price.focus();
		return false;
	}
	if(!frm.origin[0].checked && !frm.origin[1].checked){
		alert("원산지를 선택하세요.");
		document.frm.origin[0].focus();
		return false;
	}
	if(confirm("입력한 내용으로 등록하시겠습니까?")){
		
	}else{
		return false;
	}
}
</script>
<h3 align="center">상품 정보 등록</h3><br/>
<form:form name="frm" modelAttribute="itemInfo" action="../item/write.html" method="post" onSubmit="return validate(this)">
상품명 : <form:input path="name" cssClass="name"/><br/><br/>
상품가격 : <form:input path="price" cssClass="price"/><br/><br/>
상품설명 : <form:textarea rows="3" cols="80" path="info" cssClass="info"/><br/><br/>
외국산 : <form:radiobutton path="origin" value="FOR"/>
국내산 : <form:radiobutton path="origin" value="KOR"/><br/><br/>
<div align="center">
<input type="submit" value="등록"/>
<input type="submit" value="취소"/>
</div>
</form:form>
</body>
</html>