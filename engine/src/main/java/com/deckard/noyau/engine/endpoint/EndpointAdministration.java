package com.deckard.noyau.engine.endpoint;

import javax.ws.rs.Path;

import com.deckard.noyau.core.http.AbstractEndpoint;

@Path("/administration")
public class EndpointAdministration extends AbstractEndpoint {

	private static final String MEDIA_TYPE = "application/json;charset=UTF-8";
}
