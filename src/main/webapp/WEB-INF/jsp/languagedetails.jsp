<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<link rel="stylesheet" href="css/style.css" />
<title>Admin Page</title>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark p-0">
		<div class="container">
			<a href="/admin/dashboard" class="navbar-brand">Lexicographer</a>
			<button class="navbar-toggler" data-toggle="collapse"
				data-target="#navbarCollapse" aria-controls="navbarSupportedContent"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav">
					<li class="nav-item px-2"><a href="/admin/dashboard"
						class="nav-link ">Dashboard</a></li>
					<li class="nav-item px-2"><a href="/words" class="nav-link ">Words</a></li>
					<li class="nav-item px-2"><a href="/categories"
						class="nav-link ">Categories</a></li>
					<li class="nav-item px-2"><a href="/users" class="nav-link">Users</a></li>
					<li class="nav-item px-2"><a href="/types" class="nav-link">Word
							Types</a></li>
					<li class="nav-item px-2"><a href="/languages"
						class="nav-link ">Languages</a></li>
					<li class="nav-item px-2 "><a href="/roles" class="nav-link ">Role</a></li>
				</ul>

				<ul class="navbar-nav ml-auto">
					<c:if test="${pageContext.request.userPrincipal.name != null }">
						<form method="post" id="logoutForm" action="${path}/logout">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}">
						</form>
					</c:if>
					<li class="nav-item"><button
							onClick="document.forms['logoutForm'].submit()"
							class="nav-link btn btn-dark">
							<i class="fas fa-user-times"></i> Logout
						</button></li>
				</ul>
			</div>
		</div>
	</nav>

	<!--HEADER-->
	<header id="main-header" class="py-2 bg-danger text-white">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>Language Edit</h1>
				</div>
			</div>
		</div>
	</header>

	<!--ACTIONS-->

	<section id="actions" class="py-4 mb-4 bg-light">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<a href="/languages" class="btn btn-primary btn-block"> <i
						class="fas fa-arrow-left"></i> Back To Dashboard
					</a>
				</div>
			</div>
		</div>
	</section>

	<!--DETAİLS-->
	<section id="details">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="card">
						<div class="card-header">
							<c:if test="${NotLanguage != null}">
								<div class="alert alert-danger" role="alert">${NotLanguage}</div>
							</c:if>
							<c:if test="${MinimumError != null}">
								<div class="alert alert-danger" role="alert">${MinimumError}</div>
							</c:if>
							<div class="card-body">
								<form:form modelAttribute="language" method="post"
									action="/languages/language/update/${language.getId()}"
									cssClass="form-inline">
									<div class="form-group">
										<b>Language Name :</b>
										<form:input path="LANGUAGE" value="${language.getLANGUAGE()}"
											cssClass="form-control ml-3" />
									</div>
									<div class="form-group">
										<button class="btn btn-success ml-3" type="submit">
											<i class="fas fa-check"></i> Update
										</button>
									</div>
									<div class="form-group">
										<a class="btn btn-danger ml-3"
											href="/languages/language/delete/${language.getId()}"><i
											class="fas fa-trash"></i> Delete</a>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<!-- FOOTER -->
	<footer id="main-footer" class="bg-dark text-white mt-5 p-5">
		<div class="container">
			<div class="row">
				<div class="col">
					<p class="lead text-center">
						Copyright &copy; <span id="year"></span> Lexicographer
					</p>
				</div>
			</div>
		</div>
	</footer>

	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
		integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
		crossorigin="anonymous"></script>

	<script>
		// Get the current year for the copyright
		$('#year').text(new Date().getFullYear());
	</script>
</body>
</html>