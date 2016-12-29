package com.deckard.noyau.engine;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class Supervisor {

	private ScheduledExecutorService scheduledExecutorServiceMonitoring = Executors.newSingleThreadScheduledExecutor();
	private ExecutorService service = Executors.newFixedThreadPool(10);

	@Inject
	private Provider<RunnableCreateInstance> providerRunnableCreateInstance;

	public void start() {
		if (scheduledExecutorServiceMonitoring.isShutdown()) {
			scheduledExecutorServiceMonitoring.scheduleAtFixedRate(providerRunnableCreateInstance.get(), 100, 1, TimeUnit.SECONDS);
		}
	}

	public void stop() {
		scheduledExecutorServiceMonitoring.shutdown();
	}
}
