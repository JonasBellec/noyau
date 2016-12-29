package com.deckard.noyau.front.service;

import javax.inject.Inject;

import com.deckard.noyau.core.dao.request.WarehouseRequest;
import com.deckard.noyau.core.model.request.AbstractRequest;

public class ServiceRequest {

	@Inject
	private WarehouseRequest receptionWarehouse;

	public void createRequest(AbstractRequest request) {

	}
}
