<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de usuário</title>
</head>
<body>

    <h1>Cadastrar novo usuário</h1>
    <form action="cadastrar" method="post">
        Login: <input type="text" name="login" /><br>
        Senha: <input type="password" name="senha" /><br>
        Nome:  <input type="text" name="nome" /><br>
        Email: <input type="text" name="email" /><br>
        <input type="submit" value="cadastrar" /><br>
    </form>

</body>
</html>
