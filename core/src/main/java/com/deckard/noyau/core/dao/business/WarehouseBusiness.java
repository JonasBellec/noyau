package com.deckard.noyau.core.dao.business;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.mongodb.morphia.Datastore;

import com.deckard.noyau.core.dao.producer.DatastoreBusiness;
import com.deckard.noyau.core.model.administration.Player;
import com.deckard.noyau.core.model.business.instance.Instance;
import com.deckard.noyau.core.model.business.stack.Action;
import com.deckard.noyau.core.model.constant.dungeon.Dungeon;
import com.deckard.noyau.core.model.exposed.game.Game;
import com.deckard.noyau.core.util.Util;

@Singleton
@ManagedBean
public class WarehouseBusiness {

	@DatastoreBusiness
	@Inject
	private Datastore datastoreBusiness;

	private Map<String, StorageBusiness> mapStorageBusinessByIdGame;

	@PostConstruct
	public void postConstruct() {
		mapStorageBusinessByIdGame = new HashMap<>();
	}

	public void createInstance(Game game, Player player, Dungeon dungeon) {

		StorageBusiness storageBusiness = mapStorageBusinessByIdGame.get(game.getId());

		if (storageBusiness == null) {
			Instance instance = new Instance();

			instance.setId(Util.generateUuid());
			instance.setIdGame(game.getId());
			instance.setIdDungeon(dungeon.getId());
			instance.setIdPlayerCreator(player.getId());

			datastoreBusiness.save(instance);

			storageBusiness = new StorageBusiness(instance);
			mapStorageBusinessByIdGame.put(game.getId(), storageBusiness);
		} else {
			throw new RuntimeException();
		}
	}

	public void addActionToNextStack(String idGame, Action action) {
		StorageBusiness storageBusiness = mapStorageBusinessByIdGame.get(idGame);

		if (storageBusiness != null) {
			storageBusiness.addActionToNextStack(action);
		} else {
			throw new RuntimeException();
		}
	}

	public void getNextStackToProcess(String idInstance) {
	}
}
