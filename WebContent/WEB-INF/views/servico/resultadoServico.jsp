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
			<a href="#" class="brand-logo right">Resultado Serviços -
				Gygatech Informática</a>
			<ul id="nav-mobile" class="left hide-on-down">
				<li><a href="principalView">Voltar</a></li>
				<li><a href="logout">Logout</a></li>
			</ul>
		</div>
	</nav>

	<table class="responsive-table centered highlight">
		<thead>
			<tr>
				<th data-field="codigo">Código</th>
				<th data-field="descricao">Descrição</th>
				<th data-field="valor">Valor</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="servico" items="${servicos}">
				<tr>
					<td>${servico.codigo}</td>
					<td>${servico.descricao}</td>
					<td>R$ ${servico.valor}</td>
					<td><a href="alterarServicoView?codigo=${servico.codigo}">Alterar Dados</a></td>
					<td><a href="excluirServico?codigo=${servico.codigo}">Excluir Serviço</a></td>
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