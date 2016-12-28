package com.deckard.noyau.front.service;

import java.util.List;

import javax.inject.Inject;
import javax.transaction.TransactionManager;

import com.deckard.noyau.core.dao.dungeon.WarehouseDungeon;
import com.deckard.noyau.core.http.AbstractService;
import com.deckard.noyau.core.http.ContentRange;
import com.deckard.noyau.core.http.HttpCode;
import com.deckard.noyau.core.http.Result;
import com.deckard.noyau.core.model.dungeon.Dungeon;
import com.deckard.noyau.core.model.dungeon.Square;
import com.deckard.noyau.core.model.dungeon.Stage;

public class ServiceDungeon extends AbstractService {

	@Inject
	private WarehouseDungeon warehouseDungeon;

	public Result getDungeon(String idDungeon) {
		return createResultOneElement(HttpCode.OK, warehouseDungeon.getDungeon(idDungeon));
	}

	public Result readStage(String idStage) {
		return createResultOneElement(HttpCode.OK, warehouseDungeon.getStage(idStage));
	}

	public Result readStage() {
		List<Stage> listeEntites = warehouseDungeon.getStage();
		ContentRange contentRange = calculerContentRange(listeEntites.size());

		return createResult(HttpCode.OK, listeEntites, contentRange);
	}

	public Result create() throws Exception {

		TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
		tm.begin();
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

			warehouseDungeon.createStage(stage);

			dungeon.getListIdStage().add(stage.getId());

		}

		warehouseDungeon.createDungeon(dungeon);
		tm.commit();

		return createResultNoElement(HttpCode.OK);
	}
}
