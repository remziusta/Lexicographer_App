<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<title>Lexicographer</title>
</head>


<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light p-0">
		<div class="container">
			<a href="/" class="navbar-brand"><b>Lexicographer</b></a>
			<button class="navbar-toggler" data-toggle="collapse"
				data-target="#navbarCollapse">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item mr-3 pt-3 pb-3"><a href="/login"
						class="btn btn-outline-danger  ">Login</a></li>

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
					<c:if test="${usererror != null }">
						<div class="alert alert-danger" role="alert">${usererror}</div>
					</c:if>
					<c:if test="${emailerror != null }">
						<div class="alert alert-danger" role="alert">${emailerror}</div>
					</c:if>
					<c:if test="${fullname != null }">
						<div class="alert alert-danger" role="alert">${fullname}</div>
					</c:if>
					<c:if test="${passerror != null }">
						<div class="alert alert-danger" role="alert">${passerror}</div>
					</c:if>
					<div class="card">
						<div class="card-header">
							<div class="card-body">
								<form:form modelAttribute="user" action="/register"
									method="post">
									<div class="form-group">
										Username :
										<form:input type="text" path="username"
											cssClass="form-control" />
									</div>
									<div class="form-group">
										Full Name:
										<form:input type="fullname" path="fullname"
											cssClass="form-control" />
									</div>
									<div class="form-group">
										E-mail :
										<form:input type="email" path="email" cssClass="form-control" />
									</div>
									<div class="form-group">
										Password :
										<form:input type="password" path="password"
											cssClass="form-control" />

									</div>

									<form:input path="role.id" type="hidden" value="0" />
									<div class="form-group">
										<button type="submit" class="btn btn-info">
											<i class="fas fa-check"></i> Save
										</button>
									</div>
								</form:form>
							</div>
						</div>
					</div>
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