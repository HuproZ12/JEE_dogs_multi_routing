<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>

<form action="${pageContext.request.contextPath}/servlet/form" method="post">
    <ul>
        <li><label for="nom">Nom</label><input type="text" id="nom" name="nom"></li>
        <li><label for="race">Race</label><input type="text" id="race" name="race"></li>
        <li><label for="naissance">Date de naissance</label><input type="date" id="naissance" name="naissance"></li>
        <li><button type="submit">Ajouter</button></li>
    </ul>
</form>

<a href="${pageContext.request.contextPath}/servlet/affichage" class="button">Retour</a>

</body>
</html>