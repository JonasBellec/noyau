package com.deckard.noyau.core.model.instance;

import java.util.List;

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
	private List<String> listIdPlayer;

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
	 * @return the listIdPlayer
	 */
	public List<String> getListIdPlayer() {
		return listIdPlayer;
	}

	/**
	 * @param listIdPlayer
	 *            the listIdPlayer to set
	 */
	public void setListIdPlayer(List<String> listIdPlayer) {
		this.listIdPlayer = listIdPlayer;
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
