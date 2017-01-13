package com.deckard.noyau.core.model.exposed.view;

import java.util.List;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Property;

@Entity("View")
public class View {
	@Property("_id")
	private String id;

	@Property("idInstance")
	private String idInstance;

	@Property("idGame")
	private String idGame;

	@Property("idPlayer")
	private String idPlayer;

	private String currentStage;
	private List<String> listSquare;
}
