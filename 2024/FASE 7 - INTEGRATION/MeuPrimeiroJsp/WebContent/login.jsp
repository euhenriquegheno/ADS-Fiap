<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exemplo sessão</title>
</head>
<body>
	<%
		if (request.getParameter("nomeUsuario") != null)
			session.setAttribute("attrUsuario", request.getParameter("nomeUsuario"));
	%>
	
	<form method="post" action="login.jsp">
		<fieldset>
			<legend>Login</legend>
			<div>
				<label>Nome de Usuários</label>
				<input type="text" name="nomeUsuario">
			</div>
			<div>
				<label>Senha</label><br>
				<input type="password" name="senha">
			</div>
			<div>
				<input type="submit" value="LOGIN">
			</div>
		</fieldset>
	</form>
	
	<p><a href="servicos.jsp">SERVIÇOS</a></p>
	<p><a href="index.jsp">INICIO</a></p>

</body>
</html>