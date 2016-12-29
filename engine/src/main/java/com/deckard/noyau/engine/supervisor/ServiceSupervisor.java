package com.deckard.noyau.engine.supervisor;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.inject.Singleton;

import com.deckard.noyau.core.http.AbstractService;
import com.deckard.noyau.core.http.HttpCode;
import com.deckard.noyau.core.http.Result;

@Singleton
@ManagedBean
public class ServiceSupervisor extends AbstractService {

	@Inject
	private Supervisor supervisor;

	public Result start() {
		supervisor.start();
		return createResultNoElement(HttpCode.OK);
	}

	public Result stop() {
		supervisor.stop();
		return createResultNoElement(HttpCode.OK);
	}
}
