package br.com.gm.jumper.model;

import br.com.gm.jumper.exceptions.InvalidPositionException;

public class Position extends XYAxis{

    public Position(int x, int y) throws InvalidPositionException {
	super(x, y);
	if(x < 0 || y < 0)
	    throw new InvalidPositionException();
    }
}
