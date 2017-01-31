package com.deckard.noyau.core.model.business.sequence;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("Sequence")
public class Sequence {

	public enum Status {
		PENDING,
		PROCESSING,
		ARCHIVED
	}

	@Id
	private String id;

	@Property
	private String idInstance;

	@Property
	private Integer tick;

	@Embedded
	private Status status;

	@Embedded
	private List<Action> listAction;

	public Sequence(Integer tick) {
		this.tick = tick;
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
	 * @return the tick
	 */
	public Integer getTick() {
		return tick;
	}

	/**
	 * @param tick
	 *            the tick to set
	 */
	public void setTick(Integer tick) {
		this.tick = tick;
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
	 * @return the listAction
	 */
	public List<Action> getListAction() {
		return listAction;
	}

	/**
	 * @param listAction
	 *            the listAction to set
	 */
	public void setListAction(List<Action> listAction) {
		this.listAction = listAction;
	}
}
