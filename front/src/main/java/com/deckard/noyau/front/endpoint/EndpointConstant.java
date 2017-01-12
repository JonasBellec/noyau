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
import com.deckard.noyau.front.service.ServiceConstant;

@Path("/constant")
@Consumes("application/json;charset=UTF-8")
@Produces("application/json;charset=UTF-8")
public class EndpointConstant extends AbstractEndpoint {

	@Inject
	private ServiceConstant serviceDungeon;

	@HEAD
	@Path("")
	public Response head() {
		return createHttpResponseNoElement(HttpCode.NoContent);
	}

	@GET
	@Path("/dungeon/{idDungeon}")
	public Response getDungeon(@PathParam("idDungeon") String idDungeon) {
		return createHttpResponse(serviceDungeon.getDungeon(idDungeon));
	}

	@GET
	@Path("/stage/{idStage}")
	public Response getStage(@PathParam("idStage") String idStage) {
		return createHttpResponse(serviceDungeon.getStage(idStage));
	}

	@POST
	@Path("/create")
	public Response create() throws Exception {
		return createHttpResponse(serviceDungeon.create());
	}
}
