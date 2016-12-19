function drawBoard(game) {
	game.board.clearRect(0, 0, game.config.configBoard.width, game.config.configBoard.height);
	game.board.drawImage(pouet, 0, 0, game.config.configBoard.width, game.config.configBoard.height);

	for (i = 0; i < level.listSquare; i++) {
		drawSquare(game, level.listSquare[i]);
	}
}

function drawHud(game) {
	game.hud.clearRect(0, 0, game.config.configHud.width, game.config.configHud.height);
	game.hud.drawImage(pouet, 0, 0, game.config.configHud.width, game.config.configHud.height);
}

function drawSquare(game, square) {

	var x = pacman.x + pacman.width / 2;
	var y = pacman.y + pacman.height / 2;
	var startArc1 = pacman.currentAngle + pacman.currentDirection * Math.PI / 2;
	var endArc1 = Math.PI + pacman.currentAngle + pacman.currentDirection * Math.PI / 2;

	var startArc2 = Math.PI - pacman.currentAngle + pacman.currentDirection * Math.PI / 2;
	var endArc2 = 2 * Math.PI - pacman.currentAngle + pacman.currentDirection * Math.PI / 2;

	context.beginPath();
	context.arc(x, y, pacman.radius, startArc1, endArc1);
	context.fillStyle = 'yellow';
	context.fill();

	context.beginPath();
	context.arc(x, y, pacman.radius, startArc2, endArc2);
	context.fillStyle = 'yellow';
	context.fill();
}

function drawGhost(context, ghost) {
	context.drawImage(ghost.image, ghost.x, ghost.y, ghost.width, ghost.height);
}
