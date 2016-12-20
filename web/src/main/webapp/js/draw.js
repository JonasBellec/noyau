function drawView(scope) {
	drawBoard(scope.view.board, scope.configuration.configBoard);
	drawHud(scope.view.hud, scope.configuration.configHud, scope.game.dungeon);
}


function drawBoard(board, configBoard) {
	board.clearRect(0, 0, configBoard.width, configBoard.height);
}

function drawHud(hud, configHud, dungeon) {
	hud.clearRect(0, 0, configHud.width, configHud.height);
	
	for (var i = 0, n = dungeon.listIdStage.length; i < n; i++) {
		hud.fillText(dungeon.listIdStage[i], 0, 20*y);
	}
	
	
//	hud.drawImage(pouet , 0, 0, game.config.configHud.width, game.config.configHud.height);
}
