function loadAssets(scope, callback) {

}

function loadConfiguration(scope, callback) {

}

function loadDungeon(scope, callback) {
	$.ajax({
		url : 'http://localhost:8080/front/rest/stage/',
		type : 'GET',
		data : '',
		headers: {  
            "Content-Type": "application/json;charset=UTF-8"  
        }
	}).success ( function(result,status,xhr) {
		scope.game.dungeon = result;
		scope.isReady = true;
		callback();
	});
}

function loadStage(scope, callback) {

}
