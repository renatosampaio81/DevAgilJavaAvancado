<!DOCTYPE html>
<html>
<head>
    <title>Tradutor</title>
</head>
<body>
    <h1>Tradutor de Palavras</h1>
    
    <form action="TranslateServlet" method="post">
        <label for="palavra">Digite uma palavra:</label>
        <input type="text" id="palavra" name="palavra" required>
        <br>
        <input type="submit" value="Traduzir">
        <h2>${traducao}</h2>
    </form>

</body>
</html>