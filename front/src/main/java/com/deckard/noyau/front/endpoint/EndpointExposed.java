package com.deckard.noyau.front.endpoint;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.deckard.noyau.core.http.AbstractEndpoint;
import com.deckard.noyau.front.service.ServiceExposed;

@Path("/exposed")
@Consumes("application/json;charset=UTF-8")
@Produces("application/json;charset=UTF-8")
public class EndpointExposed extends AbstractEndpoint {

	@Inject
	private ServiceExposed serviceExposed;

	@GET
	@Path("/game/{idGame}")
	public Response getGame(@PathParam("idGame") String idGame) {
		return createHttpResponse(serviceExposed.getGame(idGame));
	}

	@GET
	@Path("/view/{idView}")
	public Response getView(@PathParam("idView") String idView) {
		return createHttpResponse(serviceExposed.getView(idView));
	}
}
