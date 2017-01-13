package com.deckard.noyau.core.model.exposed.view;

import org.mongodb.morphia.annotations.Property;

public class ExposedAvatar extends ExposedMobile {
	@Property("idPlayer")
	private String idPlayer;

	@Property("idPersona")
	private String idPersona;
}
