function chasePacman(ghost, pacman, approximation) {

	var ecartX = ghost.x - pacman.x;
	var ecartY = ghost.y - pacman.y;

	if (Math.abs(ecartX) > Math.abs(ecartY)) {
		if (ecartX > 0) {
			if (approximation == 0) {
				ghost.currentDirection = 2;
			} else if (approximation == 1) {
				ghost.currentDirection = 3;
			} else if (approximation == -1) {
				ghost.currentDirection = 1;
			}
		} else {
			if (approximation == 0) {
				ghost.currentDirection = 4;
			} else if (approximation == 1) {
				ghost.currentDirection = 1;
			} else if (approximation == -1) {
				ghost.currentDirection = 3;
			}
		}
	} else {
		if (ecartY > 0) {
			if (approximation == 0) {
				ghost.currentDirection = 3;
			} else if (approximation == 1) {
				ghost.currentDirection = 4;
			} else if (approximation == -1) {
				ghost.currentDirection = 2;
			}
		} else {
			if (approximation == 0) {
				ghost.currentDirection = 1;
			} else if (approximation == 1) {
				ghost.currentDirection = 2;
			} else if (approximation == -1) {
				ghost.currentDirection = 4;
			}
		}
	}
}

function eatGum(board) {

	for (var i = 0; i < board.config.listGum.length; i++) {
		if (board.config.listGum[i].eated == false) {
			isEated(board.config.listGum[i], board.pacman);
		}
	}

	drawBoard(board);
}

function isEated(gum, pacman) {

	var minX = pacman.x + pacman.width / 2 - 5;
	var maxX = pacman.x + pacman.width / 2 + 3;
	var minY = pacman.y + pacman.height / 2 - 5;
	var maxY = pacman.y + pacman.height / 2 + 3;

	if (gum.x > minX && gum.x < maxX && gum.y > minY && gum.y < maxY) {
		gum.eated = true;
	}
}
