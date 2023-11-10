<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ranking</title>
</head>
<body>
	<h1>Ranking dos usuários</h1>
	<table id="2">
		<tr>
			<th>Colocação</th>
			<th>Nome</th>
			<th>Login</th>
			<th>Pontos</th>
		</tr>
		<c:forEach var="usuario" items="${usuarios }" varStatus="id">
			<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : '8099ff' }">
				<td><c:out value="${id.count }" /></td>
				<td>${usuario.nome }</td>
				<td>${usuario.login }</td>
				<td>${usuario.pontos }</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form action="todostopicos" method="post">
		<input type="submit" value="Retornar"/>
	</form>
</body>
</html>