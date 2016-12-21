function initScope() {
	var scope = {
		service : null,
		assets : null,
		configuration : null,

		view : null,
		game : null,
	}

	scope.service = initService();
	scope.assets = initAssets();
	scope.configuration = initConfiguration();
	scope.view = initView();
	scope.game = initGame();
	
	return scope;
}

function initService() {

	var service = {
		queryStage : "http://localhost:8080/front/rest/stage/",
	};

	return service;
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

	configuration.configBoard = {
		height : 500,
		width : 1000,
	};
	
	configuration.configHud = {
			height : 200,
			width : 1000,
		};

	configuration.configSquare = {
		height : 50,
		width : 50,
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
		idDungeon : 0,
		idStage : 0,
		dungeon : null,
		stage : null,
	};

	return game;
}
