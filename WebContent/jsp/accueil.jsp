<!DOCTYPE html>
<%@page import="com.formulaire.User"%>
<html>
    <head>
        <meta charset="utf-8" />
        <title>TEAMBET - Forum entre parieurs</title>
        <link rel="stylesheet" type="text/css" href="/webteambet/css/header.css" />
        <link rel="stylesheet" type="text/css" href="/webteambet/css/bootstrap-4.3.1/css/bootstrap.css" />
    </head>

    <body class="container">
    	<%@ include file="header/header.jsp" %>
        <div>Page d'accueil du site</div>
         <% User obj = (User) request.getSession().getAttribute("sessionUtilisateur"); %>
         <% if (obj != null) { %>
        	Session utilisateur : <%= obj.getEmail() %>  <%= obj.getId() %>
        <% } %>
    </body>
</html>