package com.deckard.noyau.core.model.request;

import org.apache.commons.lang3.StringUtils;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractRequest {

	@Id
	@Property("_id")
	private String id;

	@Property("idPlayer")
	private String idPlayer;

	@Property("idGame")
	private String idGame;

	@Embedded
	private Status status;

	@JsonProperty("typeRequest")
	public String getTypeRequest() {
		Entity entity = this.getClass().getAnnotation(Entity.class);
		if (entity != null && StringUtils.isNotBlank(entity.value())) {
			return entity.value();
		} else {
			return this.getClass().getSimpleName();
		}
	}

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

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the idGame
	 */
	public String getIdGame() {
		return idGame;
	}

	/**
	 * @param idGame
	 *            the idGame to set
	 */
	public void setIdGame(String idGame) {
		this.idGame = idGame;
	}
}
