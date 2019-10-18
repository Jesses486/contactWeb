<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>contacts</title>
</head>
<body>
<h2>Recherche de contact par noms</h2>
<form action="ContactServlet" METHOD="POST">
Entrer un nom <input name="nom" id="nom" size="6">
<button type="submit">Rechercher</button>
</form>
<form action="GetAllContactsServletLAZY" METHOD="POST">
<button type="submit">Obtenez tous les contacts</button>
</form>
<form action="CreateContactsServelt" METHOD="POST">
Creer un Contact 
<div> 
      <input name="civilite" id="civilite" size="6">
      <input name="nom" id="nom" size="6">
      <input name="prenom" id="prenom" size="6">
</div>
<button type="submit">creer</button>
</form>
</body>
</html>