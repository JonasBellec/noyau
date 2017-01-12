package com.deckard.noyau.core.model.exposed.game;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("Game")
public class Game {

	@Id
	@Property("_id")
	private String id;

	@Property("idInstance")
	private String idInstance;

	@Property("idPlayerCreator")
	private String idPlayerCreator;

	@Property("idDungeon")
	private String idDungeon;

	@Embedded("listAvatar")
	private List<Participant> listParticipant;

	public Game() {
		listParticipant = new ArrayList<>();
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

	/**
	 * @return the idInstance
	 */
	public String getIdInstance() {
		return idInstance;
	}

	/**
	 * @param idInstance
	 *            the idInstance to set
	 */
	public void setIdInstance(String idInstance) {
		this.idInstance = idInstance;
	}

	/**
	 * @return the listParticipant
	 */
	public List<Participant> getListParticipant() {
		return listParticipant;
	}

	/**
	 * @param listParticipant
	 *            the listParticipant to set
	 */
	public void setListParticipant(List<Participant> listParticipant) {
		this.listParticipant = listParticipant;
	}

}
