package com.deckard.noyau.core.model.business.moment;

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

	@Embedded
	private List<Mobile> listMobile;
}
