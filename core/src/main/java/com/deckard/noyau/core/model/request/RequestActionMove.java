package com.deckard.noyau.core.model.request;

public class RequestActionMove extends AbstractRequestAction {
	private Integer direction;

	/**
	 * @return the direction
	 */
	public Integer getDirection() {
		return direction;
	}

	/**
	 * @param direction
	 *            the direction to set
	 */
	public void setDirection(Integer direction) {
		this.direction = direction;
	}
}
