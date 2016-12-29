package com.deckard.noyau.core.model.request;

import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

public abstract class AbstractRequest {

	@Id
	@Property(value = "_id")
	private String id;

	@Property(value = "idPlayer")
	private String idPlayer;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

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
}
