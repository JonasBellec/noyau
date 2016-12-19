package com.deckard.noyau.front.endpoint;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.deckard.noyau.core.reception.ServiceRequest;

@Path("/dungeon")
public class EndpointDungeon {

	private static final String MEDIA_TYPE = "application/json;charset=UTF-8";

	@Inject
	private ServiceRequest requestService;

	@GET
	@Path("")
	@Consumes(MEDIA_TYPE)
	@Produces(MEDIA_TYPE)
	public Response get() {
		return null;
	}
}
