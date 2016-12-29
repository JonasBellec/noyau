package com.deckard.noyau.front.service;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import com.deckard.noyau.core.dao.request.WarehouseRequest;
import com.deckard.noyau.core.http.AbstractService;
import com.deckard.noyau.core.http.HttpCode;
import com.deckard.noyau.core.http.Result;
import com.deckard.noyau.core.model.request.RequestCreateInstance;

@ManagedBean
public class ServiceRequest extends AbstractService {

	@Inject
	private WarehouseRequest warehouseRequest;

	public Result getRequest(String typeRequest, String idRequest) {
		return createResultOneElement(HttpCode.OK, warehouseRequest.getRequest(typeRequest, idRequest));
	}

	public Result createRequestCreateInstance(String idPlayer, String idDungeon) {
		RequestCreateInstance requestCreateInstance = new RequestCreateInstance();

		requestCreateInstance.setIdDungeon(idDungeon);
		requestCreateInstance.setIdPlayer(idPlayer);

		warehouseRequest.saveRequest(requestCreateInstance);

		return createResultOneElement(HttpCode.OK, requestCreateInstance.getId());
	}
}
