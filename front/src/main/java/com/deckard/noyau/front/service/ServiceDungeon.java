package com.deckard.noyau.front.service;

import javax.inject.Inject;

import com.deckard.noyau.core.dungeon.WarehouseDungeon;
import com.deckard.noyau.core.model.dungeon.Dungeon;
import com.deckard.noyau.core.model.dungeon.Stage;
import com.deckard.noyau.front.http.AbstractService;
import com.deckard.noyau.front.http.HttpCode;
import com.deckard.noyau.front.http.Result;

public class ServiceDungeon extends AbstractService {

	@Inject
	private WarehouseDungeon warehouseDungeon;

	public Result readDungeon(String idDungeon) {
		return createResultOneElement(HttpCode.OK, warehouseDungeon.getDungeon(idDungeon));
	}

	public Result readStage(String idStage) {
		return createResultOneElement(HttpCode.OK, warehouseDungeon.getStage(idStage));
	}

	public Result create() {

		Dungeon dungeon = new Dungeon();

		for (int i = 0; i < 10; i++) {
			Stage stage = new Stage();

			warehouseDungeon.createStage(stage);

			dungeon.getListIdStage().add(stage.getId());
		}

		warehouseDungeon.createDungeon(dungeon);

		return createResultNoElement(HttpCode.OK);
	}
}
