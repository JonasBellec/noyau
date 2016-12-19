package com.deckard.noyau.engine;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import com.deckard.noyau.core.model.instance.Request;

@Singleton
public class WarehouseRequest {
	ExecutorService service = Executors.newFixedThreadPool(10);
	Map<String, StorageRequest> mapStorageReception;

	@PostConstruct
	public void postConstruct() {
		mapStorageReception = new HashMap<>();
	}

	public void acceptRequest(Request request) {
		service.execute(new Runnable() {
			@Override
			public void run() {
				processRequest(request);
			}
		});
	}

	private void processRequest(Request request) {
	}
}
