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

@ManagedBean
public class RunnableCreateInstance implements Runnable {
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
		int a = 5;

	}

	public void createInstance(String idPlayer, String idDungeon) {

		Player player = warehouseAdministration.getPlayer(idPlayer);
		Dungeon dungeon = warehouseDungeon.getDungeon(idDungeon);

		if (player != null && dungeon != null) {
			Instance instance = new Instance();

			instance.setIdDungeon(dungeon.getId());

			Persona persona = new Persona();
			persona.setIdPlayer(player.getId());
			persona.setX(0);
			persona.setY(0);

			instance.getListPersona().add(persona);

			warehouseInstance.saveInstance(instance);
		}
	}
}
