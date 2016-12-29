function start() {

	var scope = initScope();

	window.addEventListener('keypress', function(evt) {
		processKeyPress(scope, evt);
	}, false);

	loadStaticData(scope, function() {
		prepareGame(scope);
	});
}

function prepareGame(scope) {
	createInstance(scope, function() {
		loadDungeon(scope, function() {
			loadStage(scope, function() {
				launch(scope)
			});
		});
	});
}

function launch(scope) {
	window.requestAnimFrame = (function(callback) {
		return window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.mozRequestAnimationFrame
				|| window.oRequestAnimationFrame || window.msRequestAnimationFrame || function(callback) {
					window.setTimeout(callback, 1000 / 60);
				};
	})();

	setTimeout(function() {
		refreshView(scope);
	}, 100);
	
	setTimeout(function() {
		refreshInstance(scope);
	}, 250);
}

function processKeyPress(scope, evt) {

}

function refreshView(scope) {
	requestAnimFrame(function() {
		drawView(scope);
		refreshView(scope);
	});
}

function refreshInstance(scope) {
	loadInstance(scope, function() {
		setTimeout(function() {
			refreshInstance(scope);
		}, 250);
	});
}
