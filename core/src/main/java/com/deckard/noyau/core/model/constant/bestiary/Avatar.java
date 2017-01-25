package com.deckard.noyau.core.model.constant.bestiary;

import org.mongodb.morphia.annotations.Property;

public class Avatar extends Mobile {
	@Property
	private String idPlayer;

	@Property
	private String idPersona;
}
