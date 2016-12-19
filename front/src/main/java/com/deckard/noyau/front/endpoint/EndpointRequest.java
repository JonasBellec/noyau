package com.deckard.noyau.front.endpoint;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.deckard.noyau.front.reception.ServiceRequest;

@Path("/request")
public class EndpointRequest {

	private static final String MEDIA_TYPE = "application/json;charset=UTF-8";

	@Inject
	private ServiceRequest requestService;

	@POST
	@Path("")
	@Consumes(MEDIA_TYPE)
	@Produces(MEDIA_TYPE)
	public Response createRequest() {
		return null;
	}
}
