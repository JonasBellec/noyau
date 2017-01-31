package com.deckard.noyau.engine.supervisor.runnable;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.deckard.noyau.core.dao.administration.WarehouseAdministration;
import com.deckard.noyau.core.dao.business.WarehouseBusiness;
import com.deckard.noyau.core.dao.constant.WarehouseConstant;
import com.deckard.noyau.core.dao.exposed.WarehouseExposed;
import com.deckard.noyau.core.model.business.sequence.Sequence;

@ManagedBean
public class ProcessSequence implements Runnable {
	@Inject
	private WarehouseAdministration warehouseAdministration;

	@Inject
	private WarehouseBusiness warehouseBusiness;

	@Inject
	private WarehouseExposed warehouseExposed;

	@Inject
	private WarehouseConstant warehouseDungeon;

	private List<String> listIdGameInCharge;

	@PostConstruct
	public void postConstruct() {
		listIdGameInCharge = new ArrayList<>();
	}

	public void addIdGameInCharge(String idGame) {
		listIdGameInCharge.add(idGame);
	}

	public Integer getCharge() {
		return listIdGameInCharge.size();
	}

	@Override
	public void run() {
		for (String idGame : listIdGameInCharge) {
			Sequence sequence = warehouseBusiness.popNextStackToProcess(idGame);
		}
	}
}
