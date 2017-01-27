package com.deckard.noyau.engine.supervisor.runnable;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import com.deckard.noyau.core.dao.administration.WarehouseAdministration;
import com.deckard.noyau.core.dao.constant.WarehouseConstant;
import com.deckard.noyau.core.dao.exposed.WarehouseExposed;
import com.deckard.noyau.core.dao.request.WarehouseRequest;
import com.deckard.noyau.core.model.administration.Player;
import com.deckard.noyau.core.model.constant.dungeon.Dungeon;
import com.deckard.noyau.core.model.request.AbstractRequest.Status;
import com.deckard.noyau.core.model.request.RequestCreateInstance;

@ManagedBean
public class ProcessAction implements Runnable {
	@Inject
	private WarehouseAdministration warehouseAdministration;

	@Inject
	private WarehouseRequest warehouseRequest;

	@Inject
	private WarehouseExposed warehouseInstance;

	@Inject
	private WarehouseConstant warehouseDungeon;

	@Override
	public void run() {

		RequestCreateInstance request;

		do {
			request = warehouseRequest.getNextRequestToProcess(RequestCreateInstance.class);

			if (request != null) {
				Player player = warehouseAdministration.getPlayer(request.getIdPlayer());
				Dungeon dungeon = warehouseDungeon.getDungeon(request.getIdDungeon());

				if (player != null && dungeon != null) {
				}

				request.setStatus(Status.COMPLETED);

				warehouseRequest.updateRequest(request);
			}
		} while (request != null);
	}
}
