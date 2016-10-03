<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

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
			<a href="#" class="brand-logo right">Alterar Cliente - Gygatech
				Informática</a>
			<ul id="nav-mobile" class="left hide-on-down">
				<li><a href="principalView">Voltar</a></li>
				<li><a href="logout">Logout</a></li>
			</ul>
		</div>
	</nav>

	<div class="row white"></div>

	<div class="row">
		<form class="col s12" action="alterarCliente" method="Post">
			<div class="row">
				<div class="row white">
					<div class="input-field col s1">
						<i class="material-icons prefix blue-text text-indigo">mode_edit</i>
						<input value="${cliente.codigoCliente}" id="Codigo"
							 name="codigoCliente" type="number" class="validate">
						<label for="Codigo">Código:</label>
					</div>
				</div>
				<div class="row white">
					<div class="input-field col s6">
						<i class="material-icons prefix blue-text text-indigo">perm_identity</i>
						<input value="${cliente.nome}" id="Nome" name="nome" type="text" class="validate">
						<label for="Nome">Nome:</label>
					</div>
				</div>
				<div class="row white">
					<div class="input-field col s6">
						<i class="material-icons prefix blue-text text-indigo">location_on</i>
						<input value="${cliente.logradouro}" id="Logradouro" name="logradouro" type="text"
							class="validate"> <label for="logradouro">Logradouro:</label>
					</div>
					<div class="input-field col s2">
						<input value="${cliente.numero}" id="Numero" name="numero" type="text" class="validate">
						<label for="Numero">Numero:</label>
					</div>
				</div>
				<div class="row white">
					<div class="input-field col s6">
						<i class="material-icons prefix blue-text text-indigo">location_on</i>
						<input value="${cliente.complemento}" id="Complemento" name="complemento" type="text"
							class="validate"> <label for="Complemento">Complemento:</label>
					</div>
				</div>
				<div class="row white">
					<div class="input-field col s3">
						<i class="material-icons prefix blue-text text-indigo">location_on</i>
						<input value="${cliente.bairro}" id="Bairro" name="bairro" type="text" class="validate">
						<label for="Bairro">Bairro:</label>
					</div>
					<div class="input-field col s3">
						<input value="${cliente.cidade}" id="Cidade" name="cidade" type="text" class="validate">
						<label for="Cidade">Cidade:</label>
					</div>
					<div class="input-field col s1">
						<input value="${cliente.uf}" id="UF" name="uf" type="text" class="validate"> <label
							for="UF">UF:</label>
					</div>
					<div class="input-field col s2">
						<input value="${cliente.cep}" id="Cep" name="cep" type="text" class="validate"> <label
							for="Cep">CEP:</label>
					</div>
				</div>
				<div class="row white">
					<div class="input-field col s3">
						<i class="material-icons prefix blue-text text-indigo">phone</i> <input
							value="${cliente.tel1}" id="Tel1" name="tel1" type="text" class="validate"> <label
							for="Tel1">Telefone 1:</label>
					</div>
					<div class="input-field col s3">
						<input value="${cliente.tel2}" id="Tel2" name="tel2" type="text" class="validate">
						<label for="Tel2">Telefone 2:</label>
					</div>
				</div>
				<div class="row white">
					<div class="input-field col s6">
						<i class="material-icons prefix blue-text text-indigo">email</i> <input
							value="${cliente.email}" id="Email" name="email" type="text" class="validate"> <label
							for="Email">E-mail:</label>
					</div>
				</div>
				<div class="row white">
					<div class="input-field col s8">
						<i class="material-icons prefix blue-text text-indigo">mode_edit</i>
						<input value="${cliente.informacoes}" id="Info" name="informacoes" type="text" class="validate">
						<label for="Info">Informações Adicionais:</label>
					</div>
				</div>
			</div>
			<div class="row white">
				<button class="btn waves-effect waves-light blue darken-4"
					type="submit" name="botao" value="Grava">Alterar</button>
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
	<script type="text/javascript" src="assets/js/gygatech.js"></script>
	<script type="text/javascript"
		src="assets/lib/materialize/js/materialize.min.js"></script>
</body>
</html>