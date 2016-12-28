package com.deckard.noyau.core.dao.instance;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;

import com.deckard.noyau.core.model.administration.Player;
import com.deckard.noyau.core.model.dungeon.Dungeon;
import com.deckard.noyau.core.model.instance.Instance;
import com.deckard.noyau.core.model.instance.Persona;
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
	}

	public Instance createInstance(Player player, Dungeon dungeon) {
		Instance instance = null;
		TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
		try {
			tm.begin();

			instance = new Instance();

			instance.setIdDungeon(dungeon.getId());
			
			Persona persona = new Persona();
			persona.setIdPlayer(player.getId());
			persona.setX(0);
			persona.setY(0);
			
			instance.getListPersona().add(persona);

			entityManagerInstance.persist(instance);

			tm.commit();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return instance;
	}
}
