package com.deckard.noyau.core.dungeon;

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

	@PostConstruct
	public void postConstruct() {
	}

	public Dungeon getDungeon(String idDungeon) {
		return entityManagerDungeon.find(Dungeon.class, idDungeon);
	}

	public Stage getStage(String idStage) {
		return entityManagerDungeon.find(Stage.class, idStage);
	}

	public void createDungeon(Dungeon dungeon) {
		entityManagerDungeon.persist(dungeon);
	}

	public void createStage(Stage stage) {
		entityManagerDungeon.persist(stage);
	}
}
