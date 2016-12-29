package com.deckard.noyau.front.service;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import com.deckard.noyau.core.dao.dungeon.WarehouseDungeon;
import com.deckard.noyau.core.http.AbstractService;
import com.deckard.noyau.core.http.HttpCode;
import com.deckard.noyau.core.http.Result;
import com.deckard.noyau.core.model.dungeon.Dungeon;
import com.deckard.noyau.core.model.dungeon.Square;
import com.deckard.noyau.core.model.dungeon.Stage;

@ManagedBean
public class ServiceDungeon extends AbstractService {

	@Inject
	private WarehouseDungeon warehouseDungeon;

	public Result getDungeon(String idDungeon) {
		return createResultOneElement(HttpCode.OK, warehouseDungeon.getDungeon(idDungeon));
	}

	public Result readStage(String idStage) {
		return createResultOneElement(HttpCode.OK, warehouseDungeon.getStage(idStage));
	}

	public Result create() throws Exception {

		Dungeon dungeon = new Dungeon();

		for (int i = 0; i < 10; i++) {
			Stage stage = new Stage();
			stage.setTitle(String.valueOf(i));

			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					Square square = new Square();
					square.setSquareType(1);
					square.setX(j);
					square.setY(k);

					stage.getListSquare().add(square);
				}
			}

			warehouseDungeon.saveStage(stage);

			dungeon.getListIdStage().add(stage.getId());

		}

		warehouseDungeon.saveDungeon(dungeon);

		return createResultNoElement(HttpCode.OK);
	}
}
