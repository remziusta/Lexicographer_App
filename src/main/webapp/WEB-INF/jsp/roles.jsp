<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
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
<title>Roles</title>
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
					<li class="nav-item px-2 active"><a href="/roles"
						class="nav-link active">Role</a></li>
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
					<h1>
						<i class="fas fa-language"></i> Roles
					</h1>
				</div>
			</div>
		</div>
	</header>

	<!--ADD CATEGORY-->

	<section id="search" class="py-4 mb-4 bg-light">
		<div class="container">
			<div class="row">
				<div class="col">
					<h4>Add Role</h4>
				</div>
			</div>
			<div class="row">
				<div class="col">
					<c:if test="${NotRole != null}">
						<div class="alert alert-danger" role="alert">${NotRole}</div>
					</c:if>
					<form:form modelAttribute="role" method="post"
						cssClass="form-inline">
						<div class="form-group">
							<b>Role Name :</b>
							<form:input path="ROLE" cssClass="form-control ml-3" />
						</div>
						<div class="form-group">
							<button class="btn btn-danger ml-3" type="submit">Save</button>

						</div>
					</form:form>
				</div>
			</div>
		</div>
	</section>

	<!--Categories-->
	<section id="languages">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="card">
						<div class="card-header">
							<h4>Latest Languages</h4>
						</div>
						<table class="table table-striped">
							<thead class="thead-dark">
								<tr>
									<th>#</th>
									<th>Role</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${roles}" var="role" varStatus="status">
									<tr>
										<td>${role.getId()}</td>
										<td>${role.getROLE()}</td>
										<td><a href="/roles/role/details/${role.getId()}"
											class="btn btn-danger"> <i
												class="fas fa-angle-double-right"></i> Details
										</a></td>
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
</html>