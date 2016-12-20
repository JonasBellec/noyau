package com.deckard.noyau.front.endpoint;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.deckard.noyau.front.http.AbstractEndpoint;
import com.deckard.noyau.front.http.HttpCode;
import com.deckard.noyau.front.service.ServiceDungeon;

@Path("/dungeon")
public class EndpointDungeon extends AbstractEndpoint {

	private static final String MEDIA_TYPE = "application/json;charset=UTF-8";

	@Inject
	private ServiceDungeon serviceDungeon;

	@HEAD
	@Path("")
	@Consumes(MEDIA_TYPE)
	@Produces(MEDIA_TYPE)
	public Response heaed() {
		return createHttpResponseNoElement(HttpCode.NoContent);
	}

	@GET
	@Path("/{idStage}")
	@Consumes(MEDIA_TYPE)
	@Produces(MEDIA_TYPE)
	public Response get(@PathParam("idStage") String idStage) {
		return createHttpResponse(serviceDungeon.readStage(idStage));
	}

	@POST
	@Path("/create")
	@Consumes(MEDIA_TYPE)
	@Produces(MEDIA_TYPE)
	public Response create() {
		return createHttpResponse(serviceDungeon.create());
	}
}
