package com.deckard.noyau.core.producer;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.deckard.noyau.core.model.administration.Player;
import com.deckard.noyau.core.model.dungeon.Dungeon;
import com.deckard.noyau.core.model.instance.Instance;
import com.deckard.noyau.core.model.request.AbstractRequest;

@Singleton
@ManagedBean
public class DatastoreProducer {

	private Morphia morphia;
	private Map<String, Datastore> mapDatastore;

	private static final String ADMINISTRATION = "administration";
	private static final String DUNGEON = "dungeon";
	private static final String INSTANCE = "instance";
	private static final String REQUEST = "request";

	private static final String HOST = "localhost";
	private static final Integer PORT = 27017;

	@PostConstruct
	private void postConstruct() {
		morphia = new Morphia();
		mapDatastore = new HashMap<>();

		morphia.mapPackage(Player.class.getPackage().getName());
		morphia.mapPackage(Dungeon.class.getPackage().getName());
		morphia.mapPackage(Instance.class.getPackage().getName());
		morphia.mapPackage(AbstractRequest.class.getPackage().getName());
	}

	@DatastoreDungeon
	@Produces
	public Datastore createDatastoreDungeon() {
		return getDatastore(DUNGEON);
	}

	@DatastoreInstance
	@Produces
	public Datastore createDatastoreInstance() {
		return getDatastore(INSTANCE);
	}

	@DatastoreAdministration
	@Produces
	public Datastore createDatastoreAdministration() {
		return getDatastore(ADMINISTRATION);
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
