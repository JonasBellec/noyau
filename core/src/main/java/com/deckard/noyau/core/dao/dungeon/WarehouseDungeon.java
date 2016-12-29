package com.deckard.noyau.core.dao.dungeon;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.mongodb.morphia.Datastore;

import com.deckard.noyau.core.model.dungeon.Dungeon;
import com.deckard.noyau.core.model.dungeon.Stage;
import com.deckard.noyau.core.producer.DatastoreDungeon;
import com.deckard.noyau.core.util.Util;

@Singleton
public class WarehouseDungeon {

	@Inject
	@DatastoreDungeon
	private Datastore datastoreDungeon;

	@PostConstruct
	public void postConstruct() {
	}

	public Stage getStage(String idStage) {
		return datastoreDungeon.get(Stage.class, idStage);
	}

	public Dungeon getDungeon(String idDungeon) {
		return datastoreDungeon.get(Dungeon.class, idDungeon);
	}

	public void saveDungeon(Dungeon dungeon) {
		if (dungeon.getId() == null) {
			dungeon.setId(Util.generateUuid());
			datastoreDungeon.save(dungeon);
		} else {
			throw new RuntimeException();
		}
	}

	public void saveStage(Stage stage) {
		if (stage.getId() == null) {
			stage.setId(Util.generateUuid());
			datastoreDungeon.save(stage);
		} else {
			throw new RuntimeException();
		}
	}
}
