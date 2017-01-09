package com.deckard.noyau.core.model.instance;

import java.util.ArrayList;
import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("Instance")
public class Configuration {

	@Id
	@Property("_id")
	private String id;

	@Property("idDungeon")
	private String idDungeon;

	@Embedded("listPersona")
	private List<Persona> listPersona;

	public Configuration() {
		listPersona = new ArrayList<>();
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
	 * @return the listPersona
	 */
	public List<Persona> getListPersona() {
		return listPersona;
	}

	/**
	 * @param listPersona
	 *            the listPersona to set
	 */
	public void setListPersona(List<Persona> listPersona) {
		this.listPersona = listPersona;
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
