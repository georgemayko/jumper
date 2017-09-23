package br.com.gm.jumper.model;

import br.com.gm.jumper.exceptions.InvalidMoveException;

public class Move extends XYAxis{

    public Move(int x, int y) throws InvalidMoveException {
	super(x, y);
	if(x == 0 && y == 0){
	    throw new InvalidMoveException();
	}
    }
}
