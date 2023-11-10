<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Exibir tópico</title>
</head>
<body>
	<h2>Exibindo tópico:</h2>
        <b>Título:</b> ${topico.titulo }<br>
	<b>Autor:</b>  ${topicoUsuario.nome }<br>
	<b>Conteúdo:</b><br>
	${topico.conteudo }
	<br><br>
	
	<h3>Comentários:</h3>
		<c:forEach var="list" items="${lista }" varStatus="id">
		<p style="background-color:#${id.count % 2 == 0 ? 'aaee88' : '8099ff' }">
			<b>Autor:</b> ${list.key}<br>
			<b>Comentario:</b><br>
			${list.value }<br><br>
		</p>
		</c:forEach>
	
	<b>Adicionar Comentário:</b>
	<form action="adicionarComentario" method="post"method="post"method="post"method="post"method="post"method="post">
		<br><textarea rows="8" cols="50" name="comentario" placeholder="Digite o conteúdo..."></textarea>
		<input type="hidden" name="login" value="${usuario.login }"/>
		<input type="hidden" name="id_topico" value="${topico.id }"/>
		<br><input type="submit" value="adicionar"/>
	</form>
	
	<form action="todostopicos" method="post"method="post"method="post"method="post"><input type="submit" value="Retornar aos tópicos"/></form>
</body>
</html>
