package com.deckard.noyau.core.model.exposed.view;

import java.util.List;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import com.deckard.noyau.core.model.constant.dungeon.Stage;

@Entity("View")
public class View {
	@Id
	private String id;

	@Property
	private String idInstance;

	@Property
	private String idGame;

	@Property
	private String idPlayer;

	@Property
	private String currentStage;

	@Embedded
	private List<Stage> listStage;
}
