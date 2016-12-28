function loadStaticData(scope, callback) {
	loadAssets(scope, function() {
		if (isStaticDataReady(scope)) {
			callback();
		}
	});
	loadConfiguration(scope, function() {
		if (isStaticDataReady(scope)) {
			callback();
		}
	});
	
}

function isStaticDataReady(scope) {
	return scope.assets != null && scope.configuration != null;
}

function loadAssets(scope, callback) {
	scope.assets = 1;
	callback();
}

function loadConfiguration(scope, callback) {

	scope.configuration.configBoard = {
		height : 500,
		width : 1000,
	};

	scope.configuration.configHud = {
		height : 200,
		width : 1000,
	};

	scope.configuration.configSquare = {
		height : 50,
		width : 50,
	};

	callback();
}

function createInstance(scope, callback) {
	post('instance/create', '', function(result) {
		scope.game.instance = result;
		callback();
	})
}

function loadDungeon(scope, callback) {
	get('dungeon', scope.game.instance.idDungeon, function(result) {
		scope.game.dungeon = result;
		callback();
	})
}

function loadStage(scope, callback) {
	get('stage', scope.game.dungeon.listIdStage[0], function(result) {
		scope.game.stage = result;
		callback();
	})
}

function loadInstance(scope, callback) {
	get('instance', scope.game.instance.id, function(result) {
		scope.game.instance = result;
		callback();
	})
}
