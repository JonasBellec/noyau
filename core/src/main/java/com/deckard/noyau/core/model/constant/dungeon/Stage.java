package com.deckard.noyau.core.model.constant.dungeon;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Property;

public class Stage {

	@Property("name")
	private String name;

	@Embedded("listSquare")
	private List<Square> listSquare;

	public Stage() {
		listSquare = new ArrayList<>();
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
