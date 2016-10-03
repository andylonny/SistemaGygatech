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
			<a href="#" class="brand-logo right">Resultado Clientes -
				Gygatech Informática</a>
			<ul id="nav-mobile" class="left hide-on-down">
				<li><a href="consultarClienteView">Voltar</a></li>
				<li><a href="logout">Logout</a></li>
			</ul>
		</div>
	</nav>

	<table class="responsive-table centered highlight">
		<thead>
			<tr>
				<th data-field="Google Maps">Mapa</th>
				<th data-field="nome">Nome</th>
				<th data-field="logradouro">Logradouro</th>
				<th data-field="numero">Numero</th>
				<th data-field="complemento">Complemento</th>
				<th data-field="bairro">Bairro</th>
				<th data-field="cidade">Cidade</th>
				<th data-field="uf">UF</th>
				<th data-field="cep">CEP</th>
				<th data-field="tel1">Telefone 1</th>
				<th data-field="tel2">Telefone 2</th>
				<th data-field="email">E-mail</th>
				<th data-field="informacoes">Informações Adicionais</th>
				<th data-field="altera"></th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="cliente" items="${clientes}">
				<tr>
					<td><a href="mapa?codigo=${cliente.codigoCliente}"><i
							class="material-icons prefix blue-text text-indigo">location_on</i></a></td>
					<td>${cliente.nome}</td>
					<td>${cliente.logradouro}</td>
					<td>${cliente.numero}</td>
					<td>${cliente.complemento}</td>
					<td>${cliente.bairro}</td>
					<td>${cliente.cidade}</td>
					<td>${cliente.uf}</td>
					<td>${cliente.cep}</td>
					<td>${cliente.tel1}</td>
					<td>${cliente.tel2}</td>
					<td>${cliente.email}</td>
					<td>${cliente.informacoes}</td>
					<td><a
						href="alterarClienteView?codigo=${cliente.codigoCliente}">Alterar
							Dados</a></td>
					<td><a href="excluirCliente?codigo=${cliente.codigoCliente}">Excluir
							Cliente</a></td>
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