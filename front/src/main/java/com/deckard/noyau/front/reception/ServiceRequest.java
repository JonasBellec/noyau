package com.deckard.noyau.front.reception;

import javax.inject.Inject;

import com.deckard.noyau.core.model.Request;
import com.deckard.noyau.core.reception.WarehouseRequest;

public class ServiceRequest {

	@Inject
	private WarehouseRequest receptionWarehouse;

	public void createRequest(Request request) {

	}
}
