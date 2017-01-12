package com.deckard.noyau.engine.supervisor.runnable;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import com.deckard.noyau.core.dao.administration.WarehouseAdministration;
import com.deckard.noyau.core.dao.constant.WarehouseConstant;
import com.deckard.noyau.core.dao.exposed.WarehouseExposed;
import com.deckard.noyau.core.dao.instance.WarehouseInstance;
import com.deckard.noyau.core.dao.request.WarehouseRequest;
import com.deckard.noyau.core.model.administration.Player;
import com.deckard.noyau.core.model.constant.dungeon.Dungeon;
import com.deckard.noyau.core.model.exposed.game.Game;
import com.deckard.noyau.core.model.exposed.game.Owner;
import com.deckard.noyau.core.model.instance.Instance;
import com.deckard.noyau.core.model.request.RequestCreateInstance;
import com.deckard.noyau.core.model.request.Status;

@ManagedBean
public class ProcessCreateInstance implements Runnable {
	@Inject
	private WarehouseAdministration warehouseAdministration;

	@Inject
	private WarehouseConstant warehouseConstant;

	@Inject
	private WarehouseExposed warehouseExposed;

	@Inject
	private WarehouseInstance warehouseInstance;

	@Inject
	private WarehouseRequest warehouseRequest;

	@Override
	public void run() {

		RequestCreateInstance request;

		do {
			request = warehouseRequest.getNextActionToPrepare(RequestCreateInstance.class);

			if (request != null) {
				Player player = warehouseAdministration.getPlayer(request.getIdPlayer());
				Dungeon dungeon = warehouseConstant.getDungeon(request.getIdDungeon());

				if (player != null && dungeon != null) {
					Game game = createGame(player, dungeon);
					createInstance(player, dungeon, game);

					request.setIdGame(game.getId());
				}

				request.setStatus(Status.COMPLETED);

				warehouseRequest.updateRequest(request);
			}
		} while (request != null);
	}

	public Instance createInstance(Player player, Dungeon dungeon, Game game) {

		Instance instance = new Instance();

		instance.setIdPlayerCreator(player.getId());
		instance.setIdDungeon(dungeon.getId());
		instance.setIdGame(game.getId());

		warehouseInstance.saveInstance(instance);

		return instance;
	}

	public Game createGame(Player player, Dungeon dungeon) {

		Game game = new Game();
		Owner owner = new Owner();

		owner.setIdPlayer(player.getId());
		owner.setName(player.getName());

		game.setOwner(owner);
		game.setIdDungeon(dungeon.getId());

		warehouseExposed.saveGame(game);

		return game;
	}
}
