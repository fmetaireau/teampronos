<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>Inscription</title>
		<link rel="stylesheet" type="text/css" href="/webteambet/css/header.css" />
        <link rel="stylesheet" type="text/css" href="/webteambet/css/bootstrap-4.3.1/css/bootstrap.css" />
	</head>
	<body class="container">
		<%@ include file="../header/header.jsp" %>
	    <form method="post" action="inscription">
	        <p>
	            <label for="nom">Email : </label>
	            <input type="text" name="email" id="email" />
	        </p>
	        <p>
	            <label for="prenom">Pseudo : </label>
	            <input type="text" name="pseudo" id="pseudo" />
	        </p>
	        <p>
	            <label for="nom">Mot de passe : </label>
	            <input type="password" name="password" id="password" />
	        </p>
	        <input type="submit" />
	    </form>  
	</body>
</html>