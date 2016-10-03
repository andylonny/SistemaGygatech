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
			<a href="#" class="brand-logo right">Resultado Agenda -
				Gygatech Informática</a>
			<ul id="nav-mobile" class="left hide-on-down">
				<li><a href="consultarAgendaView">Voltar</a></li>
				<li><a href="logout">Logout</a></li>
			</ul>
		</div>
	</nav>

	<table class="responsive-table centered highlight">
		<thead>
			<tr>
				<th data-field="Data">Data</th>
				<th data-field="Hora">Horário</th>
				<th data-field="Cliente">Cliente</th>
				<th data-field="Status">Status</th>
				<th data-field="Info">Informações Adicionais</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="agenda" items="${agenda}">
				<tr>
					<td>${agenda.data}</td>
					<td>${agenda.horario}</td>
					<td>${agenda.cliente.nome}</td>
					<td>${agenda.status}</td>
					<td>${agenda.informacoes}</td>
					<td><a href="alterarAgendaView?codigo=${agenda.codigo}">Alterar Status</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

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