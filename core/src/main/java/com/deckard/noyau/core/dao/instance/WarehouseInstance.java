package com.deckard.noyau.core.dao.instance;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;

import com.deckard.noyau.core.model.instance.Instance;
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
}
