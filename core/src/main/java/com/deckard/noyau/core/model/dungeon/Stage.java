package com.deckard.noyau.core.model.dungeon;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("stage")
public class Stage {

	@Id
	@Property("_id")
	private String id;

	@Property("title")
	private String title;

	@Embedded("listSquare")
	private List<Square> listSquare;

	public Stage() {
		listSquare = new ArrayList<>();
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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the listSquare
	 */
	public List<Square> getListSquare() {
		return listSquare;
	}

	/**
	 * @param listSquare
	 *            the listSquare to set
	 */
	public void setListSquare(List<Square> listSquare) {
		this.listSquare = listSquare;
	}
}
