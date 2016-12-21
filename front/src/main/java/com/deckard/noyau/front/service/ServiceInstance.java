package com.deckard.noyau.front.service;

import javax.inject.Inject;

import com.deckard.noyau.core.dao.instance.WarehouseInstance;
import com.deckard.noyau.front.http.AbstractService;
import com.deckard.noyau.front.http.HttpCode;
import com.deckard.noyau.front.http.Result;

public class ServiceInstance extends AbstractService {

	@Inject
	private WarehouseInstance warehouseInstance;

	public Result readInstance(String idInstance) {
		return createResultOneElement(HttpCode.OK, warehouseInstance.getInstance(idInstance));
	}
<<<<<<< Upstream, based on origin/master
=======

	public Result createInstance() {
		return createResultOneElement(HttpCode.OK, warehouseInstance.createInstance());
	}
>>>>>>> c2ccf0d Sprint 2 : Affichage du stage
}
