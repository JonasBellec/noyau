package com.deckard.noyau.engine.supervisor.runnable;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import com.deckard.noyau.core.dao.administration.WarehouseAdministration;
import com.deckard.noyau.core.dao.instance.WarehouseInstance;
import com.deckard.noyau.core.dao.request.WarehouseRequest;
import com.deckard.noyau.core.model.administration.Player;
import com.deckard.noyau.core.model.instance.Instance;
import com.deckard.noyau.core.model.request.AbstractRequestAction;
import com.deckard.noyau.core.model.request.Status;

@ManagedBean
public class RunnableAction implements Runnable {
	@Inject
	private WarehouseAdministration warehouseAdministration;

	@Inject
	private WarehouseRequest warehouseRequest;

	@Inject
	private WarehouseInstance warehouseInstance;

	@Override
	public void run() {
		AbstractRequestAction request;

		do {
			request = warehouseRequest.getNextRequestToProcess(AbstractRequestAction.class);

			if (request != null) {
				Player player = warehouseAdministration.getPlayer(request.getIdPlayer());
				Instance instance = warehouseInstance.getInstance(request.getIdInstance());

				request.setStatus(Status.COMPLETED);

				warehouseRequest.updateRequest(request);
			}
		} while (request != null);
	}
}
