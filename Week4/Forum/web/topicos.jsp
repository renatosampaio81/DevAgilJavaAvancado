<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h1>Olá ${usuario.nome }</h1>
    <h2>Tópicos do fórum</h2>
    <table id="tabela">
        <tr>
                <th>Usuario</th>
                <th>Tópico</th>
        </tr>
        <c:forEach var="topico" items="${topicos }" varStatus="id">
                <tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : '8099ff' }" id="${id.count }">
                        <td>${topico.login }</td>
                        <td>${topico.titulo }</td>
                        <td>
                                <form action="exibir" method="post">
                                        <input type="hidden" name="topicoID" value="${topico.id }" />
                                        <input type="submit" value="Ver tópico" />
                                </form>
                        </td>
                </tr>
        </c:forEach>
    </table>

    <br><br>
    <form action="ranking" method="post">
            <input type="submit" value="Ranking"/>
    </form>
    <form action="insere-topico.jsp" method="post">
            <input type="submit" value="Inserir tópico" />
    </form>
</body>
</html>
