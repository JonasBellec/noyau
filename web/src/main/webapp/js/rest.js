function executeRequest(word, resource, id, body, success, error) {
	var url = 'http://localhost:8080/front/rest/' + resource;

	if (id != null) {
		url += '/' + id;
	}

	$.ajax({
		type : word,
		url : url,
		data : body,
		headers : {
			"Content-Type" : "application/json;charset=UTF-8"
		},
		success : function(result, status, xhr) {
			success(result);
		},
		error : function(result, status, xhr) {
			error(result);
		}
	});
}

function request(word, resource, id, body, success) {
	executeRequest(word, resource, id, body, success, function(result){        
        alert(result);
    });
}

function get(resource, id, success) {
	request('GET', resource, id, '', success);
}

function post(resource, body, success) {
	request('POST', resource, null, body, success);
}
