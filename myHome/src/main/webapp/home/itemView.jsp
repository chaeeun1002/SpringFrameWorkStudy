<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3 align="center">��ǰ ��</h3>
[��ǰ��ȣ] : ${ITEM.code }<br/><br/>
[��ǰ�̸�] : ${ITEM.name }<br/><br/>
[��ǰ����] : <f:formatNumber type="currency" currencySymbol="" value="${ITEM.price }" minFractionDigits="0"/>��<br/><br/>
[��ǰ������] : ${ITEM.origin }<br/><br/>
===================================================================<br/><br/>
${ITEM.info }
</body>
</html>