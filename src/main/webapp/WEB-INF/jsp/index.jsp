<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta http-equiv="X-UA-Compatible" content="ie=edge" />
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.13/css/all.css"
	integrity="sha384-DNOHZ68U8hZfKXOrtjWvjxusGo9WQnrNx2sqG0tfsghAvtVlRW3tvkXWZh58N9jp"
	crossorigin="anonymous" />
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="undefined" crossorigin="anonymous">

<title>Lexicographer</title>

</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light p-0">
		<div class="container">
			<a href="/" class="navbar-brand"><b>Lexicographer</b></a>
			<button class="navbar-toggler" data-toggle="collapse"
				data-target="#navbarCollapse" aria-controls="navbarSupportedContent"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item mr-3 pt-3 pb-3">
						<button class="btn btn-light  ">About</button>
					</li>
					<c:if test="${pageContext.request.userPrincipal.name == null}">
						<li class="nav-item mr-3 pt-3 pb-3"><a href="/login"
							class="btn btn-outline-danger  ">Login</a></li>
						<li class="nav-item pt-3 pb-3"><a href="/register"
							class="btn btn-danger">Sign Up</a></li>
					</c:if>
					<c:if test="${pageContext.request.userPrincipal.name != null}">

						<form method="post" id="logoutForm" action="${path}/logout">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}">
						</form>

						<li class="nav-item mr-3 pt-3 pb-3"><a
							onClick="document.forms['logoutForm'].submit()"
							class="btn btn-dark"> <i class="fas fa-user-times"></i>
								Logout
						</a></li>
					</c:if>
				</ul>
			</div>
		</div>
	</nav>
	<hr>
	<section id="" class="py-4 mb-4 bg-light">
		<div class="container">
			<div class="row">
				<div class="col-md-1"></div>
				<div style="background-color: #ff6701;"
					class="col-md-10 align-self-center p-4 ml-1 mr-1">
					<h3 class="text-center m-5">
						Walk <sub><i>f.</i></sub>
					</h3>
				</div>
				<div class="col-md-1"></div>
			</div>
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-3">
					<button class="btn btn-warning mt-3">
						<h3 class="pl-4 pr-4">Koşmak</h3>
					</button>

				</div>
				<div class="col-md-3">
					<button class="btn btn-warning mt-3">
						<h3 class="pl-4 pr-4">Gelmek</h3>
					</button>

				</div>
				<div class="col-md-3"></div>
			</div>
		</div>
	</section>



	<script src="http://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
		integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
		crossorigin="anonymous"></script>

</body>

</html>