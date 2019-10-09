<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>TEAMBET - Forum entre parieurs</title>
        <link rel="stylesheet" type="text/css" href="/webteambet/css/header.css" />
        <link rel="stylesheet" type="text/css" href="/webteambet/css/bootstrap-4.3.1/css/bootstrap.css" />
    </head>

    <body class="container">
    	<%@ include file="../header/header.jsp" %>
        <div>Page liste question</div>
        <form method="post" action="listequestion">
	        <p>
	            <label for="nom">Sujet : </label>
	            <input type="text" name="sujet" id="sujet" />
	        </p>
	        <input type="submit" />
	    </form>
    </body>
</html>