<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tela de Login</title>
</head>
<body>
    <h1>Faça login abaixo:</h1>
    <form action="fazerlogin" method="post">
            Login: <input type="text" name="login"/>
            Senha: <input type="password" name="senha" />
            <input type="submit" value="Fazer login" />
            <br>
            ${erro }
    </form>

    <br>
    <h3>Cadastre-se</h3>
    <form action="cadastro.jsp">
            <input type="submit" value="Novo usuário"/>
    </form>
</body>
</html>
