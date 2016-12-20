package com.deckard.noyau.core.dungeon;

import com.deckard.noyau.core.model.dungeon.Dungeon;
import com.deckard.noyau.core.model.dungeon.Stage;

public class StorageDungeon {

	private Dungeon dungeon;

	public StorageDungeon(Dungeon dungeon) {
		this.dungeon = dungeon;
	}

	public Stage getStage(String idStage) {
		return dungeon.getMapStage().get(idStage);
	}
}
