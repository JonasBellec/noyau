package com.deckard.noyau.core.producer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;

public class DatabaseConnection {

	private MongoClient mongoClient;

	private String baseName;
	private String baseHost;
	private Integer basePort;

	private String userName;
	private String password;

	private DatabaseConnection(DatabaseConnection.Builder builder) {
		this.baseName = builder.baseName;
		this.baseHost = builder.baseHost;
		this.basePort = builder.basePort;
		this.userName = builder.userName;
		this.password = builder.password;

		if (StringUtils.isBlank(baseName) || StringUtils.isBlank(baseHost) || basePort == null || basePort <= 0) {
			throw new RuntimeException("Configuration");
		}

		connect();
	}

	private void connect() {

		final MongoClientOptions.Builder builder = new MongoClientOptions.Builder();

		builder.connectionsPerHost(50);
		builder.readPreference(ReadPreference.nearest());
		builder.writeConcern(WriteConcern.ACKNOWLEDGED);

		MongoCredential credential = null;
		if (StringUtils.isNotBlank(userName) && StringUtils.isNotBlank(password)) {
			credential = MongoCredential.createCredential(userName, baseName, password.toCharArray());
		}

		final List<ServerAddress> listeServerAddress = new ArrayList<ServerAddress>();
		listeServerAddress.add(new ServerAddress(baseHost, basePort));

		if (credential == null) {
			if (listeServerAddress.size() == 1) {
				mongoClient = new MongoClient(listeServerAddress.get(0), builder.build());
			} else {
				mongoClient = new MongoClient(listeServerAddress, builder.build());
			}
		} else {
			if (listeServerAddress.size() == 1) {
				mongoClient = new MongoClient(listeServerAddress.get(0), Arrays.asList(credential), builder.build());
			} else {
				mongoClient = new MongoClient(listeServerAddress, Arrays.asList(credential), builder.build());
			}
		}
	}

	public void closeConnection() {
		mongoClient.close();
	}

	/**
	 * @return the mongoClient
	 */
	public MongoClient getMongoClient() {
		return mongoClient;
	}

	/**
	 * @return the baseName
	 */
	public String getBaseName() {
		return baseName;
	}

	public static class Builder {

		// required
		private String baseName;
		private String baseHost;
		private Integer basePort;

		// optional
		private String userName;
		private String password;

		public Builder(String baseName, String baseHost, Integer basePort) {
			this.baseName = baseName;
			this.baseHost = baseHost;
			this.basePort = basePort;
		}

		public Builder userName(String userName) {
			this.userName = userName;
			return this;
		}

		public Builder password(String password) {
			this.password = password;
			return this;
		}

		public DatabaseConnection build() {
			return new DatabaseConnection(this);
		}
	}
}
