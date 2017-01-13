package com.deckard.noyau.core.model.business.moment;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import com.deckard.noyau.core.model.constant.dungeon.Stage;

@Entity("Moment")
public class Moment {
	public enum Status {
		PROCESSING,
		CURRENT,
		ARCHIVED
	}

	@Id
	@Property("_id")
	private String id;

	@Property("idInstance")
	private String idInstance;

	@Embedded("status")
	private Status status;

	@Embedded("listStage")
	private List<Stage> listStage;
}
