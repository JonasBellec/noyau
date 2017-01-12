package com.deckard.noyau.core.dao.exposed;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.mongodb.morphia.Datastore;

import com.deckard.noyau.core.dao.producer.DatastoreExposed;
import com.deckard.noyau.core.model.exposed.game.Game;
import com.deckard.noyau.core.model.exposed.view.View;
import com.deckard.noyau.core.util.Util;

@Singleton
@ManagedBean
public class WarehouseExposed {

	@DatastoreExposed
	@Inject
	private Datastore datastoreExposed;

	@PostConstruct
	public void postConstruct() {
	}

	public Game getGame(String idGame) {
		return datastoreExposed.get(Game.class, idGame);
	}

	public View getView(String idView) {
		return datastoreExposed.get(View.class, idView);
	}

	public void saveGame(Game game) {
		if (game.getId() == null) {
			game.setId(Util.generateUuid());
			datastoreExposed.save(game);
		} else {
			throw new RuntimeException();
		}
	}
}
