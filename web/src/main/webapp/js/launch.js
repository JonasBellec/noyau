function start() {

	var scope = initScope();

	window.addEventListener('keypress', function(evt) {
		processKeyPress(scope, evt);
	}, false);

	loadStaticData(scope, function() {
		launch(scope);
	});
}

function launch(scope) {
	window.requestAnimFrame = (function(callback) {
		return window.requestAnimationFrame
				|| window.webkitRequestAnimationFrame
				|| window.mozRequestAnimationFrame
				|| window.oRequestAnimationFrame
				|| window.msRequestAnimationFrame || function(callback) {
					window.setTimeout(callback, 1000 / 60);
				};
	})();

	setTimeout(function() {
		refresh(scope);
	}, 100);
}

function processKeyPress(scope, evt) {

}

function refresh(scope) {
	loadDynamicData(scope, function() {
		drawView(scope);
	});
}
