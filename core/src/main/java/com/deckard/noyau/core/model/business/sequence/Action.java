package com.deckard.noyau.core.model.business.sequence;

import org.apache.commons.lang3.math.NumberUtils;

public abstract class Action implements Comparable<Action> {

	private Integer initiative;

	/**
	 * @return the initiative
	 */
	public Integer getInitiative() {
		return initiative;
	}

	/**
	 * @param initiative
	 *            the initiative to set
	 */
	public void setInitiative(Integer initiative) {
		this.initiative = initiative;
	}

	@Override
	public int compareTo(Action o) {
		if (o != null) {
			return NumberUtils.compare(initiative, o.getInitiative());
		} else {
			return 1;
		}
	}
}
