package com.deckard.noyau.front.service;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import com.deckard.noyau.core.dao.constant.WarehouseConstant;
import com.deckard.noyau.core.http.AbstractService;
import com.deckard.noyau.core.http.HttpCode;
import com.deckard.noyau.core.http.Result;
import com.deckard.noyau.core.model.constant.dungeon.Dungeon;
import com.deckard.noyau.core.model.constant.stage.Square;
import com.deckard.noyau.core.model.constant.stage.Stage;

@ManagedBean
public class ServiceConstant extends AbstractService {

	@Inject
	private WarehouseConstant warehouseConstant;

	public Result getDungeon(String idDungeon) {
		return createResultOneElement(HttpCode.OK, warehouseConstant.getDungeon(idDungeon));
	}

	public Result getStage(String idStage) {
		return createResultOneElement(HttpCode.OK, warehouseConstant.getStage(idStage));
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

			warehouseConstant.saveStage(stage);

			dungeon.getListIdStage().add(stage.getId());

		}

		warehouseConstant.saveDungeon(dungeon);

		return createResultNoElement(HttpCode.OK);
	}
}
