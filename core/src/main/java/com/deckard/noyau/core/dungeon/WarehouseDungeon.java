package com.deckard.noyau.core.dungeon;

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

	private Map<String, StorageDungeon> mapStorageDungeon;

	@PostConstruct
	public void postConstruct() {
		mapStorageDungeon = new HashMap<>();
	}

	public Stage getStage(String idDungeon, String idStage) {

		StorageDungeon dungeonStorage = mapStorageDungeon.get(idDungeon);

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
			mapStorageDungeon.put(idDungeon, new StorageDungeon(dungeon));
		} else {
			throw new Exception();
		}
	}
}
