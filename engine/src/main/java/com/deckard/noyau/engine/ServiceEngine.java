package com.deckard.noyau.engine;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.NotSupportedException;

import org.omg.CORBA.SystemException;

import com.deckard.noyau.core.dao.administration.WarehouseAdministration;
import com.deckard.noyau.core.dao.dungeon.WarehouseDungeon;
import com.deckard.noyau.core.dao.instance.HeuristicMixedException;
import com.deckard.noyau.core.dao.instance.HeuristicRollbackException;
import com.deckard.noyau.core.dao.instance.RollbackException;
import com.deckard.noyau.core.dao.instance.TransactionManager;
import com.deckard.noyau.core.dao.instance.WarehouseInstance;
import com.deckard.noyau.core.dao.request.WarehouseRequest;
import com.deckard.noyau.core.http.AbstractService;
import com.deckard.noyau.core.http.HttpCode;
import com.deckard.noyau.core.http.Result;
import com.deckard.noyau.core.model.administration.Player;
import com.deckard.noyau.core.model.dungeon.Dungeon;
import com.deckard.noyau.core.model.instance.Instance;
import com.deckard.noyau.core.model.instance.Persona;

@Singleton
public class ServiceEngine extends AbstractService {

	ScheduledExecutorService scheduledExecutorServiceMonitoring = Executors.newSingleThreadScheduledExecutor();
	ExecutorService service = Executors.newFixedThreadPool(10);

	@Inject
	private WarehouseRequest warehouseRequest;

	@Inject
	private WarehouseInstance warehouseInstance;

	@Inject
	private WarehouseAdministration warehouseAdministration;

	@Inject
	private WarehouseDungeon warehouseDungeon;

	public Result start() {
		if (scheduledExecutorServiceMonitoring.isShutdown()) {
			scheduledExecutorServiceMonitoring.scheduleAtFixedRate(new RunnableMonitoring(), 100, 1, TimeUnit.SECONDS);
		}

		return createResultNoElement(HttpCode.OK);
	}

	public Result stop() {
		scheduledExecutorServiceMonitoring.shutdown();

		return createResultNoElement(HttpCode.OK);
	}

	class RunnableMonitoring implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub

		}

		public Result createInstance(String idPlayer, String idDungeon) {

			Player player = warehouseAdministration.getPlayer(idPlayer);
			Dungeon dungeon = warehouseDungeon.getDungeon(idDungeon);

			if (player != null && dungeon != null) {
				return createResultOneElement(HttpCode.OK, warehouseInstance.createInstance(player, dungeon));
			} else {
				return createResultNoElement(HttpCode.BadRequest);
			}
		}

		public Instance createInstance(Player player, Dungeon dungeon) {
			Instance instance = null;
			TransactionManager tm = com.arjuna.ats.jta.TransactionManager.transactionManager();
			try {
				tm.begin();

				instance = new Instance();

				instance.setIdDungeon(dungeon.getId());

				Persona persona = new Persona();
				persona.setIdPlayer(player.getId());
				persona.setX(0);
				persona.setY(0);

				instance.getListPersona().add(persona);

				entityManagerInstance.persist(instance);

				tm.commit();
			} catch (NotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (HeuristicMixedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (HeuristicRollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RollbackException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return instance;
		}
	}
}
