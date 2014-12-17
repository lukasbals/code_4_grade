<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="todos.TodoDAO"%>
<%@page import="todos.Todo"%>
<%@page import="javax.swing.JOptionPane"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
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
	background-color: white;
}
</style>
<script>
	$(function() {
		var isOpen = true;
		$("#toggleButton").click(function() {
			if (isOpen == true) {
				$("#toggleDiv").slideToggle();
				$("#toggleButton").html("Zuklappen...")
				isOpen = false;
			} else {
				$("#toggleDiv").slideToggle();
				$("#toggleButton").html("Neues Todo")
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
				<h1 id="type" class="page-header">
					Todo App<small> by Bals</small>
				</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<button id="toggleButton" type="button"
					class="btn btn-default btn-md">Neues Todo</button>
			</div>
		</div>
		<p />
		<div class="row" id="toggleDiv">
			<%
				TodoDAO d = new TodoDAO();

				String number = request.getParameter("number");
				String todo = request.getParameter("todo");
				String type = request.getParameter("type");

				if (type != null && type.equals("delete")) {
					String ID = request.getParameter("id");
					d.deleteTodo(Integer.parseInt(ID));
				}

				if ((todo != null) && (number != null)) {
					//Todo T = new Todo(todo);
					d.saveTodo(todo, Integer.parseInt(number));
				}
			%>
			<form class="form-horizontal" method="post" action="index.jsp"
				role="form">
				<div class="col-sm-1">
					<input id="todo" type="text" class="form-control"
						placeholder="ID ..." name="number">
				</div>
				<div class="col-sm-3">
					<input id="todo" type="text" class="form-control"
						placeholder="Todo eintragen..." name="todo">
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
							<th>Todo</th>
							<th>Funktionen</th>
						</tr>
					</thead>
					<tbody id="input">
						<%
							List<Todo> todoList = d.getAllTodos();
							for (Todo t : todoList) {
						%>
						<tr>
							<td data-update="updateField"><%=t.getId()%></td>
							<td data-update="updateField"><%=t.getTodo()%></td>
							<td><span data-id="<%=t.getId()%>" data-delete="delete"
								data-type="send" class="glyphicon glyphicon-remove"></span>&nbsp;&nbsp;&nbsp;&nbsp;<span
								data-id="<%=t.getId()%>" data-update="update" data-type="send"
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