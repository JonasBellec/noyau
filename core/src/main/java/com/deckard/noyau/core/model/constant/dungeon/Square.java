package com.deckard.noyau.core.model.constant.dungeon;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Property;

import com.deckard.noyau.core.model.constant.bestiary.Mobile;

public class Square {

	@Property
	private Integer x;

	@Property
	private Integer y;

	@Property
	private Integer squareType;

	@Embedded
	private Mobile mobile;

	public Integer getSquareType() {
		return squareType;
	}

	public void setSquareType(Integer squareType) {
		this.squareType = squareType;
	}

	/**
	 * @return the x
	 */
	public Integer getX() {
		return x;
	}

	/**
	 * @param x
	 *            the x to set
	 */
	public void setX(Integer x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public Integer getY() {
		return y;
	}

	/**
	 * @param y
	 *            the y to set
	 */
	public void setY(Integer y) {
		this.y = y;
	}
}
