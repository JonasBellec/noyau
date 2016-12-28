function initScope() {
	var scope = {
		assets : null,
		configuration : null,

		view : null,
		game : null,
	}

	scope.assets = initAssets();
	scope.configuration = initConfiguration();
	scope.view = initView();
	scope.game = initGame();
	
	return scope;
}

function initAssets() {

	var assets = {};

	return assets;
}

function initConfiguration() {

	var configuration = {
		configBoard : null,
		configHud : null,
		configSquare : null,
	};

	return configuration;
}

function initView() {

	var board = document.getElementById('board');
	var hud = document.getElementById('hud');

	var view = {
		board : board.getContext('2d'),
		hud : hud.getContext('2d'),
	};

	return view;
}

function initGame() {

	var game = {
		dungeon : null,
		stage : null,
		instance : null,
	};

	return game;
}
