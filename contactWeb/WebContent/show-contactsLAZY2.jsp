<%@page import="com.sun.jdi.Value"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adresses</title>
</head>
<body>
<h2>Adresses de ${contact.nom} ${contact.prenom}</h2>
<table>
<c:forEach items="${adresses}" var="adresse">
      <td>${ adresse.rue }, ${ adresse.ville }, ${ adresse.codePostal }, ${ adresse.pays }</td>
</c:forEach>
</table>
<a href="index_LAZY.jsp">Retour</a>
</body>
</html>