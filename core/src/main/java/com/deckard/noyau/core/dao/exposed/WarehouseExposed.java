package com.deckard.noyau.core.dao.exposed;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.mongodb.morphia.Datastore;

import com.deckard.noyau.core.dao.producer.DatastoreExposed;
import com.deckard.noyau.core.model.administration.Player;
import com.deckard.noyau.core.model.constant.dungeon.Dungeon;
import com.deckard.noyau.core.model.exposed.game.ExposedPlayer;
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

	public Game createGame(Player player, Dungeon dungeon) {

		Game game = new Game();
		ExposedPlayer creator = new ExposedPlayer();

		creator.setIdPlayer(player.getId());
		creator.setName(player.getName());

		game.setId(Util.generateUuid());
		game.setCreator(creator);
		game.setIdDungeon(dungeon.getId());

		datastoreExposed.save(game);

		return game;
	}
}
