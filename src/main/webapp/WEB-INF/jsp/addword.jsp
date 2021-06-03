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
	integrity="undefined" crossorigin="anonymous">
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
					<li class="nav-item px-2"><a href="/words"
						class="nav-link active">Words</a></li>
					<li class="nav-item px-2"><a href="/categories"
						class="nav-link ">Categories</a></li>
					<li class="nav-item px-2"><a href="/users" class="nav-link">Users</a></li>
					<li class="nav-item px-2"><a href="/types" class="nav-link ">Word
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
	<header id="main-header" class="py-2 bg-info text-white">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<h1>
						<i class="fas fa-plus"></i> Add Word
					</h1>
				</div>
			</div>
		</div>
	</header>

	<!--DETAİLS-->
	<section id="details" class="mt-3">
		<div class="container">
			<div class="row">
				<div class="col">
					<div class="card">
						<div class="card-header">
							<div class="card-body">
								<form action="/words/new" method="post">
									<div class="form-group">
										<label for="WORD"><b>Word :</b></label> <input
											class="form-control" name="WORD" id="WORD" />
									</div>
									<div class="form-group">
										<label for="wordLANGUAGE"><b>Language :</b></label> <select
											class="form-select form-control" id="wordLANGUAGE"
											name="wordLANGUAGE">
											<option selected>Select Language</option>
											<c:forEach items="${languages}" var="language"
												varStatus="status">
												<option value="${language.getId()}">${language.getLANGUAGE()}</option>
											</c:forEach>
										</select>
									</div>
									<div class="form-group">
										<button type="button" class="btn btn-info" id="meaningAdd"
											value="0" onclick="addMeanToDiv()">
											<i class="fas fa-plus"></i> Add a Mean
										</button>
									</div>
									<hr>
									<!-- MEANS -->
									<div id="meanings" class="form-group"></div>

									<div class="form-group">
										<button type="submit" class="btn btn-info">
											<i class="fas fa-check"></i> Save
										</button>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

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

	function addMeanToDiv() {
		let counter = document.getElementById("meaningAdd");
		counter.value = Number(counter.value) + 1;
		let count = counter.value

		let divMeaning = document.getElementById("meanings");

		let str = '<div id="meaningContext'+count+'">'
				+ '<div class="form-group">'
				+ '<label for="MEAN'+count+'"><b>Mean :</b></label>'
				+ '<input class="form-control" name="MEAN'+count+'" id="MEAN'+count+'"" />'
				+ '</div>'
				+ '<div class="form-group">'
				+ '<label for="meanLANGUAGE'+count+'"><b>Language :</b></label>'
				+ '<select class="form-select form-control" id="meanLANGUAGE'+count+'"' +' name="meanLANGUAGE'+count+'">'
				+ '<option selected>Select Language</option>'
				+ '<c:forEach items="${languages}" var="language" varStatus="status">'
				+ '<option value="${language.getId()}">${language.getLANGUAGE()}</option>'
				+ '</c:forEach>'
				+ '</select>'
				+ '</div>'
				+ '<div class="form-group">'
				+ '<label for="meanCATEGORY'+count+'"><b>Category :</b></label>'
				+ '<select class="form-select form-control" id="meanCATEGORY'+count+'"' +' name="meanCATEGORY'+count+'">'
				+ '<option selected>Select Category</option>'
				+ '<c:forEach items="${categories}" var="category" varStatus="status">'
				+ '<option value="${category.getId()}">${category.getCATEGORY()}</option>'
				+ '</c:forEach>'
				+ '</select>'
				+ '</div>'
				+ '<div class="form-group">'
				+ '<label for="meanTYPE'+count+'"><b>Type :</b></label>'
				+ '<select class="form-select form-control" id="meanTYPE'+count+'"' +' name="meanTYPE'+count+'">'
				+ '<option selected>Select Type</option>'
				+ '<c:forEach items="${types}" var="type" varStatus="status">'
				+ '<option value="${type.getId()}">${type.getTYPE()}</option>'
				+ '</c:forEach>' + '</select>' + '</div>' + '</div>' + '<hr>';

		divMeaning.innerHTML += str;
	}
</script>

</html>
</html>