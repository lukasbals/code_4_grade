<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>First Tomcat</title>
<script src="./res/js/jquery-1.11.1.min.js"></script>
<script src="./res/js/jquery-ui.min.js"></script>
<link href="./res/css/bootstrap.min.css" rel="stylesheet">
<link href="./res/css/jquery-ui.min.css" rel="stylesheet">

<script>
	$(function() {
		loadData();
		//setInterval(function(){loadData()},1000);
		
 		$("#load").click(function(){
 			loadData();
		});
 		
		$("tbody").on("click","button",function(){
			var id = $(this).attr("data-id");
			deleteTask(id);
		});
		
		
		
	});
	
	function deleteTask(id){
		$.ajax({
	        headers: {
	          Accept: 'application/json'
	        },
	        type: 'DELETE',
	        url:'<%=request.getContextPath()%>/rest/tasks/' + id,
			statusCode :{
				200: function(data) {
					//alert("works");
					loadData();
					
				}
				
			} 
		});
	}
	
	function loadData() {
		$.ajax({
		headers : {
			Accept : 'application/json'
		},
		type : 'GET',
		url : '<%=request.getContextPath()%>/rest/tasks',
					success : function(data) {
						var myHTML = '';
						data.task
								.forEach(function(t) {
									myHTML = myHTML
											+ "<tr><th>"
											+ t.id
											+ "</th><td>"
											+ t.name
											+ "</td><td>"
											+ t.description
											+ "</td><td><button data-id='" + t.id + "'class='btn btn-md btn-danger' id='delete'>Delete</button></td</tr>";
								});

						$("#data").html(myHTML);
					},
					error : function(data) {
						console.log(data);
					}
				});
	}
</script>

</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>Task App</h1>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<button class="btn btn-md btn-primary" id="load">Load data</button>
			</div>
		</div>
		<p />

		<div class="row">
			<div class="col-md-12">
				<table class="table">
					<caption>Tasks</caption>
					<thead>
						<tr>
							<th>#</th>
							<th>Name</th>
							<th>Beschreibung</th>
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