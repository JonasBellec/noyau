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

import com.deckard.noyau.core.http.AbstractEndpoint;
import com.deckard.noyau.core.http.HttpCode;
import com.deckard.noyau.front.service.ServiceDungeon;

@Path("/dungeon")
@Consumes("application/json;charset=UTF-8")
@Produces("application/json;charset=UTF-8")
public class EndpointDungeon extends AbstractEndpoint {

	@Inject
	private ServiceDungeon serviceDungeon;

	@HEAD
	@Path("")
	public Response head() {
		return createHttpResponseNoElement(HttpCode.NoContent);
	}

	@GET
	@Path("{idDungeon}")
	public Response get(@PathParam("idDungeon") String idDungeon) {
		return createHttpResponse(serviceDungeon.getDungeon(idDungeon));
	}

	@POST
	@Path("/create")
	public Response create() throws Exception {
		return createHttpResponse(serviceDungeon.create());
	}
}
