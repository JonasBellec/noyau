package com.deckard.noyau.core.dao.producer;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

@Singleton
@ManagedBean
public class DatastoreProducer {

	private Morphia morphia;
	private Map<String, Datastore> mapDatastore;

	private static final String ADMINISTRATION = "administration";
	private static final String BUSINESS = "business";
	private static final String CONSTANT = "constant";
	private static final String EXPOSED = "exposed";
	private static final String REQUEST = "request";

	private static final String HOST = "localhost";
	private static final Integer PORT = 27017;

	@PostConstruct
	private void postConstruct() {
		morphia = new Morphia();
		morphia.getMapper().getOptions().setMapSubPackages(true);
		mapDatastore = new HashMap<>();

		morphia.mapPackage("com.deckard.noyau.core.model");
	}

	@DatastoreAdministration
	@Produces
	public Datastore createDatastoreAdministration() {
		return getDatastore(ADMINISTRATION);
	}

	@DatastoreConstant
	@Produces
	public Datastore createDatastoreConstant() {
		return getDatastore(CONSTANT);
	}

	@DatastoreExposed
	@Produces
	public Datastore createDatastoreExposed() {
		return getDatastore(EXPOSED);
	}

	@DatastoreBusiness
	@Produces
	public Datastore createDatastoreBusiness() {
		return getDatastore(BUSINESS);
	}

	@DatastoreRequest
	@Produces
	public Datastore createDatastoreRequest() {
		return getDatastore(REQUEST);
	}

	private Datastore getDatastore(String baseName) {
		Datastore datastore = mapDatastore.get(baseName);

		if (datastore == null) {
			DatabaseConnection.Builder builder = new DatabaseConnection.Builder(baseName, HOST, PORT);
			DatabaseConnection databaseConnection = builder.build();

			datastore = morphia.createDatastore(databaseConnection.getMongoClient(), databaseConnection.getBaseName());
			datastore.ensureIndexes();

			mapDatastore.put(baseName, datastore);
		}

		return datastore;
	}
}
