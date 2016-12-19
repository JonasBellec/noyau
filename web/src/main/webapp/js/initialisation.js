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
}

function initService() {

	var service = {
		query : "http://localhost:8080/noyau/rest/board/",
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
		width : 500,
	};

	configuration.configSquare = {
		height : 50,
		width : 50,
	};

	return configuration;
}

function initView() {

	var board = document.getElementById('board');

	var view = {
		board : board.getContext('2d'),
	};

	return view;
}

function initGame() {

	var game = {
		idDungeon : 0,
		idLevel : 0,
		dungeon : null,
		level : null,
	};

	return game;
}
