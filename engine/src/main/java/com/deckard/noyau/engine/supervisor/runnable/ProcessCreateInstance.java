package com.deckard.noyau.engine.supervisor.runnable;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import com.deckard.noyau.core.dao.administration.WarehouseAdministration;
import com.deckard.noyau.core.dao.business.WarehouseBusiness;
import com.deckard.noyau.core.dao.constant.WarehouseConstant;
import com.deckard.noyau.core.dao.exposed.WarehouseExposed;
import com.deckard.noyau.core.dao.request.WarehouseRequest;
import com.deckard.noyau.core.model.administration.Player;
import com.deckard.noyau.core.model.constant.dungeon.Dungeon;
import com.deckard.noyau.core.model.exposed.game.Game;
import com.deckard.noyau.core.model.request.AbstractRequest.Status;
import com.deckard.noyau.core.model.request.RequestCreateInstance;

@ManagedBean
public class ProcessCreateInstance implements Runnable {
	@Inject
	private WarehouseAdministration warehouseAdministration;

	@Inject
	private WarehouseConstant warehouseConstant;

	@Inject
	private WarehouseExposed warehouseExposed;

	@Inject
	private WarehouseBusiness warehouseInstance;

	@Inject
	private WarehouseRequest warehouseRequest;

	@Override
	public void run() {

		RequestCreateInstance request;

		do {
			request = warehouseRequest.getNextRequestToProcess(RequestCreateInstance.class);

			if (request != null) {
				Player player = warehouseAdministration.getPlayer(request.getIdPlayer());
				Dungeon dungeon = warehouseConstant.getDungeon(request.getIdDungeon());

				if (player != null && dungeon != null) {
					Game game = warehouseExposed.createGame(player, dungeon);
					warehouseInstance.createInstance(game, player, dungeon);
					request.setIdGame(game.getId());
				}

				request.setStatus(Status.COMPLETED);

				warehouseRequest.updateRequest(request);
			}
		} while (request != null);
	}
}
