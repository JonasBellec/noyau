package com.deckard.noyau.core.http;

import java.util.Map.Entry;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

public class AbstractEndpoint {

	private static String contentRangeNoElement = "0-0/0";

	public Response createHttpResponseNoElement(HttpCode httpCode) {
		ResponseBuilder responseBuilder = Response.status(httpCode.getValue());
		return responseBuilder.build();
	}

	public Response createHttpResponse(Result result) {

		ResponseBuilder responseBuilder = Response.status(result.getHttpCode().getValue());
		responseBuilder.entity(result.getEntity());

		if (result.getContentRange() != null) {
			responseBuilder.header("Content-Range", result.getContentRange().buildContentRange());
			responseBuilder.header("Accept-Range", result.getContentRange().buildAcceptedRange());
		} else {
			responseBuilder.header("Content-Range", contentRangeNoElement);
			responseBuilder.header("Accept-Range", "0");
		}

		if (result.getMapHeaders() != null) {
			for (final Entry<String, Object> entry : result.getMapHeaders().entrySet()) {
				responseBuilder.header(entry.getKey(), entry.getValue());
			}
		}

		return responseBuilder.build();
	}
}
