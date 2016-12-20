package com.deckard.noyau.front.http;

import java.util.Map;

public class Result {
	private HttpCode httpCode;
	private Object entity;
	private ContentRange contentRange;
	private Map<String, Object> mapHeaders;

	/**
	 * @return the httpCode
	 */
	public HttpCode getHttpCode() {
		return httpCode;
	}

	/**
	 * @param httpCode
	 *            the httpCode to set
	 */
	public void setHttpCode(HttpCode httpCode) {
		this.httpCode = httpCode;
	}

	/**
	 * @return the entity
	 */
	public Object getEntity() {
		return entity;
	}

	/**
	 * @param entity
	 *            the entity to set
	 */
	public void setEntity(Object entity) {
		this.entity = entity;
	}

	/**
	 * @return the contentRange
	 */
	public ContentRange getContentRange() {
		return contentRange;
	}

	/**
	 * @param contentRange
	 *            the contentRange to set
	 */
	public void setContentRange(ContentRange contentRange) {
		this.contentRange = contentRange;
	}

	/**
	 * @return the mapHeaders
	 */
	public Map<String, Object> getMapHeaders() {
		return mapHeaders;
	}

	/**
	 * @param mapHeaders
	 *            the mapHeaders to set
	 */
	public void setMapHeaders(Map<String, Object> mapHeaders) {
		this.mapHeaders = mapHeaders;
	}
}
