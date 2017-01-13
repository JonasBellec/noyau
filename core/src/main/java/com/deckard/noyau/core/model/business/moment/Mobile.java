package com.deckard.noyau.core.model.business.moment;

import org.mongodb.morphia.annotations.Property;

public abstract class Mobile {
	@Property("x")
	private Integer x;

	@Property("y")
	private Integer y;
}
