package com.deckard.noyau.core.model.dungeon;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("Dungeon")
public class Dungeon {

	@Id
	@Property("_id")
	private String id;

	@Embedded("listIdStage")
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
