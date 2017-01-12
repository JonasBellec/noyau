package com.deckard.noyau.core.dao.constant;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.mongodb.morphia.Datastore;

import com.deckard.noyau.core.dao.producer.DatastoreConstant;
import com.deckard.noyau.core.model.constant.dungeon.Dungeon;
import com.deckard.noyau.core.model.constant.stage.Stage;
import com.deckard.noyau.core.util.Util;

@Singleton
@ManagedBean
public class WarehouseConstant {

	@Inject
	@DatastoreConstant
	private Datastore datastoreConstant;

	@PostConstruct
	public void postConstruct() {
	}

	public Stage getStage(String idStage) {
		return datastoreConstant.get(Stage.class, idStage);
	}

	public Dungeon getDungeon(String idDungeon) {
		return datastoreConstant.get(Dungeon.class, idDungeon);
	}

	public void saveDungeon(Dungeon dungeon) {
		if (dungeon.getId() == null) {
			dungeon.setId(Util.generateUuid());
			datastoreConstant.save(dungeon);
		} else {
			throw new RuntimeException();
		}
	}

	public void saveStage(Stage stage) {
		if (stage.getId() == null) {
			stage.setId(Util.generateUuid());
			datastoreConstant.save(stage);
		} else {
			throw new RuntimeException();
		}
	}
}
