package com.deckard.noyau.front.service;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import com.deckard.noyau.core.dao.exposed.WarehouseExposed;
import com.deckard.noyau.core.http.AbstractService;
import com.deckard.noyau.core.http.HttpCode;
import com.deckard.noyau.core.http.Result;

@ManagedBean
public class ServiceExposed extends AbstractService {

	@Inject
	private WarehouseExposed warehouseExposed;

	public Result getGame(String idGame) {
		return createResultOneElement(HttpCode.OK, warehouseExposed.getGame(idGame));
	}

	public Result getView(String idView) {
		return createResultOneElement(HttpCode.OK, warehouseExposed.getView(idView));
	}
}
