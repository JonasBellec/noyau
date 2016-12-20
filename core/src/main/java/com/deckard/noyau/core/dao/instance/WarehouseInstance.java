package com.deckard.noyau.core.dao.instance;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

@Singleton
public class WarehouseInstance {

	// @EmInstance
	// @Inject
	// private EntityManager entityManagerInstance;

	private Map<String, StorageInstance> mapStorageInstance;

	@PostConstruct
	public void postConstruct() {
		mapStorageInstance = new HashMap<>();
	}
}
