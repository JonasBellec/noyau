function animate(game, previousTime, speed) {
	var time = (new Date()).getTime();
	var relativeSpeed = 20 * speed;

	moveGhost(game.board, game.board.ghost_0, relativeSpeed);

	movePacman(game.board, game.board.pacman, relativeSpeed);
	movePacmanMouth(game.board.pacman, relativeSpeed);
	
	eatGum(game.board);

	drawBoard(game.board);
	drawPacman(game.board.context, game.board.pacman);
	drawGhost(game.board.context, game.board.ghost_0);

	// request new frame
	requestAnimFrame(function() {
		animate(game, time, speed);
	});
}

function moveGhost(board, entity, relativeSpeed) {

	entity.nextX = entity.x;
	entity.nextY = entity.y;

	chasePacman(entity, board.pacman, 0);

	calculMoveEntity(board, entity, relativeSpeed);

	var pixel = moveEntity(board, entity, relativeSpeed, 2);

	if (pixel < 0) {
		entity.x = entity.nextX;
		entity.y = entity.nextY;
		entity.approximation = -entity.approximation;
	} else {
		var approximation = entity.approximation;

		entity.nextX = entity.x;
		entity.nextY = entity.y;

		chasePacman(entity, board.pacman, approximation);
		calculMoveEntity(board, entity, relativeSpeed);

		var pixel = moveEntity(board, entity, relativeSpeed, 2);

		if (pixel >= 0) {
			approximation = -approximation;

			entity.nextX = entity.x;
			entity.nextY = entity.y;

			chasePacman(entity, board.pacman, approximation);
			calculMoveEntity(board, entity, relativeSpeed);
			pixel = moveEntity(board, entity, relativeSpeed, 2);
		}

		if (pixel < 0) {
			entity.x = entity.nextX;
			entity.y = entity.nextY;
			entity.approximation = approximation;
		}
	}
}

function movePacman(board, entity, relativeSpeed) {
	entity.nextX = entity.x;
	entity.nextY = entity.y;

	calculMoveEntity(board, entity, relativeSpeed);

	var pixel = moveEntity(board, entity, relativeSpeed, 5);

	if (pixel < 0) {
		entity.x = entity.nextX;
		entity.y = entity.nextY;
	}
}

function moveEntity(board, entity, relativeSpeed, maxDecalage) {

	var pixel = collideWithWalls(board.context, entity.nextX, entity.nextY, entity.width, entity.height);
	var iteration = 0;

	while (pixel >= 0 && iteration < maxDecalage) {
		decalage(board.context, entity, pixel);
		pixel = collideWithWalls(board.context, entity.nextX, entity.nextY, entity.width, entity.height);
		iteration++;
	}

	return pixel;
}

function calculMoveEntity(board, entity, relativeSpeed) {

	if (entity.currentDirection != 0) {
		if (entity.currentDirection == 1) {
			entity.nextY += relativeSpeed;
		} else if (entity.currentDirection == 2) {
			entity.nextX -= relativeSpeed;
		} else if (entity.currentDirection == 3) {
			entity.nextY -= relativeSpeed;
		} else if (entity.currentDirection == 4) {
			entity.nextX += relativeSpeed;
		}
	}

	if (entity.nextX + entity.width < 0) {
		entity.nextX = board.config.width;
	}

	if (entity.nextY + entity.height < 0) {
		entity.nextY = board.config.height;
	}

	if (entity.nextX > board.config.width) {
		entity.nextX = 0;
	}

	if (entity.nextY > board.config.height) {
		entity.nextY = 0;
	}
}

function decalage(context, entity, pixel) {
	if (pixel % entity.width < 2) {
		if (entity.currentDirection == 1 || entity.currentDirection == 3) {
			entity.nextX++;
		}
	} else if (pixel % entity.width > entity.width - 3) {
		if (entity.currentDirection == 1 || entity.currentDirection == 3) {
			entity.nextX--;
		}
	}

	if (pixel < 2 * entity.width) {
		if (entity.currentDirection == 2 || entity.currentDirection == 4) {
			entity.nextY++;
		}
	} else if (pixel > ((entity.height - 3) * entity.width) - 1) {
		if (entity.currentDirection == 2 || entity.currentDirection == 4) {
			entity.nextY--;
		}
	}
}

function collideWithWalls(context, x, y, width, height) {

	var data = context.getImageData(x, y, width, height).data;

	var red = 0;
	var green = 0;
	var blue = 0;

	for (var i = 0, n = data.length / 4; i < n; i++) {
		var red = data[(4 * i)];
		var green = data[(4 * i) + 1];
		var blue = data[(4 * i) + 2];

		if (red == 87 && green == 87 && blue == 255) {
			return i;
		}
	}

	return -1;
}

function movePacmanMouth(pacman, relativeSpeed) {
	if (pacman.isOpening == true) {
		pacman.currentAngle = pacman.currentAngle + relativeSpeed / 200 * Math.PI;
	} else {
		pacman.currentAngle = pacman.currentAngle - relativeSpeed / 200 * Math.PI;
	}

	if (pacman.currentAngle < 0.1) {
		pacman.currentAngle = 0.1;
		pacman.isOpening = true;
	} else if (pacman.currentAngle > Math.PI / 4) {
		pacman.currentAngle = Math.PI / 4;
		pacman.isOpening = false;
	}
}
