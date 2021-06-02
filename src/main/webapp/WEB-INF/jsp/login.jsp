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
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<title>Lexicographer Login</title>
</head>
</head>

<body>
	<nav class="navbar navbar-expand-sm navbar-light bg-light p-0">
		<div class="container">
			<a href="/" class="navbar-brand"><b>Lexicographer</b></a>
			<button class="navbar-toggler" data-toggle="collapse"
				data-target="#navbarCollapse">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item pt-3 pb-3"><a href="/register"
						class="btn btn-danger">Sign Up</a></li>
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
						<div class="alert alert-danger" role="alert">
							${error }
						</div>
					</c:if>
					<c:if test="${message != null }">
						<div class="alert alert-success" role="alert">
							${message }
						</div>
					</c:if>
					<form action="${path}/login" method="POST">
						<div class="form-group">
							<label for="username"><b>Username</b></label> <input type="text"
								class="form-control" name="username" id="username">
						</div>
						<div class="form-group">
							<label for="password"><b>Password</b></label> <input type="password"
								class="form-control" name="password" id="password">
						</div>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
						<div class="form-group text-right">
							<a href="" class="font-weight-light mr-1">Forgot Password</a>
							<button type="submit" class="btn btn-outline-success">
								Login</button>
						</div>
					</form>
				</div>
				<div class="col-md-3"></div>
			</div>

		</div>
	</section>



	<script src="http://code.jquery.com/jquery-3.3.1.min.js"
		integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js"
		integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF"
		crossorigin="anonymous"></script>
</body>
</html>