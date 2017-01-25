package com.deckard.noyau.core.model.constant.dungeon;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import com.deckard.noyau.core.model.constant.bestiary.Mobile;

@Entity("Dungeon")
public class Dungeon {

	@Id
	private String id;

	@Embedded
	private List<Stage> listStage;

	@Embedded
	private List<Mobile> listMobile;

	public Dungeon() {
		listStage = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the listStage
	 */
	public List<Stage> getListStage() {
		return listStage;
	}

	/**
	 * @param listStage
	 *            the listStage to set
	 */
	public void setListStage(List<Stage> listStage) {
		this.listStage = listStage;
	}

}
