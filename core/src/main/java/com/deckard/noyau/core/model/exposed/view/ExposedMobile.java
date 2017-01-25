package com.deckard.noyau.core.model.exposed.view;

import org.mongodb.morphia.annotations.Property;

public abstract class ExposedMobile {
	@Property
	private Integer x;

	@Property
	private Integer y;
}
