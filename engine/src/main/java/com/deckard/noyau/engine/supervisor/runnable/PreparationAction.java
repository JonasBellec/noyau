package com.deckard.noyau.engine.supervisor.runnable;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import com.deckard.noyau.core.dao.administration.WarehouseAdministration;
import com.deckard.noyau.core.dao.business.WarehouseBusiness;
import com.deckard.noyau.core.dao.request.WarehouseRequest;
import com.deckard.noyau.core.model.administration.Player;
import com.deckard.noyau.core.model.business.sequence.Action;
import com.deckard.noyau.core.model.request.AbstractRequest.Status;
import com.deckard.noyau.core.model.request.AbstractRequestAction;

@ManagedBean
public class PreparationAction implements Runnable {
	@Inject
	private WarehouseAdministration warehouseAdministration;

	@Inject
	private WarehouseRequest warehouseRequest;

	@Inject
	private WarehouseBusiness warehouseBusiness;

	@Override
	public void run() {
		AbstractRequestAction request;

		do {
			request = warehouseRequest.getNextRequestToProcess(AbstractRequestAction.class);

			if (request != null) {
				Player player = warehouseAdministration.getPlayer(request.getIdPlayer());

				if (player != null) {
					warehouseBusiness.addActionToSequence(request.getIdGame(), createActionFromRequest(request), 1);
				}

				request.setStatus(Status.COMPLETED);
				warehouseRequest.updateRequest(request);
			}
		} while (request != null);
	}

	private Action createActionFromRequest(AbstractRequestAction request) {
		return null;
	}
}
