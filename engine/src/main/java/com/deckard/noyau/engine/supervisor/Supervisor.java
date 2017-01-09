package com.deckard.noyau.engine.supervisor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import com.deckard.noyau.engine.supervisor.runnable.PreparationAction;
import com.deckard.noyau.engine.supervisor.runnable.ProcessAction;
import com.deckard.noyau.engine.supervisor.runnable.ProcessCreateInstance;

@Singleton
@ManagedBean
public class Supervisor {

	private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

	@Inject
	private Provider<ProcessCreateInstance> providerProcessCreateInstance;

	@Inject
	private Provider<PreparationAction> providerPreparationAction;

	@Inject
	private Provider<ProcessAction> providerProcessAction;
	
	public void start() {
		scheduledExecutorService.scheduleAtFixedRate(providerPreparationAction.get(), 100, 100, TimeUnit.MILLISECONDS);
		scheduledExecutorService.scheduleAtFixedRate(providerProcessAction.get(), 100, 1000, TimeUnit.MILLISECONDS);
		scheduledExecutorService.scheduleAtFixedRate(providerProcessCreateInstance.get(), 100, 1000,
				TimeUnit.MILLISECONDS);
	}

	public void stop() {
		scheduledExecutorService.shutdown();
	}
}
