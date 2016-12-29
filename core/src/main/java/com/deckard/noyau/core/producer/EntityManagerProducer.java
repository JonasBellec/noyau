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
		Map<String, Object> properties = new HashMap<>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("InstancePU", properties);
		return emf.createEntityManager();
	}

	@EmAdministration
	@Produces
	public EntityManager createEntityManagerAdministration() {
		Map<String, Object> properties = new HashMap<>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AdministrationPU", properties);
		return emf.createEntityManager();
	}

	@EmRequest
	@Produces
	public EntityManager createEntityManagerRequest() {
		Map<String, Object> properties = new HashMap<>();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("AdministrationPU", properties);
		return emf.createEntityManager();
	}
}
