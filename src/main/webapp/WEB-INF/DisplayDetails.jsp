<jsp:useBean id="id" type="java.lang.String" scope="request"/>
<jsp:useBean id="nom" type="java.lang.String" scope="request"/>
<jsp:useBean id="race" type="java.lang.String" scope="request"/>
<jsp:useBean id="naissance" type="java.lang.String" scope="request"/>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>

<table>
    <tr><th>id</th><th>Nom</th><th>Race</th><th>Date de naissance</th></tr>
    <tr><td>${id}</td><td>${nom}</td><td>${race}</td><td>${naissance}</td></tr>
</table>

<a href="${pageContext.request.contextPath}/servlet/affichage" class="button">Retour</a>

</body>
</html>