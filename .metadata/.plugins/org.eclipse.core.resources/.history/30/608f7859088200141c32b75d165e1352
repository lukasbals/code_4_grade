<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@page import="java.util.List"%>
<%@page import="at.bals.students.StudentDAO"%>
<%@page import="at.bals.students.Student"%>
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
			<%
				StudentDAO d = new StudentDAO();

				String fName = request.getParameter("firstname");
				String lName = request.getParameter("lastname");
				String type = request.getParameter("type");

				if (type != null && type.equals("delete")) {
					String ID = request.getParameter("id");
					d.deleteStudent(Integer.parseInt(ID));
				}

				if ((fName != null) && (lName != null)) {
					Student S = new Student(fName, lName);
					d.saveStudent(S);
				}
			%>
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

						<%
							List<Student> studentList = d.getAllStudents();
							for (Student s : studentList) {
						%>
						<tr>
							<td><%=s.getId()%></td>
							<td data-update="updateField"><%=s.getFirstname()%></td>
							<td data-update="updateField"><%=s.getLastname()%></td>
							<td><span data-id="<%=s.getId()%>" data-delete="delete"
								data-type="send" class="glyphicon glyphicon-remove"></span><span
								data-update="update" data-type="send"
								class="glyphicon glyphicon-pencil"></span></td>

						</tr>
						<%
							}
						%>

					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>