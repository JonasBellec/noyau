package com.deckard.noyau.core.model.exposed.game;

import org.mongodb.morphia.annotations.Property;

public class Participant {

	@Property("namePlayer")
	private String namePlayer;

	@Property("namePersona")
	private String namePersona;
}
