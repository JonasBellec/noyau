package com.deckard.noyau.front.service;

import com.deckard.noyau.front.http.ContentRange;
import com.deckard.noyau.front.http.HttpCode;
import com.deckard.noyau.front.http.Result;

public class AbstractService {

	public Result createResultNoElement(HttpCode httpCode) {
		ContentRange.Builder contentRangeBuilder = new ContentRange.Builder();
		contentRangeBuilder.borneInferieure(0).borneSuperieure(0).acceptedRange(100);

		ContentRange contentRange = contentRangeBuilder.build();
		contentRange.valoriserTotalAvecImpactSurBornes(0);

		return createResult(httpCode, null, contentRange);
	}

	public Result createResultOneElement(HttpCode httpCode, Object entity) {
		ContentRange.Builder contentRangeBuilder = new ContentRange.Builder();
		contentRangeBuilder.borneInferieure(0).borneSuperieure(0).acceptedRange(100);

		ContentRange contentRange = contentRangeBuilder.build();
		contentRange.valoriserTotalAvecImpactSurBornes(1);

		return createResult(httpCode, entity, contentRange);
	}

	public Result createResult(HttpCode httpCode, Object entite, ContentRange contentRange) {
		Result reponse = new Result();

		reponse.setHttpCode(httpCode);
		reponse.setContentRange(contentRange);
		reponse.setEntity(entite);

		return reponse;
	}
}
