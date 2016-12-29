package com.deckard.noyau.core.model.request;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Property;

@Entity
public class RequestCreateInstance extends AbstractRequest {
	@Property("idDungeon")
	private String idDungeon;

	@Property("idInstance")
	private String idInstance;

	@Override
	public String getTypeRequest() {
		return this.getClass().getSimpleName();
	}

	/**
	 * @return the idDungeon
	 */
	public String getIdDungeon() {
		return idDungeon;
	}

	/**
	 * @param idDungeon
	 *            the idDungeon to set
	 */
	public void setIdDungeon(String idDungeon) {
		this.idDungeon = idDungeon;
	}
}
