package com.deckard.noyau.core.dao.business;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import com.deckard.noyau.core.model.business.instance.Instance;
import com.deckard.noyau.core.model.business.sequence.Action;
import com.deckard.noyau.core.model.business.sequence.Sequence;

@Singleton
@ManagedBean
public class StorageBusiness {

	private Instance instance;

	private Integer nextTickToProcess;
	private Map<Integer, Sequence> mapSequence;

	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
	private Lock readLock;
	private Lock writeLock;

	@PostConstruct
	public void postConstruct() {
		nextTickToProcess = 0;
		mapSequence = new ConcurrentHashMap<>();
		readLock = readWriteLock.readLock();
		writeLock = readWriteLock.writeLock();
	}

	public StorageBusiness(Instance instance) {
		this.instance = instance;
	}

	public void addActionToSequence(Action action, Integer delayInTick) {
		readLock.lock();

		try {
			Integer tick = nextTickToProcess + delayInTick;
			Sequence sequence = mapSequence.get(tick);

			if (sequence == null) {
				sequence = new Sequence(tick);
				mapSequence.put(tick, sequence);
			}

			sequence.getListAction().add(action);
		} finally {
			readLock.unlock();
		}
	}

	public Sequence popNextSequenceToProcess() {
		writeLock.lock();
		Sequence sequence = null;

		try {
			sequence = mapSequence.get(nextTickToProcess);

			if (sequence == null) {
				return new Sequence(nextTickToProcess);
			}

			nextTickToProcess++;
		} finally {
			writeLock.unlock();
		}

		return sequence;
	}
}
