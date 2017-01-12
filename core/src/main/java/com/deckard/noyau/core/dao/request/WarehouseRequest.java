package com.deckard.noyau.core.dao.request;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.mongodb.morphia.AdvancedDatastore;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.deckard.noyau.core.dao.producer.DatastoreRequest;
import com.deckard.noyau.core.model.request.AbstractRequest;
import com.deckard.noyau.core.model.request.Status;
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

	public void updateRequest(AbstractRequest request) {
		if (request.getId() != null) {
			datastoreRequest.save(request);
		} else {
			throw new RuntimeException();
		}
	}

	public <O extends AbstractRequest> O getNextActionToPrepare(Class<O> classRequest) {
		return datastoreRequest.findAndModify(createQuery(classRequest), createUpdateOperations(classRequest));
	}

	private <O extends AbstractRequest> Query<O> createQuery(Class<O> classRequest) {
		Query<O> query = ((AdvancedDatastore) datastoreRequest).createQuery(classRequest);
		return query.field("status").equal(Status.PENDING);
	}

	private <O extends AbstractRequest> UpdateOperations<O> createUpdateOperations(Class<O> classRequest) {
		UpdateOperations<O> updateOperations = datastoreRequest.createUpdateOperations(classRequest);
		return updateOperations.set("status", Status.PROCESSING);
	}
}
