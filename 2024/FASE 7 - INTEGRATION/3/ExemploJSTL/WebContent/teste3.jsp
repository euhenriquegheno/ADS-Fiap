<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="idade" value="21"/>
	
	<c:choose>
		<c:when test="${idade >= 60}">
			<p>Idoso</p>
		</c:when>
		
		<c:when test="${idade >= 20}">
			<p>Adulto</p>
		</c:when>
		
		<c:when test="${idade >= 13}">
			<p>Adolescente</p>
		</c:when>
		
		<c:otherwise>
			<p>Infância</p>
		</c:otherwise>
	</c:choose>
		

</body>
</html>