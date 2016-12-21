function drawView(scope) {
	drawBoard(scope.view.board, scope.configuration.configBoard,
			scope.game.stage);
	drawHud(scope.view.hud, scope.configuration.configHud, scope.game.dungeon);
}

function drawBoard(board, configBoard, stage) {
	board.clearRect(0, 0, configBoard.width, configBoard.height);

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

function drawHud(hud, configHud, dungeon) {
	hud.clearRect(0, 0, configHud.width, configHud.height);

	for (var i = 0, n = dungeon.listIdStage.length; i < n; i++) {
		hud.fillText(dungeon.listIdStage[i], 0, 20 * i);
	}

	// hud.drawImage(pouet , 0, 0, game.config.configHud.width,
	// game.config.configHud.height);
}
