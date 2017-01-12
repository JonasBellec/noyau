package com.deckard.noyau.core.model.exposed.view;

import org.mongodb.morphia.annotations.Property;

public class VAvatar extends VMobile {
	@Property("idPlayer")
	private String idPlayer;

	@Property("idPersona")
	private String idPersona;
}
