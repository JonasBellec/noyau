package com.deckard.noyau.engine.supervisor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

import com.deckard.noyau.engine.supervisor.runnable.PreparationAction;
import com.deckard.noyau.engine.supervisor.runnable.ProcessCreateInstance;
import com.deckard.noyau.engine.supervisor.runnable.ProcessSequence;

@Singleton
@ManagedBean
public class Supervisor {

	private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);

	@Inject
	private Provider<ProcessCreateInstance> providerProcessCreateInstance;

	@Inject
	private Provider<PreparationAction> providerPreparationAction;

	@Inject
	private Provider<ProcessSequence> providerProcessSequence;
	
	List<ProcessSequence>

	public void start() {

		ProcessCreateInstance processCreateInstance = providerProcessCreateInstance.get();
		PreparationAction preparationAction = providerPreparationAction.get();

		scheduledExecutorService.scheduleAtFixedRate(preparationAction, 100, 200, TimeUnit.MILLISECONDS);
		scheduledExecutorService.scheduleAtFixedRate(processCreateInstance, 1000, 1000, TimeUnit.MILLISECONDS);

		for (int i = 0; i < 10; i++) {
			ProcessSequence processSequence = providerProcessSequence.get();
			scheduledExecutorService.scheduleAtFixedRate(processSequence, 100 * i, 1000, TimeUnit.MILLISECONDS);
		}
	}

	public void stop() {
		scheduledExecutorService.shutdown();
	}
}
