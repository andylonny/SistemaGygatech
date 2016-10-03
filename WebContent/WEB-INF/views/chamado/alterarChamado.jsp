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
			<a href="#" class="brand-logo right">Chamado - Gygatech
				Informática</a>
			<ul id="nav-mobile" class="left hide-on-down">
				<li><a href="consultarChamadoView">Voltar</a></li>
				<li><a href="logout">Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="row white"></div>

	<div class="row">
		<form class="col s12" action="alterarChamado" method="Post">
			<div class="row">
				<div class="col s6">
					<h4 class="blue-text text-indigo">Data do Chamado: ${data}</h4>
				</div>
				<div class="col s6">
					<h4 class="blue-text text-indigo">Cliente: ${chamado.cliente.nome}</h4>
				</div>
				<div class="row white">
					<div class="input-field col s1">
						<i class="material-icons prefix blue-text text-indigo">mode_edit</i>
						<input value="${chamado.codigo}" id="Codigo"
							 name="codigo" type="number" class="validate">
						<label for="Codigo">Código:</label>
					</div>
					<div class="input-field col s6">
						<select name="status">
							<option value="${chamado.status}" disabled selected>${chamado.status}</option>
							<option value="Aberto">Aberto</option>
							<option value="Pendente">Pendente</option>
							<option value="Finalizado - Recebido">Finalizado - Recebido</option>
							<option value="Finalizado - Recebimento Pendente">Finalizado - Recebimento Pendente</option>
							<option value="Cancelado">Cancelado</option>
						</select> <label>Selecione o novo status</label>
					</div>
				</div>
				<div class="row white">
					<div class="input-field col s6">
						<i class="material-icons prefix blue-text text-indigo">mode_edit</i>
						<input id="Info" value="${chamado.informacoes}" name="informacoes" type="text" class="validate">
						<label for="Info">Informações Complementares:</label>
					</div>
				</div>
				<div class="row white">
					<button class="btn waves-effect waves-light blue darken-4"
						type="submit" name="botao" value="Grava">alterar</button>
				</div>
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