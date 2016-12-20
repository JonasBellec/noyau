package com.deckard.noyau.core.dao.dungeon;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

import com.deckard.noyau.core.model.dungeon.Dungeon;
import com.deckard.noyau.core.model.dungeon.Stage;
import com.deckard.noyau.core.producer.EmDungeon;

@Singleton
public class WarehouseDungeon {

	@Inject
	@EmDungeon
	private EntityManager entityManagerDungeon;

	private Map<String, StorageDungeon> mapDungeonStorage;

	@PostConstruct
	public void postConstruct() {
		mapDungeonStorage = new HashMap<>();
	}

	public Stage getStage(String idStage) {
		return entityManagerDungeon.find(Stage.class, idStage);
	}

	public Dungeon getDungeon(String idDungeon) {
		return entityManagerDungeon.find(Dungeon.class, idDungeon);
	}

	public void createDungeon(Dungeon dungeon) {
		entityManagerDungeon.persist(dungeon);
	}

	public void createStage(Stage stage) {
		entityManagerDungeon.persist(stage);
	}
}
