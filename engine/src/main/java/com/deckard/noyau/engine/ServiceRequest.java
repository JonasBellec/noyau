package com.deckard.noyau.engine;

import javax.inject.Inject;

import com.deckard.noyau.core.model.Request;

public class ServiceRequest {

	@Inject
	private WarehouseRequest receptionWarehouse;

	public void createRequest(Request request) {

	}
}
