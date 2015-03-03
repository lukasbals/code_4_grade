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
	margin-left: 30px;
}

#errmsg {
	color: red;
	font-style: italic;
}

.input-group {
	width: 120px;
}

.done {
	float: left;
	margin-right: 30px;
}
</style>

<script>
	$(function() {
		//Daten laden
		loadData();
		
		//Einkauf löschen / erledigt
		$("tbody").on("click",".done",function(){
			var id = $(this).attr("data-id");
			doneItem(id);
		});
		
		//Die Anzahl einer Items aktualisieren
		$("tbody").on("click", ".update", function(){
			var quantityUpdate = $( this ).parent().siblings(".updateNum").val();
			var idUpdate = $(this).attr("data-idNum");
			//alert("id: " + idUpdate);
			//alert("eingegebener Wert:" + value);
			updateData(idUpdate, quantityUpdate);	
		});
		
		//Ein neues Item hinzufügen
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
				
// 		$("#draggable").draggable();
		
// 		$(".droppable").droppable({
// 			hoverClass: "hover",
// 			drop : function(e, ui){
// 				alert("in");
// 			}
// 		});
		
		//Funktion zum Daten laden
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
												+ "' class='done btn btn-sm btn-success'>Erledigt</button><div class='input-group'><input type='text' class='updateNum form-control' placeholder='Anzahl''><span class='input-group-btn'><button class='update btn btn-default' data-idNum='"
												+i.id
												+"' type='button'>Neu</button></span> </div></td</tr>";
										});
								$("#data").html(myHTML);
							}
						}
					});
		}
		
		//Funktion zum Item löschen
		function doneItem(id){
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
		
		//Funktion fürs einfügen der Daten
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
					$("#loadIcon").fadeToggle();
				}
			});
		}
		
		//Funktion zum aktualisieren der Anzahl
		function updateData(idUpdate, quantityUpdate){
			var putData = {};
			putData.quantity = quantityUpdate;
			$.ajax({
				dataType:'json',
				contentType:'application/json',
				type:'PUT',
				 url:'<%=request.getContextPath()%>/rest/tasks/' + idUpdate,
				 data:JSON.stringify(putData),
				 statusCode:{
					 200:function(data){
						 loadData();
					 }
				 },
				 beforeSend : function() {
						//alert("before");
						$("#loadIcon").toggle();
					},
					complete : function() {
						// Handle the complete event
						$("#loadIcon").fadeToggle();
					}
			});
		}
	});
</script>

</head>
<body>
	<div class="container">
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