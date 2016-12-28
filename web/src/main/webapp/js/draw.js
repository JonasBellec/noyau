function drawView(scope) {
	drawBoard(scope.view.board, scope.configuration.configBoard, scope.game);
	drawHud(scope.view.hud, scope.configuration.configHud, scope.game.dungeon);
}

function drawBoard(board, configBoard, game) {
	board.clearRect(0, 0, configBoard.width, configBoard.height);

	drawSquare(board, game.stage);
	drawPlayer(board, game.instance);
}

function drawSquare(board, stage) {
	for (var i = 0, n = stage.listSquare.length; i < n; i++) {
		var x = stage.listSquare[i].x;
		var y = stage.listSquare[i].y;

		if (stage.listSquare[i].squareType == 1) {
			board.fillStyle = "#FF0000";
		} else {
			board.fillStyle = "#00FF00";
		}
		board.fillRect(50 * x, 50 * y, 50, 50);
	}
}

function drawPlayer(board, instance) {
	for (var i = 0, n = instance.listPersona.length; i < n; i++) {
		var x = instance.listPersona[i].x;
		var y = instance.listPersona[i].y;

		board.fillStyle = "#0000FF";
		board.fillRect(50 * x + 10, 50 * y + 10, 30, 30);
	}
}

function drawHud(hud, configHud, dungeon) {
	hud.clearRect(0, 0, configHud.width, configHud.height);

	for (var i = 0, n = dungeon.listIdStage.length; i < n; i++) {
		hud.fillText(dungeon.listIdStage[i], 0, 20 * i);
	}

	// hud.drawImage(pouet , 0, 0, game.config.configHud.width,
	// game.config.configHud.height);
}
