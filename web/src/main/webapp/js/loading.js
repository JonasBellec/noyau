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
	scope.configuration = 1;
	callback();
}

function loadDynamicData(scope, callback) {
	createInstance(scope, function() {
		loadDungeon(scope, function() {
			loadStage(scope, function() {
				if (isDynamicDataReady(scope)) {
					callback();
				}
			});
		});
	});
}

function isDynamicDataReady(scope) {
	return scope.game.instance != null && scope.game.dungeon != null && scope.game.stage != null;
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
