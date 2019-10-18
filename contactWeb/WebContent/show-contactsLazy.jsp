<%@page import="com.sun.jdi.Value"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contacts</title>
</head>
<body>
<h2>Contacts par nom ${param['nom']}</h2>
<table>
   <c:forEach items="${contacts}" var="contacts">
      <tr>
      <td>
      <form action="ModContactsServlet" METHOD="POST" accept-charset="UTF-8">
      <input type="hidden" name="id" id="id" value="${ contacts.id }">
      <input name="civilite" id="civilite" value="${ contacts.civilite }">
      <input name="nom" id="nom" value="${ contacts.nom }">
      <input name="prenom" id="prenom" value="${ contacts.prenom }">
      <button type="submit">modifier</button>
      <form action="DelContactsServelt" METHOD="POST" accept-charset="UTF-8">
      <input type="hidden" name="id" id="id" value="${ contacts.id }">
      <button type="submit">supprimer</button>
      </form>
      </form>
      </td>
      <td>
      <form action="GetAllContactsAddressesServlet" METHOD="POST" accept-charset="UTF-8">
      <input type="hidden" name="id" id="id" value="${ contacts.id }">
      <button type="submit">Afficher les adresses</button>
      </form>
      </td>
   </c:forEach>
</table>
<a href="index.jsp">Retour</a>
</body>
</html>