package com.deckard.noyau.front.endpoint;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.deckard.noyau.front.http.AbstractEndpoint;
import com.deckard.noyau.front.service.ServiceInstance;

@Path("/instance")
public class EndpointInstance extends AbstractEndpoint {

	private static final String MEDIA_TYPE = "application/json;charset=UTF-8";

	@Inject
	private ServiceInstance serviceInstance;

	@GET
	@Path("/{idInstance}")
	@Consumes(MEDIA_TYPE)
	@Produces(MEDIA_TYPE)
	public Response get(@PathParam("idInstance") String idInstance) {
		return createHttpResponse(serviceInstance.readInstance(idInstance));
	}

	@POST
	@Path("/create")
	@Consumes(MEDIA_TYPE)
	@Produces(MEDIA_TYPE)
	public Response create() throws Exception {
		return createHttpResponse(
				serviceInstance.createInstance("5863f999f6fd40029fd7116d", "585ae1645a0a5b25b806c82d"));
	}
}
