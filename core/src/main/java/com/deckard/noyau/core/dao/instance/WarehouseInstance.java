package com.deckard.noyau.core.dao.instance;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.mongodb.morphia.Datastore;

import com.deckard.noyau.core.model.exposed.instance.Instance;
import com.deckard.noyau.core.producer.DatastoreInstance;
import com.deckard.noyau.core.util.Util;

@Singleton
@ManagedBean
public class WarehouseInstance {

	@DatastoreInstance
	@Inject
	private Datastore datastoreInstance;

	@PostConstruct
	public void postConstruct() {
	}

	public Instance getInstance(String idInstance) {
		return datastoreInstance.get(Instance.class, idInstance);
	}

	public void saveInstance(Instance instance) {
		if (instance.getId() == null) {
			instance.setId(Util.generateUuid());
			datastoreInstance.save(instance);
		} else {
			throw new RuntimeException();
		}
	}
}
