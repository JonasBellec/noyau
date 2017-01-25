package com.deckard.noyau.core.model.business.stack;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity("Stack")
public class Stack {

	public enum Status {
		PENDING,
		PROCESSING,
		ARCHIVED
	}

	@Id
	private String id;

	@Property
	private String idInstance;

	@Embedded
	private Status status;

	@Embedded
	private List<Action> listAction;
}
