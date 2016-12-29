package com.deckard.noyau.core.dao.administration;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.mongodb.morphia.Datastore;

import com.deckard.noyau.core.model.administration.Player;
import com.deckard.noyau.core.producer.DatastoreAdministration;

@Singleton
public class WarehouseAdministration {

	@Inject
	@DatastoreAdministration
	private Datastore datastoreAdministration;

	@PostConstruct
	public void postConstruct() {
	}

	public Player getPlayer(String idPlayer) {
		return datastoreAdministration.get(Player.class, idPlayer);
	}
}
