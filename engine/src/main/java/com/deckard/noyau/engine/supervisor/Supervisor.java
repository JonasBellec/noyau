package com.deckard.noyau.engine.supervisor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import com.deckard.noyau.engine.supervisor.runnable.RunnableAction;
import com.deckard.noyau.engine.supervisor.runnable.RunnableCreateInstance;

@Singleton
@ManagedBean
public class Supervisor {

	private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
	private ExecutorService service = Executors.newFixedThreadPool(10);

	@Inject
	private Provider<RunnableCreateInstance> providerRunnableCreateInstance;

	@Inject
	private Provider<RunnableAction> providerRunnableAction;

	public void start() {
		scheduledExecutorService.scheduleAtFixedRate(providerRunnableAction.get(), 100, 100, TimeUnit.MILLISECONDS);
		scheduledExecutorService.scheduleAtFixedRate(providerRunnableCreateInstance.get(), 100, 1000,
				TimeUnit.MILLISECONDS);
	}

	public void stop() {
		scheduledExecutorService.shutdown();
	}
}
