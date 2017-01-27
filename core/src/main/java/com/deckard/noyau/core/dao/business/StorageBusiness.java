package com.deckard.noyau.core.dao.business;

import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Singleton;

import com.deckard.noyau.core.model.business.instance.Instance;
import com.deckard.noyau.core.model.business.stack.Action;
import com.deckard.noyau.core.model.business.stack.Stack;

@Singleton
@ManagedBean
public class StorageBusiness {

	private Instance instance;
	private Queue<Stack> queueStack;

	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);
	private Lock readLock;
	private Lock writeLock;

	@PostConstruct
	public void postConstruct() {
		readLock = readWriteLock.readLock();
		writeLock = readWriteLock.writeLock();
	}

	public StorageBusiness(Instance instance) {
		this.instance = instance;
	}

	public void addActionToNextStack(Action action) {
		readLock.lock();

		try {

		} finally {
			readLock.unlock();
		}
	}

	public void getNextStackToProcess() {
		writeLock.lock();

		try {

		} finally {
			writeLock.unlock();
		}
	}
}
