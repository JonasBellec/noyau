package com.deckard.noyau.core.dao.instance;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

<<<<<<< Upstream, based on origin/master
import com.deckard.noyau.core.model.instance.Instance;
=======
import com.deckard.noyau.core.model.dungeon.Dungeon;
import com.deckard.noyau.core.model.instance.Instance;
import com.deckard.noyau.core.model.instance.Player;
>>>>>>> c2ccf0d Sprint 2 : Affichage du stage
import com.deckard.noyau.core.producer.EmInstance;

@Singleton
public class WarehouseInstance {

	@EmInstance
	@Inject
	private EntityManager entityManagerInstance;

	@PostConstruct
	public void postConstruct() {
	}

	public Instance getInstance(String idInstance) {
		return entityManagerInstance.find(Instance.class, idInstance);
<<<<<<< Upstream, based on origin/master
=======
	}

	public Instance createInstance(Player player, Dungeon dungeon) {
		Instance instance = new Instance();

		instance.setIdDungeon(dungeon.getId());
		instance.getListIdPlayer().add(player.get)

		entityManagerInstance.persist(instance);

		return instance;
>>>>>>> c2ccf0d Sprint 2 : Affichage du stage
	}
}
