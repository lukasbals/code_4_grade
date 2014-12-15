<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<script src="./res/js/jquery-1.11.1.min.js"></script>
<script src="./res/js/jquery-ui.min.js"></script>
<link href="./res/css/bootstrap.min.css" rel="stylesheet">
<link href="./res/css/jquery-ui.min.css" rel="stylesheet">

<style>
span[data-type] {
	cursor: pointer;
}

#toggleDiv {
	display: none;
}

.container {
	background-color: lightgrey;
}
</style>
<script>
	$(function() {
		var isOpen = true;
		$("#toggleButton").click(function() {
			if (isOpen == true) {
				$("#toggleDiv").slideToggle();
				$("#toggleButton").html("Zuklappen ...")
				isOpen = false;
			} else {
				$("#toggleDiv").slideToggle();
				$("#toggleButton").html("Student dazu ...")
				isOpen = true;
			}

		});

		$("[data-delete='delete']").click(
				function() {
					window.location = "index.jsp?type=delete&id="
							+ $(this).attr("data-id");
				});

	});
</script>
</head>
<body>
	<p />
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>Student List</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<button id="toggleButton" type="button"
					class="btn btn-default btn-md">Student dazu ...</button>
			</div>
		</div>
		<p />
		<div class="row" id="toggleDiv">
			<form class="form-horizontal" method="post" action="index.jsp"
				role="form">
				<div class="col-md-2">
					<input id="vorname" type="text" class="form-control"
						placeholder="Vorname..." name="firstname">
				</div>
				<div class="col-md-2">
					<input id="nachname" type="text" class="form-control"
						placeholder="Nachname..." name="lastname">
				</div>
				<div class="col-md-2">
					<input type="submit" class="btn btn-success btn-md"></input>
				</div>
			</form>
		</div>
		<p />
		<div class="row">
			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<th>ID</th>
							<th>Vorname</th>
							<th>Nachname</th>
							<th>Funktionen</th>
						</tr>
					</thead>
					<tbody id="input">
						<tr>
							<td>bla</td>
							<td data-update="updateField">bla</td>
							<td data-update="updateField">bla</td>
							<td><span data-id="" data-delete="delete" data-type="send"
								class="glyphicon glyphicon-remove"></span></td>

						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>