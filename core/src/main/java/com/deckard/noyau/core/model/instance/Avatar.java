package com.deckard.noyau.core.model.instance;

import org.mongodb.morphia.annotations.Property;

public class Avatar extends Mobile {
	@Property("idPlayer")
	private String idPlayer;

	@Property("idPersona")
	private String idPersona;
}
