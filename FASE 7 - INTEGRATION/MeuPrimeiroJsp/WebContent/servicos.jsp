<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav> <jsp:include page="menu.jsp"></jsp:include> </nav>
	<hr/>

	<h2>Bem vindo usuário [<%=session.getAttribute("attrUsuario")%>] a página de Serviços do Sistema!</h2>
	
	<p><a href="index.jsp">INICIO</a></p>
	<p><a href="login.jsp">LOGIN</a></p>

</body>
</html>