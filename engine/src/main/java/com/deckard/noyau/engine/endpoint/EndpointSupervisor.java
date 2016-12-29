package com.deckard.noyau.engine.endpoint;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.deckard.noyau.core.http.AbstractEndpoint;
import com.deckard.noyau.engine.supervisor.ServiceSupervisor;

@Path("/engine")
public class EndpointSupervisor extends AbstractEndpoint {

	private static final String MEDIA_TYPE = "application/json;charset=UTF-8";

	@Inject
	private ServiceSupervisor serviceEngine;

	@POST
	@Path("/start")
	@Consumes(MEDIA_TYPE)
	@Produces(MEDIA_TYPE)
	public Response start() throws Exception {
		return createHttpResponse(serviceEngine.start());
	}

	@POST
	@Path("/stop")
	@Consumes(MEDIA_TYPE)
	@Produces(MEDIA_TYPE)
	public Response stop() throws Exception {
		return createHttpResponse(serviceEngine.stop());
	}
}
