package com.deckard.noyau.core.producer;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerProducer {

	@EmDungeon
	@Produces
	public EntityManager createEntityManagerDungeon() {
		Map<String, Object> properties = new HashMap<>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("DungeonPU", properties);
		return emf.createEntityManager();
	}

	@EmInstance
	@Produces
	public EntityManager createEntityManagerInstance() {
<<<<<<< Upstream, based on origin/master

		Map<String, Object> properties = new HashMap<String, Object>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("InstancePU", properties);
=======
		Map<String, Object> properties = new HashMap<>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("InstancePU", properties);
		return emf.createEntityManager();
	}

	@EmAdministration
	@Produces
	public EntityManager createEntityManagerAdministration() {
		Map<String, Object> properties = new HashMap<>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AdministrationPU", properties);
>>>>>>> c2ccf0d Sprint 2 : Affichage du stage
		return emf.createEntityManager();
	}
}
