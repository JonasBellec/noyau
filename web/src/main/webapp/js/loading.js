function loadStaticData(scope, callback) {
	loadAssets(scope, callback);
	loadConfiguration(scope, callback);
}

function loadAssets(scope, callback) {

}

function loadConfiguration(scope, callback) {

}

function loadDynamicData(scope, callback) {
	loadDungeon(scope, callback);
	loadStage(scope, callback);
}

function loadDungeon(scope, callback) {
	$.ajax({
		url : 'http://localhost:8080/front/rest/dungeon/',
		type : 'GET',
		data : '',
		headers : {
			"Content-Type" : "application/json;charset=UTF-8"
		}
	}).success(function(result, status, xhr) {
		scope.game.dungeon = result[0];

		if (scope.game.dungeon != null && scope.game.stage != null) {
			scope.isReady = true;
		}
		callback();
	});
}

function loadStage(scope, callback) {
	$.ajax({
		url : 'http://localhost:8080/front/rest/stage/',
		type : 'GET',
		data : '',
		headers : {
			"Content-Type" : "application/json;charset=UTF-8"
		}
	}).success(function(result, status, xhr) {
		scope.game.stage = result[0];
		if (scope.game.dungeon != null && scope.game.stage != null) {
			scope.isReady = true;
		}
		callback();
	});
}
