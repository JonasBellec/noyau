package com.deckard.noyau.core.model.exposed.game;

import org.mongodb.morphia.annotations.Property;

public class ExposedPlayer {

	@Property("idPlayer")
	private String idPlayer;

	@Property("name")
	private String name;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}
