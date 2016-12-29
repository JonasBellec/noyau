package com.deckard.noyau.engine.endpoint;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.deckard.noyau.core.http.AbstractEndpoint;
import com.deckard.noyau.engine.supervisor.ServiceSupervisor;

@Path("/supervisor")
@Consumes("application/json;charset=UTF-8")
@Produces("application/json;charset=UTF-8")
public class EndpointSupervisor extends AbstractEndpoint {

	@Inject
	private ServiceSupervisor serviceEngine;

	@POST
	@Path("/start")

	public Response start() throws Exception {
		return createHttpResponse(serviceEngine.start());
	}

	@POST
	@Path("/stop")
	public Response stop() throws Exception {
		return createHttpResponse(serviceEngine.stop());
	}
}
