<%@ page import="Temp.Chien" %>
<%@ page import="java.util.List" %>
<% List<Chien> chiens = (List<Chien>) request.getAttribute("chiens"); %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title></title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet">
</head>
<body>

<h1>Liste de chiens</h1>

<div>
<%if (chiens == null || chiens.isEmpty()) {%>
    <p>Aucun chien dans la liste</p>
<%}else{%>
    <table>
        <tr><th class="borderless"></th><th>Nom</th><th>Race</th><th>Details</th></tr>
        <%for(Chien chien : chiens){%>
            <tr>
                <td class="borderless">
                    <form action="${pageContext.request.contextPath}/servlet/delete?chien=<%=chien.getId()%>" method="post">
                        <input type="image" src="${pageContext.request.contextPath}/images/redcross.png" width="100%" height="100%">
                    </form>
                </td>
                <td><%=chien.getNom()%></td><td><%=chien.getRace()%></td><td><a href="${pageContext.request.contextPath}/servlet/details?chien=<%=chien.toString()%>">ici</a></td>
            </tr>
        <%}%>
    </table>
<%}%>
</div>

<a href="${pageContext.request.contextPath}/servlet/form" class="button">Ajouter</a>

</body>
</html>