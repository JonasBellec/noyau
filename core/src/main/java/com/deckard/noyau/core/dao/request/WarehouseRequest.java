package com.deckard.noyau.core.dao.request;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.mongodb.morphia.AdvancedDatastore;
import org.mongodb.morphia.Datastore;

import com.deckard.noyau.core.model.request.AbstractRequest;
import com.deckard.noyau.core.producer.DatastoreRequest;
import com.deckard.noyau.core.util.Util;

@Singleton
@ManagedBean
public class WarehouseRequest {

	@DatastoreRequest
	@Inject
	private Datastore datastoreRequest;

	@PostConstruct
	public void postConstruct() {
	}

	public AbstractRequest getRequest(String typeRequest, String idRequest) {
		return ((AdvancedDatastore) datastoreRequest).get(typeRequest, AbstractRequest.class, idRequest);
	}

	public void saveRequest(AbstractRequest request) {
		if (request.getId() == null) {
			request.setId(Util.generateUuid());
			datastoreRequest.save(request);
		} else {
			throw new RuntimeException();
		}
	}
}
