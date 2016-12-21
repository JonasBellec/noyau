function loadAssets(scope, callback) {

}

function loadConfiguration(scope, callback) {

}

function loadDungeon(scope, callback) {
	$.ajax({
		url : 'http://localhost:8080/front/rest/dungeon/',
		type : 'GET',
		data : '',
		headers: {  
            "Content-Type": "application/json;charset=UTF-8"  
        }
	}).success ( function(result,status,xhr) {
		scope.game.dungeon = result[0];
		scope.isReady = true;
		callback();
	});
}

function loadStage(scope, callback) {

}
