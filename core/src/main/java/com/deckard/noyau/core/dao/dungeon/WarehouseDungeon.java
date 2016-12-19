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
	private EntityManager entityManagerWorld;

	private Map<String, StorageDungeon> mapDungeonStorage;

	@PostConstruct
	public void postConstruct() {
		mapDungeonStorage = new HashMap<>();
	}

	public Stage getStage(String idStage) {
		return entityManagerWorld.find(Stage.class, idStage);
	}

	public void createDungeon(Dungeon dungeon) {
		entityManagerWorld.persist(dungeon);
	}

	public void loadDungeon(String idDungeon) throws Exception {
		createDungeonStorage(idDungeon);
	}

	private void createDungeonStorage(String idDungeon) throws Exception {
		Dungeon dungeon = entityManagerWorld.find(Dungeon.class, idDungeon);

		if (dungeon != null) {
			mapDungeonStorage.put(idDungeon, new StorageDungeon(dungeon));
		} else {
			throw new Exception();
		}
	}
}
