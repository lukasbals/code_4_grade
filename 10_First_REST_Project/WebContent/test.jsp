<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Einkaufsliste</title>
<script src="./res/js/jquery-1.11.1.min.js"></script>
<script src="./res/js/jquery-ui.min.js"></script>
<link href="./res/css/bootstrap.min.css" rel="stylesheet">
<link href="./res/css/jquery-ui.min.css" rel="stylesheet">
<style>
.droppable {
	background: lightblue;
}
#droppable {
	background: lightgreen;
}
</style>

<script>
	$(function() {
		$("#draggable").draggable();

		var number = $("#number").val();

		$("#droppable").droppable({
			drop : function(event, ui) {
				alert("IN");
				$(".droppable").val(number);
			}
		});
	});
</script>
</head>
<body>
	<div class="container">
		<p />
		<div class="row">
			<div id="draggable">
				<span>Drag</span> <input id="number" placeholder="Numbers">
			</div>
		</div>
		<p />
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th>Was brauche ich?</th>
						<th>Anzahl</th>
						<th>Abhaken</th>
					</tr>
				</thead>
				<tbody id="data">
					<tr>
						<td>hans</td>
						<td id="droppable" data-idnumber="3">3</td>
						<td><button data-id="3" class="btn btn-sm btn-success"
								id="delete">Erledigt</button></td>
					</tr>
					<tr>
						<td>hans</td>
						<td class="droppable" data-idnumber="13">3</td>
						<td><button data-id="13" class="btn btn-sm btn-success"
								id="delete">Erledigt</button></td>
					</tr>
					<tr>
						<td>Klopapierrollen</td>
						<td class="droppable" data-idnumber="18">4</td>
						<td><button data-id="18" class="btn btn-sm btn-success"
								id="delete">Erledigt</button></td>
					</tr>
					<tr>
						<td>lasdkjf</td>
						<td class="droppable" data-idnumber="19">8</td>
						<td><button data-id="19" class="btn btn-sm btn-success"
								id="delete">Erledigt</button></td>
					</tr>
					<tr>
						<td>hans</td>
						<td class="droppable" data-idnumber="20">3</td>
						<td><button data-id="20" class="btn btn-sm btn-success"
								id="delete">Erledigt</button></td>
					</tr>
					<tr>
						<td>klopappe</td>
						<td class="droppable" data-idnumber="21">32</td>
						<td><button data-id="21" class="btn btn-sm btn-success"
								id="delete">Erledigt</button></td>
					</tr>
					<tr>
						<td>kulis</td>
						<td class="droppable" data-idnumber="39">3</td>
						<td><button data-id="39" class="btn btn-sm btn-success"
								id="delete">Erledigt</button></td>
					</tr>
					<tr>
						<td>bananen</td>
						<td class="droppable" data-idnumber="41">12</td>
						<td><button data-id="41" class="btn btn-sm btn-success"
								id="delete">Erledigt</button></td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>