package com.deckard.noyau.core.model.exposed.view;

import org.mongodb.morphia.annotations.Property;

public abstract class VMobile {
	@Property("x")
	private Integer x;

	@Property("y")
	private Integer y;
}
