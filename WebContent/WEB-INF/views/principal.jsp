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
	<ul id="dropClientes" class="dropdown-content">
		<li><a href="cadastrarClienteView">Cadastrar Cliente</a></li>
		<li class="divider"></li>
		<li><a href="consultarClienteView">Consultar Cliente</a></li>
	</ul>
	<ul id="dropServicos" class="dropdown-content">
		<li><a href="cadastrarServicoView">Cadastrar Serviço</a></li>
		<li class="divider"></li>
		<li><a href="consultarServicos">Consultar Serviço</a></li>
	</ul>
	<ul id="dropPecas" class="dropdown-content">
		<li><a href="cadastrarPecaView">Cadastrar Peça</a></li>
		<li class="divider"></li>
		<li><a href="consultarPecas">Consultar Peça</a></li>
	</ul>
	<ul id="dropAgenda" class="dropdown-content">
		<li><a href="agendarAtendimentoView">Agendar Chamado</a></li>
		<li class="divider"></li>
		<li><a href="consultarAgendaView">Consultar Agenda</a></li>
	</ul>
	<nav>
	<ul id="dropChamados" class="dropdown-content">
		<li><a href="novoChamadoView">Abrir Chamado</a></li>
		<li class="divider"></li>
		<li><a href="consultarChamadoView">Consultar Chamado</a></li>
	</ul>
		<div class="nav-wrapper  blue darken-4">
			<a href="#" class="brand-logo right">Gygatech Informática</a>
			<ul id="nav-mobile" class="left hide-on-down">
				<li><a class="dropdown-button" href="#!"
					data-activates="dropClientes">Clientes <i
						class="material-icons right">arrow_drop_down</i></a></li>
				<li><a class="dropdown-button" href="#!"
					data-activates="dropServicos">Serviços <i
						class="material-icons right">arrow_drop_down</i></a></li>
				<li><a class="dropdown-button" href="#!"
					data-activates="dropPecas">Peças <i
						class="material-icons right">arrow_drop_down</i></a></li>
				<li><a class="dropdown-button" href="#!"
					data-activates="dropAgenda">Agenda <i
						class="material-icons right">arrow_drop_down</i></a></li>
				<li><a class="dropdown-button" href="#!"
					data-activates="dropChamados">Chamados <i
						class="material-icons right">arrow_drop_down</i></a></li>
				<li><a href="reciboView">Recibos</a></li>
				<li><a href="notaView">Notas Fiscais</a></li>
				<li><a href="logout">Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="">
		<div class="row"></div>
	</div>

	<div class="parallax-container">
		<div class="parallax">
			<img src="assets/media/img/paralax1.jpg">
		</div>
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