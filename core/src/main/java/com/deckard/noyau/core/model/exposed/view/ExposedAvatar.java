package com.deckard.noyau.core.model.exposed.view;

import org.mongodb.morphia.annotations.Property;

public class ExposedAvatar extends ExposedMobile {
	@Property
	private String idPlayer;

	@Property
	private String idPersona;
}
