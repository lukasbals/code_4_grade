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
#loadIcon {
	display: none;
}

.right {
	float: right;
}

#draggIcon {
	cursor: hand;
}

.hover {
	background-color: gray;
}

.droppable{
	height:35px;
}

#draggable {
	background-color: gray;
	height:33px;
}
</style>

<script>
	$(function() {
		loadData();
		
		$("tbody").on("click","button",function(){
			var id = $(this).attr("data-id");
			doneTask(id);
		});
		
		$("#insert").click(function(){
			var name = $("#name").val();
			var quantity = $("#quantity").val();
			if ((!name) || (quantity == 0)){
				alert("Beschreibung oder Anzahl fehlt!");
				return;
			}
			insertData(quantity, name);
			$("#name").val('');
			$("#quantity").val('');
			$(".number").css("background","white").show();
		});
		
			  $(".number").keypress(function (e) {
			    if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {
			        $("#errmsg").html("Bitte nur Nummern eintippen").show().fadeOut(4000);
			               return false;
			    }else{
			    	$(".number").css("background","lightgreen").show();
		               return true;
			    }
			});
		
		var numberForInput = $("#numberForInput").val();
		
		$("#draggable").draggable();
		
		$(".droppable").droppable({
			hoverClass: "hover",
			drop : function(e, ui){
				alert("in");
			}
		});
		
		function loadData() {
			$.ajax({
				headers : {
					Accept : 'application/json'
				},
				type : 'GET',
				url : '<%=request.getContextPath()%>/rest/tasks',
						statusCode : {
							200 : function(data) {
								var myHTML = '';
								data.item.forEach(function(i) {
											myHTML = myHTML
													+ "<tr><td>"
													+ i.name
													+ "</td><td class='droppable' data-idNumber='"
													+i.id
													+ "'>"
													+ i.quantity
													+ "</td><td><button data-id='"
												+ i.id
												+ "'class='btn btn-sm btn-success' id='delete'>Erledigt</button></td</tr>";
										});
								$("#data").html(myHTML);
							}
						}
					});
		}
		
		function doneTask(id){
			$.ajax({
		        headers: {
		          Accept: 'application/json'
		        },
		        type: 'DELETE',
		        url:'<%=request.getContextPath()%>/rest/tasks/' + id,
				statusCode : {
					200 : function(data) {
						//alert("works");
						loadData();
					}
				}
			});
		}
		
		function insertData(quantity, name){
			var postData = {};
			postData.quantity = quantity;
			postData.name = name;
			$.ajax({
				dataType:'json',
				contentType : 'application/json',
				type : 'POST',
				url:'<%=request.getContextPath()%>/rest/tasks',
				data : JSON.stringify(postData),
				statusCode : {
					201 : function(data) {
						//alert("works");
						loadData();
					}
				},
				beforeSend : function() {
					//alert("before");
					$("#loadIcon").toggle();
				},
				complete : function() {
					// Handle the complete event
					$("#loadIcon").toggle();
				}
			});
		}
	});
</script>

</head>
<body>
	<div class="container">
		<div class="droppable row">droppable</div>

		<div class="row">
			<div class="col-md-12">
				<h1>Einkausliste</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<h3>Etwas auf die Liste setzen ...</h3>
			</div>
		</div>
		<p />
		<div class="row">
			<div class="col-md-2">
				<input id="name" type="text" class="form-control"
					placeholder="Beschreibung">
			</div>
			<div class="col-md-1">
				<input id="quantity" name="quantity" type="text"
					class="number form-control" placeholder="Anzahl">
			</div>
			<div class="col-md-1">
				<button id="insert" class="btn btn-md btn-primary">Einfügen</button>
			</div>
			<div class="col-md-1">
				<img id="loadIcon" src="./res/img/loading.gif" alt="..."
					class="img-rounded">
			</div>
			<div class="col-md-3">
				<span id="errmsg"></span>
			</div>
			<div class="col-md-2">
				<p class="lead">Neue Anzahl:</p>
			</div>
			<div class="col-md-2">
				<div id="draggable">
					<div class="col-md-3">
						<span id="draggIcon"
							class="right lead glyphicon glyphicon-hand-up" aria-hidden="true"></span>
					</div>
					<div class="col-md-9">
						<input id="numberForInput" name="quantity" type="text"
							class="number form-control" placeholder="Anzahl">
					</div>
				</div>
			</div>
		</div>
		<p />
		<p />
		<div class="row">
			<div class="col-md-12">
				<table class="table">
					<thead>
						<tr>
							<th>Was brauche ich?</th>
							<th>Anzahl</th>
							<th>Abhaken</th>
						</tr>
					</thead>
					<tbody id="data">
					</tbody>
				</table>
			</div>
		</div>

	</div>
</body>
</html>