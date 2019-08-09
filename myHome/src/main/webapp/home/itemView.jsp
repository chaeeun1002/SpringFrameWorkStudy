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
<h3 align="center">상품 상세</h3>
[상품번호] : ${ITEM.code }<br/><br/>
[상품이름] : ${ITEM.name }<br/><br/>
[상품가격] : <f:formatNumber type="currency" currencySymbol="" value="${ITEM.price }" minFractionDigits="0"/>원<br/><br/>
[상품원산지] : ${ITEM.origin }<br/><br/>
===================================================================<br/><br/>
${ITEM.info }
</body>
</html>