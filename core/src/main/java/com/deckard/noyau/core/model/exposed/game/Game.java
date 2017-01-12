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

	@Property("idDungeon")
	private String idDungeon;

	@Embedded("owner")
	private Owner owner;

	@Embedded("listParticipant")
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
	 * @return the owner
	 */
	public Owner getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(Owner owner) {
		this.owner = owner;
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
