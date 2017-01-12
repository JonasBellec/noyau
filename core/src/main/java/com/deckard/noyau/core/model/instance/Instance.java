package com.deckard.noyau.core.model.instance;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("Instance")
public class Instance {

	@Id
	@Property("_id")
	private String id;

	@Property("idPlayerCreator")
	private String idPlayerCreator;

	@Property("idGame")
	private String idGame;

	@Property("idDungeon")
	private String idDungeon;

	public Instance() {
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

	/**
	 * @return the idPlayerCreator
	 */
	public String getIdPlayerCreator() {
		return idPlayerCreator;
	}

	/**
	 * @param idPlayerCreator
	 *            the idPlayerCreator to set
	 */
	public void setIdPlayerCreator(String idPlayerCreator) {
		this.idPlayerCreator = idPlayerCreator;
	}
}
