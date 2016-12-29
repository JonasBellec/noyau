package com.deckard.noyau.engine.supervisor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import com.deckard.noyau.engine.supervisor.runnable.RunnableCreateInstance;

@Singleton
@ManagedBean
public class Supervisor {

	private ScheduledExecutorService scheduledExecutorServiceMonitoring = Executors.newSingleThreadScheduledExecutor();
	private ExecutorService service = Executors.newFixedThreadPool(10);

	@Inject
	private Provider<RunnableCreateInstance> providerRunnableCreateInstance;

	public void start() {
		scheduledExecutorServiceMonitoring.scheduleAtFixedRate(providerRunnableCreateInstance.get(), 100, 1000,
				TimeUnit.MILLISECONDS);
	}

	public void stop() {
		scheduledExecutorServiceMonitoring.shutdown();
	}
}
