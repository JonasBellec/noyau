function start() {

	var scope = initScope();

	window.addEventListener('keypress', function(evt) {
		processKeyPress(scope, evt);
	}, false);

	loadStaticData(scope, function() {
		if (scope.isReady) {
			launch(scope);
		}
	});
}

function loadStaticData(scope, callback) {
	loadAssets(scope, callback);
	loadConfiguration(scope, callback);
	loadDungeon(scope, callback);
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

	var speed = 0.1;

	setTimeout(function() {
		var startTime = (new Date()).getTime();
		refresh(scope, startTime, speed);
	}, 100);
}

function processKeyPress(scope, evt) {

}

function refresh(scope, startTime, speed){
	drawView(scope);
}
