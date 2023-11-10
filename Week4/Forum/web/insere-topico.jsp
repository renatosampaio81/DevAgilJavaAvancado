<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Inserir novo tópico:</h1>
	<form action="adicionarTopico" method="post">
		Título: <input type="text" name="titulo" />
		<br><textarea rows="8" cols="50" name="conteudo" placeholder="Digite o conteúdo..."></textarea>
		<input type="hidden" value="${usuario.login }" />
		<br><input type="submit" value="adicionar" name="adicionar"/>
	</form>    
</body>
</html>