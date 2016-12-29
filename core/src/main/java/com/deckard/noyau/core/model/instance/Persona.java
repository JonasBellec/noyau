package com.deckard.noyau.core.model.instance;

import org.mongodb.morphia.annotations.Property;

public class Persona {

	@Property("idPlayer")
	private String idPlayer;

	@Property("x")
	private Integer x;

	@Property("y")
	private Integer y;

	/**
	 * @return the idPlayer
	 */
	public String getIdPlayer() {
		return idPlayer;
	}

	/**
	 * @param idPlayer
	 *            the idPlayer to set
	 */
	public void setIdPlayer(String idPlayer) {
		this.idPlayer = idPlayer;
	}

	/**
	 * @return the x
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(Integer x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public Integer getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(Integer y) {
		this.y = y;
	}

}
