package com.deckard.noyau.core.model.business.instance;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("Instance")
public class Instance {

	@Id
	private String id;

	@Property
	private String idPlayerCreator;

	@Property
	private String idGame;

	@Property
	private String idDungeon;

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
