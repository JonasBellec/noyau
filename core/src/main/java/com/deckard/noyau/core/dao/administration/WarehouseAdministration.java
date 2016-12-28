package com.deckard.noyau.core.dao.administration;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

import com.deckard.noyau.core.model.administration.Player;
import com.deckard.noyau.core.producer.EmDungeon;

@Singleton
public class WarehouseAdministration {

	@Inject
	@EmDungeon
	private EntityManager entityManagerAdministration;

	@PostConstruct
	public void postConstruct() {
	}

	public Player getPlayer(String idPlayer) {
		return entityManagerAdministration.find(Player.class, idPlayer);
	}
}
