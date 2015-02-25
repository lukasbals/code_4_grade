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
#makeMeDraggable {
	float: left;
	width: 300px;
	height: 300px;
	background: red;
}

#makeMeDroppable {
	float: right;
	width: 300px;
	height: 300px;
	border: 1px solid #999;
}
</style>
<script type="text/javascript">
	$(init());

	function init() {
		$('#makeMeDraggable').draggable();
		$('#makeMeDroppable').droppable({
			drop : handleDropEvent
		});
	}

	function handleDropEvent(event, ui) {
		var draggable = ui.draggable;
		alert('The square with ID "' + draggable.attr('id') + '" was dropped onto me!');
	}
</script>

</head>
<body>

	<div id="content" style="height: 400px;">

		<div id="makeMeDraggable"></div>
		<div id="makeMeDroppable"></div>

	</div>

</body>
</html>