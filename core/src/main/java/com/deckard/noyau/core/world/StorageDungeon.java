package com.deckard.noyau.core.world;

import com.deckard.noyau.core.model.world.Dungeon;
import com.deckard.noyau.core.model.world.Stage;

public class StorageDungeon {

	private Dungeon dungeon;

	public StorageDungeon(Dungeon dungeon) {
		this.dungeon = dungeon;
	}

	public Stage getStage(String idStage) {
		return dungeon.getMapStage().get(idStage);
	}
}
