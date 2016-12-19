package com.deckard.noyau.front.endpoint;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.deckard.noyau.front.http.AbstractEndpoint;
import com.deckard.noyau.front.service.ServiceDungeon;

@Path("/dungeon")
public class EndpointDungeon extends AbstractEndpoint {

	private static final String MEDIA_TYPE = "application/json;charset=UTF-8";

	@Inject
	private ServiceDungeon serviceDungeon;

	@GET
	@Path("/{idDungeon}")
	@Consumes(MEDIA_TYPE)
	@Produces(MEDIA_TYPE)
	public Response get(@PathParam("idDungeon") String idDungeon) {
		return formaterReponse(serviceDungeon.readStage(idDungeon));
	}
}
