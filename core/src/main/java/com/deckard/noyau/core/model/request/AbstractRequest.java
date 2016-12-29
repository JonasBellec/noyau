package com.deckard.noyau.core.model.request;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AbstractRequest {

	@Id
	@Property(value = "_id")
	private String id;

	@Property(value = "idPlayer")
	private String idPlayer;

	@Embedded
	private Status status;

	@JsonProperty("typeRequest")
	public abstract String getTypeRequest();

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
}