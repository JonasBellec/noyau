package com.deckard.noyau.core.dao.constant;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.mongodb.morphia.Datastore;

import com.deckard.noyau.core.dao.producer.DatastoreConstant;
import com.deckard.noyau.core.model.constant.dungeon.Dungeon;
import com.deckard.noyau.core.util.Util;

@Singleton
@ManagedBean
public class WarehouseConstant {

	@Inject
	@DatastoreConstant
	private Datastore datastoreConstant;

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
}
