package com.deckard.noyau.engine.supervisor.runnable;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import com.deckard.noyau.core.dao.administration.WarehouseAdministration;
import com.deckard.noyau.core.dao.dungeon.WarehouseDungeon;
import com.deckard.noyau.core.dao.instance.WarehouseInstance;
import com.deckard.noyau.core.dao.request.WarehouseRequest;
import com.deckard.noyau.core.model.administration.Player;
import com.deckard.noyau.core.model.dungeon.Dungeon;
import com.deckard.noyau.core.model.instance.Instance;
import com.deckard.noyau.core.model.instance.Persona;
import com.deckard.noyau.core.model.request.RequestCreateInstance;
import com.deckard.noyau.core.model.request.Status;

@ManagedBean
public class ProcessCreateInstance implements Runnable {
	@Inject
	private WarehouseAdministration warehouseAdministration;

	@Inject
	private WarehouseRequest warehouseRequest;

	@Inject
	private WarehouseInstance warehouseInstance;

	@Inject
	private WarehouseDungeon warehouseDungeon;

	@Override
	public void run() {

		RequestCreateInstance request;

		do {
			request = warehouseRequest.getNextActionToPrepare(RequestCreateInstance.class);

			if (request != null) {
				Player player = warehouseAdministration.getPlayer(request.getIdPlayer());
				Dungeon dungeon = warehouseDungeon.getDungeon(request.getIdDungeon());

				if (player != null && dungeon != null) {
					Instance instance = createInstance(player, dungeon);
					request.setIdInstance(instance.getId());
				}

				request.setStatus(Status.COMPLETED);

				warehouseRequest.updateRequest(request);
			}
		} while (request != null);
	}

	public Instance createInstance(Player player, Dungeon dungeon) {

		Instance instance = new Instance();

		instance.setIdDungeon(dungeon.getId());

		Persona persona = new Persona();
		persona.setIdPlayer(player.getId());
		persona.setX(0);
		persona.setY(0);

		instance.getListPersona().add(persona);

		warehouseInstance.saveInstance(instance);

		return instance;
	}
}
