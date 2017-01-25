package com.deckard.noyau.core.model.constant.bestiary;

import org.mongodb.morphia.annotations.Property;

public abstract class Mobile {
	@Property
	private Integer x;

	@Property
	private Integer y;
}
