package br.com.gm.jumper.util;

import lombok.Getter;

@Getter
public class InputProperties {

    private String boardSize;
    private String jumperMoves;
    private String stones;
    private String startSquareLocation;
    private String endSquareLocation;
    
    
    public InputProperties(String boardSize, String jumperMoves, String stones, String startSquareLocation,
	    String endSquareLocation) {
	super();
	this.boardSize = boardSize;
	this.jumperMoves = jumperMoves;
	this.stones = stones;
	this.startSquareLocation = startSquareLocation;
	this.endSquareLocation = endSquareLocation;
    }
    
}
