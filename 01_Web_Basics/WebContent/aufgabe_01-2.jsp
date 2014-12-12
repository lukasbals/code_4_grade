<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
#wrapper {
	width: 700px;
	margin: auto;
}

td {
	background-color: grey;
}

button {
	width: 100%;
}
</style>
<script src="./res/js/jquery-1.11.1.min.js"></script>

<script>
	//Selektoren
	$(function() {
		$("#changeClass").click(function() {
			$("#changeColor").css("background-color", "red");
		});

		$("#changeTDs").click(function() {
			$("td").css("background-color", "red");
		});

		$("#changeTDsWidthColspan").click(function() {
			$("td[colspan]").css("background-color", "red");
		});

		$("#changeButton").click(function() {
			$("button").html("Ich bin ein Button");
		});

	});

	//Events
	$(function() {
		$("#blur").blur(function() {
			var text = $("#blur").val();
			$("#input").html(text);
		});

		$("#dblClickBtn").dblclick(function() {
			$("#madeIt").html("You made it!");
		});

		$("#typewriter").keyup(function() {
			var live = $("#typewriter").val();
			$("#output").html(live);
		});

	});
</script>

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h1>JQuery Aufgaben</h1>
		</div>

		<div id="content">
			<h2>Hilfe</h2>
			<ul>
				<li><a href="http://api.jquery.com/category/selectors/">JQuery
						Selektoren</a>
				<li><a href="http://api.jquery.com/category/events/">JQuery
						Events</a>
			</ul>
			<p>Dieses HTML Dokument muss unverändert bleiben! Versuche die
				Aufgaben mit purem JavaScript (JQuery) zu lösen</p>

			<h2>Selektoren</h2>
			<table>
				<tr>
					<td><button id="changeClass">Change Class</button></td>
					<td id="changeColor">Gibt diesem td die Hintergrundfarbe ROT</td>
				</tr>
				<tr>
					<td><button id="changeTDs">Change TDs</button></td>
					<td>Gibt allen TD Elementen einen roten Hintergrund</td>
				</tr>
				<tr>
					<td><button id="changeTDsWidthColspan">Change
							Attribute</button></td>
					<td>Gibt allen TDs einen roten Hintergrund, die ein Attribut
						"colspan" haben</td>
				</tr>
				<tr>
					<td colspan="2">This is a spaned column</td>
				</tr>
				<tr>
					<td><button id="changeButton">Change all Buttons</button></td>
					<td>Gibt allen Buttons den Text "Ich bin ein Button"</td>
				</tr>



			</table>

			<h2>Events</h2>
			<table>
				<tr>
					<td id="textInput"><input type="text" id="blur" /></td>
					<td id="input">Wenn das Textfeld verlassen wird, wird dieser
						Text ersetzt mit dem Text aus dem Textfeld</td>
				</tr>
				<tr>
					<td><button id="dblClickBtn">Double Click</button></td>
					<td id="madeIt">Bei einem Doppelclick auf diesen Button
						erscheint in diesem Feld der Text "You made it!"</td>
				</tr>
				<tr>
					<td><input type="text" id="typewriter" /></td>
					<td id="output">Sobald im Eingabefeld ein Text getippt wird,
						gib ihn hier aus --> Ähnlich einer Schreibmaschine</td>
				</tr>




			</table>

		</div>
	</div>
</body>
</html>