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

#toggleDivNew {
	display: none;
}

#toggleDivUpdate {
	display: none;
}

.container {
	background-color: white;
}

.drop {
	background: red;
}

span[data-update] {
	display: none;
}
</style>
<script>
	$(function() {
		var isNewOpen = true;
		$("#toggleButtonNew").click(function() {
			if (isNewOpen == true) {
				$("#toggleDivNew").fadeToggle();
				$("#toggleButtonNew").html("Neues Todo zuklappen...")
				isNewOpen = false;
			} else {
				$("#toggleDivNew").fadeToggle();
				$("#toggleButtonNew").html("Neues Todo")
				isNewOpen = true;
			}
		});
		var isUpdateOpen = true;
		$("#toggleButtonUpdate").click(function() {
			if (isUpdateOpen == true) {
				$("#toggleDivUpdate").fadeToggle();
				$("#toggleButtonUpdate").html("Update Todo zuklappen...")
				isUpdateOpen = false;
			} else {
				$("#toggleDivUpdate").fadeToggle();
				$("#toggleButtonUpdate").html("Update Todo")
				isUpdateOpen = true;
			}
		});

		$("[data-delete='delete']").click(
				function() {
					window.location = "index.jsp?type=delete&id="
							+ $(this).attr("data-id");
				});

		$("#toggleDivUpdate").draggable();
		$("#droppableDiv").droppable(
				{
					drop : function(event, ui) {
						$("#droppableDiv").addClass("drop").find("p").html(
								"Dropped!")

						window.location = "index.jsp?type=update&id="
								+ ($("[data-update='update']")
										.attr("data-IDUpdate")) + "&update="
								+ ($("#updateData").val());
					}

				});

		/*
		 $("[data-update='update']").click(
		 function() {
		 window.location = "index.jsp?type=update&id="
		 + ($(this).attr("data-IDUpdate")) + "&update="
		 + ($("#updateData").val());
		 });
		 */
	});
</script>
</head>
<body>
	<%
		TodoDAO d = new TodoDAO();

		String todo = request.getParameter("todo");
		String type = request.getParameter("type");
		String updateData = request.getParameter("update");

		if (todo != null) {
			d.saveTodo(todo);
		}

		if ((type != null) && (type.equals("delete"))) {
			String ID = request.getParameter("id");
			d.deleteTodo(Integer.parseInt(ID));
		}

		if ((updateData != null) && (type != null)
				&& (type.equals("update"))) {
			String IDUpdate = request.getParameter("id");
			d.updateTodo(Integer.parseInt(IDUpdate), updateData);
		}
	%>
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
			<div class="col-md-3">
				<button id="toggleButtonNew" type="button"
					class="btn btn-default btn-md">Neues Todo</button>
			</div>

			<form class="form-horizontal" method="post" action="index.jsp"
				role="form">
				<div id="toggleDivNew">
					<div class="col-sm-4">
						<input id="todo" type="text" class="form-control"
							placeholder="Todo eintragen..." name="todo">
					</div>
					<div class="col-md-2">
						<input type="submit" class="btn btn-success btn-md"></input>
					</div>
				</div>
			</form>



		</div>
		<p />
		<div class="row">
			<div class="col-md-3">
				<button id="toggleButtonUpdate" type="button"
					class="btn btn-default btn-md">Update Todo</button>
			</div>
			<div id="toggleDivUpdate">
				<div class="col-md-4">
					<input id="updateData" type="text" class="form-control"
						placeholder="Änderung eingeben ...">
				</div>
				<div class="col-md-2">
					<button type="button" class="btn btn-default btn-md"
						disabled="disabled">Drag!</button>
				</div>
			</div>
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
							<td ><%=t.getId()%></td>
							<td id="droppableDiv"><%=t.getTodo()%></td>

							<td>
								<div>
									<span data-id="<%=t.getId()%>" data-delete="delete"
										data-type="cursor" class="glyphicon glyphicon-remove"></span>&nbsp;&nbsp;&nbsp;&nbsp;
									<span data-IDUpdate="<%=t.getId()%>" data-update="update"
										data-type="cursor" class="glyphicon glyphicon-pencil"></span>
								</div>
							</td>

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