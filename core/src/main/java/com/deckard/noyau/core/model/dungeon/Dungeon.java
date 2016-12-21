package com.deckard.noyau.core.model.dungeon;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

@Entity
public class Dungeon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Type(type = "objectid")
	private String id;

	@Column
	@ElementCollection
	private List<String> listIdStage;

	public Dungeon() {
		listIdStage = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the listIdStage
	 */
	public List<String> getListIdStage() {
		return listIdStage;
	}

	/**
	 * @param listIdStage
	 *            the listIdStage to set
	 */
	public void setListIdStage(List<String> listIdStage) {
		this.listIdStage = listIdStage;
	}
}
