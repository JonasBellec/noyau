package com.deckard.noyau.core.instance;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

import com.deckard.noyau.core.model.dungeon.Dungeon;
import com.deckard.noyau.core.model.dungeon.Stage;
import com.deckard.noyau.core.producer.EmInstance;

@Singleton
public class WarehouseInstance {

	@EmInstance
	@Inject
	private EntityManager entityManagerInstance;

	private Map<String, StorageInstance> mapDungeonStorage;

	@PostConstruct
	public void postConstruct() {
		mapDungeonStorage = new HashMap<>();
	}

	public Stage getStage(String idDungeon, String idStage) {

		StorageInstance dungeonStorage = mapDungeonStorage.get(idDungeon);

		if (dungeonStorage != null) {
			return dungeonStorage.getStage(idStage);
		} else {
			return null;
		}
	}

	public void createDungeon(Dungeon dungeon) {
		entityManagerDungeon.persist(dungeon);
	}

	public void loadDungeon(String idDungeon) throws Exception {
		createDungeonStorage(idDungeon);
	}

	private void createDungeonStorage(String idDungeon) throws Exception {
		Dungeon dungeon = entityManagerDungeon.find(Dungeon.class, idDungeon);

		if (dungeon != null) {
			mapDungeonStorage.put(idDungeon, new StorageInstance(dungeon));
		} else {
			throw new Exception();
		}
	}
}
