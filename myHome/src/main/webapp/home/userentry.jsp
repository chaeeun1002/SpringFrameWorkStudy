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
<script type="text/javascript">
function validate(form){
	if(form.name.value == ""){
		alert("이름을 입력하세요");
		form.name.focus();
		return false;
	}
	if(form.id.value == ""){
		alert("ID를 입력하세요");
		form.id.focus();
		return false;
	}
	if(form.password.value == ""){
		alert("암호를 입력하세요");
		form.password.focus();
		return false;
	}
	if(form.password.value != form.CONFIRM.value){
		alert("암호가 일치하지 않습니다.");
		form.password.focus();
		return false;
	}
	if(!form.gender[0].checked && !form.gender[1].checked){
		alert("성별을 선택하세요.");
		form.gender[0].focus();
		return false;
	}
	if(form.job.selectedIndex < 1){
		alert("직업을 선택하세요.");
		form.job.focus();
		return false;
	}
	if(form.idChecked.value=""){
		alert("ID중복 검사를 해주세요.");
		return false;
	}
	if(confirm("입력한 내용이 맞습니까?")){
		
	}else{
		return false;	
	}
}
function idCheck(){
	if(document.frm.id.value == ""){
		alert("ID를 입력하세요.");
		document.frm.id.fucos();
		return;
	}
	var url = "../idcheck/idcheck.html?ID="+document.frm.id.value;
	window.open(url,"_blank","width=450, height=200");
}
</script>
<h2>사용자 등록 화면</h2>
<div class="body">
	<form:form name="frm" modelAttribute="user" method="post" action="../entry/entry.html" onSubmit="return validate(this)">
				<input type="hidden" name="idChecked" id="idChecked">
				이름
					<form:input path="name" mexlength="20" cssClass="name"/><br/><br/>
				아이디
					<form:input path="id" mexlength="20" cssClass="id"/>
					<input type="button" value="중복검사" onClick="idCheck()"><br/><br/>
				패스워드
					<form:password path="password" mexlength="20" cssClass="password"/><br/><br/>
				패스워드 확인
					<input type="password" name="CONFIRM"/><br/><br/>
				성별 
					남<form:radiobutton path="gender" value="M"/>
					여<form:radiobutton path="gender" value="F"/><br/><br/>
				이메일
					<form:input path="email" mexlength="50" cssClass="email"/><br/><br/>
				직업
					<form:select path="job" cssClass="jobs">
						<form:option value="=======" label="======="/>
						<form:option value="회사원" label="회사원"/>
						<form:option value="주부" label="주부"/>
						<form:option value="학생" label="학생"/>
						<form:option value="기타" label="기타"/>
					</form:select><br/><br/>
					<input type="submit" value="등록" name="btnSubmit"/>
					<input type="reset" value="취소" name="btnReset"/>
	</form:form>
</div>
</body>
</html>