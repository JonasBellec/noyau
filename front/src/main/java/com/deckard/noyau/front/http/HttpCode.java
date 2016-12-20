package com.deckard.noyau.front.http;

public enum HttpCode {
	Continue(100),
	SwitchingProtocols(101),

	OK(200),
	Created(201),
	Accepted(202),
	NonAuthoritativeInformation(203),
	NoContent(204),
	ResetContent(205),
	PartialContent(206),
	MultiStatus(207),
	MultipleChoices(300),
	MovedPermanently(301),
	Found(302),
	SeeOther(303),
	NotModified(304),
	UseProxy(305),
	TemporaryRedirect(307),

	BadRequest(400),
	Unauthorized(401),
	PaymentRequired(402),
	Forbidden(403),
	NotFound(404),
	MethodNotAllowed(405),
	NotAcceptable(406),
	ProxyAuthentication(407),
	RequestTimeout(408),
	Conflict(409),
	Gone(410),
	LengthRequired(411),
	PreconditionFailed(412),
	RequestEntityTooLarge(413),
	RequestURITooLong(414),
	UnsupportedMediaType(415),
	RequestedRangeNotSatisfiable(416),
	ExpectationFailed(417),
	UnprocessableEntity(422),
	Locked(423),
	FailedDependency(424),

	InternalServerError(500),
	NotImplemented(501),
	BadGateway(502),
	ServiceUnavailable(503),
	GatewayTimeout(504),
	HTTPVersionNotSupported(505),
	InsufficientStorage(507);

	int value;

	private HttpCode(int value) {
		this.value = value;
	}

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	public static HttpCode fromValue(int value) {
		for (HttpCode httpCode : HttpCode.values()) {
			if (httpCode.getValue() == value) {
				return httpCode;
			}
		}

		return HttpCode.InternalServerError;
	}
}
