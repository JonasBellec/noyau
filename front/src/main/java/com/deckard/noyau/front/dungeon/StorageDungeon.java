package com.deckard.noyau.front.dungeon;

import com.deckard.noyau.core.model.Dungeon;
import com.deckard.noyau.core.model.Stage;

public class StorageDungeon {

	private Dungeon dungeon;

	public StorageDungeon(Dungeon dungeon) {
		this.dungeon = dungeon;
	}

	public Stage getStage(String idStage) {
		return dungeon.getMapStage().get(idStage);
	}
}
