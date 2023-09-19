<%-- 
    Document   : resposta
    Created on : Sep 19, 2023, 7:41:53 AM
    Author     : kali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resposta dos melhores produtos</title>
    </head>
    <body>
        <h1>Os melhores produtos do tipo # ${param.produto} # são:</h1>
        <ul>
            <c:forEach var="item" items="${produtos}" >
                <li>${item}</li>
            </c:forEach>
        </ul>
    </body>
</html>
