<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>

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
<title>Lexicographer Login</title>
</head>
</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light p-0">
		<div class="container">
			<a href="/" class="navbar-brand"><b>Lexicographer</b></a>
			<button class="navbar-toggler" data-toggle="collapse"
				data-target="#navbarCollapse" aria-controls="navbarCollapse"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item mr-3 pt-3 pb-3">
						<button class="btn btn-light">
							<i class="fas fa-info"></i> About
						</button>
					</li>

					<li class="nav-item pt-3 pb-3"><a href="/register"
						class="btn btn-light"><i class="fas fa-user-plus"></i>
							Register</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<hr>
	<section id="" class="py-4 mb-4 bg-light">
		<div class="container">
			<div class="row">
				<div class="col-md-3"></div>
				<div class="col-md-6">
					<c:if test="${error != null }">
						<div class="alert alert-danger" role="alert">${error }</div>
					</c:if>
					<c:if test="${message != null }">
						<div class="alert alert-success" role="alert">${message }</div>
					</c:if>
					<c:if test="${registerSuccess != null }">
						<div class="alert alert-success" role="alert">
							${registerSuccess}</div>
					</c:if>
					<form action="${path}/login" method="POST">
						<div class="form-group">
							<label for="username"><b>Username</b></label> <input type="text"
								class="form-control" name="username" id="username">
						</div>
						<div class="form-group">
							<label for="password"><b>Password</b></label> <input
								type="password" class="form-control" name="password"
								id="password">
						</div>
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}">
						<div class="row">
							<div class="col-md-6">
								<div class="form-check">
									<input class="form-check-input" type="checkbox"
										id="defaultCheck1" name="remember-me"> <label
										class="form-check-label" for="defaultCheck1"> Remember
										Me </label>
								</div>
							</div>
							<div class=" form-group col-md-6 text-right">
								<button type="submit" class="btn btn-outline-success">
									Login</button>
							</div>
						</div>

					</form>
				</div>
				<div class="col-md-3"></div>
			</div>

		</div>
	</section>



	<script src="https://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
		integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
		crossorigin="anonymous"></script>
</body>
</html>