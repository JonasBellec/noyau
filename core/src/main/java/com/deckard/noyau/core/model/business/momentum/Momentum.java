package com.deckard.noyau.core.model.business.momentum;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import com.deckard.noyau.core.model.constant.bestiary.Mobile;
import com.deckard.noyau.core.model.constant.dungeon.Stage;

@Entity("Momentum")
public class Momentum {
	public enum Status {
		PROCESSING,
		CURRENT,
		ARCHIVED
	}

	@Id
	private String id;

	@Property
	private String idInstance;

	@Embedded
	private Status status;

	@Embedded
	private List<Stage> listStage;

	private List<Mobile> listMobile;

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
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
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

	/**
	 * @return the listMobile
	 */
	public List<Mobile> getListMobile() {
		return listMobile;
	}

	/**
	 * @param listMobile
	 *            the listMobile to set
	 */
	public void setListMobile(List<Mobile> listMobile) {
		this.listMobile = listMobile;
	}
}
