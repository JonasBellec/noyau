package com.deckard.noyau.front.service;

import javax.annotation.ManagedBean;
import javax.inject.Inject;

import com.deckard.noyau.core.dao.instance.WarehouseInstance;
import com.deckard.noyau.core.http.AbstractService;
import com.deckard.noyau.core.http.HttpCode;
import com.deckard.noyau.core.http.Result;

@ManagedBean
public class ServiceInstance extends AbstractService {

	@Inject
	private WarehouseInstance warehouseInstance;

	public Result getInstance(String idInstance) {
		return createResultOneElement(HttpCode.OK, warehouseInstance.getInstance(idInstance));
	}

	public Result createInstance(String idPlayer, String idDungeon) {

		// Player player = warehouseAdministration.getPlayer(idPlayer);
		// Dungeon dungeon = warehouseDungeon.getDungeon(idDungeon);
		//
		// if (player != null && dungeon != null) {
		// return createResultOneElement(HttpCode.OK, warehouseInstance.createInstance(player, dungeon));
		// } else {
		return createResultNoElement(HttpCode.BadRequest);
		// }
	}
}
