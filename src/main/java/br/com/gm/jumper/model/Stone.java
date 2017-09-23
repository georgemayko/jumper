package br.com.gm.jumper.model;

import br.com.gm.jumper.exceptions.InvalidPositionException;

public class Stone extends Position {

    public Stone(int x, int y) throws InvalidPositionException {
	super(x, y);
    }
    
}
