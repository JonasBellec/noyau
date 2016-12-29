package com.deckard.noyau.core.dao.request;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.deckard.noyau.core.producer.EmRequest;

public class WarehouseRequest {

	@EmRequest
	@Inject
	private EntityManager entityManagerRequest;

	@PostConstruct
	public void postConstruct() {
	}
}
