package com.deckard.noyau.front.service;

import javax.inject.Inject;

import com.deckard.noyau.core.dungeon.WarehouseDungeon;
import com.deckard.noyau.front.http.AbstractService;
import com.deckard.noyau.front.http.HttpCode;
import com.deckard.noyau.front.http.Result;

public class ServiceDungeon extends AbstractService {

	@Inject
	private WarehouseDungeon warehouseDungeon;

	public Result readStage(String idStage) {
		return createResultOneElement(HttpCode.OK, warehouseDungeon.getStage(idStage));
	}
}
