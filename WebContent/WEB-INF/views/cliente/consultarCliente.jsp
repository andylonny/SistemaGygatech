<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<!--Import materialize.css-->
<link type="text/css" rel="stylesheet"
	href="assets/lib/materialize/css/google_fonts.css"
	media="screen,projection" />

<link type="text/css" rel="stylesheet"
	href="assets/lib/materialize/css/materialize.min.css"
	media="screen,projection" />

<!-- Import gygatech CSS -->
<link type="text/css" rel="stylesheet" href="assets/css/gygatech.css"
	media="screen,projection" />

<!--Let browser know website is optimized for mobile-->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<title>Sistema de Chamados - Gygatech Informática</title>
</head>

<body>
	<nav>
		<div class="nav-wrapper  blue darken-4">
			<a href="#" class="brand-logo right">Consultar Cliente - Gygatech
				Informática</a>
			<ul id="nav-mobile" class="left hide-on-down">
				<li><a href="principalView">Voltar</a></li>
				<li><a href="logout">Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="row"></div>

	<div class="row">
		<form class="col s12" action="consultarNomeCliente" method="Post">
			<div class="row">
				<div class="row white">
					<div class="input-field col s6">
						<i class="material-icons prefix blue-text text-indigo">perm_identity</i>
						<input id="Nome" name="nome" type="text" class="validate">
						<label for="Nome">Nome:</label>
					</div>
				</div>
				<div class="row white">
					<button class="btn waves-effect waves-light blue darken-4"
						type="submit" name="botao" value="Grava">Consultar Nome</button>
				</div>
			</div>
		</form>
	</div>

	<div class="row">
		<form class="col s2" action="consultarTodosClientes" method="Post">
			<div class="row white">
				<button class="btn waves-effect waves-light blue darken-4"
					type="submit" name="botao" value="Grava">Consultar Todos</button>
			</div>
		</form>
	</div>

	<!-- Rodape -->
	<footer class="page-footer  blue darken-4">
		<div class="footer-copyright">
			<div class="container center">2016 Copyright Gygatech
				Informática</div>
		</div>
	</footer>

	<!--Import JavaScript-->
	<script type="text/javascript"
		src="assets/lib/jquery/jquery-2.1.4.min.js"></script>
	<script type="text/javascript"
		src="assets/lib/materialize/js/materialize.min.js"></script>
	<script type="text/javascript" src="assets/js/gygatech.js"></script>
</body>
</html>