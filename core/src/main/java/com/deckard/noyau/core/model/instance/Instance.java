package com.deckard.noyau.core.model.instance;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class Instance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Type(type = "objectid")
	private String id;

	@ElementCollection
	private Map<String, Player> mapPlayer;

	private String idDungeon;
	private String idStage;

	public Instance() {
		mapPlayer = new HashMap<>();
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
	 * @return the mapPlayer
	 */
	public Map<String, Player> getMapPlayer() {
		return mapPlayer;
	}

	/**
	 * @param mapPlayer
	 *            the mapPlayer to set
	 */
	public void setMapPlayer(Map<String, Player> mapPlayer) {
		this.mapPlayer = mapPlayer;
	}

	/**
	 * @return the idStage
	 */
	public String getIdStage() {
		return idStage;
	}

	/**
	 * @param idStage
	 *            the idStage to set
	 */
	public void setIdStage(String idStage) {
		this.idStage = idStage;
	}
}
