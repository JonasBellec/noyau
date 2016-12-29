package com.deckard.noyau.front.endpoint;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.deckard.noyau.core.http.AbstractEndpoint;
import com.deckard.noyau.front.service.ServiceRequest;

@Path("/request")
public class EndpointRequest extends AbstractEndpoint {

	private static final String MEDIA_TYPE = "application/json;charset=UTF-8";

	@Inject
	private ServiceRequest serviceRequest;

	@GET
	@Path("/{typeRequest}/{idRequest}")

	public Response get(@PathParam("typeRequest") String typeRequest, @PathParam("idRequest") String idRequest) {
		return createHttpResponse(serviceRequest.getRequest(typeRequest, idRequest));
	}

	@POST
	@Path("/createinstance")
	@Consumes(MEDIA_TYPE)
	@Produces(MEDIA_TYPE)
	public Response createRequestCreateInstance() {
		return createHttpResponse(
				serviceRequest.createRequestCreateInstance("5863f999f6fd40029fd7116d", "585ae1645a0a5b25b806c82d"));
	}
}
