package com.deckard.noyau.core.model.dungeon;

@Entity
public class Stage {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Type(type = "objectid")
	private String id;
	
	private Square[][] squares;

	public Square[][] getSquares() {
		return squares;
	}

	public void setSquares(Square[][] squares) {
		this.squares = squares;
	}
}
