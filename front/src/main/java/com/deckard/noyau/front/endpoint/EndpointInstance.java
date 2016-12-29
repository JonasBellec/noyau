package com.deckard.noyau.front.endpoint;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.deckard.noyau.core.http.AbstractEndpoint;
import com.deckard.noyau.front.service.ServiceInstance;

@Path("/instance")
@Consumes("application/json;charset=UTF-8")
@Produces("application/json;charset=UTF-8")
public class EndpointInstance extends AbstractEndpoint {

	@Inject
	private ServiceInstance serviceInstance;

	@GET
	@Path("/{idInstance}")

	public Response get(@PathParam("idInstance") String idInstance) {
		return createHttpResponse(serviceInstance.getInstance(idInstance));
	}
}
