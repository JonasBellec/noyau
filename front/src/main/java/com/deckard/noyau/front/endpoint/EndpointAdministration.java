package com.deckard.noyau.front.endpoint;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.deckard.noyau.front.http.AbstractEndpoint;
import com.deckard.noyau.front.service.ServiceDungeon;

@Path("/administration")
public class EndpointAdministration extends AbstractEndpoint {

	private static final String MEDIA_TYPE = "application/json;charset=UTF-8";

	@Inject
	private ServiceDungeon dungeonService;

	@POST
	@Path("/createdungeon")
	@Consumes(MEDIA_TYPE)
	@Produces(MEDIA_TYPE)
	public Response createDungeon() {
		return null;
	}

	@POST
	@Path("/loaddungeon")
	@Consumes(MEDIA_TYPE)
	@Produces(MEDIA_TYPE)
	public Response loadDungeon() {
		return null;
	}
}
