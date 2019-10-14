<!DOCTYPE html>
<%@page import="com.betforum.Ligue"%>
<%@page import="com.betforum.Sport"%>
<%@page import="com.formulaire.User"%>
<%@page import="com.betforum.Question"%>
<%@page import="java.util.List"%>
<%@page import="com.betforum.Utils"%>
<html>
    <head>
        <meta charset="utf-8" />
        <title>TEAMBET - Forum entre parieurs</title>
        <link rel="stylesheet" type="text/css" href="/webteambet/css/header.css" />
        <link rel="stylesheet" type="text/css" href="/webteambet/css/common.css" />
        <link rel="stylesheet" type="text/css" href="/webteambet/css/bootstrap-4.3.1/css/bootstrap.css" />
        <link rel="stylesheet" type="text/css" href="/webteambet/css/question.css" />
    </head>

    <body class="container page-question">
    	<%@ include file="../header/header.jsp" %>
    	
        <div class="form background-grey">
        	<h3>Proposer un sujet / Poser une question : </h3>
	        <form method="post" action="listequestion">
		        <p>
		            <label for="nom">Sujet : </label>
		            <input type="text" name="sujet" id="sujet" />
		        </p>
		        <label for="Sport">Sport : </label>
		        <SELECT name="sport" size="1">
					<% List<Sport> listSport = Utils.getListSport(); %>
			    	<% for (Sport s : listSport) { %>
			    		<OPTION><%= s.getLibelleSport() %>
			    	<% } %>
				</SELECT></br>
				<label for="Ligue">Ligue : </label>
		        <SELECT name="ligue" size="1">
					<% List<Ligue> listLigue = Utils.getListLigue(1); %>
			    	<% for (Ligue l : listLigue) { %>
			    		<OPTION><%= l.getLibelleLigue() %>
			    	<% } %>
				</SELECT></br>
		        <input class="bet-button" type="submit" />
		    </form>
	    </div>
	    <div class="list-question">
	    	<div class="bet-title">Liste des sujets</div>
	    	<% List<Question> listQuestion = Utils.getListQuestion(); %>
	    	<% for (Question q : listQuestion) { %>
	    		<% User u = Utils.getUser(q.getId()); %>
	    		<div class="item">
	    			<div class="sport-ligue"><%= q.getSport() %> / <%= q.getLigue() %></div>
	    			<div class="body">
	    				<div class="question"><%= q.getQuestion() %></div>
	    				<div class="auteur"><%= u.getLogin() %></div>
	    				<div class="button">Voir les réponses</div>
	    			</div>
	    		</div>
	    	<% } %>
	    </div>
    </body>
</html>