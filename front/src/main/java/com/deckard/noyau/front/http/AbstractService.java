package com.deckard.noyau.front.http;

public class AbstractService {

	private Integer acceptedRangeParDefaut = null;

	public Integer rechercherAcceptedRangeParDefaut() {

		if (acceptedRangeParDefaut == null) {
			acceptedRangeParDefaut = 100;
		}

		return acceptedRangeParDefaut;
	}

	public Integer rechercherAcceptedRange(String cleAcceptedRange) {
		return rechercherAcceptedRangeParDefaut();
	}

	public Result createResultNoElement(HttpCode httpCode) {
		ContentRange.Builder contentRangeBuilder = new ContentRange.Builder();
		contentRangeBuilder.borneInferieure(0).borneSuperieure(0).acceptedRange(rechercherAcceptedRangeParDefaut());

		ContentRange contentRange = contentRangeBuilder.build();
		contentRange.valoriserTotalAvecImpactSurBornes(0);

		return createResult(httpCode, null, contentRange);
	}

	public Result createResultOneElement(HttpCode httpCode, Object entite) {
		ContentRange.Builder contentRangeBuilder = new ContentRange.Builder();
		contentRangeBuilder.borneInferieure(0).borneSuperieure(0).acceptedRange(rechercherAcceptedRangeParDefaut());

		ContentRange contentRange = contentRangeBuilder.build();
		contentRange.valoriserTotalAvecImpactSurBornes(1);

		return createResult(httpCode, entite, contentRange);
	}

	public Result createResult(HttpCode httpCode, Object entity, ContentRange contentRange) {
		Result result = new Result();

		result.setHttpCode(httpCode);
		result.setContentRange(contentRange);
		result.setEntity(entity);

		return result;
	}

	public ContentRange calculerContentRange(Number total) {
		ContentRange.Builder contentRangeBuilder = new ContentRange.Builder();
		contentRangeBuilder.acceptedRange(100);

		ContentRange contentRange = contentRangeBuilder.build();
		contentRange.valoriserTotalAvecImpactSurBornes(total.longValue());

		return contentRange;
	}
}
