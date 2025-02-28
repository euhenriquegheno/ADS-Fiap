<%@ page import="java.util.*" language="java" contentType="text/html; charset=UTF-8"
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

	<h2>Bem vindo usuário [<%=session.getAttribute("attrUsuario")%>] a página Inicial do Sistema!</h2>
	
	<p><a href="servicos.jsp">SERVIÇOS</a></p>
	<p><a href="login.jsp">LOGIN</a></p>
	
	<%-- Conta quantas visitar o site teve --%>
	<%
		Integer hitsCount = (Integer)application.getAttribute("hisCounter");
		if (hitsCount == null || hitsCount == 0) {
			out.println("Bem vindo ao meu site");
			hitsCount = 1;
		} else {
			out.println("Bem vindo ao meu site");
			hitsCount += 1;
		}
		
		application.setAttribute("hisCounter", hitsCount);
	%>
	
	<p>Total de visitas no site é: <%=hitsCount%></p>
</body>
</html>