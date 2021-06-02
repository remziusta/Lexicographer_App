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
<title>Admin Page</title>

</head>
<body>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark p-0">
		<div class="container">
			<a href="/admin/dashboard" class="navbar-brand">Lexicographer</a>
			<button class="navbar-toggler" data-toggle="collapse"
				data-target="#navbarCollapse">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarCollapse">
				<ul class="navbar-nav">
					<li class="nav-item px-2"><a href="/admin/dashboard"
						class="nav-link ">Dashboard</a></li>
					<li class="nav-item px-2"><a href="/words"
						class="nav-link active">Words</a></li>
					<li class="nav-item px-2"><a href="/categories"
						class="nav-link ">Categories</a></li>
					<li class="nav-item px-2"><a href="/users" class="nav-link">Users</a></li>
					<li class="nav-item px-2"><a href="/types" class="nav-link ">Word
							Types</a></li>
					<li class="nav-item px-2"><a href="/languages"
						class="nav-link ">Languages</a></li>
					<li class="nav-item px-2 "><a href="/roles"
						class="nav-link ">Role</a></li>
				</ul>

				<ul class="navbar-nav ml-auto">
					<c:if test="${pageContext.request.userPrincipal.name != null }">
						<form method="post" id="logoutForm" action="${path}/logout">
							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}">
						</form>
					</c:if>
					<li class="nav-item"><a	onClick="document.forms['logoutForm'].submit()" class="nav-link">
						<i class="fas fa-user-times"></i> Logout </a>
					</li>
				</ul>
			</div>
		</div>
	</nav>

	<!--HEADER-->
	<header id="main-header" class="py-2 bg-info text-white">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>
						<i class="fas fa-font"></i> Words
					</h1>
				</div>
			</div>
		</div>
	</header>

	<!--ADD WORD-->

	<section id="search" class="py-4 mb-4 bg-light">
		<div class="container">
			<div class="row">
				<div class="col-md-3">
					<a href="/words/addword" class="btn btn-success"> <i
						class="fas fa-plus"></i> Add Word
					</a>
				</div>
				<div class="col-md-5">
					<a class="btn btn-success"><i class="fas fa-file-excel"></i>
						Add Word From Excel</a>
				</div>
			</div>
		</div>
	</section>

	<!--WORDS-->
	<section id="words">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="card">
						<div class="card-header">
							<h4>Latest Word</h4>
						</div>
						<table class="table table-striped">
							<thead class="thead-dark">
								<tr>
									<th>#</th>
									<th>Word</th>
									<th>Language</th>
									<th>Created At Date</th>
									<th></th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${words}" var="word" varStatus="status">
									<tr>
										<td>${word.getId()}</td>
										<td>${word.getWORD()}</td>
										<td>${word.getLANGUAGE().getLANGUAGE()}</td>
										<td>${word.getCREATED_AT_DATE()}</td>
										<td><a href="/words/word/details"
											class="btn btn-secondary"> <i
												class="fas fa-angle-double-right"></i> Details
										</a></td>
										<td><a href="/words/word/delete/${word.getId()}"
											class="btn btn-danger"><i class="fas fa-times"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
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


</body>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"
	integrity="sha384-smHYKdLADwkXOn1EmN1qk/HfnUcbVRZyYmZ4qpPea6sjB/pTJ0euyQp0Mk8ck+5T"
	crossorigin="anonymous"></script>


<script>
	// Get the current year for the copyright
	$('#year').text(new Date().getFullYear());
</script>
</html>