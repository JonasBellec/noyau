package com.deckard.noyau.front.service;

import javax.inject.Inject;

import com.deckard.noyau.core.dao.dungeon.WarehouseDungeon;
import com.deckard.noyau.core.model.dungeon.Stage;
import com.deckard.noyau.front.http.HttpCode;
import com.deckard.noyau.front.http.Result;

public class ServiceDungeon extends AbstractService {

	@Inject
	private WarehouseDungeon warehouseDungeon;

	public Result readStage(String idStage) {

		Stage stage = warehouseDungeon.getStage(idStage);

		if (stage != null) {
			return createResultOneElement(HttpCode.NoContent, stage);
		} else {
			return createResultNoElement(HttpCode.NoContent);
		}
	}
}
